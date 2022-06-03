//Anya 
import java.io.*;



public class Utility{
   private String type;
   private int rent;
   private int cost;
   private int mortgage;
   
   public Utility(String ty){
      type = ty;
      rent = 40;
      cost = 150;
      mortgage = 75;   
   
   }
   
   public int getCost(){
      return cost;
   }
   public int getCost(int n){ //if you own 2
      return cost*n;
   }
   
   public String getType(){
      return type;
   
   }
   public int getMortgage(){
      return mortgage;
   
   }





}