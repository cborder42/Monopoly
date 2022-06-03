public class CommunityCards {
    private Community[] cards; 
    public CommunityCards(){
      cards = new Community[] {          
           new Community("Advance to Go", 0, true, 0),
           new Community("Doctor's Fee. Lose $50.", -50, false, -1),
           new Community("You inherit $100", 100, false, -1),
           new Community("Pay school fees. Lose $50.", -50, false, -1),
           new Community("Bank error in your favor. Gain $ 200.", 200, false, -1),
           new Community("Pay hospital fee. Lose $50.", -50, false, -1),
           new Community("You won a second prize in a beauty contest", 10, false, -1)
           //new Community("You are assessed for street repair. Lose $100 per house and hotel.", -100, false, -1)
      };
  }
  public Community getCommunity() {
    int randomCardNumber = (int) (Math.random() * cards.length);
    return cards[randomCardNumber];
}




}
