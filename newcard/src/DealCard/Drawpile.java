package DealCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drawpile {
	
	private List<Card> cards=new ArrayList<>();
	private List<Card> rubbishCards=new ArrayList<>();
	
	public Drawpile() {
		// TODO Auto-generated constructor stub
		cards.addAll(CardFactory.createCards("property"));
		cards.addAll(CardFactory.createCards("wildcard"));
		cards.addAll(CardFactory.createCards("actioncard"));
		cards.addAll(CardFactory.createCards("rentcard"));
		cards.addAll(CardFactory.createCards("moneycard"));
		Collections.shuffle(cards);
		
	}
	
	public Card popCard() {
		if (cards.isEmpty()) {
			return null;
		}
		return cards.remove(0);
	}
	
	public void add(Card card) {
		cards.add(card);
	}
	
	
	public Card getRubbishPeek() {
		if (rubbishCards.isEmpty()) {
			return null;
		}
		return rubbishCards.get(0);
	}
	
	public void addRubbish(Card card) {
		rubbishCards.add(0, card);
	}
	
	
	

}
