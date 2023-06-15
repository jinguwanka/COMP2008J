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

    public void displayActionCards(List<Card> cards) {
        removeAll();

        for (Card card : cards) {
            String imagePath = card.getImageString();

            if (player instanceof Cpu) {
                imagePath = "back/back.jpg";
            }

            ImagePanel imagePanel = new ImagePanel(imagePath);
            add(imagePanel);
        }

        int cardCount = cards.size();
        int preferredWidth = player instanceof Cpu ? cardCount * 20 : cardCount * 80;
        setPreferredSize(new Dimension(preferredWidth, 120));

        revalidate();
        repaint();
    }
}
