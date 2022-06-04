import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// import javax.smartcardio.Card;
import javax.swing.JFrame;

public class Game {
    private JFrame frame;
    private DisplayGraphics graphics;
    private Board gameBoard;
    private ChanceCards chanceCards;
    private CommunityCards communityCards;
    private static boolean gameContinue;
    private ArrayList<Player> listOfPlayers = new ArrayList<Player>();
    private int sleepTime = 1000;
    private boolean forceEnd = false;
    public int numActivePlayers;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        gameContinue = true;
        Game g1 = new Game();
        g1.playGame();
    }

    public Game() {

        gameBoard = new Board();
        chanceCards = new ChanceCards();
        communityCards = new CommunityCards();
        graphics = new DisplayGraphics();
        frame = new JFrame();
        frame.add(graphics);
        frame.setUndecorated(true);
        frame.setSize(870, 870);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setFocusable(true);
        frame.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (key == '+') {
                    System.out.println("KEY: Speeding up.");
                    sleepTime /= 2;
                }
                if (key == '-') {
                    System.out.println("KEY: Slowing down.");
                    sleepTime *= 2;
                }
                if (key == 'q' || key == 'Q') {
                    System.out.println("KEY: Quitting game.");
                    forceEnd = true;
                }
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        welcome();
        getPlayers();
        graphics.setPlayers(listOfPlayers);
    }

    public DisplayGraphics getGraphics() {
        return graphics;
    }

    public void welcome() {
        new AskInput("Switch from the board and the game using alt+tab", new String[] { "yes", "ok", "I will" }, this)
                .getSelection();
        System.out.println("");
        System.out.println("Welcome to Monopoly!");
        System.out.println(
                "Move around the board and buy property that will earn you rent when other players land on it.");
        System.out.println("Bankrupt every other player to win.");
        System.out.println("");
    }

    public void getPlayers() {
        System.out.println("How many players are playing? (Maximum 4)");
        String answer = in.nextLine();
        int numOfPlayers = Integer.parseInt(answer);
        if (numOfPlayers > 4) {
            System.out.println("Too many players");
            getPlayers();
        } else if (numOfPlayers < 2) {
            System.out.println("Too few players");
            getPlayers();
        } else {
            for (int i = 0; i < numOfPlayers; i++) {
                listOfPlayers.add(new Player(i, this));
            }
            numActivePlayers = numOfPlayers;
        }
    }

    // only if a player has all three things in a group they can buy houses add
    // property to group properties in board class
    // three doubles goes to jail
    // in jail doubles gets out of jail, but no repeat turn then
    // doubles repeats turn
    // player has isInJail property and has a time in jail property so if it spends
    // 3 turns it gets out good
    // if money is 0 when landing on something, prompt user if that want ot sell of
    // mortgage properties an dhouses
    // YOU NEEED TO IMPLIMENT TRADING THAT IS SO IMPORTANT

    public void playGame() {
        // checks if we should continue the game
        while (gameContinue && !forceEnd) {
            // go around player array
            for (int i = 0; i < listOfPlayers.size(); i++) {
                Player currentPlayer = listOfPlayers.get(i);
                if (!currentPlayer.active) {
                    continue; // skip inactive player
                }
                int numDoubles = 0;
                boolean isDouble = false;
                // one turn, going to implement all possibilities of the spot they are in here

                // calls changePos in the Player class with a given dice.

                do {
                    int dice1 = (int) (Math.random() * 6) + 1;
                    int dice2 = (int) (Math.random() * 6) + 1;
                    System.out.println("Player " + i + " rolled a " + dice1 + " and " + dice2 + ".");
                    int diceSum = dice1 + dice2;

                    if (dice1 == dice2) {
                        numDoubles++;
                        isDouble = true;
                    } else {
                        isDouble = false;
                    }

                    if (currentPlayer.isInJail) {
                        if (isDouble) {
                            currentPlayer.exitJail();
                            System.out.println("Player " + i + " has exited jail");
                        } else if (currentPlayer.turnsInJail == 3) {
                            currentPlayer.subBal(50);
                            currentPlayer.exitJail();
                            if (currentPlayer.getBal() <= 0) { // todo: also check player to sell stuff
                                // System.out.println("Do ypu want to ");
                                currentPlayer.active = false;
                                numActivePlayers--;
                                System.out.println("Player " + i + " is now out of the game");
                             
                            } else {
                                System.out.println("Player " + i + " has exited jail");
                            }

                        } else {
                            currentPlayer.turnsInJail++;
                            System.out.println("Player " + i + " has " + currentPlayer.turnsInJail + " turns in jail. "
                                    + (3 - currentPlayer.turnsInJail) + " left until free.");
                        }
                        break;
                    }

                    handleDice(currentPlayer, i, diceSum);

                    // if the player does not have any money, they will be marked inactive
                    if (currentPlayer.getBal() <= 0) { // todo: also check player to sell stuff
                        System.out.println("marking player inactive");
                        currentPlayer.active = false;
                        numActivePlayers--;
                        break;
                    }
                } while (isDouble && numDoubles < 3);

                if (numDoubles == 3) { // if three doubles in a row
                    currentPlayer.sendToJail();
                    System.out.println("Player " + i + " has been sent to jail");
                    continue;
                }

                // if there is only one player left, announce that the game is over
                if (numActivePlayers == 1) {
                    System.out.println("only one player left");
                    gameContinue = false;
                    break;
                }
                System.out.println("Player " + i + "'s turn is now over");
                System.out.println("");

                frame.requestFocusInWindow();
                delay(true);
            }
        }
        printWinner();
    }

    public void delay(boolean extended) {
        try {
            Thread.sleep(extended ? sleepTime : sleepTime / 30);
        } catch (InterruptedException e) {
        }
    }

    public boolean promptUserForPurchase(Property prop) {
        System.out.println("Property details:");
        if (prop.isRailroad) {
            System.out.println(prop.railroadToString());
        } else if (prop.isUtility) {
            System.out.println(prop.utilityToString());
        } else {
            System.out.println(prop.toString());
        }

        System.out.println("");
        System.out.println("Would you like to purchase this property? (type y or n)");
        if (in.nextLine().toLowerCase().equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public void handleDice(Player player, int playerIndex, int diceSum) {
        DisplayGraphics graphics = getGraphics();
        int oldPosition = player.getPos();

        for (int i = 0; i < diceSum; i++) {
            player.setPos((player.getPos() + 1) % gameBoard.getTotalSpaces());

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
            }
        }
        int newPosition = player.getPos();

        // Repaint current balance area.
        graphics.repaint(650, 630, 80, 100);

        if (gameBoard.didPassGo(oldPosition, newPosition)) {
            // player passed go, so give them 200 dollars
            player.addBal(200); // todo: make 200 a constant and use here
            System.out.println("Player " + playerIndex + " has passed GO and gained $200.");

        }
        if (player.getPos() == 30) { // Landed on go to Jail
            System.out.println("Player " + playerIndex + " landed on GO TO JAIL.");
            System.out.println("");
            player.sendToJail();
            return;
        }

        // if the player lands on a position with a property on it

        Property currentProp = gameBoard.getProperty(player.getPos());
        System.out.println("Player " + playerIndex + " landed on " + currentProp.name + ".");
        System.out.println("");

        processProperty(player, currentProp, diceSum);

        // at end of turn before sets, ask user if they want to trade,
        handleTrading(player);

        // player.ownedSets.put("brown", true); // for testing house building, uncomment
        // this line

        // at end of turn, check if user has a set, if not, end turn, if they do, ask if  they want a house
        handleHouseBuilding(player);


        // at end of turn ask user if they want to sell or mortgage houses or properties

    }

    public void handleTrading(Player player) {
        Property property1;
        String name1 = "";
        int numOwned = 0;
        int currentPlayerOwned = 0;

        for (int i = 0; i < gameBoard.getTotalSpaces(); i++) {
            Property property = gameBoard.getProperty(i);
            if (property.owned){
                numOwned++;
                if (property.ownerIndex == player.getId()) {
                    currentPlayerOwned++;
                }
            }
        }

        if ( (numOwned - currentPlayerOwned) > 0) {
            int moneyTrade = 0;
            System.out.println("Would you like to offer money for property trade? (y or n)");
            String input = in.nextLine().toLowerCase();
            if (input.equals("y")) {
                System.out.println("Type the name of the property you would like to trade for.");
                String answer = in.nextLine().toLowerCase();

                for (int i = 0; i < gameBoard.getTotalSpaces(); i++) {
                    if (gameBoard.getProperty(i).name.equalsIgnoreCase(answer)) {
                        name1 = gameBoard.getProperty(i).name;
                        property1 = gameBoard.getProperty(i);
                        System.out.println("Would you like to offer a monetary trade for " + name1 + "? (y or n)");
                        String input3 = in.nextLine().toLowerCase();
                        if (input3.equals("y")) {
                            System.out.println("How much money will you offer?");
                            String input4 = in.nextLine().toLowerCase();
                            moneyTrade = Integer.parseInt(input4);
                            System.out.println("Trade request sent");
                            moneyTrade(player, property1, moneyTrade);

                        }
                        break;
                    }
                }
            }
            //  else {

            //     System.out.println("Would you like to offer a property for a property trade instead? (y or n)");
            //     String input2 = in.nextLine().toLowerCase();
            //     if (input2.equals("y")) {
            //         System.out.println("Not supported yet.");
            //         return;
            //         // System.out.println("Enter the name of the property.");
            //         // String answer2 = in.nextLine().toLowerCase();

            //         // for (int i = 0; i < gameBoard.getTotalSpaces(); i++) {
            //         // if (gameBoard.getProperty(i).name.equalsIgnoreCase(answer2)) {
            //         // name2 = gameBoard.getProperty(i).name;
            //         // property2 = gameBoard.getProperty(i);

            //         // break;
            //         // }
            //         // }

            //     }
            // }
        }
    }

    // is this property owned? if not, tell user that it is bank and not for sell
    // if owned, ask how many dollars
    // then call moneytrade method where we ask the owner if they want to sell for
    // the money amount
    // if yes then there we notify both users and make the trade

    public void moneyTrade(Player player, Property property, int moneyTrade) {
        System.out.println("Player " + property.ownerIndex + ": Do you accept a trade from Player " + player.getId()
                + " to give you $" + moneyTrade + " for " + property.name + "? (y or n)");
        String input3 = in.nextLine().toLowerCase();
        if (input3.equals("y")) {
            System.out.println("Player " + property.ownerIndex + " has accepted Player "
                    + player.getId() + "'s offer to give $" + moneyTrade + " for "
                    + property.name + ".");
            listOfPlayers.get(property.ownerIndex).addBal(moneyTrade);
            property.ownerIndex = player.getId();
            player.subBal(moneyTrade);
            
        } else {
            System.out.println("Player " + property.ownerIndex + " has rejected Player "
                    + player.getId() + "'s offer to give $" + moneyTrade + " for "
                    + property.name + "?");
        }

    }

    //function to trade properties for future use
    public void propertyTrade(Property property1, Property property2) { //offerer is the one offering property 2
        System.out.println("Player " + property1.ownerIndex
                + ": Do you accept a trade for Player " + property2.ownerIndex
                + " to give you " + property2.name + " for " + property1.name + "?");
        String input = in.nextLine().toLowerCase();
        if (input.equals("y")) {
            System.out.println("Player " + property1.ownerIndex + "has accepted Player "
                    + property2.ownerIndex + "'s offer to give " + property2.name + " for "
                    + property1.name);
            int temp = 0;
            temp = property1.ownerIndex;
            property1.ownerIndex = property2.ownerIndex;
            property2.ownerIndex = temp;
        } else {
            System.out.println("Player " + property1.ownerIndex + "has rejected Player "
                    + property2.ownerIndex + "'s offer to give " + property2.name + " for "
                    + property1.name);
        }
    }

    public void processProperty(Player player, Property property, int diceSum) {
        int playerIndex = player.getId();
        if (property.isProperty) {
            if (!property.owned) {
                if (player.getCanPay(property.cost)) {
                    buyProperty(player, property);
                } else {
                    System.out.println("You do not have enough money to buy this property.");
                }
            } else {
                if (property.ownerIndex == playerIndex) {
                    // do nothing
                }

                // todo: handle if property is owned by other player or if owned by current
                // player
                else {
                    handleRent(player, property, diceSum);
                }
            }
        } 
        else {

            // todo: handle non properties: tax, free parking, visiting jail, jail, go,
            // community chest, chance

            if (property.name.equals("Tax")) {
                // pay 200 tax
                player.subBal(200);
                System.out.println("Player " + playerIndex + "  has been taxed $200");
                System.out.println("Current balance: " + player.getBal());

                // if the player does not have any money, they will be marked inactive
                if (player.getBal() <= 0) { // todo: also check player to sell stuff
                    // todo: ask what properties to sell and call sellProperty()
                    System.out.println("marking player inactive");
                    player.active = false;
                    numActivePlayers--;
                    return;
                }
            } else if (property.isChance) {
                handleChanceAndCommunity(player, property);
            } else if (property.isCommunityChest) {
                handleChanceAndCommunity(player, property);
            } else {
                // todo: if you land on a property that doesnt do anything, or anytime at the
                // end of your turn, ask if you want to get a house on anything, only if you
                // have a set
            }

        }

    }

    public void handleHouseBuilding(Player player) {
        if (player.ownedSets != null && player.ownedSets.size() > 0) {
            System.out.println("Do you want to build houses? (y or n)");
            // String input;
            if (in.nextLine().toLowerCase().equals("y")) {
                System.out.println("Which color set do you want houses on? Your set(s): ");
                player.ownedSets.forEach((k, v) -> System.out.println(k));
                // input = in.nextLine();
                String color = in.nextLine().toLowerCase();
                if (player.ownedSets.get(color)) {
                    int[] set = gameBoard.sets.get(color);
                    int costForHouses = gameBoard.getProperty(set[0]).houseCost; // house cost is the same cost for all
                                                                                 // properties in the same color set
                    System.out.println("How many houses do you want in this set? House cost: $" + costForHouses);
                    String strNumHousesWanted = in.nextLine();
                    int numHousesWanted = Integer.parseInt(strNumHousesWanted);
                    int totalCost = costForHouses * numHousesWanted;
                    if (player.getCanPay(totalCost)) {
                        player.subBal(totalCost);
                        int housesPerProperty = numHousesWanted / set.length;
                        int remainderHouses = numHousesWanted % set.length;
                        for (int i = 0; i < set.length; i++) {
                            gameBoard.getProperty(set[i]).houses += housesPerProperty;
                        }
                        for (int i = 0; i < remainderHouses; i++) {
                            gameBoard.getProperty(set[i]).houses += 1;
                        }

                        System.out.println("Total of " + numHousesWanted + " houses built for total of $" + totalCost);
                    } 
                    else {
                        System.out.println("You do not have enough money to buy these many houses.");
                    }
                }
            }
        }
    }

    public void buyProperty(Player player, Property property) {
        boolean willBuy = promptUserForPurchase(property);
        if (willBuy) {
            player.subBal(property.cost);
            property.changeOwned(player.getId());
            System.out.println("Player " + player.getId() + " bought and now owns " + property.name + ".");
            System.out.println("Current balance: " + player.getBal());
            System.out.println("");
            if (property.isRailroad) {
                player.changeNumOfRailRoads(1);
                property.owned = true;
            }
            else if (property.isUtility) {
                player.changeNumOfUtilitie(1);
                property.owned = true;
            } 
            else { // hande set ownership for colored properties
                determineSetOwnership(player, property);
            }
        }
    }

    public void determineSetOwnership(Player player, Property property) {
        String color = property.color;
        int[] set = gameBoard.sets.get(color);
        boolean hasSet = true;
        for (int i = 0; i < set.length; i++) {
            Property prop = gameBoard.getProperty(set[i]);
            if (prop.ownerIndex != player.getId()) {
                hasSet = false;
                break;
            }
        }
        if (hasSet) {
            player.ownedSets.put(color, true);
        }
    }

    public void sellProperty(Player player, Property property) {
        int recoup = property.cost;
        if (property.houses > 0) {
            recoup += property.houses * property.houseCost;
        }

        player.addBal(recoup);
        System.out.println("Player " + player.getId() + " sold " + property.name + " for $" + recoup);
        property.owned = false;
        property.owner = null;
        property.houses = 0;
    }

    public void handleRent(Player player, Property property, int diceSum) {
        int playerIndex = player.getId();
        if (!property.isRailroad && !property.isUtility) {
            int rent = property.getPayment(player);
            player.subBal(rent);
            listOfPlayers.get(property.ownerIndex).addBal(rent);
            System.out.println("Player " + playerIndex + " paid $" + rent + " to Player "
                    + property.ownerIndex);
        }
        // subtract balance from current player add balance to the index owner of the
        // property .
        if (property.isRailroad) {
            int rent = property.getRailroadPayment(player.getNumOfRailraods());
            player.subBal(rent);
            listOfPlayers.get(property.ownerIndex).addBal(rent);
            System.out.println("Player " + playerIndex + " paid $"
                    + rent + " to Player "
                    + property.ownerIndex);
        } 
        else if (property.isUtility) {
            if (listOfPlayers.get(property.ownerIndex).getNumOfUtilities() == 1) {
                player.subBal(diceSum * 4);
                listOfPlayers.get(property.ownerIndex).addBal(diceSum * 4);
                System.out.println("Player " + playerIndex + " paid $" + (diceSum * 4) + " to Player "
                        + property.ownerIndex);
            }
            if (listOfPlayers.get(property.ownerIndex).getNumOfUtilities() == 2) {
                player.subBal(diceSum * 10);
                listOfPlayers.get(property.ownerIndex).addBal(diceSum * 10);
                System.out.println("Player " + playerIndex + " paid $" + (diceSum * 10) + " to Player "
                        + property.ownerIndex);
            }
        }
        System.out.println("Player " + playerIndex + "'s current balance: " + player.getBal()
                + " | Player " + property.ownerIndex + "'s current balance: "
                + listOfPlayers.get(property.ownerIndex).getBal());

    }

    public void handleChanceAndCommunity(Player player, Property property) {
        ChanceCommunity chanceCommunity;
        if (property.isChance) {
            chanceCommunity = chanceCards.getChance();
            System.out.println("Chance card: " + chanceCommunity.name);
        } else { // if (property.isCommunityChest)
            chanceCommunity = communityCards.getCommunity();
            System.out.println("Community chest card: " + chanceCommunity.name);
        }
        player.addBal(chanceCommunity.money);

        if (chanceCommunity.advance) {
            player.setPos(chanceCommunity.goWhere);
            if(!(gameBoard.getProperty(chanceCommunity.goWhere).owned)){
                buyProperty(player, property);
            }
            
        }
    }

    public void printWinner() {
        int playerIndex = -1;
        int activePlayers = 0;
        for (int i = 0; i < listOfPlayers.size(); i++) {
            if (listOfPlayers.get(i).active == true) {
                playerIndex = i;
                activePlayers++;
            }
        }
        if (activePlayers == 1) {
            System.out.println("Player " + playerIndex + " has won.");
        } else {
            System.out.println("No winners yet");
        }

    }
}
