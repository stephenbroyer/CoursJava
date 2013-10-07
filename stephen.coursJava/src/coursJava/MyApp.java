package coursJava;

import java.util.Scanner;

public class MyApp {

    /** ATTRIBUTS **/
    public Personne maurice;
    public Personne germaine;
    public Contact germaineContact,otherContact;
    public String otherName,otherfirstName,otherRue,otherVille,otherPhone;
    public int otherNumero,otherCp;
    public Adresse otherAddress = new Adresse();
    public String[] tab = {"Nom","Prenom","numero","rue","cp","ville","tel","email"};


    /** CONSTRUCTEUR **/

    public MyApp(){

        System.out.println("coucou");

        System.out.println("***************");

        maurice = new Personne("Dupond","Maurice",2,"rue de la berge",74000,"Annecy","0607080910",1);
        System.out.print(maurice.getPrenom()+" ");
        System.out.println(maurice.getNom());

        System.out.print(maurice.getAdresse().getNumero()+" ");
        System.out.println(maurice.getAdresse().getRue());
        System.out.print(maurice.getAdresse().getCp()+"  ");
        System.out.println(maurice.getAdresse().getVille());

        System.out.println(maurice.getTelephone());


        System.out.println("***************");
        new Calculatrice(10,5,'/');

        System.out.println("***************");
        Scanner sc = new Scanner(System.in);
        otherContact = new Contact();

        System.out.println("ENREGISTREMENT D'UN CONTACT");

        System.out.println("Entrer le nom");
        otherName = sc.nextLine();

        System.out.println("Entrer le prenom");
        otherfirstName = sc.nextLine();

        System.out.println("Entrer l'adresse");
        System.out.println("numero");
        otherNumero = sc.nextInt();
        System.out.println("rue");
        otherRue = sc.nextLine();
        System.out.println("code postal");
        otherCp = sc.nextInt();
        System.out.println("ville");
        otherVille = sc.nextLine();

        System.out.println("Entrer le telephone");
        otherPhone = sc.nextLine();

        otherAddress.setNumero(otherNumero);
        otherAddress.setRue(otherRue);
        otherAddress.setCp(otherCp);
        otherAddress.setVille(otherVille);

        otherContact.setNom(otherName);
        otherContact.setPrenom(otherfirstName);
        otherContact.setAdresse(otherAddress);
        otherContact.setTelephone(otherPhone);


        germaineContact = new Contact("Durand", "Germaine", 10, "rue du bois", 74370, "Argonay", "0611223344", 2,"germaine@gmail.com", "famille");


        new AjoutDeContact(maurice, germaineContact);
        new AjoutDeContact(maurice,otherContact);
        // faire une boucle pour recuperer l'ensemble des renseignements
        // pour cela creer un contact temporaire auquel on ajoute les donnees d'un contact
        // le pb vient de scanner qui type les variable recuperées ...

    }
    public static void main(String[] args) {
        new MyApp();

    }


}
