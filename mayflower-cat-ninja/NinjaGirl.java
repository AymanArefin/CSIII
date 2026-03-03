import mayflower.*;

public class NinjaGirl extends Actor
{
    private MayflowerImage[] frames ;
    private int currentFrame = 0;
    private Timer animationTimer;
    public NinjaGirl()
    {
        //Create a MayflowerImage object from the specified image file
        MayflowerImage p = new MayflowerImage ("img/ninjagirl/Attack__000.png");
        // Scale this image to 30% of the origianl size
        p.scale(0.3);
        //Set this Actor's image to the MayflowerImage object p
        setImage(p);
     
        frames = new MayflowerImage[10];
        for (int i = 0; i < frames.length; i++)
        {
            frames[i] = new MayflowerImage("img/ninjagirl/Attack__00" + (i) + ".png");
            frames[i].scale(100,87);
            frames[i].setTransparency(50);
        }
        animationTimer = new Timer(100000000);
    }
    
    public void act()
    {
        if (animationTimer.isDone())
        {
            animationTimer.reset();
 
            setImage( frames[currentFrame] ); 
            currentFrame++;
            currentFrame%=10;
        }

    }

}
