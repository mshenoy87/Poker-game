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
    // setHand
    //
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }


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
    public void setAnteBet(int anteBet) {
        this.anteBet = anteBet;
    }


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
    public void setPlayBet(int playBet) {
        this.playBet = playBet;
    }


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
    public void setPairPlusBet(int pairPlusBet) {
        this.pairPlusBet = pairPlusBet;
    }


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
    public void setTotalWinnings(int totalWinnings) {
        this.totalWinnings = totalWinnings;
    }


    //
    // returns total winnings
    //
    // getTotalWinnings
    //
    public int getTotalWinnings() {
        return this.totalWinnings;
    }

}
