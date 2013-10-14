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

    public String nom, prenom,telephone;

    public AddContactWithScanner(Personne p){

        System.out.println("** ADD CONTACT WITH SCANNER **");
        Scanner sc = new Scanner(System.in);
        System.out.println("NOM ?");
        nom = sc.nextLine();
        System.out.println("PRENOM ?");
        prenom = sc.nextLine();
        System.out.println("TELEPHONE ?");
        telephone = sc.nextLine();

        Contact ctc = new Contact();
        ctc.setNom(nom);
        ctc.setPrenom(prenom);
        ctc.setTelephone(telephone);
        //ctc.personne.adresse.setCompleteAddress("","","","");
        ctc.adresse.setNumero("100");
        ctc.adresse.setRue("rue ilvousenprie");
        ctc.adresse.setCp("74005");
        ctc.adresse.setVille("Annecy");
        ctc.setEmail("@@");
        ctc.setGroupe("famille");

        p.addContact(ctc);
    }
}
