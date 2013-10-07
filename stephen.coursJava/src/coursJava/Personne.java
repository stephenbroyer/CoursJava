package coursJava;

import java.util.Vector;

public class Personne {

    /** ATTRIBUTS **/
    public String nom;
    public String prenom;
    public Adresse adresse;
    public String telephone;
    public int id;
    public Vector <Contact> listeDesContact=new Vector<Contact>();

    /** CONSTRUCTEUR **/

    public Personne(String lenom, String leprenom,int lenumero, String larue,int lecp,String laville,String letel,int lid){
        this.nom=lenom;
        this.prenom=leprenom;
        this.adresse=new Adresse(lenumero,larue,lecp,laville);
        this.telephone=letel;
        this.id=lid;
    }
    public Personne(){

    }

    /** METHODES **/

    public void addContact(Contact nouveauContact) {

        try
        {
            listeDesContact.addElement(nouveauContact);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    /** GETTERS **/
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public Adresse getAdresse() {
        return adresse;
    }
    public String getTelephone() {
        return telephone;
    }
    public int getId() {
        return id;
    }
    public String getCompleteName() {
        return prenom+" "+nom;
    }
    public void setNom(String x){
        this.nom = x;
    }
    public void setPrenom(String x){
        this.prenom = x;
    }
    public void setAdresse(Adresse x){
        this.adresse = x;
    }
    public void setTelephone(String x){
        this.telephone = x;
    }


}