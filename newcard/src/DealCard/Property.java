package DealCard;

public class Property extends Card {

	public Property(CardColor cardColor, int value, int maxNum) {
		super(cardColor, value, maxNum);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String imageString() {
		// TODO Auto-generated method stub
		return "Properties/"+super.imageString();
	}
	
	

}
