import java.util.HashMap;

public class Board {
    public static int jailPos = 10;
    public Property[] board; 
    public HashMap<String, int[]> sets;
    public Board(){
        board = new Property[] {
            new Property("Go", false, false, false, false, false), 
            new Property("Mediterranean Avenue", 60, 30, 50, new int[] {2, 10, 30, 90, 160, 250}, false, false, false, false, true, "brown"), 
            new Property("Community Chest", false, true, false, false, false),
            new Property("Baltic Avenue", 60, 30, 50, new int[] {4, 20, 60, 180, 320, 450}, false, false, false, false, true, "brown"),
            new Property("Tax", false, false, false, false, false),
            new Property("Reading Railroad", 200, 100, new int[] {25, 50, 100, 200}, false, false, true, false, true),
            new Property("Oriental Avenue", 100, 50, 50, new int[] {6, 30, 90, 270, 400, 550}, false, false, false, false, true, "light blue"),
            new Property("Chance", true, false, false, false, false),
            new Property("Vermont Avenue", 100, 50, 50, new int[] {6, 30, 90, 270, 400, 550}, false, false, false, false, true, "light blue"),
            new Property("Connecticut Avenue", 120, 60, 50, new int[] {8, 40, 100, 300, 450, 600}, false, false, false, false, true, "light blue"),
            new Property("Jail", false, false, false, false, false),
            new Property("St. Charles Place", 140, 70, 100, new int[] {10, 50, 150, 450, 625, 750}, false, false, false, false, true, "pink"),
            new Property("Electric Company", 150, 75, false, false, false, true, true),
            new Property("States Avenue", 140, 70, 100, new int[] {10, 50, 150, 450, 625, 750}, false, false, false, false, true, "pink"),
            new Property("Virginia Avenue", 160, 80, 100, new int[] {12, 60, 180, 500, 700, 900}, false, false, false, false, true, "pink"),
            new Property("Pennsylvania Railroad", 200, 100, new int[] {25, 50, 100, 200}, false, false, true, false, true),
            new Property("St. James Place", 180, 90, 100, new int[] {14, 70, 200, 550, 750, 950}, false, false, false, false, true, "orange"),
            new Property("Community Chest", false, true, false, false, false),
            new Property("Tennessee Avenue", 180, 90, 100, new int[] {14, 70, 200, 550, 750, 950}, false, false, false, false, true, "orange"),
            new Property("New York Avenue", 200, 100, 100, new int[] {16, 80, 220, 600, 800, 1000}, false, false, false, false, true, "orange"),
            new Property("Free Parking", false, false, false, false, false),
            new Property("Kentucky Avenue", 220, 110, 150, new int[] {18, 90, 250, 700, 875, 1050}, false, false, false, false, true, "red"),
            new Property("Chance", true, false, false, false, false),
            new Property("Indiana Avenue", 220, 110, 150, new int[] {18, 90, 250, 700, 875, 1050}, false, false, false, false, true, "red"),
            new Property("Illinois Avenue", 240, 120, 150, new int[] {20, 100, 300, 750, 925, 1100}, false, false, false, false, true, "red"),
            new Property("B. & O. Railroad", 200, 100, new int[] {25, 50, 100, 200}, false, false, true, false, true),
            new Property("Atlantic Avenue", 260, 130, 150, new int[] {22, 110, 330, 800, 975, 1150}, false, false, false, false, true, "yellow"),
            new Property("Ventnor Avenue", 260, 130, 150, new int[] {22, 110, 330, 800, 975, 1150}, false, false, false, false, true, "yellow"),
            new Property("Water Works", 150, 75, false, false,false, true, true),
            new Property("Marvin Gardens", 280, 140, 150, new int[] {24, 120, 360, 850, 1025, 1200}, false, false, false, false, true, "yellow"),
            new Property("Go To Jail", false, false, false, false, false),
            new Property("Pacific Avenue", 300, 150, 200, new int[] {26, 130, 390, 900, 1100, 1275}, false, false, false, false, true, "green"),
            new Property("North Carolina Avenue", 300, 150, 200, new int[] {26, 130, 390, 900, 1100, 1275}, false, false, false, false, true, "green"),
            new Property("Community Chest", false, true, false, false, false),
            new Property("Pennsylvania Avenue", 320, 160, 200, new int[] {28, 150, 450, 1000, 1200, 1400}, false, false, false, false, true, "green"),
            new Property("Short Line", 200, 100, new int[] {25, 50, 100, 200}, false, false, true, false, true),
            new Property("Chance", true, false, false, false, false),
            new Property("Park Place", 350, 175, 200, new int[] {35, 175, 500, 1100, 1300, 1500}, false, false, false, false, true, "blue"),
            new Property("Tax", false, false, false, false, false),
            new Property("Boardwalk", 400, 200, 200, new int[] {50, 200, 600, 1400, 1700, 2000}, false, false, false, false, true, "blue")
        };
        sets = new HashMap<String, int[]>();
        sets.put("brown", new int[] {1, 3});
        sets.put("light blue", new int[] {6, 8, 9});
        sets.put("pink", new int[] {11, 13, 14});
        sets.put("orange", new int[] {16, 18, 19});
        sets.put("red", new int[] {21, 23, 24});
        sets.put("yellow", new int[] {26, 27, 29});
        sets.put("green", new int[] {31, 32, 34});
        sets.put("blue", new int[] {37, 39});
    }



    // public void changeOwned(){
    //     if(getProperty(currentPlayer.position).owned == false){
    //         board[currentPlayer.position].owned = true;
    //         board[currentPlayer.position].ownerIndex = currentPlayer.index;
    //     }

    // }

    
    // public void changeNumHouses(int ){
    //     if(board[currentPlayer.position].houses < 5){
    //         board[currentPlayer.position].houses += 1;
    //     }
        
    // }


    public Property[] getBoard(){
        return board;
    }
    public Property getProperty(int position){
        return board[position % board.length];
    }
    public int getTotalSpaces() {
        return board.length;
    }
    public Boolean didPassGo(int oldPos, int newPos) {
        if ((newPos % board.length) < (oldPos % board.length)){
            return true;
        }
        else{
            return false;
        }
    }
}
