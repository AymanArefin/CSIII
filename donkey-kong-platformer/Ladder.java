import mayflower.*;
public class Ladder extends Actor
{

    public Ladder()
    {
        setImage("img/bllader.png");
    }

    public void act()
    {
        // changes cats' y position when touching a ladder object
        if (isTouching(Cat.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld();
            c.setLocation(c.getX(), c.getY()-6);
        }
    }
}
