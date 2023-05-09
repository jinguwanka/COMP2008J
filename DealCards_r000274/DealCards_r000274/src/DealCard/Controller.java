package DealCard;

import java.util.List;

import view.Gui;

public class Controller {

    private DealCardGame dealCardGame = DealCardGame.getInstance();
    private Gui gui;

    public Controller() {
        dealCardGame.setPlayerNum(4);
    }


    public void setGui(Gui gui) {
        this.gui = gui;
        addPlayers();
    }
    public void nextPlayer() {
        dealCardGame.turn();

    }


    private void addPlayers() {
        List<Player> players = dealCardGame.getPlayers();
        for (Player player : players) {
            gui.addPlayer(player);
        }
    }
}
