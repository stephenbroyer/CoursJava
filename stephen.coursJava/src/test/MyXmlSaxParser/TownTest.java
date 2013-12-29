package MyXmlSaxParser;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TownTest {

  private Town town1, town2;

  @Before
  public void createInstance() {
    town1 = new Town();
    town1.setLocation("Paris");
    town1.setLat("100");
    town1.setLon("10");
    town1.setCountryId("1");

    town2 = new Town("Madrid", "200", "20", "2");
  }

  @Test
  public void testSettersAndGetters() throws Exception {
    assertEquals("Paris", town1.getLocation());
    assertEquals("100", town1.getLat());
    assertEquals("10", town1.getLon());
    assertEquals("1", town1.getCountryId());
    assertEquals("Madrid", town2.getLocation());
    assertEquals("200", town2.getLat());
    assertEquals("20", town2.getLon());
    assertEquals("2", town2.getCountryId());

  }

}
