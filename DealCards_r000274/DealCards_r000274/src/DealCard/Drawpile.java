package DealCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drawpile {

	private List<Card> cards;
	private List<Card> rubbishCards;

	public Drawpile() {
		cards = new ArrayList<>();
		rubbishCards = new ArrayList<>();
		initializeCards();
		shuffleCards();
	}

	private void initializeCards() {
		cards.addAll(CardFactory.createCards("property"));
		cards.addAll(CardFactory.createCards("wildcard"));
		cards.addAll(CardFactory.createCards("actioncard"));
		cards.addAll(CardFactory.createCards("rentcard"));
		cards.addAll(CardFactory.createCards("moneycard"));
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