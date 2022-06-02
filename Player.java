// Kaustav Mitra
// Player class to keep track of a player in the game.
import java.awt.*;

public class Player {
    private int id;
    private int bal; 
    private int pos; 
    private int numOfRailroads; 
    private int numOfUtilitiesOwned;
    private Game game;

    public Player(int id, Game game){
        //each player starts with $1500
        this.id = id;
        this.game = game;
        bal = 1500;
        pos = 0;
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

    // Will tell the user if they can pay the charged price 
    public boolean getCanPay(int price){
        return bal >= price;
    }

    public int getPos(){
        return pos; 
    }

    private void setPos(int newPos) {
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

    // Move dice positions forward
    public void makeMove(int dice){
        int oldPos = getPos();
        Board board = game.getBoard();
        DisplayGraphics graphics = game.getGraphics();
        for (int i = 0; i < dice; i++) {
            setPos((pos + 1) % board.getTotalSpaces());

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
            }
        }

        // Repaint current balance area.
        graphics.repaint(650, 630, 80, 100);

        // Each time a player's token lands on or passes over GO, whether by throwing the dice or drawing a card, the Banker pays that player a $200 salary.
        if (board.didPassGo(oldPos, pos)) {
            addBal(200);
            System.out.println(this.toStringWithDetails() + " GO $200 added.");
        }

        // get property at the new position
        Property property = board.getProperty(pos);
        processProperty(property);
    }

    private void processProperty(Property property) {
        if (property.owner == null) {
            buyProperty(property);
        } else if (property.owner != this) {
            payRentOnProperty(property);
        } else if (property.owner == this && property.isProperty && property.houses < property.rents.length - 1) {
            // Check if interested in building
            int cost = property.houseCost;
            if (cost > 0 && getCanPay(cost)) {
                property.houses++;
                subBal(cost);
            }            
        }
    }

    private void buyProperty(Property property) {
        // Check if interested in buying
        int cost = property.cost;
        if (cost > 0 && getCanPay(cost)) {
            property.owner = this;
            property.owned = true; // Replace to false if mortgage is supported
            subBal(cost);
            System.out.println(toStringWithDetails() + " BUY " + property.name + " for $" + cost);
            if (property.isUtility) {
                this.numOfUtilitiesOwned++;
            } else if (property.isRailroad) {
                this.numOfRailroads++;
            }
        } else if (property.name.equals("Tax")) {
            // pay 200 tax
            subBal(200);
            System.out.println(this.toStringWithDetails() + " Tax $200");
        } else if (property.name.equals("Go To Jail")) {
            System.out.println(toStringWithDetails() + " JAIL");
            setPos(10);
        } else if (property.isChance) {
            // TODO: Select chance card and take action.
        }
    }

    private void sellProperty(Property property) {
        int recoup = property.cost;
        if (property.houses > 0) {
            recoup += property.houses * property.houseCost;
        }

        addBal(recoup/2);
        System.out.println(toStringWithDetails() + " SELL " + property.name + " for $" + recoup/2);
        property.owned = false;
        property.owner = null;
        property.houses = 0;
    }

    private void payRentOnProperty(Property property) {
        // Pay rent!!!
        int cost = property.isProperty ? property.getPayment() :
                    property.isRailroad ? property.getRailroadPayment() : 0;
        Board board = game.getBoard();
        for (int i=0; i < board.getTotalSpaces() && cost > bal; i++) {
            Property toSell = board.getProperty(i);
            if (toSell.owner == this) {
                sellProperty(toSell);
            }           
        }

        subBal(cost);
        System.out.println(toStringWithDetails() + " RENT " + property.name + " $" + cost);
        property.owner.addBal(cost);
        System.out.println(property.owner.toString() + ": COLLECT " + property.name + " $" + cost);
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

    public String toString(){
        return "Player " + (id+1);
    }

    public String toStringWithDetails(){
        return "Player " + (id+1) + ": @" + pos + " $" + bal;
    }
}
