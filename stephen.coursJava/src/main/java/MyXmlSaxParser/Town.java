package MyXmlSaxParser;

public class Town {

  private String location, lat, lon, countryId;

  public Town() {
  }

  public Town(String location, String lat, String lon, String countryId) {
    this.location = location;
    this.lat = lat;
    this.lon = lon;
    this.countryId = countryId;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }

  public void setCountryId(String countryId) {
    this.countryId = countryId;
  }

  public String getLocation() {
    return this.location;
  }

  public String getLat() {
    return this.lat;
  }

  public String getLon() {
    return this.lon;
  }

  public String getCountryId() {
    return this.countryId;
  }
}
