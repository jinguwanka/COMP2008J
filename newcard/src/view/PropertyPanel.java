package view;

import javax.swing.JPanel;

import DealCard.Card;
import DealCard.PropertyCards;

import java.awt.Dimension;
import java.util.List;

public class PropertyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PropertyPanel() {
		setPreferredSize(new Dimension(400, 120));
		setLayout(null);

	}
	
	public void displayProperty(List<PropertyCards> propertyCards) {
		for (int i = 0; i < propertyCards.size(); i++) {
			PropertyCards propertyCards2=propertyCards.get(i);
			List<Card> cards=propertyCards2.getCards();
			for (int j = 0; j < cards.size(); j++) {
				ImagePanel imagePanel=new ImagePanel(cards.get(j).imageString());
				imagePanel.setLocation(i*100, j*30);
				add(imagePanel, 0);
			}
		}
	}

}
