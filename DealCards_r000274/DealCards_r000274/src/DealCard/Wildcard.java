package DealCard;

public class Wildcard extends Card{

	private CardColor secondCardColor;
	
	public Wildcard(CardColor cardColor,CardColor secondCardColor, int value, int maxNum) {
		super(cardColor, value, maxNum);
		// TODO Auto-generated constructor stub
		this.secondCardColor=secondCardColor;
	}
	
	@Override
	public String imageString() {
		// TODO Auto-generated method stub
		if (cardColor==CardColor.MultiColor) {
			return String.format("Wildcards/%s.jpg", cardColor.name().toLowerCase());
		}
		return String.format("Wildcards/%s%s.jpg", cardColor.name().toLowerCase(),secondCardColor.name().toLowerCase());
	}
	
	@Override
	public CardColor getSecondCardColor() {
		// TODO Auto-generated method stub
		return secondCardColor;
	}

}
