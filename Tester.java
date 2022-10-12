/**
 * Executes all the commands for Life
 *
 * @Cristian Embleton
 * @1/23/2022
 */
public class Tester
{
    public static void main(String[] args)
    {
        Working w = new Working("lifeNums.txt");
        w.fillArray();
        w.print(0);
    }
}
