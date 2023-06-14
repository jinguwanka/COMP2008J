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

	/**
	 * Create the panel.
	 */
	private Player player;
	private HandPanel handPanel;
	private BankPanel bankPanel=new BankPanel();
	private PropertyPanel propertyPanel=new PropertyPanel();
	private JLabel infJLabel=new JLabel(" ");
	
	public PlayerPanel(Player player) {
		setMinimumSize(new Dimension(10, 150));
		setMaximumSize(new Dimension(32767, 150));
		
		this.player=player;
		player.setPlayerPanel(this);
		handPanel=new HandPanel(player);
		handPanel.setMinimumSize(new Dimension(200, 10));
		handPanel.setMaximumSize(new Dimension(32767, 32767));
		handPanel.setPreferredSize(new Dimension(200, 120));
		
		setBorder(new TitledBorder(null, player.getName(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		if (!(player instanceof Cpu)) {
			Button button=new Button("NextPlayer");
			add(button);
			button.addActionListener(e->player.nextPlayer());
		}
		
		add(handPanel);
		add(bankPanel);
		add(propertyPanel);
		add(infJLabel);
		
		
		bankPanel.displayBankCards(player.getBank().getCards());
		handPanel.displayActionCards(player.getPlayPile().getActionCards());
		propertyPanel.displayProperty(player.propertyCards());
		

	}
	
	public JLabel getInfJLabel() {
		return infJLabel;
	}
	
	public void display() {
		bankPanel.displayBankCards(player.getBank().getCards());
		handPanel.displayActionCards(player.getPlayPile().getActionCards());
		propertyPanel.displayProperty(player.propertyCards());
		repaint();
	}
	
	

}
