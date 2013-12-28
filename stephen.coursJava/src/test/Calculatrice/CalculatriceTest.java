package Calculatrice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CalculatriceTest {

    private Calculatrice myC;

    @Before
    public void setUp(){
       myC = new Calculatrice();
      System.out.println("build");

    }

    @Test
    public void TestCalc(){
      System.out.println("test");

      try{
            int intVerification =  myC.doCalc(5,4,'+');
        System.out.println("calc");

        int intHoped = 9;
            Assert.assertTrue(intVerification == intHoped);
        System.out.println("assertOK");

      }catch (Exception e){
            System.err.println("LE TEST CALCULATRICE RENVOIE UNE ERREUR POUR L'ADDITION");
        }
    }

}
