package MyXmlSaxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandlerToDisplay extends DefaultHandler {

  boolean boolLocation = false, boolLat = false, boolLon = false, boolContryId = false, boolName = false, bollId = false;
  int level;

  public MyHandlerToDisplay() {
    super();
    level = 0;
  }

  public void startDocument() {

  }


  public void startElement(String uri, String localName, String qName,
                           Attributes attributes) throws SAXException {
    level++;
    System.out.println(getSpaceToadd() + "<" + qName + ">");

    if (qName.equalsIgnoreCase("location")) {
      boolLocation = true;
    }
    if (qName.equalsIgnoreCase("lat")) {
      boolLat = true;
    }
    if (qName.equalsIgnoreCase("lon")) {
      boolLon = true;
    }
    if (qName.equalsIgnoreCase("countryid")) {
      boolContryId = true;
    }
    if (qName.equalsIgnoreCase("name")) {
      boolName = true;
    }
    if (qName.equalsIgnoreCase("id")) {
      bollId = true;
    }
  }

  public void endElement(String uri, String localName, String qName) throws SAXException {
    System.out.println(getSpaceToadd() + "</" + qName + ">");
    level--;
  }

  public void characters(char ch[], int start, int length) throws SAXException {
    level++;
    if (boolLocation) {
      String location = new String(ch, start, length);
      System.out.println(getSpaceToadd() + location);
      boolLocation = false;
    }
    if (boolLat) {
      String lat = new String(ch, start, length);
      System.out.println(getSpaceToadd() + lat);
      boolLat = false;
    }
    if (boolLon) {
      String lon = new String(ch, start, length);
      System.out.println(getSpaceToadd() + lon);
      boolLon = false;
    }
    if (boolContryId) {
      String countryId = new String(ch, start, length);
      System.out.println(getSpaceToadd() + countryId);
      boolContryId = false;
    }
    level--;
  }

  private String getSpaceToadd() {
    String spacesToAdd = "";
    for (int i = 0; i < level; i++) {
      spacesToAdd += "  ";
    }
    return spacesToAdd;
  }

}
