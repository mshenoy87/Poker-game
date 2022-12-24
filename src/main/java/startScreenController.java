import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class startScreenController implements Initializable {


    @FXML
    BorderPane gameScreen;

    @FXML
    Button start;

    @FXML
    Button exit;

    @FXML
    VBox root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void exitAction(ActionEvent e) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void startGame(ActionEvent e) throws IOException {
        // change style sheet and fxml file
        Parent r = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/gameScene.fxml")));
        gameScreen.getScene().getStylesheets().add("/styles/style2.css");
        gameScreen.getScene().setRoot(r);

    }


}
