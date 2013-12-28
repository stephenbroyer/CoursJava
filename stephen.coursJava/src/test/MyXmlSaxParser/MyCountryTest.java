package MyXmlSaxParser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MyCountryTest {

  private MyCountry myCountry;
  @Before
  public void createInstance(){
    myCountry = new MyCountry();
    myCountry.setName("nameToVerify");
    myCountry.setId("12");
  }
  @Test
  public void testGetAndSet(){
    assertTrue(myCountry!=null);
    assertEquals("nameToVerify",myCountry.getName());
    assertEquals("12",myCountry.getId());
  }
}
