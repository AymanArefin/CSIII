import mayflower.*;

public class TitleScreen extends World
{
    public TitleScreen()
    {
        setBackground("img/title.png");
    }

    public void act()
    {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
           Mayflower.setWorld(new Level1());

       }


    }
}
