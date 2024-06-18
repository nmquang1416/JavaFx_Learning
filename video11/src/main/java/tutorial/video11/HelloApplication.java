package tutorial.video11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage window = primaryStage;
        window.setTitle("Hello World");

        //CheckBox
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);

        //Button
        Button button = new Button("Click Me");
        button.setOnAction(event -> handleOptions(box1, box2));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(box1, box2, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

    }

    private void handleOptions(CheckBox box, CheckBox box2) {
        String message = "User order \n";
        if (box.isSelected()) {
            message += "Bacon";
        }
        if (box2.isSelected()) {
            message += "Tuna";
        }
        System.out.println(message);
    }

    public static void main(String[] args) {
        launch();
    }
}