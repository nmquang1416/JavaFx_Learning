package tutorial.video30;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage window;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("video 30");

        //Input and labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("welcome to video 30");
        Label secondLabel = new Label("");

        HBox bottomText = new HBox(firstLabel, secondLabel, userInput);
        bottomText.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10, userInput, bottomText);
        vbox.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(userInput.textProperty());

        Scene scene = new Scene(vbox, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}