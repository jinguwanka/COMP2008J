package DealCard;

public class RentCard extends Card{
	
	private CardColor secondCardColor;

	public RentCard(CardColor cardColor,CardColor secondCardColor, int value, int maxNum) {
		super(cardColor, value, maxNum);
		// TODO Auto-generated constructor stub
		this.secondCardColor=secondCardColor;
	}
	
	public CardColor getSecondCardColor() {
		return secondCardColor;
	}
	
	@Override
	public String imageString() {
		// TODO Auto-generated method stub
		if (cardColor==CardColor.MultiColor) {
			return String.format("RentCards/wildrent.jpg");
		}
		return String.format("RentCards/%s%s.jpg",cardColor.name().toLowerCase(),secondCardColor.name().toLowerCase());
	}

}
