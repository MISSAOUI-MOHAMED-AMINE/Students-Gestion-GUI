import java.util.ArrayList;
import java.util.List;

public class Groupe {
    private float mg=0;
    private int nbeleve=0;
    List<Eleve> list = new ArrayList<>();
    public void ajout(Eleve e){
        if(!list.contains(e)){
        list.add(e);
        nbeleve+=1;
        mg+=e.getMoyenne();
        mg=mg/nbeleve;
    }

    }
    public Eleve premier(){
        Eleve a=null;
        if(list.isEmpty()){
            return a;
        }
        float m=0;
        for(Eleve e:list){
            if(e.getMoyenne()>m){
                m=e.getMoyenne();
                a=e;
            }

        }
        return a;
    }

    public float getMg() {
        return this.mg;
    }

    public List<Eleve> getList() {
        return this.list;
    }

    @Override
    public String toString() {
        return "{" +
            " mg='" + getMg() + "'" +
            ", list='" + getList() + "'" +
            "}";
    }


}
