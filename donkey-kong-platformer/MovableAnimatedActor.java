import mayflower.*;
public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private String currentAction;
    private String direction;
    private Animation fallLeft;
    private Animation fallRight;
    private boolean shoot;
    public enum dir
    {
        right, left, idle
    }
    dir direct = dir.right;
    public static int g;
    

    public MovableAnimatedActor()
    {
      
        g = 1;
        direction = "right";
        walkRight = null;
        idle = null;
        currentAction = null;
        shoot = true;
    }

    public void act()
    {
        if (Yarn.claimed && Mayflower.isKeyDown(Keyboard.KEY_ENTER) && shoot)
        {
             World wrld = getWorld();
             boolean right = (direction.equals("right")) ? true : false;
             wrld.addObject(new Yarn(true, right), getX(), getY());
             shoot = false;
        }
        String newAction = null;
        if (currentAction==null)
        {
            newAction = "idle";
        }
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();


        if (Mayflower.isKeyDown(Keyboard.KEY_LEFT)&&x>0)
        {
            setLocation(x - 5, y);
            newAction = "walkLeft";
            direction = "left";
            direct = dir.left;
            if (isTouching(Block.class) || isTouching(Grass.class))
                setLocation(x - 1, y);
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT)&&x+w<800)
        {
            setLocation(x + 5, y);        
            newAction = "walkRight";
            direction = "right";
            direct = dir.right;
            if (isTouching(Block.class) || isTouching(Grass.class))
                setLocation(x + 1, y);
        } 

        else
        {
            newAction = "idle";
            if (direction!=null && direct==dir.left)
            {
                newAction = "idleLeft";
            }

        }
                    if (isFalling())
            {
                newAction = "fallRight";
                if (direction!=null && direct==dir.left)
                {
                    newAction = "fallLeft";
                }
            }
        super.act();
        if (newAction!=null&&!newAction.equals(currentAction))
        {
            if (newAction.equals("idle"))
            {
                setAnimation(idle);
            }
            if (newAction.equals("walkRight"))
            {
                setAnimation(walkRight);
            }
            if (newAction.equals("walkLeft"))
            {
                setAnimation(walkLeft);
            }
            if (newAction.equals("idleLeft"))
            {
                setAnimation(idleLeft);
            }
            if (newAction.equals("fallRight"))
            {
                setAnimation(fallRight);
            }
            if (newAction.equals("fallLeft"))
            {
                setAnimation(fallLeft);
            }
            currentAction = newAction;
        }


    }
    

    
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }
    
    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
    }
    
    public void setIdleAnimation(Animation ani)
    {
        idle = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft = ani;
    }
    public void setIdleLeft(Animation ani)
    {
        idleLeft = ani;
    }    
    public void setFallRight(Animation ani)
    {
        fallRight = ani;
    }
    public void setFallLeft(Animation ani)
    {
        fallLeft = ani;
    }
    public static void setG(int i)
    {
        g = i;
    }
}
