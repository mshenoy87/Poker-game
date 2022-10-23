import java.util.ArrayList;

public class Dealer {

    // private variables
    private Deck theDeck;
    private ArrayList<Card> dealersHand;



    //
    // initializes theDeck
    //
    // Dealer
    //
    public Dealer() {
        theDeck = new Deck();
        dealersHand = new ArrayList<>();
    }


    //
    // gets three cards from theDeck and adds them to a hand
    // checks before dealing whether there are more than 34 cards
    // returns the hand
    //
    // dealHand
    //
    public ArrayList<Card> dealHand() {
        ArrayList<Card> hand = new ArrayList<>();
        // if 34 or fewer cards in deck, create new deck
        if (theDeck.size() <= 34) {
            theDeck.newDeck();
        }

        // get three cards
        for (int i = 0; i < 3; i++) {
            // get an elements of theDeck
            Card c = theDeck.get(i);
            // add the elements to the hand
            hand.add(c);
            // remove element from theDeck
            theDeck.remove(i);
        }
        return hand;
    }


    //
    // returns the dealer's hand
    //
    // getDealersHand
    //
    public ArrayList<Card> getDealersHand() {
        return dealersHand;
    }


    //
    // uses dealHand to create the dealersHand
    //
    // setDealersHand
    //
    public void setDealersHand() {
        this.dealersHand = dealHand();
    }

    //
    // returns theDeck
    //
    // getTheDeck
    //
    public Deck getTheDeck() {
        return theDeck;
    }

}
