import mayflower.*;
import java.util.*;
public class Level1 extends World
{
    private String[][] tiles;
    private Cat cat;

    public Level1()
    {
        setBackground("img/BG/black.png");
        cat = new Cat();
        tiles = new String[6][8];
        createTiles();
        buildWorld();
        showText("Score: " + cat.getScore() + " Lives: " + cat.getLives(), 10, 30, Color.WHITE);
    }
    public void act()
    {           

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
        for (int i = 0; i < tiles[0].length; i++) {
            int x = (int) ((Math.random() * 4) + 1);
            while (x == 3) {
             x = (int) ((Math.random() * 4) + 1);   
            }
            tiles[x][i] = "coins";
        }
        for (int i = 0; i < tiles[0].length; i++) {
            if (i != 5) {
            tiles[3][i] = "ground"; }
        }
        for (int i = 3; i >= 3; i--) {
            tiles[i][6] = "Ladder";
        }
        tiles[1][7] = "Ayman";
        tiles[4][1] = "cat";
    }
    public void buildWorld()
    {
        for (int row = 0; row<tiles.length; row++) { 
            for (int col =0; col<tiles[row].length;col++) { 
                if(tiles[row][col].equals("ground")) 
                    addObject(new Block(), col * 100, row * 100);
                if(tiles[row][col].equals("coins")) 
                    addObject(new Coins(), col * 100 + 25, row * 100);
                if (tiles[row][col].equals("cat"))
                    addObject(cat, col * 100, row * 100);
                if (tiles[row][col].equals("Ayman"))
                    addObject(new Ayman(), col * 100, row * 100);
                if (tiles[row][col].equals("Ladder"))
                    addObject(new Ladder(), col * 100, row * 100);
            }
        }
        addObject(new Block(), 600, 300);
        addObject(new Yarn(false, false), 400, 400);
    }

}
