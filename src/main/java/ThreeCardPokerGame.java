import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
//import org.w3c.dom.Text;

import java.awt.*;
import java.util.HashMap;

public class ThreeCardPokerGame extends Application {

	// buttons and text for game
	HashMap<String, Scene> sceneMap;     // hashmap of scenes


	Player player1 = new Player();
	Player player2 = new Player();
	Dealer dealer = new Dealer();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Three Card Poker");

		sceneMap = new HashMap<String,Scene>();




		sceneMap.put("start", setStartScene(primaryStage));
		sceneMap.put("game", createGameScene(primaryStage));
		sceneMap.put("options",optionsScene(primaryStage));
		//Scene scene = new Scene(root, 900, 700);    // borderpane, width, height
		primaryStage.setScene(sceneMap.get("start"));
		primaryStage.show();
	}

	//
	// set control scene
	//
	// setStartScene
	// TODO: set delays, make everything look more like a game than a simple GUI
	//
	public Scene setStartScene(Stage primaryStage) {
		// borderpane has Vbox with a label, start button, and an exit button
		BorderPane startPane = new BorderPane();
		startPane.setPadding(new Insets(0));
		Button start = new Button("Start Game");
		Button exit = new Button("Exit Game");
		// buttons and text field
		Text gameTitle = new Text("Welcome to Three Card Poker");

		// sets up design of buttons and textField
		gameTitle.setStyle("-fx-font: 30 arial;");
		start.setMaxSize(200, 200);
		exit.setMaxSize(200, 200);

		// start scene's button actions
		start.setOnAction(e -> primaryStage.setScene(sceneMap.get("game")));
		exit.setOnAction(e -> primaryStage.close());

		// adds VBox to scene
		VBox startScene = new VBox(15);
		startScene.setAlignment(Pos.CENTER);
		startScene.getChildren().addAll(gameTitle, start, exit);
		startPane.setCenter(startScene);

		// return created scene
		return new Scene(startPane, 500, 400);
	}


	//
	// TODO: Setup scene buttons based on layout in class diagram
	// createGameScene
	//
	public Scene createGameScene(Stage primaryStage) {

		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(5));
		Text deleteThis = new Text("this is just a test");
		Button options = new Button("Options");

		options.setOnAction(e -> primaryStage.setScene(sceneMap.get("options")));

		VBox delete = new VBox(deleteThis, options);
		delete.setAlignment(Pos.TOP_RIGHT);
		pane.setTop(delete);

		return new Scene(pane, 700, 700);

	}

	public Scene optionsScene(Stage primaryStage) {
		BorderPane optionsPane = new BorderPane();
		Text t = new Text("THIS IS A TEXT");
		VBox tbox = new VBox(t);
		optionsPane.setCenter(tbox);
		return new Scene(optionsPane, 700, 700);
	}



	//feel free to remove the starter code from this method
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		primaryStage.setTitle("Welcome to Project #2");
//
//
//
//		 Rectangle rect = new Rectangle (100, 40, 100, 100);
//	     rect.setArcHeight(50);
//	     rect.setArcWidth(50);
//	     rect.setFill(Color.LIGHTPINK);
//
//	     RotateTransition rt = new RotateTransition(Duration.millis(5000), rect);
//	     rt.setByAngle(270);
//	     rt.setCycleCount(4);
//	     rt.setAutoReverse(true);
//	     SequentialTransition seqTransition = new SequentialTransition (
//	         new PauseTransition(Duration.millis(500)),
//	         rt
//	     );
//	     seqTransition.play();
//
//	     FadeTransition ft = new FadeTransition(Duration.millis(5000), rect);
//	     ft.setFromValue(1.0);
//	     ft.setToValue(0.3);
//	     ft.setCycleCount(4);
//	     ft.setAutoReverse(true);
//
//	     ft.play();
//	     BorderPane root = new BorderPane();
//	     root.setCenter(rect);
//
//	     Scene scene = new Scene(root, 700,700);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//	}

}
