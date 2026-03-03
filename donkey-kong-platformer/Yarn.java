import mayflower.*;

public class Yarn extends Actor
{
    public static boolean claimed;
    MayflowerImage img;
    private boolean moving;
    private boolean right;
    public Yarn(boolean moving, boolean right)
    {
        this.right = right;
        this.moving = moving;
        img = new MayflowerImage("img/yarn.png");
        setImage(img);
        claimed = false;
    }
    
    public void act()
    {
        if (isTouching(Cat.class) && !moving)
        {
           claimed = true;
           World w = getWorld();
           w.removeObject(this);
        }
        if (moving)
        {
            if (right)
                setLocation(getX() + 5, getY());
            else
                setLocation(getX() - 5, getY());
        }
    }


}
