// Kaustav Mitra
// Game class to stitch all the components together.

import java.util.*;
import javax.swing.JFrame;

public class Game{
    private JFrame frame;
    private DisplayGraphics graphics;
    private Board board = new Board();
    private ArrayList<Player> listOfPlayers = new ArrayList<Player>(); 

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

        setupPlayers();
        graphics.setPlayers(listOfPlayers);
    }

    public int rollDice() {
        return (int)(Math.random() * 12) + 2;
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
        for (Player player = getFirstPlayer(); player != null; player = getNextPlayer(player)) {
            int dice = rollDice();
            player.makeMove(dice);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            graphics.invalidate();
        }

        // close the window
        frame.dispose();
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
            new AskInput(player.toString() + " has won", new String[] { "Goodbye!" });
            player = null;
        }

        return player;
    }

    private void setupPlayers(){
        String s = new AskInput("How many players?", new String[] { "2", "3", "4"}).getSelection();
        int numOfPlayers = Integer.parseInt(s);
        for (int i = 0; i < numOfPlayers; i++){
            listOfPlayers.add(new Player(i, this));
        }
    }            
}
