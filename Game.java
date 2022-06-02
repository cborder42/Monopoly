// Kaustav Mitra
// Game class to stitch all the components together.

import java.util.*;
import javax.swing.JFrame;

public class Game{
    private DisplayGraphics graphics;
    private JFrame frame;
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
        frame.setSize(870,870);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);

        setupPlayers();
    }

    public int rollDice() {
        return (int)(Math.random() * 12) + 2;
    }
    
    public void simulation() {
        // Loop and get next player.
        // next player is null when there is a winner (one with money).
        for (Player player = getFirstPlayer(); player != null; player = getNextPlayer(player)) {
            int dice = rollDice();
            player.makeMove(board, dice);
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
            listOfPlayers.add(new Player(i));
        }
    }            
}
