import mayflower.*;
import mayflower.net.*;
import java.util.Scanner;

public class TicTacToeClient extends Client
{
    private TicTacToeStage stage;
    private TicTacToe game;

    public TicTacToeClient() 
    {
        //Scanner in = new Scanner(System.in);
        //System.out.println("Use localhost to connect to a server running on your computer.");
        //System.out.print("IP Address > ");
        //String ip = in.next();

        //System.out.print("Port > ");
        //int port = in.nextInt();
        int port = 1234;                //default server port
        String ip = "10.11.22.234";
        //System.out.println("Connecting...");
        connect(ip, port);          //connect to the server at the specified ip and port
    }

    /*
     *  Messages:
     *      youare [piece]
     *      addpiece [row] [col]
     *      winner disconnect
     *      error [message...]
     */
    public void process(String message)
    {
        System.out.println("Message from server: " + message);
        String[] parts = message.split(" ");
        
        if(parts.length == 0) return;
        
        if("youare".equals(parts[0]))
        {
            TicTacToePiece myPiece = "X".equals(parts[1]) ? TicTacToePiece.X : TicTacToePiece.O;
            this.game = new TicTacToe();
            this.stage = new TicTacToeStage(this, game, myPiece);
            new Mayflower("Tic Tac Toe", 800, 600, stage);
        }
        else if("addpiece".equals(parts[0]))
        {
            int row = Integer.parseInt(parts[1]);
            int col = Integer.parseInt(parts[2]);
            TicTacToePiece pieceBeingAdded = game.getCurrentPlayer();
            game.addPiece(row, col);
            game.nextPlayer();
            stage.updatePiece(pieceBeingAdded, row, col);
        }
        else if("error".equals(parts[0]))
        {
            System.out.println("SERVER ERROR: " + message);
        }
        else if("winner".equals(parts[0]))
        {
            if(message.contains("disconnect"))
                System.out.println("Opponent disconnected. You win!");
        }

    }

    public void onDisconnect(String message)
    {
        System.out.println("Disconnected from server.");
    }

    public void onConnect()
    {
        System.out.println("Connected!");
    }

}