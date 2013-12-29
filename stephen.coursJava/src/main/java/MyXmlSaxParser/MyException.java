package MyXmlSaxParser;

public class MyException extends RuntimeException {
  public MyException(String message, Exception e) {
    System.out.println("*************************************************");
    System.out.println(message);
    System.out.println("*************************************************");
    System.err.println(e);
  }
}
