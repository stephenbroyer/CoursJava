package MyXmlSaxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandlerToReWrite extends DefaultHandler {


  private List<Town> townList;
  private Town town;
  boolean boolLocation = false , boolLat = false  ,boolLon = false , boolContryId=false;


  public MyHandlerToReWrite() {
    super();
    townList = new ArrayList<Town>();
    town = new Town();
  }
  public void startDocument(){
  }


  public void startElement(String uri, String localName, String qName,
                           Attributes attributes) throws SAXException {
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
      String location =  new String(ch, start, length);
      //System.err.println(location);
      town.setLocation(location);
      boolLocation = false;
    }
    if (boolLat) {
      String lat =  new String(ch, start, length);
      town.setLat(lat);
      boolLat = false;
    }
    if (boolLon) {
      String lon = new String(ch, start, length);
      town.setLon(lon);
      boolLon = false;
    }
    if(boolContryId){
      String countryId = new String(ch,start,length);
      boolContryId = false;
      System.out.println("before : " +town.getLocation()+"  "+town.getLat());

      townList.add(town);
      for(int i=0;i<townList.size();i++){
        System.out.println("after"+townList.get(i).getLocation());
      }
    }
  }

  public List<Town> getTownList (){
    /*
    for(int i=0;i<townList.size();i++){
      System.err.println(townList.get(i).getLocation());

    } */
    return townList;
  }
}
