public class TicTacToe implements ITicTacToe
{
    //INSTANCE VARIABLES
    TicTacToePiece[][] board;
    TicTacToePiece currentPlayer;
    
    //CONSTRUCTORS
    public TicTacToe() 
    {
        currentPlayer = TicTacToePiece.X;
        board = new TicTacToePiece[3][3];
    }
    
    //METHODS
    /*
     *  Return the current player's piece (X or O)
     */
    public TicTacToePiece getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    /*
     *  Change the current player from X to O, or from O to X
     */
    public void nextPlayer()
    {
        currentPlayer = (currentPlayer == TicTacToePiece.X) ? TicTacToePiece.O : TicTacToePiece.X;
    }
    
    /*
     *  Add the specified piece to the board at the specified row,col and return true
     *  If there is already a piece at that location, do not add the piece and return false
     */
    public boolean addPiece(int row, int col)
    {
        if (getPiece(row, col) == null)
        {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }
    
    /*
     *  Return the piece that is located at the specified row, col
     *  If there is no piece at that location, return null
     */
    public TicTacToePiece getPiece(int row, int col)
    {
        return board[row][col];
    }
    
    /*
     *  Return true if there is at least 1 empty space left on the board
     *  Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace()
    {
        for (int r = 0; r < 3; r++)
        {
            for (int c = 0; c < 3; c++)
            {
                if (board[r][c] == null)
                    return true;
            }
        }
        return false;
    }
    
    /*  Return null if there is no winner
     *  Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     *  Hint: use the helper methods: checkRowsForWinner(), checkColsForWinner(), and checkDiagsForWinner()
     */
    public TicTacToePiece getWinner()
    {
        if (checkRowsForWinner() != null)
            return checkRowsForWinner();
        if (checkColsForWinner() != null)
            return checkColsForWinner();
        return checkDiagsForWinner();
    }
    
    /*
     *  Return true if there is a winner or if there are no empty spaces left on the board
     *  Otherwise, return false
     */
    public boolean isGameOver()
    {
        if (!hasEmptySpace() || getWinner() != null)
            return true;
        return false;
    }
    
    //HELPER METHODS
    /*
     *  If a, b, and c are all the same TicTacToe piece, then return that piece
     *  Otherwise, return null
     */
    private TicTacToePiece checkForWinner(TicTacToePiece a, TicTacToePiece b, TicTacToePiece c)
    {
        if (a == b && b == c && a != null)
        {
            return a;
        }
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check each of the 3 rows for a winner
     *  Return the first non-null winner that is found (starting from row 0)
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkRowsForWinner()
    {
        for (int r = 0; r < 3; r++)
        {
            if (checkForWinner(board[r][0], board[r][1], board[r][2]) != null)
            {
                return board[r][0];
            }
        }
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check each of the 3 columns for a winner
     *  Return the first non-null winner that is found (starting from column 0)
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkColsForWinner()
    {
        for (int c = 0; c < 3; c++)
        {
            if (checkForWinner(board[0][c], board[1][c], board[2][c]) != null)
            {
                return board[0][c];
            }
        }
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check both of the diagonals for a winner
     *  Check the top left -> bottom right diagonal first
     *  Check the top right -> bottom left diagonal second
     *  Return the first non-null winner that is found
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkDiagsForWinner()
    {
        if (checkForWinner(board[0][0], board[1][1], board[2][2]) != null)
        {
            return board[0][0];
        }
        if (checkForWinner(board[0][2], board[1][1], board[2][0]) != null)
        {
            return board[0][2];
        }
        return null;
    }
    
    
}