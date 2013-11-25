package Calculatrice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 15/10/13
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
public class CalculatriceTest {

    private Calculatrice myC;
    @Before
    public void setUp(){
       myC = new Calculatrice();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void TestCalc(){
        try{
            int intVerification =  myC.doCalc(5,4,'+');
            int intHoped = 9;
            Assert.assertTrue(intVerification == intHoped);
        }catch (Exception e){
            System.err.println("LE TEST CALCULATRICE RENVOIE UNE ERREUR POUR L'ADDITION");
            e.printStackTrace();}
    }
}
