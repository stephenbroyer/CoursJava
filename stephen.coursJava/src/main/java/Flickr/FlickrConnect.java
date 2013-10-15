package Flickr;

import myXmlParser.SimpleSaxParser;
import org.xml.sax.SAXException;

import java.io.*;
import java.net.URLConnection;
import java.net.URL;


/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 15/10/13
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class FlickrConnect {

    private String key = "3b164ce95f32f547f43489b201005fbd";
    private int nbImages;
    private String tag="sun";


    public FlickrConnect(){
        URLConnection uc;
        try
        {
            uc = new URL("http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=" +
                    key + "&per_page=" + nbImages + "&text=" + tag).openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            FileWriter fw = new FileWriter(new File("flickr.xml"));

            String nextline;
            while ((nextline = in.readLine()) != null) {
                fw.append(nextline);
            }

            in.close();
            fw.close();
        }
        catch (IOException ioe){System.out.println(ioe);}
    }

    public static void main(String[] args) {
        new FlickrConnect();
       try
       {
           SimpleSaxParser ssp =  new SimpleSaxParser("flickr.xml");
           //recupérer variables  de SimpleContentHandler

       }
       catch (SAXException se){}
       catch (IOException ioe){}

    }

}
