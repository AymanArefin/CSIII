import mayflower.*;
public class Cat extends Actor
{
    private int score = 0;
    private int lives = 3;
    public Cat()
    {
        setImage("img/cat.png");
    }
    
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        int xmove = 0;
        int ymove = 0;
        
        if (Mayflower.isKeyDown(Keyboard.KEY_DOWN)&&y+h<600)
        {
            ymove++;
        }
        if (Mayflower.isKeyDown(Keyboard.KEY_LEFT)&&x>0)
        {
            xmove--;
        }
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT)&&x+w<800)
        {
            xmove++;      
        } 
        if (Mayflower.isKeyDown(Keyboard.KEY_UP)&&y>0)
        {
            ymove--;               
        }
        setLocation(x + xmove, y + ymove);
        updateText();

        if(isTouching(Dog.class)){
            Object a = getOneIntersectingObject(Dog.class);
            Dog dog = (Dog) a;
            lives--;
            updateText();
            if (lives <= 0)
            {
                World world = getWorld();
                world.removeObject(this);
            }
            setLocation(400, 300);
        }
          
    }
    
    public void increaseScore(int amount)
    {
        score += amount;
    }
    
    public int getScore()
    {
        return score;
    }
    
    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
}
