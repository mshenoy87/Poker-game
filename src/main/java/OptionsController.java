import javafx.fxml.Initializable;
import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class OptionsController implements Initializable {

    @FXML
    BorderPane optionsMenu;

    @FXML
    Button closeMenu, freshStart, newLook, exitToMenu;

    @FXML
    VBox root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void closeMenu(ActionEvent e) throws IOException {
        // change style sheet and fxml file
        Parent r = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/gameScene.fxml")));
        optionsMenu.getScene().getStylesheets().add("/styles/style2.css");
        optionsMenu.getScene().setRoot(r);
    }

    @FXML
    void exitToMenu(ActionEvent e) throws IOException {
        Parent r = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/homePage.fxml")));
        optionsMenu.getScene().getStylesheets().add("/styles/style1.css");
        optionsMenu.getScene().setRoot(r);
    }

}
