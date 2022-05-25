import java.util.*;
public class Game{
    private static boolean gameContinue; 
    private ArrayList<Player> listOfPlayers = new ArrayList<Player>(); 
    private ArrayList<Player> originalListOfPlayers = new ArrayList<Player>();
    Scanner in = new Scanner(System.in); 

    public static void main (String[] args){
        gameContinue = true;
        Game g1 = new Game();
        g1.simulation();
    }

    public Game(){
        getPlayers();
    }
    
    public void getPlayers(){
        System.out.println("How many players are playing? (Maximum 4)");
        int numOfPlayers= in.nextInt();
        if (numOfPlayers > 4){
            System.out.println("Too many players");
            getPlayers();
        }
        else{
            for (int i = 0; i < numOfPlayers; i++){
                listOfPlayers.add(new Player());
                originalListOfPlayers.add(new Player());
            }
        }
    }            
        
    public void simulation(){
        //checks if we should continue the game
            for (int i = 0; i < listOfPlayers.size(); i++){
                if (gameContinue){
                    Player currentPlayer = listOfPlayers.get(i);
            
                    //one turn, going to implement all possibilities of the spot they are in here

                    //calls changePos in the Player class with a given dice. 
                    currentPlayer.changePos((int)(Math.random()*12)+2);

                    //if the player lands on a position with a property on it

                    if (board[currentPlayer.getPos()].owned() && board[currentPlayer.getPos()].isProperty()){
                        if(currentPlayer.getCanPay(board[currentPlayer.getPos()].cost()))
                        currentPlayer.subBal(board.getPayment());
                    }

                    //if the player does not have any money, they will be eliminated from the array of players. 
                    if (currentPlayer.getBal()==0){
                        listOfPlayers.remove(i);
                    }

                    //if there is only one player left, announce that the game is over
                    if (listOfPLayers.size() == 1){
                        gameContinue = false;
                    }
                }
                else if (!gameContinue){
                    getWinner(); 
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
    public void getWinner(int i){
        System.out.println(originalListOfPlayers.get(i).toString(i) + "has won.");
    }
}
