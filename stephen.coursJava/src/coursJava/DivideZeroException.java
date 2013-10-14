package coursJava;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 14/10/13
 * Time: 09:25
 * To change this template use File | Settings | File Templates.
 */
public class DivideZeroException extends Exception {

    public DivideZeroException(){
        super();
    }

    public DivideZeroException(String e){

        super(e);
        System.out.println(e);

    }
}
