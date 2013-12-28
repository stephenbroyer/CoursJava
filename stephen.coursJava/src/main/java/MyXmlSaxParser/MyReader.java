package MyXmlSaxParser;

import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MyReader {

  public MyReader(String file){

    try{
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      MyHandlerToDisplay myHandlerToDisplay = new MyHandlerToDisplay();

      saxParser.parse(new File(file), myHandlerToDisplay);

      myHandlerToDisplay.getCountryList();
      myHandlerToDisplay.getTownList();

    }catch(ParserConfigurationException e){
      throw new MyException("Erreur de configuration du parseur",e);
    }catch(SAXException e){
      throw new MyException("Erreur de parsing",e);
    }catch(IOException e){
      throw new MyException("Erreur d'entrée/sortie",e);
    }

  }
}
