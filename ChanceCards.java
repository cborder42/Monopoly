public class ChanceCards{
    private Chance[][] cards;
    private int[] indexes = new int[] {0, 0};
    public ChanceCards(){
        cards = new Chance[][] {
            new Chance[] {
                new Chance("Advance to Boardwalk",0, "Boardwalk"),
                new Chance("Advance to Go", 200, "Go"),
                new Chance("Speeding fine", -15, null),
                new Chance("Advance to the nearest Railroad", 0, "Railroad"),
                new Chance("Go to Jail", -50, "Jail"),
                new Chance("Advance token to nearest Utility", 0, "Utility"),
                new Chance("Building loan matures", 150, null),
                new Chance("Bank pays you dividend", 50, null)
            },
            new Chance[] {
                new Chance("Advance to Go", 200, "Go"),
                new Chance("Doctor's Fee", -50, null),
                new Chance("You inherit $100", 100, null),
                new Chance("Pay school fees", -50, null),
                new Chance("Bank error in your favor", 200, null),
                new Chance("Pay hospital fee", -50, null),
                new Chance("You are assessed for street repair", -100, null),
                new Chance("You won a second prize in a beauty contest", 10, null)
            }
        };

       // Shuffle the cards.
       for (Chance[] cardset : cards) {
           shuffle(cardset);
       }
    }

    public Chance advanceCard(boolean isChance){
        int type = isChance ? 0 : 1;
        Chance[] cardset = cards[type];
        indexes[type]++;
        indexes[type] %= cardset.length;
        return cardset[indexes[type]];
    }

    private void shuffle(Chance[] cards){
        for (int i=0; i < 10; i++) {
            int a = (int)(Math.random() * cards.length);
            int b = (int)(Math.random() * cards.length);
            Chance temp = cards[a];
            cards[a] = cards[b];
            cards[b] = temp;
        }
     }
}
