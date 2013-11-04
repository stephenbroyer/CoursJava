package teatcherXMLParser;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {

	public Main() {
    	try {
	    	 XMLReader saxReader = XMLReaderFactory.createXMLReader();
	    	 GeoReader gr = new GeoReader();
	         saxReader.setContentHandler(gr);
	         saxReader.parse("geo.xml");
   	}
   	catch(SAXException se) {
   		se.printStackTrace();
   	}
   	catch(IOException ioe) {
   		ioe.printStackTrace();
   	}    	

	}
	public static void main(String[] args) {
		new Main();
	}
}
