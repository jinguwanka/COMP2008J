package DealCard;

public class Wildcard extends Card {

    private CardColor secondCardColor;

    /**
     * Constructs a Wildcard with the specified card colors, value, and maximum number.
     *
     * @param cardColor       the primary card color
     * @param secondCardColor the secondary card color
     * @param value           the value of the card
     * @param maxNum          the maximum number of this card
     */
    public Wildcard(CardColor cardColor, CardColor secondCardColor, int value, int maxNum) {
        super(cardColor, value, maxNum);
        this.secondCardColor = secondCardColor;
    }

}