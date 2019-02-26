import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by travis on 2/27/17.
 */
public class UI {
    private Scanner scan = new Scanner(System.in);
    DivDifferenceAlg engine;

    UI(DivDifferenceAlg a)
    {
        this.engine = a;
    }

    /**
     * This method prompts the user to input values
     * for x and the functional value of x, f(x)
     * and stores these values into two ArrayLists
     */
    public void getValues(){
        double ans;
        System.out.println("Please input a series of x values: ");
        System.out.println("Enter -99 when done.");

        int i = 0;
        do {
            ans = takeInputRange(-100, 100);
            if(ans == -99)
                break;
            engine.xValues.add(i,ans);
            i++;
        }while(ans != -99);

        System.out.println("Please input a series of functional values: ");
        System.out.println("Enter -99 when done.");

        i = 0;
        do {
            ans = takeInputRange(-100, 100);
            if(ans == -99)
                break;
            engine.fxValues.add(i,ans);
            i++;
        }while(ans != -99);
    }

    /**
     * This method takes only correct user input.
     * Input must be between a range of values passed as a
     * parameter
     * @param lower
     * @param upper
     * @return double
     */
    private  double takeInputRange(int lower, int upper) {
        double choice;

        try
        {
            choice = scan.nextDouble();
            if(!isInputValid(lower, upper, choice))
                throw new InputMismatchException();
        } catch(InputMismatchException e) {
            System.out.println("Error: Invalid input");
            scan.nextLine();
            choice = -1;
        }
        return choice;
    }

    /**
     * This method handles exceptions for the user input.
     * returning false if the input is valid, and false
     * if it is invalid
     *
     * @param lower
     * @param upper
     * @return boolean
     */
    private  boolean isInputValid(int lower, int upper, double c) {
        if(lower <= c && c <= upper)
                return true;
        return false;
    }

}
