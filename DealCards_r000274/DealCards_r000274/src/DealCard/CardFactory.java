package DealCard;
import java.util.ArrayList;
import java.util.List;

public class CardFactory {


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

        for (int i = 0; i < 6; i++) {
            cards.add(moneyCard(1, 6));
        }
        for (int i = 0; i < 5; i++) {
            cards.add(moneyCard(2, 5));
        }

        return cards;
    }

    private static Card moneyCard(int value, int maxNum) {
        return new MoneyCard(value, maxNum);
    }

    // Create a list of rent cards
    private static List<Card> rentCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(rentCard(CardColor.DarkBlue, CardColor.Green, 1, 2));
        cards.add(rentCard(CardColor.DarkBlue, CardColor.Green, 1, 2));
        cards.add(rentCard(CardColor.Red, CardColor.Yellow, 1, 2));
        cards.add(rentCard(CardColor.Red, CardColor.Yellow, 1, 2));
        return cards;
    }


    private static Card rentCard(CardColor cardColor, CardColor secondCardColor, int value, int maxNum) {
        return new RentCard(cardColor, secondCardColor, value, maxNum);
    }


    private static List<Card> actionCards() {
        List<Card> cards = new ArrayList<>();

        return cards;
    }

    private static Card actionCard(String name, int value, int maxNum) {
        return new ActionCard(name, value, maxNum);
    }


    private static List<Card> wildCards() {
        List<Card> cards = new ArrayList<>();

        return cards;
    }


    private static List<Card> propertyCards() {
        List<Card> cards = new ArrayList<>();

        return cards;

    }
}
