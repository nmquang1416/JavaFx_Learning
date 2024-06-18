package tutorial.video13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
       Stage window = primaryStage;
       window.setTitle("Video 13");
       window.setResizable(false);
       Button button = new Button("Click Me");

       //creat empty box to archive choice
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //add choices to empty box
        choiceBox.getItems().addAll("banana", "wifi", "jing liu", "hanabi", "sparkle", "ruan mei");
        //set default value
        choiceBox.getSelectionModel().selectFirst();
        //Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(button, choiceBox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}