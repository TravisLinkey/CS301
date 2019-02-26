import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by travis on 2/4/17.
 */
public class UI {
    private int ans1, ans2;
    private Scanner scan = new Scanner(System.in);
    private boolean correctFunction = false, correctMethod = false;
    private double leftbound, rightbound;

    /**
     * This constructor calls {@link #getMethod()}
     * until the user has input a valid choice
     */
    public UI() {
        do {
            ans1 = getFunction();
            ans2 = getMethod();
        } while (!correctFunction || !correctMethod);
    }

    /**
     * This method lets the user decide which function
     * they would like to choose to approximate
     * @return
     */
    public int getFunction() {
        int answer;

        System.out.println("Which function would you like to approximate? : ");
        System.out.println("[1]. 2x^3 + 11.7x^2 + 17.7x - 5");
        System.out.println("[2]. e^(-x) - x");
        System.out.println("[0]. Quit");

        answer = takeInput(1,2,0);

        if(answer == 0)
           System.exit(0);

        correctFunction = true;

        return answer;
    }

    /**
     * This method prompts the user to select which method.
     * returning the respective integer for their choice.
     *
     * @return answer
     */
    public int getMethod() {
        int answer;

        System.out.println("Please choose from the following methods: ");
        System.out.println("[1]. Bisection Method");
        System.out.println("[2]. Newton's Method");
        System.out.println("[3]. False-Position Method");
        System.out.println("[4]. Secant Method");
        System.out.println("[5]. Modified Secant Method");

        answer = takeInput(1,2,3,4,5);

        correctMethod = true;

        return answer;
    }

    public int getAns1() {
        return ans1;
    }

    public int getAns2() {
        return ans2;
    }

    public double getLeftbound() {

        double lBound;

        System.out.println("Please input a value for the leftbound:");
        lBound = takeInputRange(-10,10);

        return lBound;
    }

    public double getRightbound() {
        double rBound;

        System.out.println("Please input a value for the rightbound:");
        rBound = takeInputRange(-10,10);

        return rBound;
    }

    public double getDelta() {
        System.out.println("Please input a value for delta: ");
        double delta = takeInputRange(-10,10);

        return delta;
    }

    public double getxValue() {
        System.out.println("Please input an x value: ");
        double xValue = takeInputRange(-30,30);

        return xValue;
    }

    private double takeInputRange(int lowerbound, int upperbound) {
        int choice;

        try
        {
            choice = scan.nextInt();
            if(!isInputRangeValid(lowerbound,upperbound,choice))
                throw new InputMismatchException();
        } catch(InputMismatchException e) {
            System.out.println("Error: invalid input range.");
            scan.nextLine();
            choice = -1;
        }

        return choice;
    }

    private boolean isInputRangeValid(int lowerbound, int upperbound, int choice) {
        if(choice >= lowerbound && choice <= upperbound)
            return true;
        else
            return false;
    }

    /**
     * This method checks whether user input is valid or not.
     * @param validInputs all possible valid inputs
     * @return choice the correct input for the prompt
     */
    private  int takeInput(int...validInputs) {
        int choice;

        try
        {
            choice = scan.nextInt();
            if(!isInputValid(validInputs, choice))
                throw new InputMismatchException();
        } catch(InputMismatchException e) {
            System.out.println("Error: Invalid input");
            scan.nextLine();
            choice = -1;
        }
        return choice;
    }

    /**
     * This method checks whether user input is valid or not.
     * @param inputs array of valid inputs
     * @param c the value the user inputted
     * @return boolean valid representing if the input is valid or not
     */
    private  boolean isInputValid(int inputs[], int c) {
        for(int i : inputs)
        {
            if(c == i)
                return true;
        }
        return false;
    }
}
