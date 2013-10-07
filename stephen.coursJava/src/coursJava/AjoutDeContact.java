package coursJava;

public class AjoutDeContact {

    public AjoutDeContact (Personne persQuiRecoit, Contact ctAajouter)
    {
        if (persQuiRecoit.listeDesContact.contains(ctAajouter))
        {
            System.out.println("Ce contact existe deja.");
        }
        else
        {
            persQuiRecoit.listeDesContact.add(ctAajouter);
            System.out.println("Le contact "+ctAajouter.getCompleteName()+"  qui aura le numero "+persQuiRecoit.listeDesContact.indexOf(ctAajouter)+" a bien ete ajoute dans la liste de "+persQuiRecoit.getCompleteName());
        }
    }

}

