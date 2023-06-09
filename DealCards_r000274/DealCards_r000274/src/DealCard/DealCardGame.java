package DealCard;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealCardGame {

	private int playerNum;
	private List<Player> players;
	private Drawpile drawpile;

	private static DealCardGame instance;

	public static DealCardGame getInstance() {
		if (instance == null) {
			instance = new DealCardGame();
		}
		return instance;
	}

	private DealCardGame() {
		players = new ArrayList<>();
		drawpile = new Drawpile();
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
	private void distribute() {
		int cardsToDistribute = 5 * players.size();
		for (int i = 0; i < cardsToDistribute; i++) {
			Player currentPlayer = players.get(i % players.size());
			currentPlayer.addCard(drawpile.popCard());
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
