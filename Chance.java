//Anya 
//5/24/2022

public class Chance{
    private String name;
    private boolean goJail;
    private String whereGo;
    private int money;
    private boolean advance;
    private boolean recieve;
    private boolean community;

   public Chance(String n, boolean jail, int mon, boolean adv, boolean recieveM, String gowhere, boolean isCommunity){
      name = n;
      goJail = jail;
      money = mon;
      advance = adv;
      whereGo = gowhere;
      community = isCommunity;
      recieve = recieveM;
      
   
   }
   
   public static int getMoney(){
      return money;
   }
   public static boolean getRecieve(){
      return recieve;
   }
   public String toString(){
      return "Name: " + n + "Jail involved?: " + jail + "How much money involved: " + money + "Advance?: " + advance + "Recieve the money?: " + recieve + "Where do you go?: " + whereGo + "Is it a community card: " + community;
   
   }
   




}