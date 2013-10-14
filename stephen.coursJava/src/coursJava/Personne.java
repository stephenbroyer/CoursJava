package coursJava;

import java.util.Vector;

public class Personne {

    /** ATTRIBUTS **/
    public String nom;
    public String prenom;
    public Adresse adresse;
    public String telephone;
    public Vector <Contact> listeDesContact=new Vector<Contact>();

    /** CONSTRUCTEUR **/

    public Personne(String lenom, String leprenom,String lenumero, String larue,String lecp,String laville,String letel){
        this.nom=lenom;
        this.prenom=leprenom;
        this.adresse=new Adresse(lenumero,larue,lecp,laville);
        this.telephone=letel;
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

    public void printListOfContacts(){

       System.out.println("**** CONTACTS ****");
       for(int i=0; i<listeDesContact.size();i++)
       {
           System.out.println("** n° "+i+"**");
           System.out.println("*nom: "+listeDesContact.get(i).getNom());
           System.out.println("*prenom: "+listeDesContact.get(i).getPrenom());
           System.out.println("*adresse: "+listeDesContact.get(i).adresse.getCompleteAdress());
           System.out.println("*tel: "+listeDesContact.get(i).getTelephone());
           System.out.println("*mail: "+listeDesContact.get(i).getEmail());
           System.out.println("*groupe: "+listeDesContact.get(i).getGroupe());
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
    public String getCompleteName() {
        return prenom+" "+nom;
    }
    public Vector<Contact> getListOfContact(){
        return  listeDesContact;
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