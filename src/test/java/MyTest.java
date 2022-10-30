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
		assertEquals(3, dealer.getDealersHand().size(), "wrong dealersHand size");
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

		// checks if a new deck is created
		dealer.setDealersHand();
		assertEquals(dealer.getTheDeck().size(), 49, "setDealersHand not working 3");

	}




	//
	// test player class
	//

	@Test
	void PlayerConstructorHand() {
		// tests if hand is correct and the getHand function
		Player player = new Player();
		ArrayList<Card> h = player.getHand();
		assertEquals(h.size(), 0, "playerHand is wrong size");

	}

	@Test
	void PlayerConstructorAnte() {
		// tests if getAnte is zero when created
		Player player = new Player();
		assertEquals(player.getAnteBet(), 0, "ante bet is not zero first");

	}

	@Test
	void PlayerConstructorPlay() {
		// tests if getPlayBet is zero when created
		Player player = new Player();
		assertEquals(player.getPlayBet(), 0, "play bet is not zero when created");

	}

	@Test
	void PlayerConstructorPairPlus() {
		// tests if getPairPlusBet is zero when created
		Player player = new Player();
		assertEquals(player.getPairPlusBet(), 0, "pair plus bet is not zero when created");

	}

	@Test
	void PlayerConstructorTotalWinnings() {
		// tests if getTotalWinnings is 0 when created
		Player player = new Player();
		assertEquals(player.getTotalWinnings(), 0, "total winnings not zero when game states");

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
		assertEquals(player1.getPlayBet(), 10, "play bet before");
		assertEquals(player1.getAnteBet(), 5, "ante bet before");
		assertEquals(player1.getPairPlusBet(), 0, "Pair plus is not 0");

		player1.setPairPlusBet(number);

		assertEquals(player1.getPlayBet(), 10, "wrong play bet after");
		assertEquals(player1.getAnteBet(), 5, "ante bet after");
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



	//
	// test ThreeCardLogic
	//


	// evalHand

	@Test
	void evalHandStraightFlush() {
		// create an arraylist of cards for a straight flush
		ArrayList<Card> straightFlushHand = new ArrayList<>();
		straightFlushHand.add(new Card('S', 14));
		straightFlushHand.add(new Card('S', 13));
		straightFlushHand.add(new Card('S', 12));
		// evaluate hand
		int handEvaluation = ThreeCardLogic.evalHand(straightFlushHand);
		// check if function evaluated a straight flush (1)
		assertEquals(handEvaluation, 1, "did not find a straight flush");

	}

	@Test
	void evalHandThreeOfAKind() {
		ArrayList<Card> ThreeOfAKindHand = new ArrayList<>();
		ThreeOfAKindHand.add(new Card('D', 4));
		ThreeOfAKindHand.add(new Card('S', 4));
		ThreeOfAKindHand.add(new Card('H', 4));

		int handEvaluation = ThreeCardLogic.evalHand(ThreeOfAKindHand);
		// check if function evaluated a three of a kind
		assertEquals(handEvaluation, 2, "did not find a three of a kind");

	}

	@Test
	void evalHandStraight() {
		ArrayList<Card> straightHand = new ArrayList<>();
		straightHand.add(new Card('H', 8));
		straightHand.add(new Card('S', 7));
		straightHand.add(new Card('D', 6));

		int handEvaluation = ThreeCardLogic.evalHand(straightHand);
		// check if function evaluated a three of a kind
		assertEquals(handEvaluation, 3, "did not find a straight");
	}

	@Test
	void evalHandFlush() {
		ArrayList<Card> flushHand = new ArrayList<>();
		flushHand.add(new Card('C', 13));
		flushHand.add(new Card('C', 2));
		flushHand.add(new Card('C', 5));

		int handEvaluation = ThreeCardLogic.evalHand(flushHand);
		// check if function evaluated a three of a kind
		assertEquals(handEvaluation, 4, "did not find a flush");

	}

	@Test
	void evalHandPair() {
		ArrayList<Card> pairHand = new ArrayList<>();
		pairHand.add(new Card('D', 10));
		pairHand.add(new Card('S', 10));
		pairHand.add(new Card('C', 6));

		int handEvaluation = ThreeCardLogic.evalHand(pairHand);
		// check if function evaluated a three of a kind
		assertEquals(handEvaluation, 5, "did not find a pair");

	}

	@Test
	void evalHandHighCard() {
		ArrayList<Card> highCardHand = new ArrayList<>();
		highCardHand.add(new Card('D', 10));
		highCardHand.add(new Card('H', 14));
		highCardHand.add(new Card('C', 6));

		int handEvaluation = ThreeCardLogic.evalHand(highCardHand);
		// check if function evaluated a three of a kind
		assertEquals(handEvaluation, 0, "did not return a high card");
	}


	// evalPPWinnings

	@Test
	void evalPPWinningsStraightFlush() {
		// create a number, player, and set the number to pair plus bet
		int number = 20;
		Player pSF = new Player();
		pSF.setPairPlusBet(20);

		// use pairPlus bet and calculate winnings
		ArrayList<Card> straightFlush = new ArrayList<>();
		straightFlush.add(new Card('S', 14));
		straightFlush.add(new Card('S', 13));
		straightFlush.add(new Card('S', 12));

		// calculate Pair plus bet winnings
		int PPWinnings  = ThreeCardLogic.evalPPWinnings(straightFlush, pSF.getPairPlusBet());
		assertEquals(PPWinnings, 800, "pair plus incorrectly calculated (straight flush): should be 800");

	}

	@Test
	void evalPPWinningsThreeOfAKind() {
		// create a number, player, and set the number to pair plus bet
		int number = 20;
		Player pTOK = new Player();
		pTOK.setPairPlusBet(20);

		// use pairPlus bet and calculate winnings
		ArrayList<Card> threeOfAKind = new ArrayList<>();
		threeOfAKind.add(new Card('D', 4));
		threeOfAKind.add(new Card('S', 4));
		threeOfAKind.add(new Card('H', 4));

		// calculate Pair plus bet winnings
		int PPWinnings  = ThreeCardLogic.evalPPWinnings(threeOfAKind, pTOK.getPairPlusBet());
		assertEquals(PPWinnings, 600, "pair plus incorrectly calculated (Three of a kind): should be 600");
	}

	@Test
	void evalPPWinningsStraight() {
		// create a number, player, and set the number to pair plus bet
		int number = 20;
		Player pS = new Player();
		pS.setPairPlusBet(20);

		// use pairPlus bet and calculate winnings
		ArrayList<Card> straight = new ArrayList<>();
		straight.add(new Card('C', 14));
		straight.add(new Card('D', 13));
		straight.add(new Card('S', 12));

		// calculate Pair plus bet winnings
		int PPWinnings  = ThreeCardLogic.evalPPWinnings(straight, pS.getPairPlusBet());
		assertEquals(PPWinnings, 120, "pair plus incorrectly calculated (straight): should be 120");

	}

	@Test
	void evalPPWinningsFlush() {
		// create a number, player, and set the number to pair plus bet
		int number = 20;
		Player pF = new Player();
		pF.setPairPlusBet(20);

		// use pairPlus bet and calculate winnings
		ArrayList<Card> Flush = new ArrayList<>();
		Flush.add(new Card('D', 14));
		Flush.add(new Card('D', 3));
		Flush.add(new Card('D', 11));

		// calculate Pair plus bet winnings
		int PPWinnings  = ThreeCardLogic.evalPPWinnings(Flush, pF.getPairPlusBet());
		assertEquals(PPWinnings, 60, "pair plus incorrectly calculated (flush): should be 60");

	}

	@Test
	void evalPPWinningsPair() {
		// create a number, player, and set the number to pair plus bet
		int number = 20;
		Player pP = new Player();
		pP.setPairPlusBet(20);

		// use pairPlus bet and calculate winnings
		ArrayList<Card> straightFlush = new ArrayList<>();
		straightFlush.add(new Card('D', 9));
		straightFlush.add(new Card('C', 13));
		straightFlush.add(new Card('H', 13));

		// calculate Pair plus bet winnings
		int PPWinnings  = ThreeCardLogic.evalPPWinnings(straightFlush, pP.getPairPlusBet());
		assertEquals(PPWinnings, 20, "pair plus incorrectly calculated (pair): should be 20");

	}

	@Test
	void evalPPWinningsHighCard() {
		// create a number, player, and set the number to pair plus bet
		int number = 20;
		Player pHC = new Player();
		pHC.setPairPlusBet(20);

		// use pairPlus bet and calculate winnings
		ArrayList<Card> highCard = new ArrayList<>();
		highCard.add(new Card('S', 14));
		highCard.add(new Card('H', 3));
		highCard.add(new Card('D', 10));

		// calculate Pair plus bet winnings
		int PPWinnings  = ThreeCardLogic.evalPPWinnings(highCard, pHC.getPairPlusBet());
		assertEquals(PPWinnings, 0, "pair plus incorrectly calculated (high card) should be 0");

	}


	// compare hands

	@Test
	void compareHandsStraightFlushPlayer() {
		// returns 2
		ArrayList<Card> p = new ArrayList<>();
		p.add(new Card('S', 10));
		p.add(new Card('S', 11));
		p.add(new Card('S', 9));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 2));
		d.add(new Card('S', 14));
		d.add(new Card('H', 5));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 2, "player should win by straight flush");

	}

	@Test
	void compareHandsStraightFlushDealer() {
		// returns 1
		ArrayList<Card> p = new ArrayList<>();
		p.add(new Card('S', 2));
		p.add(new Card('D', 5));
		p.add(new Card('C', 9));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('C', 4));
		d.add(new Card('C', 3));
		d.add(new Card('C', 5));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win by straight flush");

	}

	@Test
	void compareHandsStraightFlushTie() {
		// returns who have the next highest card
		ArrayList<Card> p = new ArrayList<>();
		p.add(new Card('S', 10));
		p.add(new Card('S', 11));
		p.add(new Card('S', 9));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('C', 2));
		d.add(new Card('C', 3));
		d.add(new Card('C', 4));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 2, "player should win Straight flush tie with highest card");

	}


	@Test
	void compareHandsThreeOfAKindPlayer() {
		ArrayList<Card> p = new ArrayList<>();
		p.add(new Card('S', 10));
		p.add(new Card('D', 10));
		p.add(new Card('H', 10));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 2));
		d.add(new Card('S', 10));
		d.add(new Card('H', 5));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 2, "player should win by Three of A Kind");

	}

	@Test
	void compareHandsThreeOfAKindDealer() {
		ArrayList<Card> p = new ArrayList<>();
		p.add(new Card('S', 10));
		p.add(new Card('D', 5));
		p.add(new Card('H', 7));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 12));
		d.add(new Card('C', 12));
		d.add(new Card('D', 12));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win by Three of A Kind");

	}

	@Test
	void compareHandsThreeOfAKindTie() {
		ArrayList<Card> p = new ArrayList<>();
		p.add(new Card('S', 7));
		p.add(new Card('D', 7));
		p.add(new Card('H', 7));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 10));
		d.add(new Card('H', 10));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win Three of A Kind tie with Highest card");

	}

	@Test
	void compareHandsStraightPlayer() {
		ArrayList<Card> p = new ArrayList<>();
		p.add(new Card('C', 14));
		p.add(new Card('D', 12));
		p.add(new Card('S', 13));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 6));
		d.add(new Card('H', 4));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 2, "player should win by Straight");

	}

	@Test
	void compareHandsStraightDealer() {
		ArrayList<Card> p = new ArrayList<>();
		p.add(new Card('C', 14));
		p.add(new Card('D', 14));    // pair vs straight -> straight should win
		p.add(new Card('S', 9));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 9));
		d.add(new Card('H', 11));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win by Straight");
	}

	@Test
	void compareHandsStraightTie() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 2));
		p.add(new Card('H', 4));
		p.add(new Card('S', 3));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 9));
		d.add(new Card('H', 11));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win tie for Straight");
	}

	@Test
	void compareHandsFlushPlayer() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 7));
		p.add(new Card('S', 6));
		p.add(new Card('S', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 10));
		d.add(new Card('C', 2));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 2, "player should win tie for Straight");
	}

	@Test
	void compareHandsFlushDealer() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 7));
		p.add(new Card('C', 9));
		p.add(new Card('S', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 3));
		d.add(new Card('D', 10));
		d.add(new Card('D', 2));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win tie for Flush");
	}

	@Test
	void compareHandsFlushTie() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 7));
		p.add(new Card('S', 6));
		p.add(new Card('S', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('S', 10));
		d.add(new Card('S', 9));
		d.add(new Card('S', 13));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win tie for Flush");
	}

	@Test
	void compareHandsPairPlayer() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 7));
		p.add(new Card('C', 7));
		p.add(new Card('D', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 8));
		d.add(new Card('C', 2));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 2, "player should win tie for Pair");
	}

	@Test
	void compareHandsPairDealer() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 7));
		p.add(new Card('C', 6));
		p.add(new Card('D', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 2));
		d.add(new Card('C', 2));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win tie for Pair");

	}

	@Test
	void compareHandsPairTie() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 7));
		p.add(new Card('C', 7));
		p.add(new Card('D', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('D', 7));
		d.add(new Card('H', 7));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win tie for Pair with High Card");

	}

	@Test
	void compareHandsHighCardPlayer() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 14));
		p.add(new Card('C', 6));
		p.add(new Card('D', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 2));
		d.add(new Card('C', 5));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 2, "plsyer should win tie for High Card");

	}

	@Test
	void compareHandsHighCardDealer() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 10));
		p.add(new Card('C', 6));
		p.add(new Card('D', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 10));
		d.add(new Card('S', 2));
		d.add(new Card('S', 9));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 1, "dealer should win tie for High Card");

	}

	@Test
	void compareHandsHighCardTie() {
		ArrayList<Card> p = new ArrayList<>();

		p.add(new Card('S', 7));
		p.add(new Card('C', 6));
		p.add(new Card('D', 4));

		ArrayList<Card> d = new ArrayList<>();
		d.add(new Card('D', 7));
		d.add(new Card('S', 6));
		d.add(new Card('C', 4));

		int comparison = ThreeCardLogic.compareHands(d, p);
		assertEquals(comparison, 0, "Neither should win tie for High Card");

	}

}
