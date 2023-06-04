package view;

import javax.swing.JPanel;

import DealCard.Card;
import DealCard.PropertyCards;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

public class PropertyPanel extends JPanel {

    /**
     * Create the panel.
     */
    public PropertyPanel() {
        setPreferredSize(new Dimension(400, 120));
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public void displayProperty(List<PropertyCards> propertyCards) {
        removeAll();

        for (PropertyCards property : propertyCards) {
            List<Card> cards = property.getCards();
            for (Card card : cards) {
                ImagePanel imagePanel = new ImagePanel(card.getImageString());
                add(imagePanel);
            }
        }


    }
}
