package view;

import javax.swing.JPanel;

import DealCard.Card;
import DealCard.Cpu;
import DealCard.Player;

import java.awt.Dimension;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class HandPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private Player player;
	
	public HandPanel(Player player) {
		setPreferredSize(new Dimension(10, 150));
		this.player=player;
		setLayout(null);
		

	}
	
	public void displayActionCards(List<Card> cards) {
		removeAll();
		for (int i = 0; i <cards.size(); i++) {
			String string=cards.get(i).imageString();
			if (player instanceof Cpu) {
				string="back/back.jpg";
			}
			ImagePanel imagePanel=new ImagePanel(string);
			
			imagePanel.setLocation(i*20, 0);
			if (!(player instanceof Cpu)) {
				imagePanel.setLocation(i*80, 0);
				setPreferredSize(new Dimension(80*i+80, 120));
			}
			add(imagePanel);
		}
	}
}
