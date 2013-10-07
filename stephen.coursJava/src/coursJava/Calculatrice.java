package coursJava;

public class Calculatrice
{

    /** ATTRIBUTS **/
    public int operation;

    /** CONSTRUCTEUR **/

    public Calculatrice(int chiffre1, int chiffre2, char operateur)
    {


        switch (operateur)
        {
            case '+':
                operation=chiffre1+chiffre2;
                break;
            case '-':
                operation=chiffre1-chiffre2;
                break;
            case '*':
                operation=chiffre1*chiffre2;
                break;
            case '/':
                if (chiffre2!=0){operation=chiffre1/chiffre2;}
                else{System.out.println("DIVISION PAR 0");}
                break;
            default:
                System.out.println("operateur inconnu");
                break;
        }

        System.out.println(chiffre1+""+operateur+""+chiffre2+" = "+operation);

    }

}

