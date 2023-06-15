package DealCard;

import java.util.List;
import java.util.Random;

public class Cpu extends Player {

    public Cpu(String name) {
        super(name);
    }

    @Override
    public void action() {
        try {
            Thread.sleep(1000); // Pause execution for 1 second to simulate CPU's turn delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getCardsFromDrawpile(); // Get cards from the draw pile

        if (Math.random() < 0.5) { // 50% chance to skip turn and pass to the next player
            nextPlayer();
        } else {
            List<Card> cards = playPile.getActionCards(); // Get the action cards from the play pile
            Random random = new Random();
            Card card = cards.get(random.nextInt(cards.size())); // Select a random action card
            dealCardGame.getDrawpile().addRubbish(card); // Add the selected card to the draw pile's rubbish pile
            action(card); // Perform the action associated with the card
            playPile.remove(card); // Remove the card from the play pile

            nextPlayer(); // Move to the next player's turn
        }

        displayCards(); // Display the player's updated cards after the action
    }
}