public class ChanceCards{

     private ChanceCommunity[] card; 
      public ChanceCards(){
        card = new ChanceCommunity[] {
            new ChanceCommunity("Advance to Boardwalk", false, 0, true, false, "Boardwalk", false), //String name, boolean jail, int mon, boolean adv, boolean moneyYes, String gowhere
            new ChanceCommunity("Advance to Go", false, 200, true, true, "Go", false),
            new ChanceCommunity("Speeding fine", false, 15, false, false, "", false),
            new ChanceCommunity("Advance to the nearest Railroad", false, 0, true, false, "Go", false),
            new ChanceCommunity("Go to Jail", true, 0, true, false, "Jail", false),
            new ChanceCommunity("Advance token to nearest Utility", false, 0, true, false, "Utility", false),
            new ChanceCommunity("Building loan matures", false, 150, false, false, "", false),
            new ChanceCommunity("Bank pays you dividend", false, 50, false, true, "", false),
            
             new ChanceCommunity("Advance to Go", false, 200, true, true, "Go", true),
             new ChanceCommunity("Doctor's Fee", false, 50, false, false, "", true),
             new ChanceCommunity("You inherit $100", false, 100, false, true, "", true),
             new ChanceCommunity("Pay school fees", false, 50, false, false, "", true),
             new ChanceCommunity("Bank error in your favor", false, 200, false, true, "", true),
             new ChanceCommunity("Pay hospital fee", false, 50, false, false, "", true),
             new ChanceCommunity("You are assessed for street repair", false, 100, false, false, "", true),
             new ChanceCommunity("You won a second prize in a beauty contest", false, 10, false, true, "", true)
        };
    }





}