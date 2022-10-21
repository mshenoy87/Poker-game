public class Card {

    // private variables
    private char suit;
    private int value;



    //
    // constructor
    //
    // creates an instance of type Card
    // sets parameter suit to the suit of the Card and value to the value of the Card
    //
    public Card(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }


    //
    // getSuit
    //
    // returns the suit of a card
    //
    public char getSuit() {
        return this.suit;
    }


    //
    // getValue
    //
    // returns the value of a card
    //
    public int getValue() {
        return this.value;
    }

}
