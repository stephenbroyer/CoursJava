package TryingAlone;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 25/11/13
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public class ReadXMLFile {

    private File fileToRead;
    public ReadXMLFile(String fileName){
        fileToRead = new File(fileName);
     }

    public void readFile(){

        try {
            SAXParserFactory factory =  SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bfname = false;
                boolean blname = false;
                boolean bnname = false;
                boolean bsalary = false;
            };

            saxParser.parse(fileToRead, handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void startElement(String uri, String localName,String qName,
                             Attributes attributes) throws SAXException {

    }
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {

    }

    public void characters(char ch[], int start, int length) throws SAXException {

    }




    public static void main(String argv[]) {
        ReadXMLFile readXMLFile = new ReadXMLFile("test.xml");
        readXMLFile.readFile();
    }
}
