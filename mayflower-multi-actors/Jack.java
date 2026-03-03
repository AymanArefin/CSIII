import mayflower.*;

public class Jack extends AnimatedActor
{
    Animation walk;
    public Jack() 
    {

        String[] imgs = new String[10];
        for(int i = 0; i < 10; i++)
        {
            imgs[i] = "img/jack/idle (" + (i + 1) + ").png";
        }
        walk = new Animation(50, imgs);
       walk.scale(100, 87);
        setAnimation(walk);
    }
    public void act()
    {
        super.act();
    }
}
