package DealCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cpu extends Player {

	public Cpu(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		getCardsFromDrawpile();
		if (Math.random()<0.5) {
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
	
	@Override
	public Player rndPlayer() {
		// TODO Auto-generated method stub
		Random random=new Random();
		ArrayList<Player> arrayList=new ArrayList<>(players);
		arrayList.remove(this);
		return arrayList.get(random.nextInt(arrayList.size()));
	}
	
	@Override
	public void addCard(Card card) {
		// TODO Auto-generated method stub
		if (card instanceof ActionCard) {
			if (Math.random()<0.5) {
				bank.add(card);
				return;
			}
		}
		
		super.addCard(card);
	}
	
	

}
