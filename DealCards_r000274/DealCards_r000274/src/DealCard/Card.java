package DealCard;

public class Card {

    protected CardColor cardColor;
    protected int value;
    protected int maxNum;

    public Card(CardColor cardColor,int value,int maxNum) {
        // TODO Auto-generated constructor stub
        this.cardColor=cardColor;
        this.value=value;
        this.maxNum=maxNum;
    }

    public String imageString() {
        return cardColor.name().toLowerCase()+".jpg";
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public int getValue() {
        return value;
    }

    public int getMaxNum() {
        return maxNum;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("(%s,%d)", getClass().getSimpleName(),getValue());
    }


}
