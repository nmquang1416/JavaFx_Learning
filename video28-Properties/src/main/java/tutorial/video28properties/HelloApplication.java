package tutorial.video28properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage window;
    Button button;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("video 28 properties");
        window.setResizable(false);

        //cach 1
//        Person quang = new Person();
//        quang.setFirstName("Quang");

        //Property
        Person2 quang = new Person2();

        quang.firstNameProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Name change to (new value): " + newValue);
            System.out.println("first name change (firstNameProperty()): " + quang.firstNameProperty());
            System.out.println("getFirstName(): " + quang.getFirstName());
        });

        button = new Button("submit");
        button.setOnAction(event -> {
            quang.setFirstName("Quang");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}