import java.awt.*;
public class Player {
    private int id;
    private int bal; 
    private int pos; 
    private int numOfRailroads; 
    private int numOfUtilitiesOwned;
    public boolean active;
    public boolean isInJail;
    public int turnsInJail;
    private Game game;

    public Player(int playerId, Game gameInstance){
        //each player starts with $1500
        bal = 1500;
        pos = 0; 
        isInJail = false;
        turnsInJail = 0;
        active = true;
        id = playerId;
        game = gameInstance;
    }

    
    public int getId() {
        return id;
    }
    public int getBal(){
        return bal;
    }
    
    // will affect the balance increasing the amount of money available to the players based on their actions 
    public void addBal(int change){
        bal += change; 
    }

    // will affect the balance, decreasing the amount of money available to the player based on their actions
    public void subBal(int change){
        bal -= change;
    }

    public void sendToJail(){
        isInJail = true;
        setPos(Board.jailPos); 
    }
    public void exitJail(){
        isInJail = false;
        turnsInJail = 0;
    }

    // Will tell the user if they can pay the charged price 
    public boolean getCanPay(int price){
        if (bal >= price){
            return true;
        }
        return false;
    }

    public int getPos(){
        return pos; 
    }


    public int changePos(int dice){
        pos += dice;
        pos %= 40;
        return pos;
    }

    public void setPos(int newPos){
        Point loc = getLocation();
        pos = newPos;
        Point newloc = getLocation();
        game.getGraphics().repaint(loc.x, loc.y, 40, 40);
        game.getGraphics().repaint(newloc.x, newloc.y, 50, 40);
    }

    public Point getLocation() {
        int major = pos / 10;
        int minor = pos % 10;

        // Additional offset for the large corners.
        int additional = 70 * minor;
        if (minor > 0) {
            additional += 25;
        }

        int x;
        int y;
        if (major == 0) {
            x = 750+120/2 - additional;
            y = 750+120/2;
        } else if (major == 1) {
            x = 120/2;
            y = 750+120/2 - additional;
        } else if (major == 2) {
            x = 120/2 + additional;
            y = 120/2;
        } else {
            x = 750+120/2;
            y = 120/2 + additional;
        }

        // Non-overlap for users.
        x -= 10 * (id % 2) + 10;
        y -= 10 * (id / 2) + 10;

        return new Point(x, y);
    }

    public void changeNumOfRailRoads(int change){
        numOfRailroads += change; 
    }

    public int getNumOfRailraods(){
        return numOfRailroads;
    }
    
    public void changeNumOfUtilitie(int change){
        numOfUtilitiesOwned += change;
    }
    
    public int getNumOfUtilities(){
        return numOfUtilitiesOwned;
    }

    //status if game is lost 
    public boolean getLost(){
        if (bal <= 0){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Player " + id + " ";
    }
}
