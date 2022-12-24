import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class ThreeCardPokerGame extends Application {

//	// buttons and text for game
//	HashMap<String, Scene> sceneMap;     // hashmap of scenes, that will map a scene to a ke
//	BorderPane gameScreen, startPane, optionsPane;
//
//	Player player1 = new Player();
//	Player player2 = new Player();
//	Dealer dealer = new Dealer();
//
//	// buttons for the game
//	Button start, exit;    // start screen
//
//	Button closeMenu, freshStart, newLook, exitToMenu;     // options screen
//
//	Button options, deal, play1, play2, fold1, fold2, setBets;     // game screen buttons
//	TextField antePlayer1, playPlayer1, pairPlusPlayer1;	  // text fields for player 1
//	TextField antePlayer2, playPlayer2, pairPlusPlayer2;	  // text fields for player 2
//
//	// HBoxes that will have changing items
//	HBox p1Cards, p2Cards, p1CardsFaceUp, p2CardsFaceUp;
//	HBox cardsArea;
//	ImageView face;
//
//	// miscellaneous items: pauses, etc;
//	PauseTransition pause = new PauseTransition(Duration.seconds(1));
//	PauseTransition pause2 = new PauseTransition(Duration.seconds(0.5));
//
//	// Text to display
//	Text gameInfo;    // text to display information about the game
//
//	Text totalWinnings1, totalWinnings2;   // total winnings


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		try {
			// Read file fxml and draw interface.
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/homePage.fxml"));

			primaryStage.setTitle("Three Card Poker Game");
			Scene s1 = new Scene(root, 1000,700);
			s1.getStylesheets().add("/styles/style1.css");
			primaryStage.setScene(s1);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

//		primaryStage.setTitle("Welcome to Three Card Poker!");
//
//		// create a scene map
//		sceneMap = new HashMap<>();
//
//		// start with start screen
//		sceneMap.put("Start", startScreen(primaryStage));
//		sceneMap.put("Game", gameScreen(primaryStage));
//		sceneMap.put("Options", optionsScreen(primaryStage));
//
//		primaryStage.setScene(sceneMap.get("Start"));
//		primaryStage.show();
	}

//	//
//	// create an HBox for cards face down, and return it
//	// used for the beginning when dealer and players' cards are facing down
//	//
//	// cardsFaceDown
//	//
//	public HBox cardsFaceDown() {
//		cardsArea = new HBox(10);
//		for (int i = 0; i < 3; i++) {
//			Image img1 = new Image("backOfCard.png");
//			face = new ImageView(img1);
//			face.setFitHeight(130);
//			face.setFitWidth(80);
//			cardsArea.getChildren().addAll(face);
//		}
//		cardsArea.setAlignment(Pos.CENTER);
//		return cardsArea;
//	}
//
//
//	//
//	// sets up a text field to show information about the game
//	//
//	// setUpGameInfo
//	//
//	public HBox setUpGameInfo(Text gameInfo) {
//		HBox gameInfoPane = new HBox(gameInfo);
//		gameInfo.setFont(new Font("Arial", 20));
//		gameInfoPane.setAlignment(Pos.CENTER);
//		gameInfoPane.setStyle("-fx-background-color: #D4E7DC");
//		gameInfoPane.setPadding(new Insets(15));
//		gameInfoPane.setPrefHeight(20);
//		gameInfoPane.setMaxWidth(75);
//		return gameInfoPane;
//	}
//
//	//
//	// creates and returns a VBox containing text fields and the button to set bets
//	//
//	// setBettingArea
//	//
//	public VBox setBettingArea(TextField ante, TextField play, TextField pairPlus, Text totalWinnings) {
//
//		// set sizes and alignment for text field
//
//		// create Labels and attach to text fields
//		HBox Ante = new HBox(5, new Text("Ante: "), ante);
//		HBox Play = new HBox(5, new Text("Play: "), play);
//		HBox PairPlus = new HBox(5, new Text("Pair Plus: "), pairPlus);
//
//		// total winnings area and design
//		HBox totalWinningsArea = new HBox(totalWinnings);
//		totalWinnings.setFont(new Font("Arial", 15));
//		totalWinningsArea.setPadding(new Insets(5));
//		totalWinningsArea.setStyle("-fx-background-color: #D4E7DC");
//
//		// create VBox being returned
//		VBox bets = new VBox(5, Ante, Play, PairPlus);
//		bets.setMaxSize(180, 25);
//		bets.setAlignment(Pos.BOTTOM_RIGHT);
//
//		VBox bettingArea = new VBox(5, totalWinningsArea, bets);
//
//		return bettingArea;
//	}
//
//
//	//
//	// designs and returns play and fold buttons in an HBox
//	//
//	// playFoldButtons
//	//
//	public HBox playFoldButtons(Button play, Button fold) {
//		// designs buttons
//		play.setAlignment(Pos.CENTER);
//		fold.setAlignment(Pos.CENTER);
//		play.setMinSize(75, 50);
//		fold.setMinSize(75, 50);
//
//		HBox playerOptions = new HBox(10, play, fold);
//
//		return playerOptions;
//	}
//
//
//	//
//	// returns an array of images of what to display depending on the card
//	//
//	//
//	//

//
//
//	//
//	// create the game screen
//	// returns the scene containing the game border pane
//	//
//	// gameScreen
//	//
//	public Scene gameScreen(Stage primaryStage) {
//
//		gameScreen = new BorderPane();
//		gameScreen.setStyle("-fx-background-color: #218867");
//
//		options = new Button("Options");
//		options.setOnAction(e -> primaryStage.setScene(sceneMap.get("Options")));
//
//		// center pane with dealer cards, player cards, play, deal, and fold buttons
//		HBox dealerCardsFaceDown = cardsFaceDown();
//		p1Cards = cardsFaceDown();
//		p2Cards = cardsFaceDown();
//		HBox playerCardsArea = new HBox(50, p1Cards, p2Cards);
//		playerCardsArea.setAlignment(Pos.CENTER);
//
//		// sets up text fields and buttons for bets
//		totalWinnings1 = new Text("total winnings of Player 1: \n\t $0");
//		totalWinnings2 = new Text("total winnings of Player 2: \n\t $0");
//		// create areas for textFields
//		antePlayer1 = new TextField();
//		antePlayer2 = new TextField();
//		playPlayer1 = new TextField();
//		playPlayer2 = new TextField();
//		pairPlusPlayer1 = new TextField();
//		pairPlusPlayer2 = new TextField();
//
//		VBox bets1 = setBettingArea(antePlayer1, playPlayer1, pairPlusPlayer1, totalWinnings1);
//		VBox bets2 = setBettingArea(antePlayer2, playPlayer2, pairPlusPlayer2, totalWinnings2);
//		bets1.setAlignment(Pos.CENTER_LEFT);
//		bets2.setAlignment(Pos.CENTER_RIGHT);
//
//		// game information text field
//		gameInfo = new Text("Select \"deal\" to start game");
//		HBox gameInfoPane = setUpGameInfo(gameInfo);
//
//		// create play, fold, and deal buttons
//		play1 = new Button("Play Player 1");
//		play2 = new Button("Play Player 2");
//		fold1 = new Button("Fold Player 1");
//		fold2 = new Button("Fold Player 2");
//
//		// event handlers for play and fold buttons for both players
//		fold1.setOnAction(e -> {
//			// play bet is 0
//
//			// loses ante and pair plus
//
//			// msg is displayed
//
//			// new round
//		});
//
//		// button to set the bets
//		setBets = new Button("Set Player's bets");
//		setBets.setAlignment(Pos.CENTER);
//		setBets.setMinSize(150, 50);
//
//		// event handler for setBets
//		setBets.setOnAction(e -> {
//			// change ability to click buttons
//			deal.setDisable(false);
//			setBets.setDisable(true);
//
//			// get ante, play, and pair plus bets from text fields and set it to player1
//			player1.setAnteBet(Integer.parseInt(antePlayer1.getText()));
//			player1.setPlayBet(Integer.parseInt(playPlayer1.getText()));
//			player1.setPairPlusBet(Integer.parseInt(pairPlusPlayer1.getText()));
//
//			// get ante, play, and pair plus bets from text fields and set it to player1
//			player2.setAnteBet(Integer.parseInt(antePlayer2.getText()));
//			player2.setPlayBet(Integer.parseInt(playPlayer2.getText()));
//			player2.setPairPlusBet(Integer.parseInt(pairPlusPlayer2.getText()));
//
////			System.out.println(player1.getAnteBet() + " " + player1.getPlayBet() + " " + player1.getPairPlusBet());
////			System.out.println(player2.getAnteBet() + " " + player2.getPlayBet() + " " + player2.getPairPlusBet());
//
//		});
//
//		// organize buttons
//		HBox playFold1 = playFoldButtons(play1, fold1);
//		HBox playFold2 = playFoldButtons(play2, fold2);
//		deal = new Button("deal");
//		deal.setMinSize(150, 50);
//		deal.setFont(new Font("Arial", 18));
//		deal.setDisable(true);
//
//		// event handler for deal button
//		deal.setOnMouseClicked(e -> {
//
//			// deal player cards
//			player1.setHand(dealer.dealHand());    // set hands for both players
//			player2.setHand(dealer.dealHand());
//
//			// find the correct card images for both
//			ArrayList<ImageView> cardImgs1 = findCards(player1.getHand());
//			ArrayList<ImageView> cardImgs2 = findCards(player2.getHand());
//
//			// replace and display cards
//			p1CardsFaceUp = new HBox(10);
//			   // System.out.println("here!!!");
//			// TODO: FIX BUG HERE -> Does not get to end of event handler until multiple clicks
//			for (int i = 0; i < 3; i++) {
//				ImageView img = cardImgs1.get(i);
//				p1CardsFaceUp.getChildren().add(img);    // add cards facing up to H box
//			}
//
//			p2CardsFaceUp = new HBox(10);
//			for (int i = 0; i < 3; i++) {
//				ImageView img = cardImgs2.get(i);
//				p2CardsFaceUp.getChildren().add(img);    // add cards facing up to H box
//			}
//
//			playerCardsArea.getChildren().addAll(p1CardsFaceUp, p2CardsFaceUp);
//
//			// remove items in the HBoxes
//			playerCardsArea.getChildren().removeAll(p1Cards, p2Cards);
//
//		});
//
//		// player options area
//		HBox playOptions = new HBox(30, playFold1, deal, playFold2);
//		playOptions.setAlignment(Pos.CENTER);
//
//		// text that displays game information
//		gameInfo = new Text("Select Deal to start");
//		VBox centerPane = new VBox(15, dealerCardsFaceDown, gameInfoPane, playerCardsArea, playOptions, setBets);
//		centerPane.setAlignment(Pos.CENTER);
//
//		// setting up the game screen
//		gameScreen.setCenter(centerPane);
//		gameScreen.setTop(options);
//		gameScreen.setLeft(bets1);
//		gameScreen.setRight(bets2);
//
//		return new Scene(gameScreen, 1000, 600);
//	}
//
//
//	//
//	// creates an options scene
//	//
//	// optionsScene
//	//
//	public Scene optionsScreen(Stage primaryStage) {
//		// create borderpane
//		optionsPane = new BorderPane();
//		optionsPane.setStyle("-fx-background-color: #218867");
//
//		// create buttons
//		Text optionsTitle = new Text("Options: ");
//		freshStart = new Button("Fresh Start");
//		newLook = new Button("New Look");
//		exitToMenu = new Button("Exit to Start");
//		closeMenu = new Button("Close menu");
//
//		// design buttons for options
//		optionsPane.setStyle("-fx-background-color: #218867");
//		optionsTitle.setStyle("-fx-font: 30 Arial");
//		optionsTitle.setFill(Color.LIGHTBLUE);
//
//		newLook.setStyle("-fx-font: 25 Arial");
//		newLook.setMaxSize(200, 300);
//
//		freshStart.setStyle("-fx-font: 25 Arial");
//		freshStart.setMaxSize(200, 300);
//
//		exitToMenu.setStyle("-fx-font: 25 Arial");
//		exitToMenu.setMaxSize(200, 300);
//
//		closeMenu.setStyle("-fx-font: 25 Arial");
//		closeMenu.setMaxSize(200, 300);
//
//		// event handlers for buttons
//		freshStart.setOnAction(e -> {
//			try {
//				start(primaryStage);    // start a new game
//			} catch (Exception ex) {
//				throw new RuntimeException(ex);
//			}
//		});
//
//		newLook.setOnAction(e -> {
//			// changes styles, alternating between background colors
//			if (gameScreen.getStyle().contains("#218867")) {
//				gameScreen.setStyle("-fx-background-color: #636363");
//				startPane.setStyle("-fx-background-color: #636363");
//				optionsPane.setStyle("-fx-background-color: #636363");
//			} else if (gameScreen.getStyle().contains("#636363")) {
//				gameScreen.setStyle("-fx-background-color: #E6CEE3");
//				startPane.setStyle("-fx-background-color: #E6CEE3");
//				optionsPane.setStyle("-fx-background-color: #E6CEE3");
//			} else {    // change back to color
//				gameScreen.setStyle("-fx-background-color: #218867");
//				startPane.setStyle("-fx-background-color: #218867");
//				optionsPane.setStyle("-fx-background-color: #218867");
//			}
//			primaryStage.setScene(sceneMap.get("Game"));
//
//		});
//		exitToMenu.setOnAction(e -> primaryStage.setScene(sceneMap.get("Start")));
//		closeMenu.setOnAction(e -> primaryStage.setScene(sceneMap.get("Game")));
//
//		// set it up in a VBOX and attach to border pane and add to the returned scene
//		VBox optionButtons = new VBox(5, optionsTitle, freshStart, newLook, exitToMenu, closeMenu);
//		optionButtons.setAlignment(Pos.CENTER);
//		optionsPane.setCenter(optionButtons);
//
//		return new Scene(optionsPane, 300, 300);
//	}
//
//
//	//
//	// creates a start game scene
//	//
//	// startScreen
//	//
//	public Scene startScreen(Stage primaryStage) {
//		// create border pane for start menu
//		startPane = new BorderPane();
//		startPane.setStyle("-fx-background-color: #218867");
//
//		// set up title
//		Text title = new Text("Welcome to Three Card Poker!");
//		title.setStyle("-fx-font: 30 arial");
//		title.setFill(Color.LIGHTBLUE);
//
//		// set up the buttons that will be on the screen
//		start = new Button("Start Game");
//		exit = new Button("Exit");
//
//		// design the buttons
//		title.setFont(new Font("Arial", 18));
//		start.setMaxSize(200, 100);
//		exit.setMaxSize(150, 100);
//
//		start.setStyle("-fx-font: 20 Arial");
//		exit.setStyle("-fx-font: 20 Arial");
//
//		// event handlers for start and exit
//		start.setOnAction(e -> {
//			start.setText("Starting...");
//			pause.play();
//		});
//		pause.setOnFinished(e-> {
//			primaryStage.setScene(sceneMap.get("Game"));
//			start.setText("Start Game");
//		});
//		exit.setOnAction(e -> {primaryStage.close();});
//
//		// create scene then return
//		VBox startScene = new VBox(10, title, start, exit);
//		startScene.setAlignment(Pos.CENTER);
//		startPane.setCenter(startScene);
//
//		return new Scene(startPane, 500, 400);
//	}

}
