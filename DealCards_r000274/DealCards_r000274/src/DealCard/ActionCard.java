package DealCard;

public class ActionCard extends Card{

	private String name;
	public ActionCard(String name, int value, int maxNum) {
		super(null, value, maxNum);
		// TODO Auto-generated constructor stub.
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String imageString() {
		// TODO Auto-generated method stub.
		return "ActionCards/"+name+".jpg";
	}

}
