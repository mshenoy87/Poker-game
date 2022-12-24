import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;


public class gameController implements Initializable {

    @FXML
    BorderPane gamePane;

    @FXML
    Button options, play1, play2, fold1, fold2, deal;

    @FXML
    TextField ante1, pairPlus1, ante2, pairPlus2;

    @FXML
    VBox bets1, bets2, player1Decision, player2Decision, root;

    @FXML
    HBox player1Cards, player2Cards, dealerCards, playerCards, playerInfo;

    @FXML
    ImageView dC1, dC2, dC3, p1c1, p1c2, p1c3, p2c1, p2c2, p2c3;     // card images

    @FXML
    Text player1Total, player2Total, gameInfo;

    @FXML
    HBox totalWinningsP1, totalWinningsP2, winnings;


    // initialize dealer and player
    Dealer dealer;
    Player player1;
    Player player2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dealer = new Dealer();
        player1 = new Player();
        player2 = new Player();

        player1.setTotalWinnings(1000);
        player2.setTotalWinnings(1000);
        dealer.setDealersHand();

        player1Total.setText("Total Winnings Player 1: $" + player1.getTotalWinnings());
        player2Total.setText("Total Winnings Player 2: $" + player2.getTotalWinnings());

        dC1.setImage(new Image("/Images/backOfCard.png"));
        dC2.setImage(new Image("/Images/backOfCard.png"));
        dC3.setImage(new Image("/Images/backOfCard.png"));

        p1c1.setImage(new Image("/Images/backOfCard.png"));
        p1c2.setImage(new Image("/Images/backOfCard.png"));
        p1c3.setImage(new Image("/Images/backOfCard.png"));

