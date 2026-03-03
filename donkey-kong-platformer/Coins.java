import mayflower.*;
public class Coins extends Actor
{    
    /**
     * Constructor for objects of class Coins
     */

    public Coins()
    {
        setImage("img/coins.png");
    }

    public void act() {
        if (isTouching(Cat.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld();
            c.increaseScore(1);
            w.showText("Score: " + c.getScore() + " Lives: " + c.getLives(), 10, 30, Color.WHITE);
            w.removeObject(this);            
        }   

    }
}
