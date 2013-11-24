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
      String myURL = null;
      TwitterConnect twitterConnect;

    /* CONSTRUCTEURS */
    public SearchInTwitter(){
        int myChoice;
        System.out.println("Choisissez");
        System.out.println("1- Récupérer Tweets");
        System.out.println("2- Afficher infos users");
        System.out.println("3- Rechercher des Tweets");
        System.out.println("Sinon Quitter");

        Scanner sc = new Scanner(System.in);
        myChoice = sc.nextInt();
        switch(myChoice) {
            case 1: myURL="";getSomeTweets();break;
            case 2: myURL="https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=franceinter";getUser();break;
            case 3:
               // myURL="https://api.twitter.com/1.1/search/tweets.json?q=%23freebandnames&since_id=24012619984051000&m        ax_id=250126199840518145&result_type=mixed&count=4 ";
                myURL = "https://api.twitter.com/1.1/search/tweets.json";
                getATweet();break;
            default:System.exit(0);break;
        }
    }
    /* METHODES */
    public void getSomeTweets(){
        twitterConnect = new TwitterConnect(myURL);
     }
    public void getUser(){
        twitterConnect = new TwitterConnect(myURL);
        DBObject myDatasGetted = (DBObject)twitterConnect.returnDatasGetted();
       new ReadDBObject(myDatasGetted);
    }
    public void getATweet(){
        new TwitterConnect(myURL);
        DBObject myDatasGetted = (DBObject)twitterConnect.returnDatasGetted();
        System.out.println("Tweet: "+myDatasGetted);
    }

/* ***************** MAIN ************************ */
/**/    public static void main(String[] args) { /**/
/**/        new SearchInTwitter();               /**/
/**/    }                                        /**/
/* *********************************************** */

}
