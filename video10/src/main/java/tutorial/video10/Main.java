package tutorial.video10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage window;
    Button button;
    Scene scene;
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("Video 10");

        //Form
        TextField nameInput = new TextField();

        button = new Button("Submit");
        button.setOnAction(event -> isInt(nameInput, nameInput.getText()));

        //layout
        VBox layout = new VBox(10);
        layout.setPadding( new Insets( 20, 20, 20, 20 ) );
        layout.getChildren().addAll(nameInput, button);

        scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField input, String message) {
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error:" + message + " is not a number");
            return false;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}