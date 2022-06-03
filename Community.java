
public class Community extends ChanceCommunity {

    public Community(String name, int mon, boolean adv, int goWhere) {
        super(name, mon, adv, goWhere);
    }
    public String toString(){
        return "Community card:" + super.getName();
     } 
}