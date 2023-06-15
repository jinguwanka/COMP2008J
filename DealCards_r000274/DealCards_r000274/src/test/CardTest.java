package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DealCard.ActionCard;
import DealCard.Card;
import DealCard.CardFactory;
import DealCard.MoneyCard;
import DealCard.Property;
import DealCard.RentCard;
import DealCard.Wildcard;

public class CardTest {

	

	@Test
	public void testproperty() {
		List<Card>cards=CardFactory.createCards("property");
		for (Card card : cards) {
			assertTrue(card instanceof Property);
		}
		assertEquals(cards.size(), 28);
	}
	
	@Test
	public void testwildcard() {
		List<Card>cards=CardFactory.createCards("wildcard");
		for (Card card : cards) {
			assertTrue(card instanceof Wildcard);
		}
		
		assertEquals(cards.size(), 10);
	}
	
	@Test
	public void testactioncard() {
		List<Card>cards=CardFactory.createCards("actioncard");
		for (Card card : cards) {
			assertTrue(card instanceof ActionCard);
		}
		
		assertEquals(cards.size(), 36);
	}
	
	@Test
	public void testrentcard() {
		List<Card>cards=CardFactory.createCards("rentcard");
		for (Card card : cards) {
			assertTrue(card instanceof RentCard);
		}
		
		assertEquals(cards.size(), 13);
	}
	
	@Test
	public void testmoneycard() {
		List<Card>cards=CardFactory.createCards("moneycard");
		for (Card card : cards) {
			assertTrue(card instanceof MoneyCard);
		}
		
		assertEquals(cards.size(), 20);
	}
	
	

}
