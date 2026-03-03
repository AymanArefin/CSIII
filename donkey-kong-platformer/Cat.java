import mayflower.*;
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat extends MovableAnimatedActor
{
    private int x;
    private int score;
    private int lives;
    Animation walk;
    Animation idle;
    private boolean level1done;
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
        
        lives = 5;
        level1done = true;
    }

    public void act() {
        super.act();
        World w = getWorld();
        //  switches from world1 to world2 once criteria is met
        if (score > 4 && isTouching(Ayman.class) && level1done) {
            Mayflower.setWorld(new Level2());
            level1done = false;
        }
 
        if (isTouching(Ladder.class)) {
            setAnimation(idle);
        }

        if (lives == 0)
        {
            Mayflower.setWorld(new Lose());
        }
    }
    public void increaseScore(int amount) {
        score += amount;
        updateText();
    }
    // returns the score
    public int getScore() {
       return score;
    }
    // returns the number of lives
    public int getLives() {
       return lives;
    }
    // updates 
    private void updateText() {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
    // removes a life 
    public void removeLives(int amount) {    
        lives -= amount;
        updateText();
        setLocation(400, 300);
        if (lives == 0){
            World w = getWorld();
        }
    }

}
