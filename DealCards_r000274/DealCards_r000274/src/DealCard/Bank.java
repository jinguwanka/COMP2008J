package DealCard;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Bank {
	
	private PriorityQueue<Card> priorityQueue=new PriorityQueue<>(new Comparator<Card>() {

		@Override
		public int compare(Card o1, Card o2) {
			// TODO Auto-generated method stub
			return o1.getValue()-o2.getValue();
		}
	});
	
	public void add(Card card) {
		if (card instanceof MoneyCard||card instanceof ActionCard||card instanceof RentCard) {
			priorityQueue.add(card);
		}
	}
	
	public List<Card> getCards() {
		return new ArrayList<>(priorityQueue);
	}
	
	public void addAll(List<Card> cards) {
		for (Card card : cards) {
			add(card);
		}
	}
	
	public List<Card> getMoney(int money) {
		int total=0;
		List<Card> cards=new ArrayList<>();
		while (!priorityQueue.isEmpty()) {
			Card card=priorityQueue.poll();
			total+=card.getValue();
			cards.add(card);
			if (total>=money) {
				break;
			}
		}
		
		return cards;
	}

}
