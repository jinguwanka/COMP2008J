package DealCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PropertyCards {
	
	private CardColor cardColor;
	private List<Card> propertyCards=new ArrayList<>();
	
	private List<Card> otherCards=new ArrayList<>();
	
	public PropertyCards(CardColor cardColor) {
		// TODO Auto-generated constructor stub
		this.cardColor=cardColor;
	}
	
	public void add(Card card) {
		if (card instanceof Property) {
			propertyCards.add(card);
		}else {
			otherCards.add(card);
		}
		
	}
	
	public CardColor getCardColor() {
		return cardColor;
	}
	
	public boolean isFull() {
		
		return cardColor.getNum()==propertyCards.size();
	}
	
	public Card slyDeal() {
		Random random=new Random();
		if (propertyCards.isEmpty()) {
			return null;
		}
		return propertyCards.remove(random.nextInt(propertyCards.size()));
	}
	
	public int getRent() {
		int rent=cardColor.rent(propertyCards.size());
		for (Card card : otherCards) {
			if (card.getName().equals("house")) {
				rent+=3;
			}else if (card.getName().equals("hotel")) {
				rent+=4;
			}
		}
		return rent;
	}
	
	public int propertyNum() {
		return propertyCards.size();
	}
	
	public List<Card> getCards() {
		ArrayList<Card> arrayList=new ArrayList<>();
		arrayList.addAll(propertyCards);
		arrayList.addAll(otherCards);
		
		return arrayList;
	}

}
