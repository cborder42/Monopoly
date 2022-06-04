import java.awt.*;

public class Board {
    public static int jailPos = 10;
    public Property[] board; 
    public Board(){
        board = new Property[] {
            new Property("Go", false, false, false, false, false), 
            new Property("Mediterranean Avenue", 60, 30, 50, new int[] {2, 10, 30, 90, 160, 250}, false, false, false, false, true), 
            new Property("Community Chest", false, true, false, false, false),
            new Property("Baltic Avenue", 60, 30, 50, new int[] {4, 20, 60, 180, 320, 450}, false, false, false, false, true),
            new Property("Tax", false, false, false, false, false),
            new Property("Reading Railroad", 200, 100, new int[] {25, 50, 100, 200}, false, false, true, false, true),
            new Property("Oriental Avenue", 100, 50, 50, new int[] {6, 30, 90, 270, 400, 550}, false, false, false, false, true),
            new Property("Chance", true, false, false, false, false),
            new Property("Vermont Avenue", 100, 50, 50, new int[] {6, 30, 90, 270, 400, 550}, false, false, false, false, true),
            new Property("Connecticut Avenue", 120, 60, 50, new int[] {8, 40, 100, 300, 450, 600}, false, false, false, false, true),
            new Property("Jail", false, false, false, false, false),
            new Property("St. Charles Place", 140, 70, 100, new int[] {10, 50, 150, 450, 625, 750}, false, false, false, false, true),
            new Property("Electric Company", 150, 75, false, false, false, true, true),
            new Property("States Avenue", 140, 70, 100, new int[] {10, 50, 150, 450, 625, 750}, false, false, false, false, true),
            new Property("Virginia Avenue", 160, 80, 100, new int[] {12, 60, 180, 500, 700, 900}, false, false, false, false, true),
            new Property("Pennsylvania Railroad", 200, 100, new int[] {25, 50, 100, 200}, false, false, true, false, true),
            new Property("St. James Place", 180, 90, 100, new int[] {14, 70, 200, 550, 750, 950}, false, false, false, false, true),
            new Property("Community Chest", false, true, false, false, false),
            new Property("Tennessee Avenue", 180, 90, 100, new int[] {14, 70, 200, 550, 750, 950}, false, false, false, false, true),
            new Property("New York Avenue", 200, 100, 100, new int[] {16, 80, 220, 600, 800, 1000}, false, false, false, false, true),
            new Property("Free Parking", false, false, false, false, false),
            new Property("Kentucky Avenue", 220, 110, 150, new int[] {18, 90, 250, 700, 875, 1050}, false, false, false, false, true),
            new Property("Chance", true, false, false, false, false),
            new Property("Indiana Avenue", 220, 110, 150, new int[] {18, 90, 250, 700, 875, 1050}, false, false, false, false, true),
            new Property("Illinois Avenue", 240, 120, 150, new int[] {20, 100, 300, 750, 925, 1100}, false, false, false, false, true),
            new Property("B. & O. Railroad", 200, 100, new int[] {25, 50, 100, 200}, false, false, true, false, true),
            new Property("Atlantic Avenue", 260, 130, 150, new int[] {22, 110, 330, 800, 975, 1150}, false, false, false, false, true),
            new Property("Ventnor Avenue", 260, 130, 150, new int[] {22, 110, 330, 800, 975, 1150}, false, false, false, false, true),
            new Property("Water Works", 150, 75, false, false,false, true, true),
            new Property("Marvin Gardens", 280, 140, 150, new int[] {24, 120, 360, 850, 1025, 1200}, false, false, false, false, true),
            new Property("Go To Jail", false, false, false, false, false),
            new Property("Pacific Avenue", 300, 150, 200, new int[] {26, 130, 390, 900, 1100, 1275}, false, false, false, false, true),
            new Property("North Carolina Avenue", 300, 150, 200, new int[] {26, 130, 390, 900, 1100, 1275}, false, false, false, false, true),
            new Property("Community Chest", false, true, false, false, false),
            new Property("Pennsylvania Avenue", 320, 160, 200, new int[] {28, 150, 450, 1000, 1200, 1400}, false, false, false, false, true),
            new Property("Short Line", 200, 100, new int[] {25, 50, 100, 200}, false, false, true, false, true),
            new Property("Chance", true, false, false, false, false),
            new Property("Park Place", 350, 175, 200, new int[] {35, 175, 500, 1100, 1300, 1500}, false, false, false, false, true),
            new Property("Tax", false, false, false, false, false),
            new Property("Boardwalk", 400, 200, 200, new int[] {50, 200, 600, 1400, 1700, 2000}, false, false, false, false, true),
        };
        for (int i=0; i < board.length; i++) {
            board[i].position = i;
        }
    }

    public int findProperty(String name, int pos) {
        if (name.equals("Railroad")) {
            return findNearestRailroad(pos);
        } else if (name.equals("Utility")) {
            return findNearestUtility(pos);
        }
        for (int i=0; i < board.length; i++) {
            if (board[i].name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    private int findNearestRailroad(int pos) {
        for (int i=0; i < board.length * 2; i++) {
            int check;
            if (i % 2 == 0) {
                check = -i/2;
            } else {
                check = i/2;
            }
            check += pos + board.length;
            check %= board.length;
            if (board[check].isRailroad) {
                return check;
            }
        }
        return -1;
    }

    private int findNearestUtility(int pos) {
        for (int i=0; i < board.length * 2; i++) {
            int check;
            if (i % 2 == 0) {
                check = -i/2;
            } else {
                check = i/2;
            }
            check += pos + board.length;
            check %= board.length;
            if (board[check].isUtility) {
                return check;
            }
        }
        return -1;
    }

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

    public Point getLocation(int pos) {
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

        return new Point(x, y);
    }
}
