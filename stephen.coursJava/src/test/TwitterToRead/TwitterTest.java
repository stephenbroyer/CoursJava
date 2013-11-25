package TwitterToRead;

import TwiterToRead.SearchInTwitter;
import com.mongodb.DBObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 25/11/13
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
public class TwitterTest {
    private SearchInTwitter searchInTwitter;

    @Before
    public void setUp() {
        searchInTwitter = new SearchInTwitter();
        searchInTwitter.setURL("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=franceinter");
    }

    @After
    public void tearDown()  {
    }

    @Test
    public void testTwitter(){
        searchInTwitter.getDatas();
        Assert.assertTrue(searchInTwitter.getClassOfDatats() == DBObject.class);
    }
}
