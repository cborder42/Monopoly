// Kaustav Mitra
// Game class to stitch all the components together.

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.JFrame;

public class Game{
    private JFrame frame;
    private DisplayGraphics graphics;
    private Board board = new Board();
    public  ChanceCards cards = new ChanceCards();
    private ArrayList<Player> listOfPlayers = new ArrayList<Player>(); 
    private int sleepTime = 1000;
    private boolean forceEnd = false;

    public static void main (String[] args){
        Game game = new Game();
        game.simulation();
    }

    public Game() {
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

        setupPlayers();
        graphics.setPlayers(listOfPlayers);
    }

    public int rollDice() {
        return (int)(Math.random() * 6) + 1;
    }

    public DisplayGraphics getGraphics() {
        return graphics;
    }

    public Board getBoard() {
        return board;
    }
    
    public void simulation() {
        // Loop and get next player.
        // next player is null when there is a winner (one with money).
        for (Player player = getFirstPlayer(); player != null && !forceEnd; player = getNextPlayer(player)) {
            for (int tries=0; tries<3; tries++){
                int dice1 = rollDice();
                int dice2 = rollDice();
                boolean isDouble = dice1 == dice2;
                
                System.out.println(player.toString() + ": turn #" + (tries+1) + " rolled " + dice1 + "+" + dice2);
                player.makeMove(dice1 + dice2, isDouble);
                
                frame.requestFocusInWindow();
                delay(true);

                if (!isDouble) {
                    // Break out of loop.
                    tries=4;
                } else if (tries == 3) {
                    System.out.println(player.toString() + " is sent to jail for rolling 3 doubles.");
                    player.setPos(Board.jailPos);
                }
            }
        }

        // close the window
        frame.dispose();
    }

    public void delay(boolean extended) {
        try {
            Thread.sleep(extended ? sleepTime : sleepTime/30);
        } catch (InterruptedException e) {
        }
    }

    // Each player in turn throws the dice. The player with the highest total starts the play. 
    private Player getFirstPlayer() {
        Player firstPlayer = null;
        int max = 0;
        for(Player player: listOfPlayers) {
            int roll = rollDice();
            if (roll > max) {
                max = roll;
                firstPlayer = player;
            }
        }
        return firstPlayer;
    }

    // Get the next player with any balance.
    private Player getNextPlayer(Player activePlayer) {
        int playerId = activePlayer.getId();
        boolean done = false;
        Player player = null;
        while (!done) {
            playerId = (playerId + 1) % listOfPlayers.size();
            player = listOfPlayers.get(playerId);
            done = player.getBal() > 0;
        }

        if (activePlayer == player) {
            new AskInput(player.toString() + " has won", new String[] { "Goodbye!" }, this);
            player = null;
        }

        return player;
    }

    private void setupPlayers(){
        String s = new AskInput("How many players?", new String[] { "2", "3", "4"}, this).getSelection();
        int numOfPlayers = Integer.parseInt(s);
        for (int i = 0; i < numOfPlayers; i++){
            listOfPlayers.add(new Player(i, this));
        }
    }            
}
