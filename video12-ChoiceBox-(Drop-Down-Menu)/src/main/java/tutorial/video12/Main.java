package tutorial.video12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
       Stage window = primaryStage;
       window.setTitle("Video 12");
       window.setResizable(false);
       Button button = new Button("Click Me");


       ChoiceBox<String> choiceBox = new ChoiceBox<>();

       //getItems returns the observableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Pears");
        choiceBox.getItems().addAll("Banana", "HAM","Meatballs");

        //setValue
        choiceBox.getSelectionModel().selectFirst();
        //get Value
        button.setOnAction(event -> getChoice(choiceBox));

       VBox layout = new VBox(10);
       layout.setPadding(new Insets(10, 10, 10, 10));
       layout.getChildren().addAll(choiceBox, button);

       Scene scene = new Scene(layout, 300, 250);
       window.setScene(scene);
       window.show();
    }
    private void getChoice(ChoiceBox<String> choiceBox ){
        String food = choiceBox.getValue();
        System.out.println(food);
    }
}