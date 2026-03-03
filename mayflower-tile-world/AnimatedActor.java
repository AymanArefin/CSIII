import mayflower.*;
public class AnimatedActor extends Actor
{
    // instance variables - replace the example below with your own
    private Animation animation;
    private Timer animationTimer;
    /**
     * Constructor for objects of class AnimatedActor
     */
    public AnimatedActor()
    {
        animationTimer = new Timer();
        
    }
    
    public void setAnimation(Animation a)
    {
        animation = a;
    }
    
    public void act()
    {
        if (animationTimer.isDone())
        {
            animationTimer.reset();
            if (animation != null)
            {
                MayflowerImage nf = animation.getNextFrame();
                setImage(nf);
            }
        }
    }
}
