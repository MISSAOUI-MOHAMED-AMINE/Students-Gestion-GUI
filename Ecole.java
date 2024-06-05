import java.util.TreeMap;
import java.util.Map;
public class Ecole{
    private Map<String,Groupe> mt=new TreeMap<>();
    public void Ajouter(String nom){
        mt.put(nom, new Groupe());
    }
    public void AjouterEleve(String nom,Eleve e){
        for(String i:mt.keySet()){
            if(i.equals(nom)){
                mt.get(i).ajout(e);
            }
        }

    }

    public String Premier(){
        String x=null;
        float m=0;
        for(String i:mt.keySet()){
            if(mt.get(i).getMg()>m){
                x=i;
            }
        }
        return x;
    }
    public String Majeur(){
        String aux=Premier();
        String y=mt.get(aux).premier().getNom();
        return y;
    }
    public Map<String,Groupe> getMt() {
        return this.mt;
    }

    public void Afficher() {
        System.out.println( "{" +" mt='" + getMt() + "'" +"}");
    }

}