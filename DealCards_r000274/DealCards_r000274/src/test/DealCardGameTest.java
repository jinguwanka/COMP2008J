package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DealCard.Cpu;
import DealCard.DealCardGame;
import DealCard.Player;

public class DealCardGameTest {

	private DealCardGame dealCardGame;
	@Before
	public void setUp() throws Exception {
		dealCardGame=DealCardGame.getInstance();
		dealCardGame.setPlayerNum(4);
	}

	@Test
	public void testTurn() {
		
		assertEquals(dealCardGame.currentPlayer().getName(), "Player");
	}

	@Test
	public void testGetDrawpile() {
		
		assertEquals(dealCardGame.getDrawpile().getCards().size(),41);
	}

	
	@Test
	public void testGetPlayers() {
		List<Player> players=dealCardGame.getPlayers();
		
		for (int i = 0; i < players.size(); i++) {
			if (i<players.size()-1) {
				assertTrue(players.get(i) instanceof Cpu);
			}
		}
	}

}
