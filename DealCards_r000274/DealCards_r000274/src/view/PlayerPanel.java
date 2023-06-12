package view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import DealCard.Player;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;


public class PlayerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private Player player;
	private HandPanel handPanel;
	private BankPanel bankPanel=new BankPanel();
	
	public PlayerPanel(Player player) {
		setMinimumSize(new Dimension(10, 150));
		setMaximumSize(new Dimension(32767, 150));
		
		this.player=player;
		handPanel=new HandPanel(player);
		handPanel.setMinimumSize(new Dimension(200, 10));
		handPanel.setMaximumSize(new Dimension(32767, 32767));
		handPanel.setPreferredSize(new Dimension(200, 120));
		
		setBorder(new TitledBorder(null, player.getName(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		add(handPanel);
		add(bankPanel);
		
		
		bankPanel.displayBankCards(player.getBank().getCards());
		handPanel.displayActionCards(player.getPlayPile().getActionCards());
		

	}
	
	

}
