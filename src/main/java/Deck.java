import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {


    //
    // creates an array of 52 Cards
    //
    // Deck()
    //
    public Deck() {

        char[] suits = new char[] {'C', 'D', 'S', 'H'};
        // for loop for values, for each loop for making a card with each suit
        for (int value = 2; value <= 14; value++) {
            for (char suit : suits) {
                this.add(new Card(suit, value));
            }
        }

        // Collections.shuffle to randomize
        Collections.shuffle(this);
    }



    //
    // clears the deck of cards, creates a new deck of cards
    //
    // newDeck()
    //
    public void newDeck() {

        char[] suits = new char[] {'C', 'D', 'S', 'H'};

        // clears cards in deck
        this.clear();

        // creates a deck and shuffles the cards (like the constructor)
        for (int value = 2; value <= 14; value++) {
            for (char suit : suits) {
                this.add(new Card(suit, value));
            }
        }

        // Collections.shuffle to randomize
        Collections.shuffle(this);
    }

}
