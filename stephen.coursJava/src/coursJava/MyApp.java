package coursJava;

import java.util.Scanner;

public class MyApp {

    /* ATTRIBUTS */
    public Personne maurice;
    public Contact germaineContact;

    /* CONSTRUCTEUR */
    public MyApp(){

       System.out.println("***************");
/* Creation d'une personne */
        maurice = new Personne("Dupond","Maurice","5","rue de la berge","74000","Annecy","0607080910");
        System.out.print(maurice.getPrenom()+" ");
        System.out.println(maurice.getNom());
/* Recuperation des caracteristiques de cette personne grace aux getters */
        System.out.print    (maurice.getAdresse().getNumero()+" ");
        System.out.println  (maurice.getAdresse().getRue());
        System.out.print    (maurice.getAdresse().getCp()+"  ");
        System.out.println  (maurice.getAdresse().getVille());
        System.out.println(maurice.getTelephone());

/* essai d'une petite calculatrice, RIEN A VOIR   et essai d'exception */
        System.out.println("***************");
        try{
            new Calculatrice(10,5,'+');
            /* essai de dividion par zero */
            new Calculatrice(5,0,'/');
        }
        catch (DivideZeroException e){
               new DivideZeroException(e.toString());
        }

/* Ajout d'un liste de contact */
        for (int i=0; i<2;i++){
            maurice.listeDesContact.addElement(
                    new Contact(    "Nom-"+i,
                            "Prenom-"+i,
                            i+"bis",
                            "rue street-"+i,
                            "7400"+i,
                            "annecy-"+i,
                            "060000000"+i,
                            i+"@net.com",
                            "groupe-"+i));
        }
/* ajout d'un nouveau contact dans la liste des contacts de Maurice */
        System.out.println("****** add contact with reader *********");
        germaineContact = new Contact("Durand", "Germaine","10", "rue du bois", "74370", "Argonay", "0611223344","germaine@gmail.com", "famille");
        AjoutDeContact oneMore = new AjoutDeContact(maurice, germaineContact);
        oneMore.getByKeyBoard(maurice);

/* ajout de contact with scanner */
        System.out.println("******* add contact with scanner ********");
        //AddContactWithScanner secondMore = new AddContactWithScanner(maurice);
          // NE MARCHE PAS NULLPOINTEREXCEPTION   A REVOIR !!!!!


/* Affichage de la liste de contacts de Maurice */
        System.out.println("***************");
        maurice.printListOfContacts();
    }

    public static void main(String[] args){
        new MyApp();

    }


}
