package coursJava;

public class Contact extends Personne
{
    /** ATTRIBUTS **/
    public Personne personne;
    public String email;
    public String groupe;

    /** CONSTRUCTEUR **/
    public Contact(String lenom, String leprenom,String lenumero, String larue,String lecp,String laville,String letel, String unEmail, String unGroupe ){
        super(lenom, leprenom, lenumero,  larue, lecp, laville, letel);
        this.email=unEmail;
        this.groupe=unGroupe;

    }
    public Contact(){}

    /** GETTERS **/
   public String getGroupe() {
        return groupe;
    }
    public String getEmail (){
        return email;
    }
    public void setEmail(String lemail){
        this.email=lemail;
    }
    public void setGroupe (String legroupe){
        this.groupe=legroupe;
    }
}


