package DealCard;
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

	private void distribute() {
		int cardsToDistribute = 5 * players.size();
		for (int i = 0; i < cardsToDistribute; i++) {
			Player currentPlayer = players.get(i % players.size());
			currentPlayer.addCard(drawpile.popCard());
		}
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
		for (int i = 0; i < playerNum - 1; i++) {
			players.add(new Cpu("Cpu" + i));
		}
		players.add(new Player("Player"));
		distribute();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		// 添加游戏逻辑代码
	}

	public static void main(String[] args) {
		DealCardGame dealCardGame = DealCardGame.getInstance();
		// 添加游戏启动逻辑代码
	}

}
