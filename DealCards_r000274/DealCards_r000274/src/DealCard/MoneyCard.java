package DealCard;

public class MoneyCard extends Card {

	public MoneyCard(int value, int maxNum) {
		super(null, value, maxNum);
	}

	@Override
	public String imageString() {
		return "MoneyCards/" + value + ".jpg";
	}
}
