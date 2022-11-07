import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ThreeCardPokerGame extends Application {

	// buttons and text for game
	HashMap<String, Scene> sceneMap;     // hashmap of scenes, that will map a scene to a ke
	BorderPane gameScreen, startPane, optionsPane;

	Player player1 = new Player();
	Player player2 = new Player();
	Dealer dealer = new Dealer();

	// buttons for the game
	Button start, exit;    // start screen

	Button closeMenu, freshStart, newLook, exitToMenu;     // options screen


	Button options, deal, play1, play2, fold1, fold2, setPlayer1Bets, setPlayer2Bets;     // game screen buttons
	TextField antePlayer1, playPlayer1, pairPlusPlayer1;	  // text fields for player 1
	TextField antePlayer2, playPlayer2, pairPlusPlayer2;	  // text fields for player 2


	// miscellaneous items: pauses, etc;
	PauseTransition pause = new PauseTransition(Duration.seconds(1));

	// Text to display
	Text gameInfo;    // text to display information about the game

	Text totalWinnings1, totalWinnings2;   // total winnings


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Welcome to Three Card Poker!");

		// create a scene map
		sceneMap = new HashMap<>();
		// call functions to add to the scene map


		// start with start screen
		sceneMap.put("Start", startScreen(primaryStage));
		sceneMap.put("Game", gameScreen(primaryStage));
		sceneMap.put("Options", optionsScreen(primaryStage));

		primaryStage.setScene(sceneMap.get("Start"));
		primaryStage.show();
	}

	//
	// create an HBox for cards face down, and return it
	// used for the beginning when dealer and players' cards are facing down
	//
	// cardsFaceDown
	//
	public HBox cardsFaceDown() {
		HBox cardsArea = new HBox(10);
		for (int i = 0; i < 3; i++) {
			Image img = new Image("backOfCard.png");
			ImageView faceDown = new ImageView(img);
			faceDown.setFitHeight(130);
			faceDown.setFitWidth(80);
			cardsArea.getChildren().addAll(faceDown);
		}
		cardsArea.setAlignment(Pos.CENTER);
		return cardsArea;
	}


	//
	// sets up a text field to show information about the game
	//
	// setUpGameInfo
	//
	public HBox setUpGameInfo(Text gameInfo) {
		HBox gameInfoPane = new HBox(gameInfo);
		gameInfo.setFont(new Font("Arial", 20));
		gameInfoPane.setAlignment(Pos.CENTER);
		gameInfoPane.setStyle("-fx-background-color: #D4E7DC");
		gameInfoPane.setPadding(new Insets(15));
		gameInfoPane.setPrefHeight(20);
		gameInfoPane.setMaxWidth(75);
		return gameInfoPane;
	}

	//
	// creates and returns a VBox containing text fields and the button to set bets
	//
	// setBettingArea
	//
	public VBox setBettingArea(TextField ante, TextField play, TextField pairPlus, Button setBets, Text totalWinnings) {

		// create areas for textFields
		ante = new TextField();
		play = new TextField();
		pairPlus = new TextField();

		// set sizes and alignment for text field

		// create Labels and attach to text fields
		HBox Ante = new HBox(5, new Text("Ante: "), ante);
		HBox Play = new HBox(5, new Text("Play: "), play);
		HBox PairPlus = new HBox(5, new Text("Pair Plus: "), pairPlus);

		// total winnings area and design
		HBox totalWinningsArea = new HBox(totalWinnings);
		totalWinnings.setFont(new Font("Arial", 15));
		totalWinningsArea.setPadding(new Insets(5));
		totalWinningsArea.setStyle("-fx-background-color: #D4E7DC");

		// button to set the bets
		setBets = new Button("Set Player's bets");
		setBets.setMinSize(30, 30);

		// create VBox being returned
		VBox bets = new VBox(5, Ante, Play, PairPlus, setBets);
		bets.setMaxSize(180, 25);
		bets.setAlignment(Pos.BOTTOM_RIGHT);

		VBox bettingArea = new VBox(5, totalWinningsArea, bets);

		return bettingArea;
	}

	public HBox playFoldButtons(Button play, Button fold) {
		// designs buttons
		play.setAlignment(Pos.CENTER);
		fold.setAlignment(Pos.CENTER);
		play.setMinSize(75, 50);
		fold.setMinSize(75, 50);

		HBox playerOptions = new HBox(10, play, fold);

		return playerOptions;
	}


	public Scene gameScreen(Stage primaryStage) {

		gameScreen = new BorderPane();
		gameScreen.setStyle("-fx-background-color: #218867");

		options = new Button("Options");
		options.setOnAction(e -> primaryStage.setScene(sceneMap.get("Options")));

		// center pane with dealer cards, player cards, play, deal, and fold buttons
		HBox dealerCardsFaceDown = cardsFaceDown();
		HBox p1CardsFaceDown = cardsFaceDown();
		HBox p2CardsFaceDown = cardsFaceDown();
		HBox playerCardsArea = new HBox(50, p1CardsFaceDown, p2CardsFaceDown);
		playerCardsArea.setAlignment(Pos.CENTER);

		// sets up text fields and buttons for bets
		totalWinnings1 = new Text("total winnings of Player 1: \n\t $0");
		totalWinnings2 = new Text("total winnings of Player 2: \n\t $0");
		VBox bets1 = setBettingArea(antePlayer1, playPlayer1, pairPlusPlayer1, setPlayer1Bets, totalWinnings1);
		VBox bets2 = setBettingArea(antePlayer2, playPlayer2, pairPlusPlayer2, setPlayer2Bets, totalWinnings2);
		bets1.setAlignment(Pos.CENTER_LEFT);
		bets2.setAlignment(Pos.CENTER_RIGHT);

		// game information text field
		gameInfo = new Text("Select \"deal\" to start game");
		HBox gameInfoPane = setUpGameInfo(gameInfo);

		// create play, fold, and deal buttons
		play1 = new Button("Play Player 1");
		play2 = new Button("Play Player 2");
		fold1 = new Button("Fold Player 1");
		fold2 = new Button("Fold Player 2");
		HBox playFold1 = playFoldButtons(play1, fold1);
		HBox playFold2 = playFoldButtons(play2, fold2);
		deal = new Button("deal");
		deal.setMinSize(150, 50);
		deal.setFont(new Font("Arial", 18));
		HBox playOptions = new HBox(30, playFold1, deal, playFold2);
		playOptions.setAlignment(Pos.CENTER);

		// text that displays game information
		gameInfo = new Text("Select Deal to start");
		VBox centerPane = new VBox(15, dealerCardsFaceDown, gameInfoPane, playerCardsArea, playOptions);
		centerPane.setAlignment(Pos.CENTER);

		gameScreen.setCenter(centerPane);
		gameScreen.setTop(options);
		gameScreen.setLeft(bets1);
		gameScreen.setRight(bets2);

		return new Scene(gameScreen, 1000, 600);
	}


	//
	// creates an options scene
	//
	// optionsScene
	//
	public Scene optionsScreen(Stage primaryStage) {
		// create borderpane
		optionsPane = new BorderPane();
		optionsPane.setStyle("-fx-background-color: #218867");

		// create buttons
		Text optionsTitle = new Text("Options: ");
		freshStart = new Button("Fresh Start");
		newLook = new Button("New Look");
		exitToMenu = new Button("Exit to Start");
		closeMenu = new Button("Close menu");

		// design buttons for options
		optionsPane.setStyle("-fx-background-color: #218867");
		optionsTitle.setStyle("-fx-font: 30 Arial");
		optionsTitle.setFill(Color.LIGHTBLUE);

		newLook.setStyle("-fx-font: 25 Arial");
		newLook.setMaxSize(200, 300);

		freshStart.setStyle("-fx-font: 25 Arial");
		freshStart.setMaxSize(200, 300);

		exitToMenu.setStyle("-fx-font: 25 Arial");
		exitToMenu.setMaxSize(200, 300);

		closeMenu.setStyle("-fx-font: 25 Arial");
		closeMenu.setMaxSize(200, 300);

		// event handlers for buttons

		exitToMenu.setOnAction(e -> primaryStage.setScene(sceneMap.get("Start")));
		closeMenu.setOnAction(e -> primaryStage.setScene(sceneMap.get("Game")));

		// set it up in a VBOX and attach to border pane and add to the returned scene
		VBox optionButtons = new VBox(5, optionsTitle, freshStart, newLook, exitToMenu, closeMenu);
		optionButtons.setAlignment(Pos.CENTER);
		optionsPane.setCenter(optionButtons);

		return new Scene(optionsPane, 300, 300);
	}


	//
	// creates a start game scene
	//
	// startScreen
	//
	public Scene startScreen(Stage primaryStage) {
		// create border pane for start menu
		startPane = new BorderPane();
		startPane.setStyle("-fx-background-color: #218867");

		// set up title
		Text title = new Text("Welcome to Three Card Poker!");
		title.setStyle("-fx-font: 30 arial");
		title.setFill(Color.LIGHTBLUE);

		// set up the buttons that will be on the screen
		start = new Button("Start Game");
		exit = new Button("Exit");

		// design the buttons
		title.setFont(new Font("Arial", 18));
		start.setMaxSize(200, 100);
		exit.setMaxSize(150, 100);

		start.setStyle("-fx-font: 20 Arial");
		exit.setStyle("-fx-font: 20 Arial");

		// event handlers for start and exit
		start.setOnAction(e -> {
			start.setText("Starting...");
			pause.play();
		});
		pause.setOnFinished(e-> {
			primaryStage.setScene(sceneMap.get("Game"));
			start.setText("Start Game");
		});
		exit.setOnAction(e -> {primaryStage.close();});

		// create scene then return
		VBox startScene = new VBox(10, title, start, exit);
		startScene.setAlignment(Pos.CENTER);
		startPane.setCenter(startScene);

		return new Scene(startPane, 500, 400);
	}

}
