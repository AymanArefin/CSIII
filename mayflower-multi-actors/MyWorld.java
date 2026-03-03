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
        addObject(cat, 100, 100);
    	dog = new Dog();
    	jack = new Jack();
    	ninja = new Ninja();
    	
    	addObject(dog, 100, 300);
    	addObject(jack, 300, 300);
    	addObject(ninja, 200, 100);
    }
    
    public void act()
    {
    }
    
}