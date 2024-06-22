package tutorial.video29;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
        window.setTitle("video 29 - Binding");
//        window.setResizable(false);

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));
        System.out.println();
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue());

        x.setValue(9);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue());

        button = new Button("submit");

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