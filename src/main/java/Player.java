import java.util.ArrayList;

class Player {

    // private variables
    private ArrayList<Card> hand;
    private int anteBet;
    private int playBet;
    private int pairPlusBet;
    private int totalWinnings;



    //
    // constructor
    //
    // creates the player object
    // sets ante, play, and pair plus bets to zero
    //
    public Player() {
        this.hand = new ArrayList<>();
        this.anteBet = 0;
        this.playBet = 0;
        this.pairPlusBet = 0;
        this.totalWinnings = 0;
    }


    //
    // sets player's hand to ArrayList passed as parameter
    //
    // setPlayersHand
    //


    //
    // returns player's hand
    //
    // getPlayerHand
    //
    public ArrayList<Card> getHand() {
        return this.hand;
    }


    //
    // sets ante bet to
    //
    // setAnteBet
    //


    //
    // returns the ante
    //
    // getAnteBet
    //
    public int getAnteBet() {
        return this.anteBet;
    }

    //
    // sets play bet to integer passed as parameter
    //
    // setPlayBet
    //


    //
    // returns play bet
    //
    // getPlayBet
    //
    public int getPlayBet() {
        return this.playBet;
    }

    //
    // sets pair plus bet to integer passed as parameter
    //
    // setPairPlusBet
    //


    //
    // returns the pair plus bet
    //
    // getPairPlusBet
    //
    public int getPairPlusBet() {
        return this.pairPlusBet;
    }

    //
    // calculates total winnings and stores it
    //
    // setTotalWinnings
    //


    //
    // returns total winnings
    //
    // getTotalWinnings
    //
    public int getTotalWinnings() {
        return this.totalWinnings;
    }

}
