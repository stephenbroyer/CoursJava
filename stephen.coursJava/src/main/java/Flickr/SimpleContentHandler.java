package Flickr;

import org.xml.sax.*;
import org.xml.sax.helpers.LocatorImpl;

import java.util.Vector;

public class SimpleContentHandler implements ContentHandler {

    protected String id,server,secret;

    /* CONSTRUCTEURS */
    public SimpleContentHandler() {
        super();
        locator = new LocatorImpl();
    }
    /* METHODES */
    public void setDocumentLocator(Locator value) {
        locator =  value;
    }
    public void startDocument() throws SAXException {
        System.out.println("Debut de l'analyse du document");
    }
    public void endDocument() throws SAXException {
        System.out.println("Fin de l'analyse du document" );
    }
    public void startPrefixMapping(String prefix, String URI) throws SAXException {
        System.out.println("Traitement de l'espace de nommage : " + URI + ", prefixe choisi : " + prefix);
    }
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("Fin de traitement de l'espace de nommage : " + prefix);
    }

    /* importantes !!!! */

    /**
     *
     * @param nameSpaceURI
     * @param localName
     * @param rawName
     * @param attributs
     * @throws SAXException
     */
    public void startElement(String nameSpaceURI, String localName, String rawName, Attributes attributs) throws SAXException {
        System.out.println("Ouverture de la balise : " + localName);

        if ( ! "".equals(nameSpaceURI)) {
            System.out.println("  appartenant a l'espace de nom : "  + nameSpaceURI);
        }

        System.out.println("  Attributs de la balise : ");

        for (int index = 0; index < attributs.getLength(); index++) {
            System.out.println("     - " +  attributs.getLocalName(index) + " = " + attributs.getValue(index));

            if (localName.equals("photo")){
                if (attributs.getLocalName(index).equals("id")){ id=attributs.getValue(index);}
                if (attributs.getLocalName(index).equals("server")){ server=attributs.getValue(index);}
                if (attributs.getLocalName(index).equals("secret")){secret=attributs.getValue(index);}
            }

        }
    }

    /**
     *
     * @param nameSpaceURI
     * @param localName
     * @param rawName
     * @throws SAXException
     */
    public void endElement(String nameSpaceURI, String localName, String rawName) throws SAXException {
        System.out.print("Fermeture de la balise : " + localName);

        if ( ! "".equals(nameSpaceURI)) { // name space non null
            System.out.print("appartenant a l'espace de nommage : " + localName);
        }

        System.out.println();
    }

    /**
     *
     * @param ch
     * @param start
     * @param end
     * @throws SAXException
     */
    public void characters(char[] ch, int start, int end) throws SAXException {
        System.out.println("#PCDATA : " + new String(ch, start, end));
    }

    /**
     *
     * @param ch
     * @param start
     * @param end
     * @throws SAXException
     */
    public void ignorableWhitespace(char[] ch, int start, int end) throws SAXException {
        System.out.println("espaces inutiles rencontres : ..." + new String(ch, start, end) +  "...");
    }

    /**
     *
     * @param target
     * @param data
     * @throws SAXException
     */
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Instruction de fonctionnement : " + target);
        System.out.println("  dont les arguments sont : " + data);
    }

    /**
     *
     * @param arg0
     * @throws SAXException
     */
    public void skippedEntity(String arg0) throws SAXException {
    }
    private Locator locator;


}