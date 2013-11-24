package TwiterToRead;

import com.mongodb.DBObject;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 18/11/13
 * Time: 09:51
 * To change this template use File | Settings | File Templates.
 */
public class SearchInTwitter {

    /* ATTRIBUTS */
      private String myURL = null;
      private TwitterConnect twitterConnect;
      private int myChoice;

    /* CONSTRUCTEURS */
    public SearchInTwitter(){
        System.out.println("Choisissez");
        System.out.println("1- Récupérer Tweets");
        System.out.println("2- Afficher infos users");
        System.out.println("3- Rechercher des Tweets");
        System.out.println("4- Rechercher des pays");

        System.out.println("Sinon Quitter");

        Scanner sc = new Scanner(System.in);
        myChoice = sc.nextInt();
         //myChoice=2;

        switch(myChoice) {
            case 1: myURL="";
                    break;
            case 2: System.out.println("Enter user name:");
                    //String user = sc.next();
                    String user = "franceinter";
                    myURL="https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+user+"";
                    break;
            case 3:
                    // myURL="https://api.twitter.com/1.1/search/tweets.json?q=%23freebandnames&since_id=24012619984051000&m        ax_id=250126199840518145&result_type=mixed&count=4 ";
                    myURL = "https://api.twitter.com/1.1/search/tweets.json";
                    break;
            case 4: myURL="https://api.twitter.com/1.1/geo/id/df51dec6f4ee2b2c.json";
                    break;

            default:System.exit(0);break;
        }
        getDatas();

    }
    /* METHODES */
    public void getDatas(){
        twitterConnect = new TwitterConnect(myURL);
        DBObject myDatasGetted = (DBObject)twitterConnect.returnDatasGetted();
        ReadDBObject readDBObject = new ReadDBObject(myDatasGetted);
        readDBObject.getFromMyChoice(myChoice);
    }

/* ***************** MAIN ************************ */
/**/    public static void main(String[] args) { /**/
/**/        new SearchInTwitter();               /**/
/**/    }                                        /**/
/* *********************************************** */

}
