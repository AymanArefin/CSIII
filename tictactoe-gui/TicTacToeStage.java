import mayflower.*;
import java.awt.Color;

//Find the Mayflower documentation here: http://mrmaycs.com/mayflower/

public class TicTacToeStage extends Stage
{
    //INSTANCE VARIABLES
    private TicTacToe game;
    private Text currentPlayer, winner;

    private boolean playAgainAdded; 
    
    //CONSTRUCTOR
    public TicTacToeStage() 
    {
        setBackground("img/background.png");
        
        game = new TicTacToe();
        
        //Add a label to the top of the screen that displays the name of the game
        Text title = new Text("Tic Tac Toe", Color.WHITE);
        addActor(title, 0, 0);
        
        currentPlayer = new Text("Loading...", Color.WHITE);
        addActor(currentPlayer, 0, 30);
        
        winner = new Text("", Color.WHITE);
        addActor(winner, 0, 60);
        //TODO: Add a "blank" PieceActor to each of the 9 spots of the TicTacToe board
        //      Each PieceActor needs a reference to the TicTacToe object
        for (int r = 0; r < 3; r++)
        {
            for (int c = 0; c < 3; c++)
            {
                addActor(new PieceActor(game, r, c), r * 105 + 150, c * 105 + 150);
            }
        }
    }
    
    //METHODS
    /*
     *  Check if the game is over
     *      If the game is over, display the text "Game Over!" on the screen
     *      If there is a winner, display the text "X wins!" or "O wins!" on the screen
     *      If there is not a winner, display the text "Tie Game!" on the screen
     *  If the game is NOT over
*      Display the current player's turn on the screen: "It is X's turn" or "It is O's turn"
     */
    public void update()
    {
        if (game.isGameOver())
        {
            currentPlayer.setText("Game Over!");
            
            TicTacToePiece win = game.getWinner();
            
            if (win == TicTacToePiece.X)
                winner.setText("X wins!");
            else if (win == TicTacToePiece.O)
                winner.setText("O Wins!");
            else
                winner.setText("Tie Game!");
        }
        else
        {
            TicTacToePiece curr = game.getCurrentPlayer();
            if (curr == TicTacToePiece.X)
                currentPlayer.setText("It is X's turn");
            else
                currentPlayer.setText("It is O's turn");
        }

    }
}