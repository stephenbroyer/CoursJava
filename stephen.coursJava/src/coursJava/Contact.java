package coursJava;

import java.util.Vector;

public class Contact extends Personne
{

    /** ATTRIBUTS **/
    public Personne personne;
    public String email;
    public String groupe;

    /** CONSTRUCTEUR **/
    public Contact(String lenom, String leprenom,int lenumero, String larue,int lecp,String laville,String letel,int lid, String unEmail, String unGroupe ){
        super(lenom, leprenom, lenumero,  larue, lecp, laville, letel, lid);
        this.email=unEmail;
        this.groupe=unGroupe;

    }
    public Contact(){}


}

