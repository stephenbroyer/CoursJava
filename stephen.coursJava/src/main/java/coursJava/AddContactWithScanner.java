package coursJava;

import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * User: PortStephen
 * Date: 14/10/13
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 */
public class AddContactWithScanner {

    public String nom, prenom,telephone,numero,rue,cp,ville,email,groupe;
    public Adresse uneAdresse = new Adresse();

    public AddContactWithScanner(Personne p){

        System.out.println("** ADD CONTACT WITH SCANNER **");
        Scanner sc = new Scanner(System.in);
        System.out.println("NOM ?");
        nom = sc.nextLine();
        System.out.println("PRENOM ?");
        prenom = sc.nextLine();
        System.out.println("TELEPHONE ?");
        telephone = sc.nextLine();

        System.out.println("Adresse: NUMERO ?");
        numero = sc.nextLine();
        System.out.println("RUE ?");
        rue = sc.nextLine();
        System.out.println("CP ?");
        cp = sc.nextLine();
        System.out.println("VILLE ?");
        ville = sc.nextLine();
        System.out.println("EMAIL ?");
        email = sc.nextLine();
        System.out.println("GROUPE ?");
        groupe = sc.nextLine();


        Contact ctc = new Contact();
        ctc.setNom(nom);
        ctc.setPrenom(prenom);
        ctc.setTelephone(telephone);

        uneAdresse.setNumero(numero);
        uneAdresse.setRue(rue);
        uneAdresse.setCp(cp);
        uneAdresse.setVille(ville);

        ctc.setAdresse(uneAdresse);

        ctc.setEmail(email);
        ctc.setGroupe(groupe);

        p.addContact(ctc);
    }
}
