import java.util.Scanner;

/**
 * Created by travis on 2/4/17.
 */
public class NumericalEngine {
    private double a, b, c, fa, fb, fc, error;
    final int nmax = 100;
    final double actualerror = 0.01;
    double approximation;
    public enum NumericalMethod {Newton, Bisection, Secant, FalsePosition, mFalsePosition};
    NumericalMethod methodChoice = null;
    UI ui;

    public NumericalEngine(UI userInterface) {
        ui = userInterface;
        methodChoice = getMethod(userInterface);
        CalculateMethod(methodChoice);
    }

    private NumericalMethod getMethod(UI userInterface) {
        switch(userInterface.getAnswer())
        {
            case 1:
                return NumericalMethod.Newton;
            case 2:
                return NumericalMethod.Bisection;
            case 3:
                return NumericalMethod.Secant;
            case 4:
                return NumericalMethod.FalsePosition;
            case 5:
                return NumericalMethod.mFalsePosition;
        }

        return NumericalMethod.Newton;
    }

    private void CalculateMethod(NumericalMethod methodChoice) {
        switch (methodChoice) {
            case Newton:
            {
                calculateNewton(ui.getNewtonValues());
            }
            case Bisection:
            {
                System.out.println("Given the function: f(x) = 2x^3 - 11.7x^2 + 17.7x - 5");
                calculateBisection(ui.getLeftbound(),ui.getRightbound(),nmax,actualerror);
            }
            case Secant:
            {
                calculateSecant(ui.getSecantValues());
            }
            case FalsePosition:
            {
                calculateFalsePosition(ui.getFalsePositionValues());
            }
            case mFalsePosition:
            {
                calculatemodifiedFalsePosition(ui.getmFalsePositionValues());
            }
        }
    }

    /**
     * This method takes number of max iterations, nMax to be 100
     *
     */
    public double calulateBisection(double a, double b, double e)
    {
    }


}
