package tutorial.video15;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WhoIsLookUp {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}