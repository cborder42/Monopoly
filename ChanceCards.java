public class ChanceCards{

    private Chance[] cards; 
     public ChanceCards(){
       cards = new Chance[] {
           new Chance("Advance to Boardwalk", 0, true, 39), //String name, boolean jail, int mon, boolean adv, String gowhere
           new Chance("Advance to Go", 0, true, 0),
           new Chance("Speeding fine. Lose $15.", -15, false, -1),
            //new Chance("Advance to the nearest Railroad", 0, true, "Go"),
           new Chance("Go to Jail", 0, true, 30),
            //new Chance("Advance to nearest Utility", 0, true, "Utility"),
           new Chance("Building loan matures. Get $150", 150, false, -1),
           new Chance("Bank pays you dividend. Get $50.", 50, false, -1)
       };
   }

   public Chance getChance() {
       int randomCardNumber = (int) (Math.random() * cards.length);
       return cards[randomCardNumber];
   }





}
