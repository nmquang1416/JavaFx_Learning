package tutorial.video26;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    Stage window;
    GridPane grid;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("video 25");

        //GridPane with 8px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(8, 8, 8, 8));
        grid.setHgap(8);
        grid.setVgap(8);

        //Name label - constrains use child, column, row
        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name input
        TextField username = new TextField("");
        username.setPromptText("Username");
        GridPane.setConstraints(username, 1, 0);

        //Password Label
        Label passwordLabel = new Label("Password");
        GridPane.setConstraints(passwordLabel, 0, 1);

        //Password input
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        GridPane.setConstraints(password, 1, 1);

        //Login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, username, passwordLabel, password, loginButton);

        Scene scene = new Scene(grid, 300, 250);
        scene.getStylesheets().add("tutorial/video26/style.css");
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}