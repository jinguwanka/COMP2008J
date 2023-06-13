package DealCard;

import java.util.HashMap;

import javax.swing.JLabel;

public class Observer {
	
	private HashMap<Player, JLabel> hashMap=new HashMap<>();
	
	public void add(Player player,JLabel jLabel) {
		hashMap.put(player, jLabel);
	}
	
	public void update(Player player,String inf) {
		hashMap.get(player).setText(inf);
	}

}
