package TwiterToRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Vector;

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

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
import teatcherXMLParser.Authentication;

public class TwitterFeed {
/* ATTRIBUTS */
	private HttpGet request = null;
	private int number = 0;
    //MongoDB connection
	private DB db = null;
    //MongoDB server
	private Mongo m = null;
    private Vector <String> myVector = new Vector<String>();
    private String tempo;


/* CONSTRUCTEUR */
	public TwitterFeed() {
		Authentication app = getConnectionData("app.xml");
		connect();
		request = connect(app);
        retrieve(request);
        printMyVector(myVector);
	}

/* METHODES */
	/**
	 * The connection method connects to the MongoDB database
	 */
	private void connect() {
		try {
			m = new Mongo( Configuration.mongo_location , Configuration.mongo_port );
			db = m.getDB(Configuration.mongo_database);
		} //try
		catch (Exception e) {
			e.printStackTrace();

		} //catch

	} //connect

	/**
	 * The retrieve method is responsible to read the content from the stream
	 * and to provide to consumers
	 * 
	 * @param request
	 *            the request to access the stream
	 */
	private void retrieve(HttpGet request) {

		String in;
		try {

			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {

				InputStream inputStream = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inputStream));

				// since this is a continuous stream, there is no end with the
				// readLine, we just check whether live boolean variable is set
				// to false
				while ((in = reader.readLine()) != null) {
					number++;
					//store the JSON result in MongoDB
					DBCollection collection = db.getCollection(Configuration.mongo_collection);
						
					// convert JSON to DBObject directly
					DBObject dbObject = (DBObject)JSON.parse(in);

					//insert into the database
					collection.insert(dbObject);
                    System.out.println("**********************************************************");
                    System.out.println(in);

                    tempo = (String) dbObject.get("text");
                    myVector.add(tempo);

                    if(number == 100){
						System.exit(0);
                    }

				} // while

			} // if

		} // try
		catch (Exception e) {

			e.printStackTrace();

		} // catch

	} // retrieve()
	
	/**
	 * getConnectionData retrieves the data for the authentication
	 * @param stFile the file containing the data for the OAuth authentication
	 * @return an instance of Authentication containing the data
	 */
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
			
		} //try
		catch (FileNotFoundException e) {

			e.printStackTrace();

		} // catch
		
		catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		} // catch
		
		catch (SAXException e) {

			e.printStackTrace();

		} // catch
		
		catch (IOException e) {

			e.printStackTrace();

		} // catch

		return sr;
		
	} //getConnectionData()
	
	/**
	 * The connect method connects to the stream via OAuth
	 * 
	 * @param app
	 *            the data for connection
	 * @return the request
	 */
	private HttpGet connect(Authentication app) {

		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
				app.getConsumerKey(), app.getConsumerSecret());

		consumer.setTokenWithSecret(app.getAccessToken(), app.getAccessSecret());
		HttpGet request = new HttpGet("https://stream.twitter.com/1.1/statuses/sample.json");

		try {

			consumer.sign(request);

		} // try
		catch (OAuthMessageSignerException e) {

			e.printStackTrace();

		} // catch
		catch (OAuthExpectationFailedException e) {

			e.printStackTrace();

		} // catch
		catch (OAuthCommunicationException e) {

			e.printStackTrace();

		} // catch

		return request;

	} // connect()

    private void printMyVector (Vector theVectorToPrint){
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(theVectorToPrint.elements());

    }
	public static void main(String[] args) {
		new TwitterFeed();
	}
}

/*
Pour MongoDB
- ouvrir cmd
- repertoire ou est mongo
 > mongo
 > show dbs          on doit voir dim
 > use dim
 > show collections     on doit voir tweets
 > db.tweets.count()    on doit voir le nombre de tweets
 =>  O
 */