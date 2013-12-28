package MyXmlSaxParser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

   MyCreator creator = new MyCreator();
   creator.write("geo.xml");

    new MyReader("geo.xml");
    System.err.println("---------------------------------------------------");
    new MyAdder("geo.xml");

    new MyReader("geo.xml");

  }
}
