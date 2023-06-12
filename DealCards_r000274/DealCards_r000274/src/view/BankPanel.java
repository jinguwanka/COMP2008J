package view;

import javax.swing.JPanel;

import DealCard.Card;

import java.awt.Dimension;
import java.util.List;

public class BankPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BankPanel() {
		setMinimumSize(new Dimension(200, 10));
		setMaximumSize(new Dimension(200, 32767));
		setPreferredSize(new Dimension(200, 120));
		setLayout(null);

	}
	
	public void displayBankCards(List<Card> cards) {
		removeAll();
		int i=0;
		for (Card card : cards) {
			ImagePanel imagePanel=new ImagePanel(card.imageString());
			imagePanel.setLocation(i*20, 0);
			add(imagePanel);
			i++;
		}
	}

}
