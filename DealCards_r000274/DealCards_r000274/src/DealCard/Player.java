package DealCard;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import view.Gui;
import view.PlayerPanel;

public class Player {
	
	private Bank bank=new Bank();
	protected PlayPile playPile=new PlayPile();
	private Map<CardColor, PropertyCards> propertyMap=new LinkedHashMap<>();
	private List<Wildcard> wildcards=new ArrayList<>();
	private List<Player> players;
	
	public DealCardGame dealCardGame;
	private PlayerPanel playerPanel;
	
	private String name;
	private Gui gui;
	private Observer observer;
	
	public Player(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
		
	}
	
	public void setObserver(Observer observer) {
		this.observer = observer;
	}
	
	public void setGui(Gui gui) {
		this.gui = gui;
	}
	
	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}
	
	public Player rndPlayer() {
		Random random=new Random();
		ArrayList<Player> arrayList=new ArrayList<>(players);
		arrayList.remove(this);
		return arrayList.get(random.nextInt(arrayList.size()));
	}
	
	public PropertyCards getPropertyCards(Card card) {
		if (!(card instanceof RentCard)) {
			return null;
		}
		if (card.getCardColor()==CardColor.MultiColor) {
			ArrayList<PropertyCards> arrayList=new ArrayList<>(propertyMap.values()); 
			if (arrayList.isEmpty()) {
				return null;
			}
			return arrayList.get(0);
		}
		if (propertyMap.containsKey(card.getCardColor())) {
			return propertyMap.get(card.cardColor);
		}else if (propertyMap.containsKey(card.getSecondCardColor())) {
			return propertyMap.get(card.getSecondCardColor());
		}
		return null;
	}
	
	private void rent(Card card) {
		PropertyCards propertyCards=getPropertyCards(card);
		if (propertyCards==null) {
			observer.update(this, String.format("rentcard %s not renting", card.getName()));
		}else {
			Player player=rndPlayer();
			int rent=propertyCards.getRent();
			List<Card> cards=player.getBank().getMoney(rent);
			bank.addAll(cards);
			observer.update(this, String.format("rentcard %s renting for %s", card.getName(),player.getName()));
		}
		
		
	}
	
	public boolean iswin() {
		int num=0;
		for (PropertyCards propertyCards:propertyMap.values()) {
			if (propertyCards.isFull()) {
				num++;
			}
		}
		return num>=3;
	}
	
	public Map<CardColor, PropertyCards> getPropertyMap() {
		return propertyMap;
	}
	
	private void dealbreaker(Card card) {
		Player player=rndPlayer();
		ArrayList<PropertyCards> arrayList=new ArrayList<>(player.getPropertyMap().values());
		player.getPropertyMap().clear();
		for (PropertyCards propertyCards : arrayList) {
			List<Card> cards=propertyCards.getCards();
			for (Card card1 : cards) {
				addCard(card1);
			}
		}
		observer.update(this, String.format(" %s dealbreaker for %s", card.getName(),player.getName()));
	}
	
	private void justsayno(Card card) {
		
	}
	
	private void slydeal(Card card) {
		Player player=rndPlayer();
		for (PropertyCards propertyCards:player.getPropertyMap().values()) {
			if (!propertyCards.isFull()) {
				Card card2=propertyCards.slyDeal();
				if (card2==null) {
					continue;
				}
				addCard(card2);
				break;
			}
		}
		observer.update(this, String.format(" %s slydeal for %s", card.getName(),player.getName()));
	}
	
	private void forcedeal(Card card) {
		Player player=rndPlayer();
		
		Random random=new Random();
		ArrayList<CardColor> arrayList=new ArrayList<>(player.getPropertyMap().keySet());
		ArrayList<CardColor> arrayList2=new ArrayList<>(getPropertyMap().keySet());
		PropertyCards propertyCards=player.getPropertyMap().remove(arrayList.get(random.nextInt(arrayList.size())));
		PropertyCards propertyCards2=getPropertyMap().remove(arrayList2.get(random.nextInt(arrayList2.size())));
		player.getPropertyMap().put(propertyCards2.getCardColor(), propertyCards2);
		getPropertyMap().put(propertyCards.getCardColor(), propertyCards);
		
		observer.update(this, String.format(" %s forcedeal for %s", card.getName(),player.getName()));
	}
	
	private void debtcollector(Card card) {
		Player player=rndPlayer();
		List<Card> cards=player.getBank().getMoney(5);
		for (Card card2 : cards) {
			addCard(card2);
		}
		observer.update(this, String.format(" %s debtcollector for %s", card.getName(),player.getName()));
	}
	
	
	
	private void mybirthday(Card card) {
		ArrayList<Player> arrayList=new ArrayList<>(players);
		arrayList.remove(this);
		for (Player player : arrayList) {
			List<Card> list=player.getBank().getMoney(2);
			for (Card card1:list) {
				addCard(card1);
			}
		}
		observer.update(this, String.format(" %s forcedeal for %s", card.getName(),"All players"));
	}
	
	public void action(Card card) {
		if (card instanceof RentCard) {
			rent(card);
		}else if (card instanceof ActionCard) {
			if (card.getName().equals("dealbreaker")) {
				dealbreaker(card);
			}else if (card.getName().equals("justsayno")) {
				justsayno(card);
			}else if (card.getName().equals("slydeal")) {
				slydeal(card);
			}else if (card.getName().equals("forcedeal")) {
				forcedeal(card);
			}else if (card.getName().equals("debtcollector")) {
				debtcollector(card);
			}else if (card.getName().equals("mybirthday")) {
				mybirthday(card);
			}
		}
		
	}
	
	public void action() {
		
	}
	
	public void getCardsFromDrawpile() {
		int n=2;
		if (playPile.getActionCards().size()==0) {
			n=5;
		}
		for (int i = 0; i < n; i++) {
			addCard(dealCardGame.getDrawpile().popCard());
		}
	}
	
	public void nextPlayer() {
		dealCardGame.turn();
		playerPanel.display();
		if (dealCardGame.getDrawpile().getRubbishPeek()==null) {
			return;
		}
		gui.setRubbishImage(dealCardGame.getDrawpile().getRubbishPeek().imageString());
		
	}
	
	public void setDealCardGame(DealCardGame dealCardGame) {
		this.dealCardGame = dealCardGame;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public List<PropertyCards> propertyCards() {
		return new ArrayList<>(propertyMap.values());
	}
	
	public PlayPile getPlayPile() {
		return playPile;
	}
	
	public void dealCard(Card card) {
		action(card);
		playPile.remove(card);
		dealCardGame.getDrawpile().addRubbish(card);
		displayCards();
	}
	
	public void displayCards() {
		gui.displayPlayerPanels();
		
		if (dealCardGame.getDrawpile().getRubbishPeek()==null) {
			return;
		}
		gui.setRubbishImage(dealCardGame.getDrawpile().getRubbishPeek().imageString());
		gui.repaint();
	}
	
	public void addCard(Card card) {
		
		if (card instanceof MoneyCard) {
			bank.add(card);
		}else if (card instanceof ActionCard||card instanceof RentCard) {
			if (card.getName().equals("hotel")||card.getName().equals("house")) {
				PropertyCards propertyCards=maxNumPropertyCards();
				if (propertyCards!=null) {
					propertyCards.add(card);
				}else {
					playPile.addAction(card);
				}
			}else {
				playPile.addAction(card);
			}
			
		}else {
			if (card instanceof Property) {
				if (!propertyMap.containsKey(card.cardColor)) {
					propertyMap.put(card.getCardColor(), new PropertyCards(card.cardColor));
				}
				propertyMap.get(card.cardColor).add(card);
			}else if (card instanceof Wildcard) {
				if (propertyMap.containsKey(card.cardColor)) {
					propertyMap.get(card.cardColor).add(card);
				}else if (propertyMap.containsKey(card.getSecondCardColor())) {
					propertyMap.get(card.getSecondCardColor()).add(card);
				}else {
					if (card.getCardColor()==CardColor.MultiColor) {
						PropertyCards propertyCards=maxNumPropertyCards();
						if (propertyCards==null) {
							PropertyCards propertyCard=new PropertyCards(CardColor.Brown);
							propertyCard.add(card);
							propertyMap.put(CardColor.Brown, propertyCard);
						}else {
							propertyCards.add(card);
						}
					}else {
						PropertyCards propertyCards=new PropertyCards(card.cardColor);
						propertyCards.add(card);
						propertyMap.put(card.cardColor, propertyCards);
					}
					
				}
			}
		}
		
	}
	
	public PropertyCards maxNumPropertyCards() {
		PropertyCards maxCards=null;
		for (PropertyCards propertyCards:propertyMap.values()) {
			if (maxCards==null) {
				maxCards=propertyCards;
			}else {
				if (maxCards.propertyNum()<propertyCards.propertyNum()) {
					maxCards=propertyCards;
				}
			}
		}
		return maxCards;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public String getName() {
		return name;
	}
	
	
	

}
