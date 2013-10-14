package coursJava;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 14/10/13
 * Time: 09:30
 * To change this template use File | Settings | File Templates.
 */
public class TestDivisionZero {

    public int div(int a, int b)throws DivideZeroException{
        if(b != 0){
            return a/b;
        }
        else{
            throw new DivideZeroException("You can't divide by zero");
        }
    }
}
