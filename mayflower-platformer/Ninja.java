import mayflower.*;

public class Ninja extends AnimatedActor
{
    Animation walk;
    public Ninja() 
    {

        String[] imgs = new String[10];
        for(int i = 0; i < 10; i++)
        {
            imgs[i] = "img/ninjagirl/Run__00" + (i) + ".png";
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
