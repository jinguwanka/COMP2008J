package view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import DealCard.Player;
import java.awt.FlowLayout;

public class PlayerPanel extends JPanel {

    private Player player;
    private HandPanel handPanel;
    private BankPanel bankPanel = new BankPanel();

    public PlayerPanel(Player player) {
        this.player = player;
        initializePanel();
        displayBankCards();
        displayActionCards();
    }

    private void initializePanel() {
        setBorder(new TitledBorder(null, player.getName(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        handPanel = new HandPanel(player);
        add(handPanel);
        add(bankPanel);
    }

    private void displayBankCards() {
        bankPanel.displayBankCards(player.getBank().getCards());
    }

    private void displayActionCards() {
        handPanel.displayActionCards(player.getPlayPile().getActionCards());
    }
}
