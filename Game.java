import java.util.*;
public class Game{
    private static boolean gameContinue; 
    private ArrayList<Player> listOfPlayers = new ArrayList<Player>(); 
    Scanner in = new Scanner(System.in); 

    public static void main (String[] args){
        gameContinue = true;
    }

    public Game(){
        System.out.println ("How many players are playing?");
        int numOfPlayers = in.nextInt();
        for (int i = 0; i < numOfPlayers; i++){
            listOfPlayers.add(new Player()); 
        }
    }

    public void simulation(){
        for (int i = 0; i < listOfPlayers.size(); i++){
            Player currentPlayer = listOfPlayers.get(i);
            currentPlayer.changePos((int)(Math.random()*12)+2);
            if (board[currentPlayer.getPos()].owned() && board[currentPlayer.getPos()].isProperty()){
                if(currentPlayer.getCanPay(board[currentPlayer.getPos()].cost()))
                currentPlayer.subBal(board.getPayment());
            }
            if (currentPlayer.getBal()==0){
                listOfPlayers.remove(i);
            }
        }
        
    }
    public int pay(){
        if (!this.own()) {
            return Cards.getRent();
        }
        else if (this.own()){
            System.out.println("Do you want to get another house? (y or n)");
            if (in.nextString().equals("y")){
                int price = Cards.getEstatePrice();
                if (this.getCanPay(price)){
                    this.changeBal(price);
                }
            }
        }
    } 
}
