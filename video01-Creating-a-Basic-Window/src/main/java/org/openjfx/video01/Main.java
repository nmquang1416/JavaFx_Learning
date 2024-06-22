package org.openjfx.video01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class Main extends Application  {
    Button button;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("JavaFX Video 01");
        button = new Button("Click Me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}