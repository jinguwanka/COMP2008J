package DealCard;

import java.util.List;

import view.Gui;

public class Controller {

    private DealCardGame dealCardGame = DealCardGame.getInstance(); // Instance of the DealCardGame
    private Gui gui; // Reference to the GUI

    public Controller() {
        dealCardGame.setPlayerNum(4); // Set the number of players in the DealCardGame
    }

    // Set the GUI for the controller
    public void setGui(Gui gui) {
        this.gui = gui;
        addPlayers(); // Add players to the GUI
    }

    // Add players to the GUI
    private void addPlayers() {
        List<Player> players = dealCardGame.getPlayers(); // Get the list of players from the DealCardGame
        for (Player player : players) {
            gui.addPlayer(player); // Add each player to the GUI
        }
    }
}
