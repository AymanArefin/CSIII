import java.util.Scanner;
import java.io.File;

public class RoyalFamily
{
    public static void main(String[] args)
    {
        //Define a variable to store the root node
        TNode<String> root = null;

        //TODO: SETUP TREE DATA
        //1. Use Scanner to read the data.txt file
        //2. The first line in data.txt is the root node
        //3. For each line in data.txt in the format A > B
        //      - *find* the A node
        //      - add B as a child of A

        try 
        {
        Scanner in = new Scanner(new File("data.txt"));

        String name = in.nextLine();
        root = new TNode<String>(name);

        while(in.hasNextLine())
        {
            String line = in.nextLine();
            String[] parts = line.split(" > ");
            String parentName = parts[0];
            String childName = parts[1];

            TNode<String> parent = find(root, parentName);
            if (parent != null)
                parent.addChild( new TNode<String> (childName) );

        }
        
        in.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
        //TODO: test printPath method
        TNode<String> child = find(root, "Princess Beatrice of York");
        String path = getPath( child );
        System.out.println(path);
    }

    /**
     *  @return node if its data matches name, or return a child node with data that matches name
     */
    public static TNode<String> find(TNode<String> node, String name)
    {
        if (node.getData().equals(name))
            return node;

        for (TNode<String> child : node.getChildren())
        {
            TNode<String> ret = find(child, name);
            if (ret != null)
                return ret;
        }
        return null;

    }

    /**
     *  @return a String containing the path from the root node to the specified node, separeated by ->
     */
    public static String getPath(TNode<String> node)
    {
       String s = node.getData();
       while (node.getParent() != null)
       {
           node = node.getParent();
           s = node.getData() + " -> " + s;
       }
       return s;
       
    }
}