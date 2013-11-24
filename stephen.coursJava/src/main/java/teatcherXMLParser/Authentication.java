package teatcherXMLParser;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class Authentication implements ContentHandler {

	/* ATTRIBUTS */
	private boolean bAccessToken = false;
	private boolean bAccessSecret = false;
	private boolean bConsumerKey = false;
	private boolean bConsumerSecret = false;
	
	private String accessToken = null;
	private String accessSecret = null;
	private String consumerKey = null;
	private String consumerSecret = null;

    /* CONSTRUCTEUR */
	public Authentication() {}

    /* METHODES */
	public void setDocumentLocator(Locator locator) {
        //Note: left blank intentionally
	}
	public void startDocument() throws SAXException {
        //Note: left blank intentionally
    }
	public void endDocument() throws SAXException {
		//Note: left blank intentionally
	}
	public void startPrefixMapping(String prefix, String uri)throws SAXException {
		//Note: left blank intentionally
	}
	public void endPrefixMapping(String prefix) throws SAXException {
		//Note: left blank intentionally
	}
	public void startElement(String uri, String localName, String qName,Attributes atts) throws SAXException {
		if (localName.equals("accessToken"))    bAccessToken = true;
		if (localName.equals("accessSecret"))	bAccessSecret = true;
		if (localName.equals("consumerKey"))	bConsumerKey = true;
		if (localName.equals("consumerSecret")) bConsumerSecret = true;
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals("accessToken"))    bAccessToken = false;
		if (localName.equals("accessSecret")) 	bAccessSecret = false;
		if (localName.equals("consumerKey"))    bConsumerKey = false;
		if (localName.equals("consumerSecret"))	bConsumerSecret = false;
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (bAccessToken)   accessToken = new String(ch, start, length);
		if (bAccessSecret)  accessSecret = new String(ch, start, length);
		if (bConsumerKey)   consumerKey = new String(ch, start, length);
		if (bConsumerSecret)consumerSecret = new String(ch, start, length);
	}
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		//Note: left blank intentionally
	}
	public void processingInstruction(String target, String data) throws SAXException {
		//Note: left blank intentionally
	}
	public void skippedEntity(String name) throws SAXException {
		//Note: left blank intentionally
	}
	public String getAccessToken() {
        return accessToken;
	}
	public String getAccessSecret() {
		return accessSecret;
	}
	public String getConsumerKey() {
		return consumerKey;
	}
	public String getConsumerSecret() {
		return consumerSecret;
	}
}
