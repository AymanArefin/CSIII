import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private Dog dog;
    private Jack jack;
    private Ninja ninja;
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        cat = new Cat();
        addObject(cat, 400, 100);
        Block block = new Block();
        addObject(block, 400, 500);
        Block b2 = new Block();
        addObject(b2, 528, 372);
        Mayflower.showBounds(true);
    }
    
    public void act()
    {
    }
    
}