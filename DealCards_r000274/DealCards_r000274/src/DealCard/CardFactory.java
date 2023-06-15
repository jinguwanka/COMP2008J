package DealCard;
import java.util.ArrayList;
import java.util.List;

public class CardFactory {

    // Factory method to create a list of cards based on the specified type
    public static List<Card> createCards(String type) {
        ArrayList<Card> cards = new ArrayList<>();
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

    // Create a list of money cards
    private static List<Card> moneyCards() {
        List<Card> cards = new ArrayList<>();
        // Add money cards with different values and quantities
        for (int i = 0; i < 6; i++) {
            cards.add(moneyCard(1, 6));
        }
        for (int i = 0; i < 5; i++) {
            cards.add(moneyCard(2, 5));
        }
        // Add more money cards with different values and quantities
        // ...
        return cards;
    }

    // Create a money card with the specified value and maximum quantity
    private static Card moneyCard(int value, int maxNum) {
        return new MoneyCard(value, maxNum);
    }

    // Create a list of rent cards
    private static List<Card> rentCards() {
        List<Card> cards = new ArrayList<>();
        // Add rent cards with different color combinations, values, and quantities
        // ...
        return cards;
    }

    // Create a rent card with the specified color combination, value, and maximum quantity
    private static Card rentCard(CardColor cardColor, CardColor secondCardColor, int value, int maxNum) {
        return new RentCard(cardColor, secondCardColor, value, maxNum);
    }

    // Create a list of action cards
    private static List<Card> actionCards() {
        List<Card> cards = new ArrayList<>();
        // Add action cards with different names, values, and quantities
        // ...
        return cards;
    }

    // Create an action card with the specified name, value, and maximum quantity
    private static Card actionCard(String name, int value, int maxNum) {
        return new ActionCard(name, value, maxNum);
    }

    // Create a list of wild cards
    private static List<Card> wildCards() {
        List<Card> cards = new ArrayList<>();
        // Add wild cards with different color combinations, values, and quantities
        // ...
        return cards;
    }

    // Create a wild card with the specified color combination, value, and maximum quantity
    private static Card wildCard(CardColor cardColor, CardColor secondCardColor, int value, int maxNum) {
        return new Wildcard(cardColor, secondCardColor, value, maxNum);
    }

    // Create a list of property cards
    private static List<Card> propertyCards() {
        List<Card> cards = new ArrayList<>();
        // Add property cards with different colors, values, and quantities
        // ...
        return cards;
    }

    // Create a property card with the specified color, value, and maximum quantity
    private static Card propertyCard(CardColor cardColor, int value, int maxNum) {
        return new Property(cardColor, value, maxNum);
    }
}
``