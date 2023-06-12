package DealCard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealCardGame {
	
	private int playerNum;
	private List<Player> players=new ArrayList<>();
	private Drawpile drawpile;
	
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
		distribute();
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
