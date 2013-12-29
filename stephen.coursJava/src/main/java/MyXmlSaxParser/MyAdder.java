package MyXmlSaxParser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MyAdder {

  private List<Town> townList;

  public MyAdder(String file) {
    try {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      MyHandlerToReWrite myHandlerToReWrite = new MyHandlerToReWrite();

      saxParser.parse(new File(file), myHandlerToReWrite);
      townList = myHandlerToReWrite.getTownList();

      this.insert(new Town("New-York", "70", "77", "7"));

    } catch (ParserConfigurationException e) {
      throw new MyException("Erreur de configuration du parseur", e);
    } catch (SAXException e) {
      throw new MyException("Erreur de parsing", e);
    } catch (IOException e) {
      throw new MyException("Erreur d'entrée/sortie", e);
    }
  }

  public void insert(Town townToInsert) {
    townList.add(townToInsert);
    MyCreator myCreator = new MyCreator(townList);
    myCreator.write("geo.xml");
  }//insert()
}//MyAdder
