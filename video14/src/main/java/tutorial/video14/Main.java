package tutorial.video14;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    ComboBox<String> comboBox;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage window = primaryStage ;
        window.setTitle("video 14 - combo box");
        window.setResizable(false);
        Button button = new Button("Submit");

        //tao mot combobox
        comboBox = new ComboBox<>();

        //them gia tri cho combo box
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "St. Vincent",
                "BlackHat"
        );
        //set placeholder combobox
        comboBox.setPromptText("What is your favourite movie?");

        //set gia tri, co the chinh sua
        comboBox.setEditable(true);

        //lay gia tri vua nhap va in ra
        button.setOnAction(event -> printMovie());
        //lay gia tri va in ra  trong combobox
        comboBox.setOnAction(event -> notifycationMovie());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(comboBox, button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    private void printMovie() {
        System.out.println("User added new movie: " + comboBox.getValue());
    }
    private void notifycationMovie() {
        System.out.println("User select: " + comboBox.getValue());

    }




}