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


}
