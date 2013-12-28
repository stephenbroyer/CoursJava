package Flickr;

import org.xml.sax.SAXException;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.URLConnection;
import java.net.URL;
import java.util.Scanner;


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
    private String tag;


    public FlickrConnect(){
        URLConnection uc;
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("entrer un tag");
            tag = sc.nextLine();

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


        try
        {   /* lecture fichier xml */
            SimpleSaxParser ssp =  new SimpleSaxParser("flickr.xml");
           /* ouverture image */
            JFrame f = new JFrame("Load Image Sample");
            f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            f.add(new LoadImageApp(ssp.server,ssp.id,ssp.secret));
            f.pack();
            f.setVisible(true);


        }
        catch (SAXException se){}
        catch (IOException ioe){}

    }


    public static void main(String[] args) {
       /* recuperation xml */
       new FlickrConnect();

    }
}
