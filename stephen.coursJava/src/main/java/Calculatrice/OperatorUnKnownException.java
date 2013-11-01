package Calculatrice;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 01/11/13
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
public class OperatorUnKnownException extends Exception{

    public OperatorUnKnownException(){
        super();
    }

    public OperatorUnKnownException(String ouk){

        super(ouk);
        System.out.println(ouk);

    }
}
