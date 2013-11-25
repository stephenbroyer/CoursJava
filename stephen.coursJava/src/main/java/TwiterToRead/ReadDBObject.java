package TwiterToRead;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import java.util.StringTokenizer;


/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 18/11/13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class ReadDBObject{
    /* ATTRIBUTS */
    private BasicDBList basicDBList ;
    private DBObject dbObject;
    private Object object;
    private String myString;

    /* CONSTRUCTEUR */
    /**
     *
     * @param dbo
     */
    public ReadDBObject(DBObject dbo){
       dbObject = (DBObject) dbo;

    }

    /* METHODES */
    /**
     *
     * @param myChoice
     */
    public void getFromMyChoice(int myChoice){
        switch (myChoice){
            case 1: getTweet();
                    break;
            case 2: getUserDetails();
                break;
            case 3: getCountryDetails();
                    break;
            default:break;
        }
    }

    public void getUserDetails(){
        try{
            basicDBList = (BasicDBList) dbObject;
            dbObject = (DBObject) basicDBList.get(0);
            DBObject user =(DBObject) dbObject.get("user");

            //System.out.println("user: "+user);
            System.out.println("name: "+user.get("name"));
            System.out.println("location: "+user.get("location"));
            System.out.println("url: "+user.get("url"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getCountryDetails(){
        System.out.println("PAYS : "+dbObject.get("country"));
    }

    public void getTweet(){
        try{
            basicDBList = (BasicDBList) dbObject;
            dbObject = (DBObject) basicDBList.get(0);
            object =(Object) dbObject.get("text");

            //System.out.println("user: "+user);
            System.out.println("Text: "+object);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
