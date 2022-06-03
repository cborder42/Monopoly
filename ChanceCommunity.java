public class ChanceCommunity{
    public String name;
    public int money;
    public boolean advance;
    public int goWhere;
 
   public ChanceCommunity(String n, int mon, boolean adv, int whereGo){
      name = n;
      money = mon;
      advance = adv;
      goWhere = whereGo;
   }
   
   public String getName(){
      return name;
   }

   public String toString(){
      return name;
   }
 }
