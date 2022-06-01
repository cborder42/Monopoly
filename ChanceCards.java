public class ChanceCards{

     private Chance[] card; 
      public ChanceCards(){
        card = new Chance[] {
            new Chance("Advance to Boardwalk", false, 0, true, false, "Boardwalk", false), //String name, boolean jail, int mon, boolean adv, boolean moneyYes, String gowhere
            new Chance("Advance to Go", false, 200, true, true, "Go", false),
            new Chance("Speeding fine", false, 15, false, false, "", false),
            new Chance("Advance to the nearest Railroad", false, 0, true, false, "Go", false),
            new Chance("Go to Jail", true, 0, true, false, "Jail", false),
            new Chance("Advance token to nearest Utility", false, 0, true, false, "Utility", false),
            new Chance("Building loan matures", false, 150, false, false, "", false),
            new Chance("Bank pays you dividend", false, 50, false, true, "", false),
            
             new Chance("Advance to Go", false, 200, true, true, "Go", true),
             new Chance("Doctor's Fee", false, 50, false, false, "", true),
             new Chance("You inherit $100", false, 100, false, true, "", true),
             new Chance("Pay school fees", false, 50, false, false, "", true),
             new Chance("Bank error in your favor", false, 200, false, true, "", true),
             new Chance("Pay hospital fee", false, 50, false, false, "", true),
             new Chance("You are assessed for street repair", false, 100, false, false, "", true),
             new Chance("You won a second prize in a beauty contest", false, 10, false, true, "", true)
        }
    }





}
