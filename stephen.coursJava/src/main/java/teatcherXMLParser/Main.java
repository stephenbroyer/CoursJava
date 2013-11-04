package teatcherXMLParser;

import java.io.IOException;
import java.util.Scanner;

import com.sun.xml.internal.bind.marshaller.XMLWriter;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {
    private boolean outWhile = true;
    private String ville,latitude,longitude, sortirBoucle;
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


        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Ville: ");
            ville = sc.nextLine();
            System.out.println("Longitude: ");
            ville = sc.nextLine();
            System.out.println("Latitude: ");
            ville = sc.nextLine();

            do{
                System.out.println("Encore? o/n: ");
                sortirBoucle = sc.nextLine();
            }
            while(  (! sortirBoucle.equals("o"))
                    &&
                    (!sortirBoucle.equals("n"))
                  );
            if(sortirBoucle.equals("o")){outWhile = false;}

            //XMLWriter myXMLWriter = new XMLWriter();

        }    while (outWhile);

	}
	public static void main(String[] args) {
		new Main();
	}
}
