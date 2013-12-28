package Flickr;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SimpleSaxParser {

     public String id,server,secret;

    /* CONTRUCTEURS */

    /**
     *
     * @param uri
     * @throws SAXException
     * @throws IOException
     */
    public SimpleSaxParser(String uri) throws SAXException, IOException {
        XMLReader saxReader = XMLReaderFactory.createXMLReader();
        SimpleContentHandler simpleContentHandler =  new SimpleContentHandler();
        saxReader.setContentHandler(simpleContentHandler);
        saxReader.parse(uri);
//       String theResponse = saxReader.getResponse();
        id = simpleContentHandler.id;
        server = simpleContentHandler.server;
        secret = simpleContentHandler.secret;

    }

    /**
     *
     * @param args
     **/
    public static void main(String[] args) {
        if (0 == args.length || 2 < args.length) {
            System.out.println("Usage : SimpleSaxParser uri [parserClassName]");
            System.exit(1);
        }

        String uri = args[0];

        String parserName = null;
        if (2 == args.length) {
            parserName = args[1];
        }

        try {
            SimpleSaxParser parser = new SimpleSaxParser(uri);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