        p2c1.setImage(new Image("/Images/backOfCard.png"));
        p2c2.setImage(new Image("/Images/backOfCard.png"));
        p2c3.setImage(new Image("/Images/backOfCard.png"));

    }

    //
    // findCard
    //
    // finds the correct image for the card
    //
    private Image findCard(Card card) {
        String cardPath = "/Images/";
        // check the suit and go to the correct directory
        if (card.getSuit() == 'H') {
            cardPath = cardPath + "Hearts/";
        } else if (card.getSuit() == 'D') {
            cardPath = cardPath + "Diamonds/";
        } else if (card.getSuit() == 'C') {
            cardPath = cardPath + "Hearts/";
        } else if (card.getSuit() == 'S') {
            cardPath = cardPath + "Diamonds/";
        }

        // check value and get the right card
        cardPath = cardPath + card.getValue() + ".png";

        return new Image(cardPath);
    }

    //
    // disableBets
    //
    // disable and collect info from betting area
    //
    private void disableBets() {
        // get the info in textFields for both players
        try {player1.setAnteBet(Integer.parseInt(ante1.getText()));}
        catch (Exception e) {player1.setAnteBet(0);}

        try {player1.setPairPlusBet(Integer.parseInt(pairPlus1.getText()));}
        catch (Exception e) {player1.setPairPlusBet(0);}

        try {player2.setAnteBet(Integer.parseInt(ante2.getText()));}
        catch (Exception e) {player2.setAnteBet(0);}

        try {player2.setPairPlusBet(Integer.parseInt(pairPlus2.getText()));}
        catch (Exception e) {player2.setPairPlusBet(0);}

        // disable the fields
        ante1.setDisable(true);
        pairPlus1.setDisable(true);

        ante2.setDisable(true);
        pairPlus2.setDisable(true);

    }

    //
    // changeCards
    //
    // changes the images of the cards
    //
    private void changeCards() {
        // change image for player 1's cards, and use pause transitions
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.play();
        pause.setOnFinished(event -> p1c1.setImage(findCard(player1.getHand().get(0))));

        pause = new PauseTransition(Duration.seconds(2));
        pause.play();
        pause.setOnFinished(event -> p1c2.setImage(findCard(player1.getHand().get(1))));

        pause = new PauseTransition(Duration.seconds(3));
        pause.play();
        pause.setOnFinished(event -> p1c3.setImage(findCard(player1.getHand().get(2))));

        // change image for player 2's cards, and use pause transitions
        pause = new PauseTransition(Duration.seconds(4));
        pause.play();
        pause.setOnFinished(event -> p2c1.setImage(findCard(player2.getHand().get(0))));

        pause = new PauseTransition(Duration.seconds(5));
        pause.play();
        pause.setOnFinished(event -> p2c2.setImage(findCard(player2.getHand().get(1))));

        pause = new PauseTransition(Duration.seconds(6));
        pause.play();
        pause.setOnFinished(event -> p2c3.setImage(findCard(player2.getHand().get(2))));

    }

    @FXML
    void optionsMenu(ActionEvent e) throws IOException {
        Parent r = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/Options.fxml")));
        gamePane.getScene().setRoot(r);
    }

    @FXML
    public void dealAction(ActionEvent e) {

        player1.setHand(dealer.dealHand());
        player2.setHand(dealer.dealHand());

        // disable betting area and get bets
        disableBets();

        // change card images with this function
        changeCards();

        deal.setDisable(true);    // disable deal for now
        play1.setDisable(false);
        fold1.setDisable(false);

    }


    @FXML
    public void play1Action(ActionEvent e) {

        // enable player 2, disable player 1
        play1.setDisable(true);
        play1.setDisable(true);

        play2.setDisable(false);
        fold2.setDisable(false);

        // set play bet to the ante
        player1.setPlayBet(player1.getAnteBet());

        // calculate the winnings based on the hand
        ThreeCardLogic.compareHands(dealer.getDealersHand(), player1.getHand());   // compare hands with dealer

    }

    @FXML
    public void fold1Action(ActionEvent e) {
        // calculate total winnings (total winnings - ante - pair plus)
        int total = player1.getTotalWinnings() - player1.getAnteBet() +
                ThreeCardLogic.evalPPWinnings(player1.getHand(), player1.getPairPlusBet());
        player1.setTotalWinnings(total);

        // display it on the screen
        player1Total.setText("Total Winnings Player 1: $" + player1.getTotalWinnings());

    }

    @FXML
    public void play2Action(ActionEvent e) {

        // disable actions
        play1.setDisable(true);
        fold1.setDisable(true);

        play2.setDisable(true);
        fold2.setDisable(true);

        // set play bet as ante
        player2.setPlayBet(player2.getAnteBet());

        // calculate winnings based off the hand
        ThreeCardLogic.compareHands(dealer.getDealersHand(), player2.getHand());   // compare hands with dealer

        // if both play buttons are pressed, show dealer's cards
        PauseTransition pause2 = new PauseTransition(Duration.seconds(1));
        pause2.play();
        pause2.setOnFinished(event -> dC1.setImage(findCard(dealer.getDealersHand().get(0))));

        pause2 = new PauseTransition(Duration.seconds(2));
        pause2.play();
        pause2.setOnFinished(event -> dC2.setImage(findCard(dealer.getDealersHand().get(1))));

        pause2 = new PauseTransition(Duration.seconds(3));
        pause2.play();
        pause2.setOnFinished(event -> dC3.setImage(findCard(dealer.getDealersHand().get(2))));


    }

    @FXML
    public void fold2Action(ActionEvent e) {
        // disable options
        play1.setDisable(true);
        play1.setDisable(true);

        play2.setDisable(true);
        fold2.setDisable(true);


        PauseTransition pause2 = new PauseTransition(Duration.seconds(1));
        pause2.play();
        pause2.setOnFinished(event -> dC1.setImage(findCard(dealer.getDealersHand().get(0))));

        pause2 = new PauseTransition(Duration.seconds(2));
        pause2.play();
        pause2.setOnFinished(event -> dC2.setImage(findCard(dealer.getDealersHand().get(1))));

        pause2 = new PauseTransition(Duration.seconds(3));
        pause2.play();
        pause2.setOnFinished(event -> dC3.setImage(findCard(dealer.getDealersHand().get(2))));


        // calculate total winnings (total winnings - ante - pair plus)
        int total = player2.getTotalWinnings() - player2.getAnteBet() +
                ThreeCardLogic.evalPPWinnings(player2.getHand(), player2.getPairPlusBet());
        player2.setTotalWinnings(total);

        // display it on the screen
        player2Total.setText("Total Winnings Player 2: $" + player2.getTotalWinnings());
    }



}
