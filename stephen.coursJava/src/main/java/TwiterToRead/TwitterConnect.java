package TwiterToRead;

import com.mongodb.*;
import com.mongodb.util.JSON;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import teatcherXMLParser.Authentication;

import java.io.*;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 18/11/13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
public class TwitterConnect {

    /* ATTRIBUTS */
    private HttpGet request = null;
    private DB db = null;//MongoDB connection
    private Mongo m = null; //MongoDB server
    public DBObject datasGetted;

    /* CONSTRUCTEUR */
    public TwitterConnect(String myURL) {
        Authentication app = getConnectionData("app.xml");
        mongoConnect();
        request = connect(app,myURL);
        retrieve(request);
    }
    /* METHODES */
    public DBObject returnDatasGetted(){
            return datasGetted;
        }
    private void mongoConnect() {
        try {   m = new Mongo( Configuration.mongo_location , Configuration.mongo_port );
                db = m.getDB(Configuration.mongo_database);
        } catch (Exception e) {e.printStackTrace(); }
    }
    private void retrieve(HttpGet request) {
        String in;
        try {   HttpClient client = new DefaultHttpClient();
                HttpResponse response = client.execute(request);
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream inputStream = entity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    while ((in = reader.readLine()) != null) {
                        datasGetted = (DBObject) JSON.parse(in);
                        System.out.println("In retrieve: "+datasGetted);
                    }
                }
            }catch (Exception e) {e.printStackTrace();}
        }
    private Authentication getConnectionData(String stFile) {
        Authentication sr = null;
        try {
            //open the file and parse it to retrieve the four required information
            File file = new File(stFile);
            InputStream inputStream;
            inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, "ISO-8859-1");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            XMLReader saxReader = XMLReaderFactory.createXMLReader();
            sr = new Authentication();
            saxReader.setContentHandler(sr);
            saxReader.parse(is);

        }catch (FileNotFoundException e) { e.printStackTrace();}
         catch (UnsupportedEncodingException e) { e.printStackTrace();}
         catch (SAXException e) { e.printStackTrace();}
         catch (IOException e) {e.printStackTrace();}

        return sr;
    }
    private HttpGet connect(Authentication app, String myURL) {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(app.getConsumerKey(), app.getConsumerSecret());
        consumer.setTokenWithSecret(app.getAccessToken(), app.getAccessSecret());
        HttpGet request = new HttpGet(myURL);
        try {
            consumer.sign(request);
        }catch (OAuthMessageSignerException e) {e.printStackTrace();}
        catch (OAuthExpectationFailedException e) {e.printStackTrace();}
        catch (OAuthCommunicationException e) {e.printStackTrace();}

        return request;
    }
}