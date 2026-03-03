import mayflower.*;

public class Cat extends AnimatedActor
{
    Animation walk;
    public Cat() 
    {

        String[] imgs = new String[10];
        for(int i = 0; i < 10; i++)
        {
            imgs[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        walk = new Animation(50, imgs);
        walk.scale(100, 87);
        walk.setTransparency(50);
        setAnimation(walk);

    }
    public void act()
    {
        super.act();
    }
}
