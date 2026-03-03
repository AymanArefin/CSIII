// name: 
// date:
// per:  

public class Lab0
{

    public Lab0()
    {
        // do not update the constructor
    }

    public  void display (int min, int max)
    {
        for(int i = 1; i <= 100; i++)
        {
            System.out.println(checkValue(i));
        }
    }

    public String checkValue(int value)
    {
       String return_value = "";
       if (value % 3 == 0)
       {
           return_value += "Poke";
       }
       if (value % 5 == 0)
       {
           return_value += "mon";
       }
       if (return_value.equals(""))
       {
           return String.valueOf(value);
       }
       return return_value;
    }
}
