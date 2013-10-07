package coursJava;

public class Adresse {

    /** ATTRIBUTS **/
    private int numero;
    private String rue;
    private int cp;
    private String ville;

    /** CONSTRUCTEUR **/

    public Adresse(int lenumero,String larue,int lecp,String laville){

        this.numero=lenumero;
        this.rue=larue;
        this.cp=lecp;
        this.ville=laville;
    }
    public Adresse(){};

    /** GETTERS **/

    public int getNumero() {
        return numero;
    }
    public String getRue() {
        return rue;
    }

    public int getCp() {
        return cp;
    }
    public String getVille() {
        return ville;
    }
    public void setNumero(int n){
        this.numero = n;
    }
    public void setRue(String s){
        this.rue = s;
    }

    public void setCp(int i){
        this.cp = i;
    }
    public void setVille(String s){
        this.ville = s;
    }
}
