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
	static Player player1;

	@BeforeAll
	static void setup() {
		card1 = new Card('C', 2);   // 2 of clove
		card2 = new Card('S', 9);   // 9 of spade
		card3 = new Card('H', 14);  // ace of hearts
		card4 = new Card('D', 10);	// 10 of diamonds
		deck = new Deck();
		player1 = new Player();
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




	//
	// test player class
	//

	@Test
	void PlayerConstructorHand() {
		// tests if hand is correct and the getHand function
		assertEquals(player1.getHand().size(), 0, "playerHand is wrong size");

	}

	@Test
	void PlayerConstructorAnte() {
		// tests if getAnte is zero when created
		assertEquals(player1.getAnteBet(), 0, "ante bet is not zero first");

	}

	@Test
	void PlayerConstructorPlay() {
		// tests if getPlayBet is zero when created
		assertEquals(player1.getPlayBet(), 0, "play bet is not zero when created");

	}

	@Test
	void PlayerConstructorPairPlus() {
		// tests if getPairPlusBet is zero when created
		assertEquals(player1.getPairPlusBet(), 0, "pair plus bet is not zero when created");

	}

	@Test
	void PlayerConstructorTotalWinnings() {
		// tests if getTotalWinnings is 0 when created
		assertEquals(player1.getTotalWinnings(), 0, "total winnings not zero when game states");

	}

	@Test
	void PlayerHand() {
		// tests dealing a hand and setting to player's hand
		Dealer dealer = new Dealer();
		ArrayList<Card> player1Hand = dealer.dealHand();

		assertEquals(player1.getHand().size(), 0, "playerHand is wrong size before");
		player1.setHand(player1Hand);
		assertTrue(player1.getHand().size() == 3, "playerHand is wrong size after set");

		// make sure that cards are matching with the dealer's hand
		int i = 0;
		for (Card c : player1.getHand()) {
			assertEquals(c.getSuit(), player1Hand.get(i).getSuit(), "card is not equal");
			i++;
		}

	}

	@Test
	void PlayerAnte() {
		// tests set and get AnteBet
		int number = 5;
		assertEquals(player1.getAnteBet(), 0, "ante before");
		player1.setAnteBet(number);
		assertEquals(player1.getAnteBet(), 5, "wrong ante bet after");

	}

	@Test
	void PlayerPlayBet() {
		// tests set and get setPlayBet
		int number = 10;
		assertEquals(player1.getPlayBet(), 0, "play bet before");
		assertEquals(player1.getAnteBet(), 0, "ante bet before");
		player1.setPlayBet(number);

		assertEquals(player1.getPlayBet(), 10, "wrong ante bet after");
		assertEquals(player1.getAnteBet(), 0, "ante bet after");

	}

	@Test
	void PlayerPairPlus() {
		// tests set and get PairPlusBet
		int number = 20;
		assertEquals(player1.getPlayBet(), 0, "play bet before");
		assertEquals(player1.getAnteBet(), 0, "ante bet before");
		assertEquals(player1.getPairPlusBet(), 0, "Pair plus is not 0");

		player1.setPairPlusBet(number);

		assertEquals(player1.getPlayBet(), 0, "wrong ante bet after");
		assertEquals(player1.getAnteBet(), 0, "ante bet after");
		assertEquals(player1.getPairPlusBet(), 20, "Pair plus is wrong");

	}

	@Test
	void PlayerTotalWinnings() {
		// tests set and get TotalWinnings
		int number = 0;
		player1.setTotalWinnings(number);
		assertEquals(player1.getTotalWinnings(), 0, "total winnings should be 0");

		number = 10;
		player1.setTotalWinnings(number);
		assertEquals(player1.getTotalWinnings(), 10, "total winnings should be 10");

		number = -100;
		player1.setTotalWinnings(number);
		assertEquals(player1.getTotalWinnings(), -100, "total winnings should be -100");

	}

}
