package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DealCard.Bank;
import DealCard.Card;
import DealCard.CardFactory;

public class BankTest {

	private Bank bank;
	@Before
	public void setUp() throws Exception {
		bank=new Bank();
		bank.addAll(CardFactory.createCards("moneycard"));
	}

	@Test
	public void testcards() {
		
		assertEquals(bank.getCards().size(), 20);
	}

	

	@Test
	public void testGetMoney() {
		List<Card> list=bank.getMoney(10);
		int total=0;
		for (Card card : list) {
			total+=card.getValue();
		}
		assertTrue(total>=10);
	}

}
