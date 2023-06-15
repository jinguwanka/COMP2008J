package DealCard;
import java.util.ArrayList;
import java.util.List;

public class PlayPile {
	
	private List<Card> actionCards=new ArrayList<>();
	
	public void addAction(Card card) {
		if (card instanceof ActionCard||card instanceof RentCard) {
			actionCards.add(card);
		}
	}
	
	public void remove(Card card) {
		actionCards.remove(card);
	}
	
	
	public List<Card> getActionCards() {
		return actionCards;
	}
	

}
