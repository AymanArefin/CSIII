import mayflower.*;
import java.util.*;
public class Level2 extends World
{
    private String[][] tiles;
    private Cat cat;

    public Level2()
    {
        setBackground("img/BG/BG3.png");
        cat = new Cat();
        tiles = new String[6][8];
        createTiles();
        buildWorld();
        showText("Score: " + cat.getScore() + " Lives: " + cat.getLives(), 10, 30, Color.WHITE);
        
    }
    public void act()
    {
        int score = cat.getScore();
        if (score > 4)
        {
            Mayflower.setWorld(new GameOverWin());
        }
    }  

    public void createTiles()
    {
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) 
                tiles[r][c] = "";
        }
        for (int i = 0; i < tiles[0].length; i++) {
            tiles[5][i] = "ground";  
        } 
        for (int i = 5; i < tiles[0].length; i ++) {
        tiles[3][i] = "ground";
         }
        for (int i = 0; i < tiles[0].length; i++) {
            int x = (int) ((Math.random() * 4) + 1);
            if (tiles[x][i] == "floating") { 
                x = (int) ((Math.random() * 4) + 1); }
            tiles[x][i] = "coins";
        }
        for (int i = 3; i >= 3; i--) {
            tiles[i][6] = "Ladder";}
        tiles[3][4] = "Ayman";
        tiles[4][1] = "cat";
        tiles[4][6] = "dk";
    }

    public void buildWorld()
    {
        for (int row = 0; row<tiles.length; row++) { 
            for (int col =0; col<tiles[row].length;col++) { 
                if(tiles[row][col].equals("ground")) 
                    addObject(new Grass(), col * 100, row * 100);
                if(tiles[row][col].equals("floating")) 
                    addObject(new Floating(), col * 100, row * 100);
                if(tiles[row][col].equals("coins")) 
                    addObject(new Coins(), col * 100 + 25, row * 100);
                if (tiles[row][col].equals("cat"))
                    addObject(cat, col * 100, row * 100);
                if (tiles[row][col].equals("Ayman"))
                    addObject(new Ayman(), col * 100, row * 100);
                if (tiles[row][col].equals("Ladder"))
                    addObject(new Ladder(), col * 100, row * 100);
                if(tiles[row][col].equals("dk")) 
                    addObject(new DK(), col * 100, row * 100);
            }
        }
    }
}
