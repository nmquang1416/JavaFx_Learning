package org.openjfx.video04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage window;
    Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;

        //Button 1
        Label label = new Label("Hello World");
        Button button1 = new Button("go to scene 2");
        button1.setOnAction(event -> window.setScene(scene2));

        //Layout 1 - children are laid out in vertical column
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label, button1);
        scene1 = new Scene(layout1, 200, 200);

        //Button 2
        Button button2 = new Button("This scene sucks, go back to scene 1");
        button2.setOnAction(event -> window.setScene(scene1));

        //layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);
        window.setTitle("title here");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}