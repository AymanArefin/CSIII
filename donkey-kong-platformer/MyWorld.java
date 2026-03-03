import mayflower.*;
public class MyWorld extends World
{
    private String[][] tiles = new String[6][8];
    private boolean started;
    private Cat cat;
    public MyWorld()
    {
        setBackground("img/titlescreen.png");
        cat = new Cat();
        //Mayflower.setWorld(new Level1());
        
        //showText("Score: " + cat.getScore() + " Lives: " + cat.getLives(), 10, 30, Color.BLACK);
    }
    public void act()
    {
        if (started == false) {
           if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
                Mayflower.setWorld(new Level1());
                started = true;
            }   
        }
    }
    public void createTiles()
    {

    }
    public void buildWorld()
    {

    }
    public void addRandomObjects() {

    }

}