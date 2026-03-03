import mayflower.*;

public class Animation
{
    // instance variables - replace the example below with your own
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
    
    public Animation(int rate, String[] images)
    {
        framerate = rate;
        currentFrame = 0;
        frames = new MayflowerImage[images.length];
        for (int i = 0; i < images.length; i++)
        {
            frames[i] = new MayflowerImage(images[i]);
        }
        
    }
    
    public int getFrameRate()
    {
        return framerate;
    }
    
    public MayflowerImage getNextFrame()
    {
        MayflowerImage i = frames[currentFrame];
        currentFrame++;
        currentFrame%=frames.length;
        return i;
        
    }
    
    public void scale(int w, int h)
    {
        for (MayflowerImage a : frames)
        {
            a.scale(w, h);
        }
    }
    
    public void setTransparency(int t)
    {
        for (MayflowerImage a : frames)
        {
            a.setTransparency(t);
        }
     
    }
    public void mirrorHorizontally()
    {
        for (MayflowerImage a : frames)
        {
            a.mirrorHorizontally();
        }
    }
    
    public void setBounds(int x, int y, int w, int h)
    {
        
        for (MayflowerImage a : frames)
        {
            a.crop(x, y ,w, h);
        }
    }
}
