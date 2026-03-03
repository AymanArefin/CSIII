import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    Animation walk;
    Animation idle;
    public Cat() 
    {

        String[] imgs = new String[10];
        for(int i = 0; i < 10; i++)
        {
            imgs[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        walk = new Animation(50, imgs);
        walk.scale(100, 87);
        walk.setBounds(18, 5, 54, 80);
        
        Animation walkLeft = new Animation(50, imgs);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);
        
        String[] idleimgs = new String[10];
        for(int i = 0; i < 10; i++)
        {
            idleimgs[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        idle = new Animation(50, idleimgs);
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        
        Animation idleLeft = new Animation(50, idleimgs);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28, 5, 54, 80);
        

        String[] fall = new String[8];
        for(int i = 0; i < 8; i++)
        {
            fall[i] = "img/cat/Fall (1).png";
        }
        Animation fallRight = new Animation(50, fall);
        fallRight.scale(100, 87);
        fallRight.setBounds(18, 5, 54, 80);
        
        Animation fallLeft = new Animation(50, fall);
        fallLeft.scale(100, 87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(28, 5, 54, 80);
        
        super.setFallRight(fallRight);
        super.setFallLeft(fallLeft);
        
        
        super.setWalkRightAnimation(walk);
        super.setWalkLeftAnimation(walkLeft);
        super.setIdleAnimation(idle);
        super.setIdleLeft(idleLeft);
        

    }
    

    public void act()
    {
        super.act();
    }
}
