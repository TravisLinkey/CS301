import java.util.ArrayList;

/**
 * Created by travis on 2/27/17.
 */
public class DivDifferenceAlg {
    ArrayList fxValues = new ArrayList<Double>();
    ArrayList xValues = new ArrayList<Double>();
    ArrayList store = new ArrayList<Double>();

    /**
     * This method returns the ListArray for the x values
     * @return xArray
     */
    public ArrayList<Double> getXarray()
    {
        return xValues;
    }

    /**
     * This method returns the ListArray x value at a
     * particular index passed as a parameter, i
     *
     * @return xArray
     */
    public double getXarray(int i)
    {
        return (double)xValues.get(i);
    }

    public ArrayList<Double> getfXarray()
    {
        return fxValues;
    }

    /**
     * This method returns the ListArray f(x) value at a
     * particular index passed as a parameter, i
     *
     * @return xArray
     */
    public double getfXarray(int i)
    {
        return (double)fxValues.get(i);
    }

    public void Coef() {

        ArrayList<Double> divDiff = fxValues;
        int n = xValues.size();
        store.add(fxValues.get(0));

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n-i; j++) {
                double denominator = getXarray(i + j) - getXarray(j);
                divDiff.add(j,(divDiff.get(j+1) - divDiff.get(j)) / denominator);
                System.out.println("Next number: " + divDiff.get(j));
            }
            store.add(i,divDiff.get(0));
        }
        
    }

    public double Eval(int n, double[] x, double[] store, double t) {
        double temp;

        temp = store[n];

        for(int i = n - 1; i > 0; i--)
            temp = temp*(t - x[i]) + store[i];

        return temp;
    }

    public void printValues() {
        System.out.println("Divided difference: ");
        int i = 0;
        do {
            System.out.print(store.get(i) + "    ");
            i++;
        }while(i < store.size());
    }

}
