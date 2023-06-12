package DealCard;

public class Wildcard extends Card{

	private CardColor secondCardColor;
	
	public Wildcard(CardColor cardColor,CardColor secondCardColor, int value, int maxNum) {
		super(cardColor, value, maxNum);
		// TODO Auto-generated constructor stub
		this.secondCardColor=secondCardColor;
	}

}
