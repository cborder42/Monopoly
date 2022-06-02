import java.awt.*;
import java.awt.Font;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.Graphics; 

public class DisplayGraphics extends Canvas {

public ArrayList<Player> players = new ArrayList<Player>();

public void setPlayers(ArrayList<Player> players) {
    this.players = players;
}

public void paint(Graphics g) {


Font f1 = new Font("GO SIGN",1,70); 
Font f2 = new Font("IN JAIL", 1,30);
Font f3 = new Font("VISITING", 1,15);
Font f4 = new Font("side squares", 1,10);
Font f5 = new Font("INCOME TAX", 1, 15);
Font f6 = new Font("TITLE", 1, 90);

setBackground(Color.WHITE);

setForeground(Color.BLACK);


g.setColor(Color.decode("#E5FFCC"));
g.fillRect(0,0,870,870); // whole dimension
g.fillRect(120, 120, 630, 630);  // center square


g.setFont(f4);

g.setColor(Color.BLACK);
g.drawRect(0, 120, 120, 70);   //1
g.setColor(Color.ORANGE);
g.fillRect(0, 120, 120, 20);
g.setColor(Color.BLACK);
g.drawString("NEW YORK AVENUE", 12, 150);
g.drawString("$200", 50, 185);


g.setColor(Color.BLACK);
g.drawRect(0, 190, 120, 70);   //2
g.setColor(Color.ORANGE);
g.fillRect(0, 190, 120, 20); 
g.setColor(Color.BLACK);
g.drawString("TENNESSEE AVENUE", 5, 220);
g.drawString("$180", 50, 255);

g.setColor(Color.BLACK);
g.drawRect(0, 260, 120, 70);   //3
g.drawString("COMMUNITY CHEST", 10, 280);


g.setColor(Color.BLACK);
g.drawRect(0, 330, 120, 70);   //4
g.setColor(Color.ORANGE);
g.fillRect(0, 330, 120, 20);
g.setColor(Color.BLACK);
g.drawString("ST. JAMES PLACE", 15, 360);
g.drawString("$180", 50, 395);

g.setColor(Color.BLACK);
g.drawRect(0, 400, 120, 70);   //5
g.drawString("PENNSYLVANIA", 22, 420);
g.drawString("RAILROAD", 35, 430);
g.drawString("$200", 50, 465);


g.setColor(Color.BLACK);
g.drawRect(0, 470, 120, 70);   //6
g.setColor(Color.decode("#FF007F"));
g.fillRect(0, 470, 120, 20);
g.setColor(Color.BLACK);
g.drawString("VIRGINIA AVENUE", 15, 500);
g.drawString("$160", 50, 535);

g.setColor(Color.BLACK);
g.drawRect(0, 540, 120, 70);   //7
g.setColor(Color.decode("#FF007F"));
g.fillRect(0, 540, 120, 20); 
g.setColor(Color.BLACK);
g.drawString("STATES AVENUE", 20, 570);
g.drawString("$140", 50, 605);

g.setColor(Color.BLACK);
g.drawRect(0, 610, 120, 70);   //8
g.drawString("ELECTRIC COMPANY", 10, 630);
g.drawString("$150", 50, 675);


g.setColor(Color.BLACK);
g.drawRect(0, 680, 120, 70);   //9   
g.setColor(Color.decode("#FF007F"));
g.fillRect(0, 680, 120, 20);
g.setColor(Color.BLACK);
g.drawString("ST. CHARLES PLACE", 10, 710);
g.drawString("$140", 50, 745);




// FREE PARKING 
g.setFont(f5);
g.setColor(Color.BLACK);
g.drawRect(0,0, 120, 120); // top left corner
g.drawString("FREE PARKING", 2, 60);


// TOP ROW 
// FREE PARKING to GO TO JAIL
g.setFont(f4);

g.setColor(Color.BLACK);
g.drawRect(120,0,70, 120);
g.setColor(Color.RED);
g.fillRect(120,0,70, 30);
g.setColor(Color.BLACK);
g.drawString("KENTUCKY", 130, 40);
g.drawString("AVENUE", 135, 50);
g.drawString("$220", 145, 115);

g.setColor(Color.BLACK);
g.drawRect(190,0,70, 120);
g.drawString("CHANCE", 205, 20);


g.setColor(Color.BLACK);
g.drawRect(260,0,70, 120);
g.setColor(Color.RED);
g.fillRect(260,0,70, 30);
g.setColor(Color.BLACK);
g.drawString("INDIANA", 275, 40);
g.drawString("AVENUE", 275, 50);
g.drawString("$220", 285, 115);

g.setColor(Color.BLACK);
g.drawRect(330,0,70, 120);
g.setColor(Color.RED);
g.fillRect(330,0,70, 30);
g.setColor(Color.BLACK);
g.drawString("ILLINOIS", 345, 40);
g.drawString("AVENUE", 345, 50);
g.drawString("$240", 355, 115);

g.setColor(Color.BLACK);
g.drawRect(400,0,70, 120);
g.drawString("B.& O.", 420,15);
g.drawString("RAILROAD", 410, 25);
g.setColor(Color.BLACK);
g.drawString("$200", 425,115);

g.setColor(Color.BLACK);
g.drawRect(470,0,70, 120);
g.setColor(Color.YELLOW);
g.fillRect(470,0,70, 30);
g.setColor(Color.BLACK);
g.drawString("ATLANTIC", 480, 40);
g.drawString("AVENUE", 485, 50);
g.drawString("$260", 495, 115);

g.setColor(Color.BLACK);
g.drawRect(540,0,70, 120);
g.setColor(Color.YELLOW);
g.fillRect(540,0,70, 30);
g.setColor(Color.BLACK);
g.drawString("VENTNOR", 550, 40);
g.drawString("AVENUE", 555, 50);
g.drawString("$260", 565, 115);

g.setColor(Color.BLACK);
g.drawRect(610,0,70, 120);
g.drawString("WATER",625,15);
g.drawString("WORKS", 625, 25);
g.setColor(Color.BLACK);
g.drawString("$150", 635, 115);

g.setColor(Color.BLACK);
g.drawRect(680,0,70, 120);
g.setColor(Color.YELLOW);
g.fillRect(680,0,70, 30);
g.setColor(Color.BLACK);
g.drawString("MARVIN",695,40);
g.drawString("GARDENS", 690, 50);
g.drawString("$280", 705, 115);



// GO TO JAIL
g.setColor(Color.BLACK);
g.drawRect(750,0, 120, 120); // top right corner
g.setFont(f3);
g.drawString("GO TO JAIL", 765, 60);


g.setFont(f4);
// RIGHT COLUMN
// GO TO JAIL to GO
g.setColor(Color.BLACK);
g.drawRect(750, 120, 120, 70);   //1
g.setColor(Color.decode("#006400"));
g.fillRect(750, 120, 120, 20);
g.setColor(Color.BLACK);
g.drawString("PACIFIC AVENUE", 770, 150);
g.drawString("$300", 800, 185);

g.setColor(Color.BLACK);
g.drawRect(750, 190, 120, 70);   //2
g.setColor(Color.decode("#006400"));
g.fillRect(750, 190, 120, 20); 
g.setColor(Color.BLACK);
g.drawString("NORTH CAROLINA", 765, 220);
g.drawString("AVENUE", 790, 230);
g.drawString("$300", 800, 255);


g.setColor(Color.BLACK);
g.drawRect(750, 260, 120, 70);   //3
g.drawString("COMMUNITY CHEST", 760, 280);

g.setColor(Color.BLACK);
g.drawRect(750, 330, 120, 70);   //4
g.setColor(Color.decode("#006400"));
g.fillRect(750, 330, 120, 20); 
g.setColor(Color.BLACK);
g.drawString("PENNSYLVANIA AVENUE", 751, 360);
g.drawString("$320", 800, 395);

g.setColor(Color.BLACK);
g.drawRect(750, 400, 120, 70);   //5
g.drawString("SHORT LINE", 780, 420);
g.drawString("$200", 800, 465);

g.setColor(Color.BLACK);
g.drawRect(750, 470, 120, 70);   //6
g.drawString("CHANCE", 790, 490);

g.setColor(Color.BLACK);
g.drawRect(750, 540, 120, 70);   //7
g.setColor(Color.decode("#02386E"));
g.fillRect(750, 540, 120, 20);
g.setColor(Color.BLACK);
g.drawString("PARK PLACE", 779, 570);
g.drawString("$350", 800, 605);

g.setFont(f5);
g.setColor(Color.BLACK);
g.drawRect(750, 610, 120, 70);   //8
g.drawString("LUXURY TAX", 760, 630);
g.setFont(f4);
g.drawString("PAY $100", 790, 675);



g.setFont(f4);
g.setColor(Color.BLACK);
g.drawRect(750, 680, 120, 70);
g.setColor(Color.decode("#02386E"));
g.fillRect(750, 680, 120, 20);
g.setColor(Color.BLACK);
g.drawString("BOARDWALK", 780, 710);
g.drawString("$140", 800, 745);




// BOTTOM ROW

g.setColor(Color.BLACK);
g.drawRect(750,750, 120, 120); // bottom right corner
g.setFont(f1);
g.drawString("GO", 755, 810);


// BOTTOM ROW RIGHT TO LEFT

g.setFont(f4);
g.drawRect(120,750,70, 120);
g.setColor(Color.decode("#ADD8E6"));
g.fillRect(120, 750,70, 30);
g.setColor(Color.BLACK);
g.drawString("CONNETICUT", 121, 790);
g.drawString("AVENUE", 135, 800);
g.drawString("$120", 145, 865);

g.setColor(Color.BLACK);
g.drawRect(190,750,70, 120);
g.setColor(Color.decode("#ADD8E6"));
g.fillRect(190,750,70, 30);
g.setColor(Color.BLACK);
g.drawString("VERMONT", 200, 790);
g.drawString("AVENUE", 205, 800);
g.drawString("$100", 215, 865);

g.setColor(Color.BLACK);
g.drawRect(260,750,70, 120);
g.drawString("CHANCE", 275, 770);


g.setColor(Color.BLACK);
g.drawRect(330,750,70, 120);
g.setColor(Color.decode("#ADD8E6"));
g.fillRect(330,750,70, 30);
g.setColor(Color.BLACK);
g.drawString("ORIENTAL", 340, 790);
g.drawString("AVENUE", 345, 800);
g.drawString("$100", 355, 865);

g.setColor(Color.BLACK);
g.drawRect(400,750,70, 120);
g.drawString("READING", 413, 765);
g.drawString("RAILROAD", 410, 775);
g.drawString("$200", 425,865);

g.setColor(Color.BLACK);
g.drawRect(470,750,70, 120);
g.setFont(f5);
g.drawString("INCOME", 475, 765);
g.drawString("TAX", 490, 780);
g.setFont(f4);
g.drawString("PAY $200", 485, 865);


g.setColor(Color.BLACK);
g.drawRect(540,750,70, 120);
g.setColor(Color.decode("#4A2511"));
g.fillRect(540,750,70, 30);
g.setColor(Color.BLACK);
g.drawString("BALTIC", 557, 790);
g.drawString("AVENUE", 555, 800);
g.drawString("$60", 568, 865);


g.setFont(f4);
g.setColor(Color.BLACK);
g.drawRect(610,750,70, 120);
g.drawString("COMMUNITY", 613, 765);
g.drawString("CHEST", 625, 775);

g.setColor(Color.BLACK);
g.drawRect(680,750,70, 120);
g.setColor(Color.decode("#4A2511"));
g.fillRect(680,750,70, 30);
g.setColor(Color.BLACK);
g.drawString("MEDITER-",688,790);
g.drawString("RANEAN", 693, 800);
g.drawString("AVENUE", 693, 810);
g.drawString("$60", 708, 865);




g.setColor(Color.BLACK);
g.drawRect(0, 750, 120, 120); // bottom left corner 
g.drawRect(30,750,90,90);

// BOTTOM LEFT CORNER TEXT
g.setFont(f2);
g.drawString("JAIL", 42, 805);
g.setFont(f3);
g.drawString("VISITING", 30, 865);

Polygon redPoly = new Polygon(new int[]{ 0+240-40  , 870-240-40, 870-240+40, 0+240+40  },
                              new int[]{ 870-240-40, 0+240-40  , 0+240+40  , 870-240+40},
                              4);
g.setColor(Color.RED);
g.fillPolygon(redPoly);
g.setColor(Color.BLACK);
g.drawPolygon(redPoly);
AffineTransform transform = new AffineTransform();
transform.rotate(Math.toRadians(-45), 0, 0);
g.setFont(f6.deriveFont(transform));
g.setColor(Color.BLACK);
g.drawString("MONOPOLY", 270, 645);
g.setColor(Color.WHITE);
g.drawString("MONOPOLY", 275, 645);
transform.rotate(Math.toRadians(45), 0, 0);

// Paint the players

int i = 0;
for(Player player : players) {
    int bal = player.getBal();
    if (bal > 0) {
        Point p = player.getLocation();
        if (i == 0) {
            g.setColor(Color.decode("#FF8A8A"));
            g.fillOval(p.x, p.y,30,20);
        } else if (i== 1) {
            g.setColor(Color.GREEN);
            g.fillOval(p.x, p.y, 20, 20);
        } else if (i == 2) {
            g.setColor(Color.BLUE);
            g.fillRect(p.x, p.y, 20, 20);
        } else {
            g.setColor(Color.MAGENTA);
            g.fillRect(p.x, p.y,20,30);
        }

        g.setFont(f4);
        g.drawString(player.toString() + ": $" + bal, 650, 650 + i*20);
    }
    i++;
}

}
}