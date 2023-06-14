package DealCard;
import java.util.ArrayList;
import java.util.List;

public enum CardColor {
	DarkBlue(),Brown,Utility,Green,Yellow,Red,Orange,Pink,LightBlue,Railroad,MultiColor;
	
	private List<Integer> rents=new ArrayList<>();
	private CardColor(int ...rents) {
		// TODO Auto-generated constructor stub
		for (int i : rents) {
			this.rents.add(i);
		}
	}
	
	public int rent(int num) {
		if (num>=rents.size()) {
			num=rents.size()-1;
		}
		return this.rents.get(num-1);
	}

}