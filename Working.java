import chn.util.*;
import apcslib.*;
/**
Contains all the innerworkings of my take on the Game of Life:
Methods (- main methods, + helper methods, * methods for lab):
    - Read file and store in 2D array -> parameter: none, return type: none
    - generate next gen -> parameter: none, return type: none
      + count neighbors -> parameter: row and column, return type: int
      + determine life or death (w/ ints 0 and 1) -> parameter: int, return type: int (1 or 0)
      + store into copy -> parameter: none, return type: none
      + Replace OG array w/this -> parameter: none, return type: none
    - print array onto screen
      + format (w/ stars if alive and spaces if dead maybe)
    * Count living cells on entire board -> parameters: none, return type: int
    * Count living cells on given row -> parameters: row, return type: int
    * Count living cells on given column -> parameters: column, return type: int

Instance Variables:
    - og 2D array
    - copy 2D array
    - (FileInput) file reader

 * @Cristian Embleton
 * @1/23/2022
 */
public class Working
{
    private FileInput reader;
    private int[][] original;
    private int[][] copy;
    private int alive;
    
    public Working(String file)
    {
        reader = new FileInput(file);
        original = new int[22][22];
        copy = new int[22][22];
        alive = 0;
    }
    
    public void fillArray()
    {
        int row = 0;
        int col = 0;
        while(reader.hasMoreLines())
        {
            //store each int one at a time for row, then column
            row = reader.readInt();
            col = reader.readInt();
            
            //Debug
            //System.out.print(row + " " + col + "\n");
            
            //1 means alive and 0 means dead
            original[row][col] = 1;
            alive++;
        }
    }
    
    public void generate(int generations)
    {
        
    }
    
    public void print(int genNum)
    {
        int[][] array = copy;
        if(genNum % 2 == 0)
        {
            array = original;
        }

        System.out.println("Generation " + genNum + ":");
        System.out.println(Format.right("1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0", 44) + "\n");
        
        //Loops through each row of array and converts 1s to stars
        //and 0s to spaces on each column
        for(int row = 1; row <= 20; row++)
        {
            //String will build up for each empty space and organism
            String string = "";
            //Prints row number
            System.out.print(Format.right(row + "", 3));
            for(int col = 1; col <= 20; col++)
            {
                //Adds an asterisk to string only if there is life, 
                //else it is a space
                if(array[row][col] == 0) 
                {
                    string += "  ";
                }
                else
                {
                    string += "* ";
                }
            }
            //Prints final compiled string
            System.out.println(Format.right(string, 42));
            //System.out.println(string.length());
        }
        
    }
}
