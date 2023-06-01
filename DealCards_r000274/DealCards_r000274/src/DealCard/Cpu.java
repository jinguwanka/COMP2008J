package DealCard;

import java.util.List;
import java.util.Random;

public class Cpu extends Player {

    public Cpu(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void action() {
        try {
            Thread.sleep(1000); // Pause execution for 1 second to simulate CPU's turn delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getCardsFromDrawpile();
        if (Math.random() < 0.5) { // 50% chance to skip turn and pass to the next player
            nextPlayer();
        } else {
            List<Card> cards=playPile.getActionCards();
            Random random=new Random();
            Card card=cards.get(random.nextInt(cards.size()));
            dealCardGame.getDrawpile().addRubbish(card);
            action(card);
            playPile.remove(card);

            nextPlayer();

        }
        displayCards();
    }



}