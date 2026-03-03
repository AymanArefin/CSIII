import mayflower.*;
public class Ayman extends Actor
{
    /**
     * Constructor for objects of class Block
     */
    private int direction;
    private int range;
    public Ayman()
    {
        setImage("img/donkeykong.png");
    }

    public void act()
    {
        direction = (int) Math.random() * 4;
        range = (int) Math.random() * 4;
        if (direction == 0)
        {
            setLocation(getX() + range, getY());
        }
        if (direction == 1)
        {
            setLocation(getX() - range, getY());        
        }
        if (direction == 2)
        {
            setLocation(getX(), getY() - range);        
        }
        if (direction == 3)
        {
            setLocation(getX(), getY() + range);        
        }
    }
}
