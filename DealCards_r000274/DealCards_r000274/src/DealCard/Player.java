package DealCard;
import java.util.LinkedHashMap;
import java.util.Map;

public class Player {
	
	private Bank bank=new Bank();
	private PlayPile playPile=new PlayPile();
	private Map<CardColor, Card> propertyMap=new LinkedHashMap<>();
	
	private String name;
	
	public Player(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	public PlayPile getPlayPile() {
		return playPile;
	}
	
	public void addCard(Card card) {
		if (card instanceof MoneyCard) {
			bank.add(card);
		}else if (card instanceof ActionCard||card instanceof RentCard) {
			playPile.addAction(card);
		}
		
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public String getName() {
		return name;
	}
	
	
	

}
