package HowToParseXmlWithOneFile;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;
import java.util.ArrayList;


public class MySAXApp extends DefaultHandler {
  private int level;
  private ArrayList<String> currentElement;

  public MySAXApp() {
    super();
    level = 0;
    currentElement = new ArrayList<String>();
    currentElement.add(level, "geo.xml");
  }

  public static void main(String args[])
    throws Exception {
    XMLReader xr = XMLReaderFactory.createXMLReader();
    MySAXApp handler = new MySAXApp();
    xr.setContentHandler(handler);
    xr.setErrorHandler(handler);

    // Parse each file provided on the
    // command line.
    FileReader r = new FileReader("geo.xml");
    xr.parse(new InputSource(r));
  }

  public void startDocument() {
  }

  public void startElement(String uri, String name, String qName, Attributes atts) {
    level++;
    currentElement.add(level, qName);
    System.out.println("<" + qName + " >");

  }

  public void characters(char ch[], int start, int length) {
    String word = "";
    for (int i = start; i < start + length; i++) {
      switch (ch[i]) {
        case '\\':
          // System.out.print("\\\\");
          break;
        case '"':
          //System.out.print("\\\"");
          break;
        case '\n':
          //System.out.print("\\n");
          break;
        case '\r':
          //System.out.print("\\r");
          break;
        case '\t':
          //System.out.print("\\t");
          break;
        default:
          word += ch[i];
          //System.out.println(ch[i]);
          break;
      }
    }
    System.out.println(word);
  }

  public void endElement(String uri, String name, String qName) {
    System.out.println("</" + qName + " >");
    level--;
  }

  public void endDocument() {
  }

  /**
   * ************************************************************
   * UNUSED METHODS
   * **************************************************************
   */

  public void error(SAXParseException e) {
    //Receive notification of a recoverable parser error.
  }

  public void fatalError(SAXParseException e) {
    //Report a fatal XML parsing error.
  }

  public void ignorableWhitespace(char[] ch, int start, int length) {
    //Receive notification of ignorable whitespace in element content.
    System.out.println("ignorableWhitespace");
  }

  public void endPrefixMapping(String prefix) {
    //Receive notification of the end of a Namespace mapping.
    System.out.println("endPrefixMapping");
  }

  public void notationDecl(String name, String publicId, String systemId) {
    // Receive notification of a notation declaration.
    System.out.println("notationDecl");
  }

  public void processingInstruction(String target, String data) {
    // Receive notification of a processing instruction.
    System.out.println("processingInstruction");

  }

  public InputSource resolveEntity(String publicId, String systemId) {
    // Resolve an external entity.
    System.out.println("resolveEntity");
    return null;
  }

  public void setDocumentLocator(Locator locator) {
    //Receive a Locator object for document events.
    System.out.println("setDocumentLocator");

  }

  public void skippedEntity(String name) {
    //Receive notification of a skipped entity.
    System.out.println("skippedEntity");

  }

  public void startPrefixMapping(String prefix, String uri) {
    //Receive notification of the start of a Namespace mapping.
    System.out.println("startPrefixMapping");

  }

  public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName) {
    //Receive notification of an unparsed entity declaration.
    System.out.println("unparsedEntityDecl");

  }

  public void warning(SAXParseException e) {
    //Receive notification of a parser warning.
    System.out.println("warning");

  }
}
