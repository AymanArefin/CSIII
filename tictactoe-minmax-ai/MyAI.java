import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyAI implements AI
{
    public String getName()
    {
        return "MinMaxTree";
    }

    //Return the best move myPiece can make using a MinMaxTree
    public Point getNextMove(TicTacToe game, TicTacToePiece myPiece)
    {

        //if game is over, reutrn null
        if (game.isGameOver() )
            return null;

        //Generate a MinMax tree using the TicTacToe game parameter
        TNode<MinMaxNode> root = generateMinMaxTree(game, null);

    
        //Score the MinMax tree
        scoreMinMaxTree(root, myPiece);

        //Create a list of MinMaxNodes from the children of the root of the MinMax tree you just generated
        //if the root node has no children, return null

        List<TNode<MinMaxNode>>  l = root.getChildren();
        int bestScore = Integer.MIN_VALUE;
        if(l==null || l.isEmpty()) return null;
        List<Point> best = new LinkedList<>();

        //Determine what the best (highest) score is among all of the MinMax nodes in the list your just created
        for(TNode<MinMaxNode> child : l)
        {
            MinMaxNode node = child.getData();
            int s = node.getScore();

            if(s>bestScore)
            {
                bestScore = s;
                best.clear();
                best.add(node.getMove());
            }
            else if(s==bestScore)
            {
                best.add(node.getMove());
            }
        }

        if(best.isEmpty()) return null;

    
        //Create a list to hold all of the moves (Point objects) that are rated with the best score
        //loop through all of the children of the root of hte MinMax tree and add the Point from the ones with the "best score" to the list of Points you just created

        //return a random point from the list of Points
        return best.get((int) (Math.random() * best.size()));
    }

    //Generate a MinMaxTree consisting of a root node containing game, and children nodes 
    //containing all possible moves the current player can make
    private TNode<MinMaxNode> generateMinMaxTree(TicTacToe game, Point move)
    {
        //make a copy of game (so you can modify the copy without changing game)
        TicTacToe g = game.copy();
        //if move is not null
        if(move!=null)
        {
            g.addPiece(move.getRow(), move.getCol());
            g.nextPlayer();
        }
        //  apply move to the copy (addPiece and nextPlayer)

        //Make a MinMaxNode with the copy and move

        MinMaxNode mNode = new MinMaxNode(g, move);
        //Make a TNode with the MinMaxNode you just created
        TNode<MinMaxNode> treeNode = new TNode<>(mNode);

        //recursively call generateMinMaxTree for each legal move that the new current player can make on copy (every empty space is a legal move)
        if(!g.isGameOver())
        {
            for(Point p : g.getEmptySpaces())
            {
                treeNode.addChild(generateMinMaxTree(g, p));
            }

        }
        //  add the TNode returned by the recursive generateMinMaxTree calls as a child to the TNode you created above

        //return the TNode you created above
        return treeNode;
    }

    //Generate a score for every node in the MinMaxTree (from the point of view of player)
    private void scoreMinMaxTree(TNode<MinMaxNode> root, TicTacToePiece player)
    {
        //get the MinMaxNode out of the root node]
        MinMaxNode node = root.getData();

        //get the game out of the MinMaxNode

        TicTacToe g = node.getGame();

        //if the game is over
        //  use the setScore method to score the MinMaxNode based on who one the gmae
        //      if player is the winner ->  10 points
        //      if the game is tied ->      0 points
        //      if player is the loser ->   -10 points

        if(g.isGameOver())
        {
            TicTacToePiece w = g.getWinner();

            if(player == w) node.setScore(10);
            else if(w == null) node.setScore(0);
            else node.setScore(-10);

            return;

        }

        int bestMax = Integer.MIN_VALUE;
        int bestMin = Integer.MAX_VALUE;

        for(TNode<MinMaxNode> c : root.getChildren())
        {
            scoreMinMaxTree(c, player);

            int s = c.getData().getScore();
            bestMax = Math.max(bestMax, s);
            bestMin = Math.min(bestMin, s);
        }
        if(g.getCurrentPlayer() == player) node.setScore(bestMax);
        else node.setScore(bestMin);
    }

    //if the game is not over
    //  recursively call scoreMinMaxTree on all of the root node's children
    //  determine the lowest and highest scores among all of the root node's children
    //  if it is player's turn
    //      set this MinMaxNode's score to the highest score
    //  if it is NOT player's turn
    //      set this MinMaxNode's score to the lowest score
}