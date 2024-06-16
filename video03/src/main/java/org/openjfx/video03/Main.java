package org.openjfx.video03;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Button button;
    @Override
    public void start(Stage primaryStage) throws IOException {
       primaryStage.setTitle("JavaFX Video 03");
       button = new Button();
       button.setText("Click Me");
        /*cach 01*/
//       button.setOnAction(new EventHandler<ActionEvent>() {
//           @Override
//           public void handle(ActionEvent actionEvent) {
//               System.out.println("hello 01");
//           }
//       });
        /*Cach 02*/
//      button.setOnAction(event -> System.out.println("hello 02"));

       /*Cach 03*/
       button.setOnAction(event -> {
           System.out.println("hello 03");
           System.out.println("hello bro!");
       });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}