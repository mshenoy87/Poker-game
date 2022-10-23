import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyTest {

	static Card card1;
	static Card card2;
	static Card card3;
	static Card card4;
	static Deck deck;

	@BeforeAll
	static void setup() {
		card1 = new Card('C', 2);   // 2 of clove
		card2 = new Card('S', 9);   // 9 of spade
		card3 = new Card('H', 14);  // ace of hearts
		card4 = new Card('D', 10);	// 10 of diamonds
		deck = new Deck();
	}



	//
	// tests card class and functions
	//

	@Test
	void getValueCardClass() {
		// tests getValues() function in card class
		assertEquals(2, card1.getValue(), "wrong value");
		assertEquals(9, card2.getValue(), "wrong value");
		assertEquals(14, card3.getValue(), "wrong value");
		assertEquals(10, card4.getValue(), "wrong value");
	}

	@Test
	void getSuitCardClass() {
		assertEquals('C', card1.getSuit(), "wrong suit value");
		assertEquals('S', card2.getSuit(), "wrong suit value");
		assertEquals('H', card3.getSuit(), "wrong suit value");
		assertEquals('D', card4.getSuit(), "wrong suit value");
	}



	//
	// tests Deck class
	//

	@Test
	void DeckType() {
		// check what is the type for deck
		assertEquals(deck.getClass(), Deck.class, "wrong class");
	}

	@Test
	void deckLength() {
		// check length of Deck
		assertEquals(deck.size(), 52,  "wrong length of deck");
	}

	@Test
	void deckSuits() {
		for (Card C : deck) {
			// makes sure the suits are all spades, clovers, hearts, or diamonds
			assertTrue((C.getSuit() == 'S' || C.getSuit() == 'C' || C.getSuit() == 'H' || C.getSuit() == 'D'));
		}
	}

	@Test
	void deckValues() {
		for (Card C : deck) {
			// makes sure the suits are all spades, clovers, hearts, or diamonds
			assertTrue(2 <= C.getValue() && C.getValue() <= 14);
		}
	}

	@Test
	void newDeckSize() {
		deck.newDeck();
		assertEquals(deck.size(), 52, "wrong size of newDeck");
	}

	@Test
	void newDeckValues() {
		for (Card C : deck) {
			assertTrue((C.getSuit() == 'S' || C.getSuit() == 'C' || C.getSuit() == 'H' || C.getSuit() == 'D'));
			assertTrue(2 <= C.getValue() && C.getValue() <= 14);
		}
		System.out.print("\n\n");
		deck.newDeck();
		for (Card C : deck) {
			assertTrue((C.getSuit() == 'S' || C.getSuit() == 'C' || C.getSuit() == 'H' || C.getSuit() == 'D'));
			assertTrue(2 <= C.getValue() && C.getValue() <= 14);
		}
	}



	//
	// test dealer class
	//

	@Test
	void DealerConstructorTest() {
		Dealer dealer = new Dealer();
		assertEquals(dealer.getTheDeck().size(), 52, "Wrong size of theDeck");
	}

	@Test
	void dealHand() {
		// sets dealer's hand, tests the size
		Dealer dealer = new Dealer();
		dealer.setDealersHand();
		assertTrue(dealer.getDealersHand().size() == 3, "wrong dealersHand size");
		assertEquals(dealer.getTheDeck().size(), 49, "dealHand not working");
	}

	@Test
	void theDeckSizeTest1() {
		// tests if deck is decreasing in size (Cards are taken from the deck)
		Dealer dealer = new Dealer();
		dealer.setDealersHand();
		assertEquals(dealer.getTheDeck().size(), 49, "dealHand not working 1");

		ArrayList<Card> hand1 = dealer.dealHand();
		assertEquals(dealer.getTheDeck().size(), 46, "dealHand not working 2");

		ArrayList<Card> hand2 = dealer.dealHand();
		assertEquals(dealer.getTheDeck().size(), 43, "dealHand not working 3");
	}

	@Test
	void theDeckSizeTest2() {
		// tests if a new deck is created when 34 cards are left
		Dealer dealer = new Dealer();
		dealer.setDealersHand();
		assertEquals(dealer.getTheDeck().size(), 49, "setDealersHand not working 1");

		ArrayList<Card> hand1 = dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();

		assertEquals(dealer.getTheDeck().size(), 34, "dealHand not working 2");
		assertEquals(hand1.size(), 3, "hand size incorrect");

		dealer.setDealersHand();
		assertEquals(dealer.getTheDeck().size(), 49, "setDealersHand not working 3");
	}

}
