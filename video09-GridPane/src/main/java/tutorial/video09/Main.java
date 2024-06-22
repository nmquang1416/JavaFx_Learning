package tutorial.video09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("video 09");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(12);

        //name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0,0);

        //name input
        TextField textField = new TextField("Bucky");
        GridPane.setConstraints(textField, 1, 0);

        //password label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 1);

        //password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1,1);

        Button button = new Button("log in");
        GridPane.setConstraints(button, 1,2);

        gridPane.getChildren().addAll(nameLabel, textField, passLabel, passInput, button);
        Scene scene = new Scene(gridPane, 300, 250);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}