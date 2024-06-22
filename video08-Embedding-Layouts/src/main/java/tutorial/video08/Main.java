package tutorial.video08;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Main extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("thenewboston");
        //tao menu top theo chieu ngang (horizontal)
        HBox topMenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("Views");
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
        //tao menu theo chieu doc (vertical)
        VBox leftMenu = new VBox();
        Button buttonD = new Button("D");
        Button buttonE = new Button("E");
        Button buttonF = new Button("F");
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
        //set vi tri dua tren border cua man hinh
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);
        //add vao scene va hien thi
        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Test lai video 07
//    Stage window;
//    Button button;
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        window = primaryStage;
//        window.setTitle("video 08");
//        window.setOnCloseRequest(event -> {
//            event.consume();
//            closeProgram();
//        });
//        button = new Button("Click me");
//        button.setOnAction(actionEvent -> closeProgram());
//
//        VBox layout = new VBox();
//        layout.getChildren().add(button);
//        layout.setAlignment(Pos.CENTER);
//        Scene scene = new Scene(layout, 300, 200);
//        window.setScene(scene);
//        window.show();
//    }
//
//    public void closeProgram(){
//        Boolean answer = ConfirmBox.display("Title", "Are you sure?");
//        if (answer){
//            window.close();
//        };
//    }
}