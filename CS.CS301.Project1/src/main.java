/**
 * Created by travis on 2/4/17.
 */
public class main {

    public static void main(String[] args)
    {
       UI userInterface = new UI();
       NumericalEngine Engine = new NumericalEngine(userInterface);
       Engine.CalculateMethod(Engine.methodChoice);
    }
}
