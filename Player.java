public class Player {
    private int id;
    private int bal; 
    private int pos; 
    private int numOfRailroads; 
    private int numOfUtilitiesOwned;

    public Player(int id){
        //each player starts with $1500
        this.id = id;
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

    // Move dice positions forward
    public void makeMove(Board board, int dice){
        int oldPos = getPos();
        pos = (oldPos + dice) % board.getTotalSpaces();

        // Each time a player's token lands on or passes over GO, whether by throwing the dice or drawing a card, the Banker pays that player a $200 salary.
        if (board.didPassGo(oldPos, pos)) {
            addBal(200);
            System.out.println(this.toString() + " GO");
        }

        // get property at the new position
        Property property = board.getProperty(pos);
        processProperty(property, board);
    }

    private void processProperty(Property property, Board board) {
        if (property.owner == null) {
            buyProperty(property);
        } else if (property.owner != this) {
            payRentOnProperty(property, board);
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
            System.out.println(toString() + " BUY " + property.name);
            if (property.isUtility) {
                this.numOfUtilitiesOwned++;
            } else if (property.isRailroad) {
                this.numOfRailroads++;
            }
        } else if (property.name.equals("Tax")) {
            // pay 200 tax
            subBal(200);
            System.out.println(this.toString() + " Tax");
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
        System.out.println(toString() + " SELL " + property.name);
        property.owned = false;
        property.owner = null;
        property.houses = 0;
    }

    private void payRentOnProperty(Property property, Board board) {
        // Pay rent!!!
        int cost = property.isProperty ? property.getPayment() :
                    property.isRailroad ? property.getRailroadPayment() : 0;

        for (int i=0; i < board.getTotalSpaces() && cost > bal; i++) {
            Property toSell = board.getProperty(i);
            if (toSell.owner == this) {
                sellProperty(toSell);
            }           
        }

        subBal(cost);
        System.out.println(toString() + " RENT " + property.name);
        property.owner.addBal(cost);
        System.out.println(property.owner.toString() + " COLLECT " + property.name);
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
        return "Player " + id + " @" + pos + " $" + bal;
    }
}
