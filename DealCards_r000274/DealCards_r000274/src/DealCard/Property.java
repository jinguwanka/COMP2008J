package DealCard;

public class Property extends Card {

    public Property(CardColor cardColor, int value, int maxNum) {
        super(cardColor, value, maxNum);
    }

    @Override
    public String imageString() {
        return "Properties/" + super.imageString();
    }
}
