package DealCard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DealCardGame {
	
	private int playerNum;
	private List<Player> players=new ArrayList<>();
	private Drawpile drawpile;
	private int currentPlayerIdx=3;
	
	private static DealCardGame instance;
	
	
	public static DealCardGame getInstance() {
		if (instance==null) {
			instance=new DealCardGame();
		}
		return instance;
	}
	
	private DealCardGame() {
		// TODO Auto-generated constructor stub
		drawpile=new Drawpile();
		
	}
	
	public void turn() {
		if (players.get(currentPlayerIdx).iswin()) {
			JOptionPane.showMessageDialog(null, String.format("%s win", players.get(currentPlayerIdx).getName()));
			return;
		}
		currentPlayerIdx++;
		currentPlayerIdx%=playerNum;
		Player player=players.get(currentPlayerIdx);
		if (player instanceof Cpu) {
			player.action();
			
		}else {
			players.get(currentPlayerIdx).getCardsFromDrawpile();
			players.get(currentPlayerIdx).displayCards();
		}
		
	}
	
	public Drawpile getDrawpile() {
		return drawpile;
	}
	
	
	
	private void distribute() {
		for (int i = 0; i < 5; i++) {
			for (Player player : players) {
				player.addCard(drawpile.popCard());
			}
		}
	}
	
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
		for (int i = 0; i <playerNum-1; i++) {
			players.add(new Cpu("Cpu"+i));
		}
		players.add(new Player("Player"));
		for (Player player : players) {
			player.setPlayers(players);
			player.setDealCardGame(this);
		}
		currentPlayerIdx=players.size()-1;
		
		distribute();
		players.get(currentPlayerIdx).getCardsFromDrawpile();
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	
	public void run() {
		Scanner scanner=new Scanner(System.in);
		
		
	}

	
	public static void main(String[] args) {
		DealCardGame dealCardGame=new DealCardGame();
		
	}
}
