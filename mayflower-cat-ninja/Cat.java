import mayflower.*;

public class Cat extends Actor
{
    private MayflowerImage[] frames = new MayflowerImage[10];
    private int currentFrame = 0;
    private Timer animationTimer;
    public Cat()
    {
        //Create a MayflowerImage object from the specified image file
        MayflowerImage p = new MayflowerImage ("img/cat/Walk (1).png");
        // Scale this image to 30% of the origianl size
        p.scale(0.3);
        //Set this Actor's image to the MayflowerImage object p
        setImage(p);
        for (int i = 0; i < 10; i++)
        {
            frames[i] = new MayflowerImage("img/cat/Walk (" + (i + 1) + ").png");
            frames[i].scale(100,87);
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
