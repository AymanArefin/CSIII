import mayflower.*;
public class MyWorld extends World
{
    public MyWorld()
    {
        setBackground("img/bluebonnets.jpg");
        Cat a = new Cat();
        addObject(a, 400, 300);
        Dog b = new Dog();
        addObject(b, 200, 150);
        Yarn c = new Yarn();
        Yarn d = new Yarn();
        Yarn e = new Yarn();
        addObject(c, 600, 150);
        addObject(d, 200, 450);
        addObject(e, 600, 450);
        
    }
    
    public void act()
    {
    
    }
}
