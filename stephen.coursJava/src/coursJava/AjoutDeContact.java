package coursJava;

import java.util.Vector;
import java.lang.String;
import  java.io.*;

public class AjoutDeContact {

    public Contact otherContact = new Contact();
    public String otherName,otherRue,otherVille,otherPhone,otherNumero,otherCp;
    public Adresse otherAddress = new Adresse();
    public String[] tab = {" le nom","le prenom","l'adresse: numero"," la rue"," le cp","la ville","le telephone","l\'email","le groupe"};
    public Vector <String> donnees= new Vector<String>();
    public String myStringToEnter;

    public AjoutDeContact (Personne persQuiRecoit, Contact ctAajouter)
    {
        if (persQuiRecoit.listeDesContact.contains(ctAajouter))
        {
            System.out.println("Ce contact existe deja.");
        }
        else
        {
            persQuiRecoit.listeDesContact.add(ctAajouter);
            System.out.println("Le contact "+ctAajouter.getCompleteName()+" a bien ete ajoute dans la liste de "+persQuiRecoit.getCompleteName()+"  et aura le numero "+persQuiRecoit.listeDesContact.indexOf(ctAajouter));
        }
    }

    public AjoutDeContact (){

    }

    public void getByKeyBoard (Personne persQuiRecoit)
    {

        System.out.println("ENREGISTREMENT D'UN CONTACT");
        for(int i=0; i<tab.length;i++)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Entrer "+ tab[i]);
            myStringToEnter = null;
            try
            {
                myStringToEnter = reader.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            donnees.addElement(myStringToEnter);
        }
        otherContact = new Contact(donnees.get(0),donnees.get(1),donnees.get(2),donnees.get(3),donnees.get(4),donnees.get(5),donnees.get(6),donnees.get(7),donnees.get(8));
        //otherContact = new Contact(donnees[0],donnees[1],donnees[2],donnees[3],donnees[4],donnees[5],donnees[6],donnees[7],donnees[8]);

        if (persQuiRecoit.listeDesContact.contains(otherContact))
        {
            System.out.println("Ce contact existe deja.");
        }
        else
        {
            persQuiRecoit.listeDesContact.add(otherContact);
            System.out.println("Le contact "+otherContact.getCompleteName()+" a bien ete ajoute dans la liste de "+persQuiRecoit.getCompleteName()+"  et aura le numero "+persQuiRecoit.listeDesContact.indexOf(otherContact));
        }
    }

}

