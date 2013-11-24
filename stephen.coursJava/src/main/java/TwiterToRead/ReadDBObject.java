package TwiterToRead;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 18/11/13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class ReadDBObject {
    BasicDBList dbl ;

    public ReadDBObject(DBObject dbo){
       JSONArray ja = JSONArray.fromObject(dbo);
       for(int i=0; i<ja.size();i++){
          JSONObject ja2 = (JSONObject) ja.get(i);
          System.out.println(ja2.toString());
       }
    }
}
