package DealCard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Bank {
    private PriorityQueue<Card> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Card::getValue));

    public void add(Card card) {
        if (isSupportedCard(card)) { // Check if the card is supported (MoneyCard, ActionCard, or RentCard)
            priorityQueue.add(card); // Add the card to the priority queue
        }
    }

    private boolean isSupportedCard(Card card) {
        return card instanceof MoneyCard || card instanceof ActionCard || card instanceof RentCard;
    }

    public List<Card> getCards() {
        return new ArrayList<>(priorityQueue); // Return a new ArrayList containing all the cards in the priority queue
    }

    public void addAll(List<Card> cards) {
        for (Card card : cards) {
            add(card); // Add each card from the list to the priority queue
        }
    }

    public List<Card> getMoney(int money) {
        int total = 0;
        List<Card> cards = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Card card = priorityQueue.poll(); // Retrieve and remove the card with the lowest value from the priority queue
            total += card.getValue(); // Increment the total value with the card's value
            cards.add(card); // Add the card to the result list
            if (total >= money) {
                break; // Exit the loop if the total value exceeds or equals the required amount of money
            }
        }
        return cards; // Return the list of cards that fulfill the money requirement
    }
}