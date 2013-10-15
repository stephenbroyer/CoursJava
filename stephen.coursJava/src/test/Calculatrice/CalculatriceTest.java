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
    public void setUp() throws Exception {
       myC = new Calculatrice();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void TestCalc() throws Exception {
       //Assert.assertTrue(myC.doCalc(5,4,"+")==9);

    }
}
