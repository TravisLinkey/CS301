/**
 * Created by travis on 2/27/17.
 */
public class main {

    public static void main(String[] args) {

        DivDifferenceAlg div = new DivDifferenceAlg();
        UI userinterface = new UI(div);

        userinterface.getValues();

        div.Coef();
        div.printValues();
    }

//    private static void printNewton()
//    {
//
//    }
}
