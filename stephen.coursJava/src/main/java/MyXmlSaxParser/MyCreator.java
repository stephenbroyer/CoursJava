package MyXmlSaxParser;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCreator{

  private  List<Town> listTown;
  public MyCreator(){
    listTown = new ArrayList<Town>();
    listTown.add(new Town("London","10","11","1"));
    listTown.add(new Town("Madrid","20","22","2"));
    listTown.add(new Town("Tokyo","30","33","3"));
    listTown.add(new Town("Berlin","40","44","4"));
    listTown.add(new Town("Moscou","50","55","5"));
    listTown.add(new Town("Paris","60","66","6"));
  }
  public MyCreator(List<Town> townList){
    this.listTown = townList;
  }

  public boolean write(String file){
    XMLOutputFactory factory      = XMLOutputFactory.newInstance();

    try {
      XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(file));

      /* OPTIONNAL TO HAVE A READABLE INDENTED DOCUMENT */
      writer = new IndentingXMLStreamWriter(writer);

      /* START READING DOCUMENT */
      writer.writeStartDocument();
      /* FIRST ELEMENT CALLED <document> */
      writer.writeStartElement("document");
      /* SECOND ELEMENT UNDER CALLED <towns> */
      writer.writeStartElement("towns");

      /* FOR EACH <town> ADD  AN ID IN TOWN ELEMENT AND ADD <location> <lat> <lon> <countryID> */
      /* DON'T FORGET TO CLOSE EACH ELEMENT */
      for(int indexTown=0;indexTown<listTown.size();indexTown++){
        writer.writeStartElement("town");
        writer.writeAttribute("id", String.valueOf(indexTown + 1));

        writer.writeStartElement("location");
        writer.writeCharacters(listTown.get(indexTown).getLocation());
        writer.writeEndElement();

        writer.writeStartElement("lat");
        writer.writeCharacters(listTown.get(indexTown).getLat());
        writer.writeEndElement();

        writer.writeStartElement("lon");
        writer.writeCharacters(listTown.get(indexTown).getLon());
        writer.writeEndElement();

        writer.writeStartElement("countryId");
        writer.writeCharacters(listTown.get(indexTown).getCountryId());
        writer.writeEndElement();

        writer.writeEndElement();


       }
      /* DON'T FORGET TO CLOSE EACH ELEMENT AND DOCUMENT  */
      writer.writeEndElement();
      writer.writeEndElement();
      writer.writeEndDocument();

      /* PUSH THE DATAS */
      writer.flush();
      /* CLOSE THE WRITER !! */
      writer.close();

      return true;

    } catch (XMLStreamException e) {
      throw new MyException("XMLStreamException",e);
    } catch (IOException e) {
      throw new MyException("IOException",e);

    }
  }
}
