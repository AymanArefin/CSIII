import mayflower.*;


public class GravityActor extends Actor
{
    private int startpos;
    private int endpos;
    private int move;
    private boolean motion;
    public enum m
    {
        up, down
    }
    m mot;
    public GravityActor()
    {
        motion = false;
        mot = m.down;
       
    }
    
    public void act()
    {       

            if (mot==m.down && !isBlocked())
            {
                setLocation(getX(), getY() + 5);
            }
            if (isBlocked() && Mayflower.isKeyDown(Keyboard.KEY_UP))
            {
                mot=m.up;
                startpos = getY();
                endpos = startpos - 200;
            }
            if (mot==m.up)
            {
                setLocation(getX(), getY() - 7);
                if (getY() < endpos || isBlocked())
                {
                    mot = m.down;
                    setLocation(getX(), getY() + 10);
                }
            }
        

        
        




    }
    
    public boolean isBlocked()
    {
        if(isTouching(Block.class) || isTouching(Grass.class) || isTouching(Floating.class))
        {
            return true;
        }
        return false;
    }
    
    public boolean isFalling()
    {
        boolean ret;
        // move the actor down and see if it touches a block
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class) || isTouching(Grass.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}
