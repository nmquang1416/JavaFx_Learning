package org.openjfx.video07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Main extends Application {
    Stage window;
    Button button;
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("video 07");

        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        button = new Button("Click Me");
        button.setOnAction(event -> closeProgram());

        VBox layout = new VBox();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public void closeProgram(){
        Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if(answer){
            window.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}