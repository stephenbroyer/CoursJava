package MyXmlSaxParser;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 27/12/13
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */
public class MyException extends RuntimeException{
  public MyException(String message, Exception e){
    System.out.println("*************************************************");
    System.out.println(message);
    System.out.println("*************************************************");

    System.err.println(e);
  }
}
