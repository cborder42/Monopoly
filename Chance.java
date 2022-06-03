//Anya 
//5/24/2022

public class Chance{
   private String name;
   private String whereGo;
   private int money;

  public Chance(String n, int mon, String gowhere){
     name = n;
     money = mon;
     whereGo = gowhere;
  }
  
  public String getName(){
     return name;
  }
  
  public int getMoney(){
     return money;
  }

  public String getWhere(){
     return whereGo;
  }

  public String toString(){
     return "Name: " + name + " How much money involved: $" + money + " Where do you go? " + whereGo;
  }
}
