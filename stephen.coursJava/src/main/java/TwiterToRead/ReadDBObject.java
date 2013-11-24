package TwiterToRead;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 18/11/13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class ReadDBObject{
    /* AtTIBUTS */
    private BasicDBList dbl ;
    private JSONArray jsonArray;
    private List<Object> jsonObjectList;
    private Object object;
    private String myString;

    /* CONSTRUCTEUR */
    public ReadDBObject(DBObject dbo){
       jsonArray = JSONArray.fromObject(dbo);
    }
    /* METHODES */
    public void getFromMyChoice(int myChoice){
        switch (myChoice){
            case 1: break;
            case 2: getUserDetails();break;
            case 3: break;
            case 4: getCountryDetails(); break;
            default:
        }
    }
    public void getUserDetails(){
        myString = jsonArray.toString();
        StringTokenizer st = new StringTokenizer(myString, ",");
        boolean isTrue=false;
        while (st.hasMoreTokens()) {
            String stringDetails = st.nextToken();
            try{isTrue = stringDetails.substring(0,6).equals("\"user\"");}catch (Exception e){  }

            if (isTrue){
              System.err.println(stringDetails);
            }else{
                System.out.println(stringDetails);
            }

        }
    }
    public void getCountryDetails(){
        myString = jsonArray.toString();
        StringTokenizer st = new StringTokenizer(myString, ",");
        boolean isTrue=false;
        while (st.hasMoreTokens()) {
            String stringDetails = st.nextToken();
            try{isTrue = stringDetails.substring(0,9).equals("\"country\"");}catch (Exception e){  }

            if (isTrue){
                System.err.println(stringDetails);
            }else{
                System.out.println(stringDetails);
            }
        }
    }

}
