package coursJava;

public class Adresse {

    /* ATTRIBUTS */
    public String numero,rue,cp,ville;

    /* CONSTRUCTEUR */

    /**
     *
     * @param lenumero
     * @param larue
     * @param lecp
     * @param laville
     */
    public Adresse(String lenumero,String larue,String lecp,String laville){

        this.numero=lenumero;
        this.rue=larue;
        this.cp=lecp;
        this.ville=laville;
    }
    public Adresse(){};

    /** GETTERS **/
    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }
    public String getRue() {
        return rue;
    }

    public String getCp() {
        return cp;
    }
    public String getVille() {
        return ville;
    }
    public String getCompleteAdress(){
        return this.getNumero()+" "+this.getRue()+" "+this.getCp()+" "+this.getVille();
    }
    public void setNumero(String n){
        this.numero = n;
    }
    public void setRue(String s){
        this.rue = s;
    }

    public void setCp(String i){
        this.cp = i;
    }
    public void setVille(String s){
        this.ville = s;
    }

    /**
     *
     * @param lenum
     * @param larue
     * @param lecp
     * @param laville
     */
    public void setCompleteAddress(String lenum, String larue,String lecp, String laville){
        this.setNumero(lenum);
        this.setRue(larue);
        this.setCp(lecp);
        this.setVille(laville);
    }
}
