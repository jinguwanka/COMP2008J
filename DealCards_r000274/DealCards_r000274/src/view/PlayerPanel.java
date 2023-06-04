package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import DealCard.Cpu;
import DealCard.Player;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

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
    public void display() {
        bankPanel.displayBankCards(player.getBank().getCards());
        handPanel.displayActionCards(player.getPlayPile().getActionCards());
        propertyPanel.displayProperty(player.propertyCards());
        repaint();
    }
}
