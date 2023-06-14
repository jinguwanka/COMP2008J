package DealCard;
import java.util.ArrayList;
import java.util.List;

public class CardFactory {
	
	public static List<Card> createCards(String type) {
		ArrayList<Card> cards=new ArrayList<>();
		switch (type.toLowerCase()) {
		case "property":
			cards.addAll(propertyCards());
			break;
		case "wildcard":
			cards.addAll(wildCards());
			break;
		case "actioncard":
			cards.addAll(actionCards());
			break;
		case "rentcard":
			cards.addAll(rentCards());
			break;
		case "moneycard":
			cards.addAll(moneyCards());
			break;

		default:
			break;
		}
		return cards;
	}
	
	private static List<Card> moneyCards() {
		List<Card> cards=new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			cards.add(moneyCard(1, 6));
		}
		for (int i = 0; i < 5; i++) {
			cards.add(moneyCard(2, 5));
		}
		for (int i = 0; i < 3; i++) {
			cards.add(moneyCard(3, 3));
		}
		for (int i = 0; i < 3; i++) {
			cards.add(moneyCard(4, 3));
		}
		cards.add(moneyCard(5, 2));
		cards.add(moneyCard(5, 2));
		cards.add(moneyCard(10, 1));
		return cards;
	}
	
	private static Card moneyCard(int value,int maxNum) {
		return new MoneyCard(value, maxNum);
	}
	
	private static List<Card> rentCards() {
		List<Card> cards=new ArrayList<>();
		cards.add(rentCard(CardColor.DarkBlue, CardColor.Green, 1, 2));
		cards.add(rentCard(CardColor.DarkBlue, CardColor.Green, 1, 2));
		cards.add(rentCard(CardColor.Red, CardColor.Yellow, 1, 2));
		cards.add(rentCard(CardColor.Red, CardColor.Yellow, 1, 2));
		
		cards.add(rentCard(CardColor.Pink, CardColor.Orange, 1, 2));
		cards.add(rentCard(CardColor.Pink, CardColor.Orange, 1, 2));
		cards.add(rentCard(CardColor.LightBlue, CardColor.Brown, 1, 2));
		cards.add(rentCard(CardColor.LightBlue, CardColor.Brown, 1, 2));
		
		cards.add(rentCard(CardColor.Railroad, CardColor.Utility, 1, 2));
		cards.add(rentCard(CardColor.Railroad, CardColor.Utility, 1, 2));
		cards.add(rentCard(CardColor.MultiColor, CardColor.MultiColor, 3, 3));
		cards.add(rentCard(CardColor.MultiColor, CardColor.MultiColor, 3, 3));
		cards.add(rentCard(CardColor.MultiColor, CardColor.MultiColor, 3, 3));
		return cards;
		
	}
	
	private static Card rentCard(CardColor cardColor,CardColor secondCardColor,int value,int maxNum) {
		return new RentCard(cardColor, secondCardColor, value, maxNum);
	}
	
	private static List<Card> actionCards() {
		List<Card> cards=new ArrayList<>();
		cards.add(actionCard("dealbreaker", 5, 2));
		cards.add(actionCard("dealbreaker", 5, 2));
		cards.add(actionCard("justsayno", 4, 3));
		cards.add(actionCard("justsayno", 4, 3));
		cards.add(actionCard("justsayno", 4, 3));
		
		cards.add(actionCard("slydeal", 3, 3));
		cards.add(actionCard("slydeal", 3, 3));
		cards.add(actionCard("slydeal", 3, 3));
		
		cards.add(actionCard("forcedeal", 3, 4));
		cards.add(actionCard("forcedeal", 3, 4));
		cards.add(actionCard("forcedeal", 3, 4));
		cards.add(actionCard("forcedeal", 3, 4));
		
		cards.add(actionCard("debtcollector", 3, 3));
		cards.add(actionCard("debtcollector", 3, 3));
		cards.add(actionCard("debtcollector", 3, 3));
		
		cards.add(actionCard("mybirthday", 2, 3));
		cards.add(actionCard("mybirthday", 2, 3));
		cards.add(actionCard("mybirthday", 2, 3));
		
		for (int i = 0; i <10; i++) {
			cards.add(actionCard("passgo", 1, 10));
		}
		
		cards.add(actionCard("house", 3, 3));
		cards.add(actionCard("house", 3, 3));
		cards.add(actionCard("house", 3, 3));
		
		cards.add(actionCard("hotel", 4, 3));
		cards.add(actionCard("hotel", 4, 3));
		cards.add(actionCard("hotel", 4, 3));
		
		cards.add(actionCard("doubletherent", 1, 2));
		cards.add(actionCard("doubletherent", 1, 2));
		
		return cards;
		
	}
	
	private static Card actionCard(String name,int value,int maxNum) {
		return new  ActionCard(name, value, maxNum);
	}
	
	
	
	private static List<Card> wildCards() {
		List<Card> cards=new ArrayList<>();
		cards.add(wildCard(CardColor.DarkBlue, CardColor.Green, 4, 1));
		cards.add(wildCard(CardColor.Green, CardColor.Railroad, 4, 1));
		cards.add(wildCard(CardColor.Utility, CardColor.Railroad, 2, 1));
		cards.add(wildCard(CardColor.LightBlue, CardColor.Railroad, 4, 1));
		cards.add(wildCard(CardColor.LightBlue, CardColor.Brown, 1, 1));
		cards.add(wildCard(CardColor.Pink, CardColor.Orange, 2, 2));
		cards.add(wildCard(CardColor.Pink, CardColor.Orange, 2, 2));
		cards.add(wildCard(CardColor.Red, CardColor.Yellow, 3, 2));
		cards.add(wildCard(CardColor.MultiColor, CardColor.MultiColor, 0, 2));
		cards.add(wildCard(CardColor.MultiColor, CardColor.MultiColor, 0, 2));
		return cards;
		
	}
	
	private static Card wildCard(CardColor cardColor,CardColor secondCardColor,int value,int maxNum) {
		return new Wildcard(cardColor, secondCardColor, value, maxNum);
	}
	
	private static List<Card> propertyCards() {
		List<Card> cards=new ArrayList<>();
		cards.add(propertyCard(CardColor.DarkBlue, 4, 2));
		cards.add(propertyCard(CardColor.DarkBlue, 4, 2));
		cards.add(propertyCard(CardColor.Brown, 1, 2));
		cards.add(propertyCard(CardColor.Brown, 1, 2));
		cards.add(propertyCard(CardColor.Utility, 2, 2));
		cards.add(propertyCard(CardColor.Utility, 2, 2));
		cards.add(propertyCard(CardColor.Green, 4, 3));
		cards.add(propertyCard(CardColor.Green, 4, 3));
		cards.add(propertyCard(CardColor.Green, 4, 3));
		
		cards.add(propertyCard(CardColor.Yellow, 3, 3));
		cards.add(propertyCard(CardColor.Yellow, 3, 3));
		cards.add(propertyCard(CardColor.Yellow, 3, 3));
		
		cards.add(propertyCard(CardColor.Red, 3, 3));
		cards.add(propertyCard(CardColor.Red, 3, 3));
		cards.add(propertyCard(CardColor.Red, 3, 3));
		
		cards.add(propertyCard(CardColor.Orange, 2, 3));
		cards.add(propertyCard(CardColor.Orange, 2, 3));
		cards.add(propertyCard(CardColor.Orange, 2, 3));
		
		cards.add(propertyCard(CardColor.Pink, 2, 3));
		cards.add(propertyCard(CardColor.Pink, 2, 3));
		cards.add(propertyCard(CardColor.Pink, 2, 3));
		
		cards.add(propertyCard(CardColor.LightBlue, 1, 3));
		cards.add(propertyCard(CardColor.LightBlue, 1, 3));
		cards.add(propertyCard(CardColor.LightBlue, 1, 3));
		
		cards.add(propertyCard(CardColor.Railroad, 2, 4));
		cards.add(propertyCard(CardColor.Railroad, 2, 4));
		cards.add(propertyCard(CardColor.Railroad, 2, 4));
		cards.add(propertyCard(CardColor.Railroad, 2, 4));
		
		return cards;
		
	}
	
	private static Card propertyCard(CardColor cardColor,int value,int maxNum) {
		return new Property(cardColor, value, maxNum);
	}

}
