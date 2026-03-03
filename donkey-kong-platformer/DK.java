import mayflower.*;
public class DK extends Actor
{
    public DK()
    {
        
        setImage("img/DK1.png");
    }
    public void act()
    {
        if (isTouching(Cat.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld();
            c.removeLives(1);
            w.showText("Score: " + c.getScore() + " Lives: " + c.getLives(), 10, 30, Color.WHITE);
            c.setLocation(100, 400);        
            setLocation(600, 400);
        }   
        
        if (isTouching(Yarn.class))
        {
           World lv1 = getWorld();
           lv1.removeObject(this);
           Mayflower.setWorld(new easteregg());
        }
        int a = (int) (Math.random() * 5) - 10;
        setLocation(getX() + a, getY() );
    }
}
