import mayflower.*;
public class GravityActor extends Actor
{

    public GravityActor()
    {
        // initialise instance variables
       
    }
    
    public void act()
    {       

        setLocation(getX(), getY() + MovableAnimatedActor.g);
        MovableAnimatedActor.setG(MovableAnimatedActor.g+1);
        if (isBlocked())
        {

            if (Mayflower.isKeyDown(Keyboard.KEY_UP))
            {
                MovableAnimatedActor.setG(-20);
            }   
            else
            {
                MovableAnimatedActor.setG(0);               
            }
            setLocation(getX(), getY() - 1);
        }

    }
    
    public boolean isBlocked()
    {
        if(isTouching(Block.class))
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
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}
