package view;

import javax.swing.JPanel;

import DealCard.Card;
import DealCard.Cpu;
import DealCard.Player;

import java.awt.Dimension;
import java.util.List;
import java.awt.FlowLayout;

public class HandPanel extends JPanel {

    private Player player;

    /**
     * Create the panel.
     */
    public HandPanel(Player player) {
        this.player = player;
        setPreferredSize(new Dimension(10, 150));
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }


}
