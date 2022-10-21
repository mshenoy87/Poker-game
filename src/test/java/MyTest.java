import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyTest {

	static Card card1;
	static Card card2;
	static Card card3;
	static Card card4;

	@BeforeAll
	static void setup() {
		card1 = new Card('C', 2);   // 2 of clove
		card2 = new Card('S', 9);   // 9 of spade
		card3 = new Card('H', 14);  // ace of hearts
		card4 = new Card('D', 10);	// 10 of diamonds
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

}
