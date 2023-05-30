package DealCard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Bank {
    private PriorityQueue<Card> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Card::getValue));


    public List<Card> getCards() {
        return new ArrayList<>(priorityQueue); // Return a new ArrayList containing all the cards in the priority queue
    }

    public void addAll(List<Card> cards) {
        for (Card card : cards) {
            add(card);
        }
    }

    public void add(Card card) {
        if (card instanceof MoneyCard||card instanceof ActionCard||card instanceof RentCard) {
            priorityQueue.add(card);
        }
    }

    public List<Card> getMoney(int money) {
        int total = 0;
        List<Card> cards = new ArrayList<>();

        PriorityQueue<Card> minHeap = new PriorityQueue<>(priorityQueue);

        int cardsTotalValue = 0;
        for (Card card : minHeap) {
            cardsTotalValue += card.getValue();
        }

        while (!minHeap.isEmpty()) {
            Card card = minHeap.poll();
            total += card.getValue();
            cards.add(card);

            if (total >= money) {
                break;
            }
        }
        return new ArrayList<>(cards);
    }

}