package MyXmlSaxParser;

public class MyCountry {
  private String name;
  private String id;

   public void setName(String name){
     this.name = name;
   }

  public void setId(String id){
    this.id = id;
  }

  public String getId(){
    return this.id;
  }
  public String getName(){
    return this.name;
  }
  public boolean isNothingEmpty(){
    if(!"".equals(this.name) && !"".equals(this.id)){
      return true;
    } else{
      return false;
    }
  }
}
