public class Chance extends ChanceCommunity{

 
   public Chance(String n, int mon, boolean adv, int gowhere){
      super(n, mon, adv, gowhere);
   }
   
   public String toString(){
      return "Chance card:" + super.getName();
   } 
 }
