import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


class cardComparator implements Comparator<Card> {


    // implements comparator for Card to sort hand
    @Override
    public int compare(Card c1, Card c2) {
        return Integer.compare(c1.getValue(), c2.getValue());
    }
}


public class ThreeCardLogic {

    // private variables


    //
    // returns an integer depending on the hand
    //
    //
    // evalHand
    //
    public static int evalHand(ArrayList<Card> hand) {

       // check if there is at least a pair in the hand
        if (hand.get(0).getValue() == hand.get(1).getValue() ||
                hand.get(0).getValue() == hand.get(2).getValue() ||
                hand.get(1).getValue() == hand.get(2).getValue()) {

            // checks if all three cards are same and returns "three of a kind" if true
            if (hand.get(0).getValue() == hand.get(1).getValue() &&
                    hand.get(1).getValue() == hand.get(2).getValue()) {
                return 2;
            } else {        // only two are the same, so return pair
                return 5;
            }

        } else {
            // sort list
            hand.sort(new cardComparator());

            // check if consecutive ranks
            if ((hand.get(0).getValue() + 1) == hand.get(1).getValue() &&
                    (hand.get(1).getValue() + 1) == hand.get(2).getValue()) {

                // if suits are same and consecutive in value, return 1 for straight flush
                if (hand.get(0).getSuit() == hand.get(1).getSuit() &&
                        hand.get(1).getSuit() == hand.get(2).getSuit()) {
                    return 1;
                } else {
                    // return 3 for straight if only consecutive values
                    return 3;
                }

            } else {
                if (hand.get(0).getSuit() == hand.get(1).getSuit() &&
                        hand.get(1).getSuit() == hand.get(2).getSuit()) {
                    // values are not consecutive, but suits are the same: flush
                    return 4;
                }

            }

        }
        // does not fall into any of the conditions
        // return 0 to evaluate the highest hand
        return 0;

    }


    //
    //
    //
    // evalPPWinnings
    //
    public static int evalPPWinnings(ArrayList<Card> hand, int bet) {

        // evaluate hand
        int handResultValue = evalHand(hand);

        // evaluate pair plus bet based on evalHand function
        if (handResultValue == 1) {
            return (40 * bet);          // straight flush
        } else if (handResultValue == 2) {
            return (30 * bet);          // three of a kind
        } else if (handResultValue == 3) {
            return (6 * bet);           // straight
        } else if (handResultValue == 4) {
            return (3 * bet);           // flush
        } else if (handResultValue == 5) {
            return bet;                 // pair
        }

        // if we placed a PairPlus bet without having one of the 5 hands
        // we return zero. we lose the pair plus wager
        return 0;
    }


    //
    // evaluates the hand between the player and dealer
    // return 1, if dealer won and 2 if player won
    // if numbers are the same, we calculate who has the highest hand and return who has the highest hand
    // return 0 if it's a tie
    //
    // compareHands
    //
    public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
        // evaluate hands
        int evalPlayer = evalHand(player);
        int evalDealer = evalHand(dealer);
        // cases to check:
        // if both are zero or equal the same values, evaluate highest hand by looping through list
        // return whichever one has the highest value card
        // if one is zero and the other is not (two cases)
        // return the one that is not zero
        // if both are not zero, compare values
        // return the winner (whoever has the lower value)

        if (evalDealer == evalPlayer) {
            Collections.sort(player, new cardComparator());
            Collections.sort(dealer, new cardComparator());

            // start from index 2, check cards
            for (int i = 2; i >= 0; i--) {
                // if dealer's is bigger, highCardWinner 1, break
                if (player.get(i).getValue() < dealer.get(i).getValue()) {
                    return 1;
                } else if (dealer.get(i).getValue() < player.get(i).getValue()) {
                    // if player's is bigger, highCardWinner 2, break
                    return 2;
                }
            }

        } else if (evalDealer == 0 || evalPlayer == 0 && evalDealer != evalPlayer) {
            if (evalDealer == 0) {    // player has higher value
                return 2;
            } else  {   // dealer has higher value
                return 1;
            }
        } else {
            // compare pair plus winning hands only
            if (evalDealer < evalPlayer) {
                return 1;
            } else {
                return 2;
            }
        }

        return 0;

    }









//        if (playerHandResult != 0 && dealerHandResult != 0 &&
//                playerHandResult != dealerHandResult) {
//            if (dealerHandResult < playerHandResult) {
//                // if dealer's number is smaller and not zero, return 1 - dealer won
//                return 1;
//            } else if (playerHandResult < dealerHandResult) {
//                // if dealer number is bigger and not zero, return 2 - player won
//                return 2;
//            }
//        }
//        // go through the ArrayLists and check which hand has highest value
//        // return appropriate value
//
//        // sort items ascending order (getting the largest last, smallest first)
//        Collections.sort(player, new cardComparator());
//        Collections.sort(dealer, new cardComparator());
//
//        // start from index 2, check cards
//        for (int i = 2; i >= 0; i--) {
//            // if dealer's is bigger, highCardWinner 1, break
//            if (player.get(i).getValue() < dealer.get(i).getValue()) {
//                return 1;
//            } else if (dealer.get(i).getValue() < player.get(i).getValue()) {
//                // if player's is bigger, highCardWinner 2, break
//                return 2;
//            }
//        }
//
//        // if neither hand won (both numbers were equal), return 0
//        return 0;
//
//        }


}