package DealCard;
import java.util.ArrayList;
import java.util.List;

public enum CardColor {
	DarkBlue(3,8),Brown(1,2),Utility(1,2),Green(2,4,7),Yellow(2,4,6),Red(2,3,6),Orange(1,3,5),Pink(1,2,4),LightBlue(1,2,3),Railroad(1,2,3,4),MultiColor;
	
	private List<Integer> rents=new ArrayList<>();
	private CardColor(int ...rents) {
		// TODO Auto-generated constructor stub
		for (int i : rents) {
			this.rents.add(i);
		}
	}
	
	public int getNum() {
		return rents.size();
	}
	
	public int rent(int num) {
		if (rents.isEmpty()) {
			return 0;
		}
		if (num>=rents.size()) {
			num=rents.size()-1;
		}
		return this.rents.get(num-1);
	}

}
