package MyXmlSaxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandlerToReWrite extends DefaultHandler {


  boolean boolLocation = false, boolLat = false, boolLon = false, boolContryId = false;
  private List<Town> townList;
  private int id;

  public MyHandlerToReWrite() {
    super();
    townList = new ArrayList<Town>();
  }

  public void startDocument() {
  }

  public void startElement(String uri, String localName, String qName,
                           Attributes attributes) throws SAXException {
    if (qName.equals("town")) {
      this.id = Integer.valueOf(attributes.getValue(0));
      townList.add(id, new Town());
    }
    if (qName.equalsIgnoreCase("location")) {
      boolLocation = true;
    }
    if (qName.equalsIgnoreCase("lat")) {
      boolLat = true;
    }
    if (qName.equalsIgnoreCase("lon")) {
      boolLon = true;
    }
    if (qName.equalsIgnoreCase("countryId")) {
      boolContryId = true;
    }
  }

  public void endElement(String uri, String localName, String qName) throws SAXException {
  }

  public void characters(char ch[], int start, int length) throws SAXException {
    if (boolLocation) {
      String location = new String(ch, start, length);
      townList.get(id).setLocation(location);
      boolLocation = false;
    }
    if (boolLat) {
      String lat = new String(ch, start, length);
      townList.get(id).setLat(lat);
      boolLat = false;
    }
    if (boolLon) {
      String lon = new String(ch, start, length);
      townList.get(id).setLon(lon);
      boolLon = false;
    }
    if (boolContryId) {
      String countryId = new String(ch, start, length);
      boolContryId = false;
      townList.get(id).setCountryId(countryId);
    }
  }

  public List<Town> getTownList() {
    return townList;
  }
}
