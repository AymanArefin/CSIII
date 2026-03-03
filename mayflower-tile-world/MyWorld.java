import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private Dog dog;
    private Jack jack;
    private Ninja ninja;
    private String[][] tiles = new String[6][8];
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        createTiles();
        buildWorld();
        /**
        cat = new Cat();
        addObject(cat, 100, 100);
        dog = new Dog();
        jack = new Jack();
        ninja = new Ninja();
        
        addObject(dog, 100, 300);
        addObject(jack, 300, 300);
        addObject(ninja, 200, 100);
        **/
    }
    
    public void act()
    {
    }
    
    public void createTiles()
    {

    for (int r=0; r<tiles.length; r++)
    {
        for(int c=0; c<tiles[r].length; c++)
            tiles[r][c] = "";
    }
    addRandomObjects();    

    for (int i=0; i<tiles[0].length; i++)
    {
        tiles[5][i] = "ground";
    }
    addMainCharacter();    
    }
    public void buildWorld()
    {
        for (int row=0; row<tiles.length; row++)
        {
            for (int col=0; col<tiles[row].length; col++)
                {
                    if ( tiles[row][col].equals("ground") )
                        addObject(new Block(), col*100, row*100);
                    if ( tiles[row][col].equals("yarn") )
                        addObject(new Yarn(), col*100, row*100);
                    if ( tiles[row][col].equals("cat") )
                        addObject(new Cat(), col*100, row*100);                        
                }
        }
    }
    public void addRandomObjects()
    {
        for (int row=0; row<tiles.length; row++)
        {
            for (int col=0; col<tiles[row].length; col++)
                {
                    int r = (int) (Math.random() * tiles[0].length);
                    if(r<3)
                        tiles[row][col] = "yarn";
                }
        }
    }
    
    public void addMainCharacter()
    {
        cat = new Cat();
        boolean added = false;
        int row;
        int col;
        while(!added)
        {
            row = (int) (Math.random()*tiles.length);
            col = (int) (Math.random()*tiles[0].length);
            System.out.println(row);
            if (tiles[row][col].equals(""))
            {
                tiles[row][col] = "cat";
                added = true;
            }
            
        }   

    }
    
}