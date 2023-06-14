package DealCard;

public class MoneyCard extends Card{

	public MoneyCard( int value, int maxNum) {
		super(null, value, maxNum);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String imageString() {
		// TODO Auto-generated method stub
		return "MoneyCards/"+value+".jpg";
	}

}
