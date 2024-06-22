package tutorial.video27;

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
        nameLabel.setId("bold-label");
        nameLabel.setStyle("-fx-text-fill: #ed3636;");
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
        loginButton.setStyle("-fx-font-size: 16pt; -fx-text-fill: #fff; -fx-background-color: #ed3636;");
        System.out.println(loginButton.styleProperty().getValue());
        GridPane.setConstraints(loginButton, 1, 2);

        //Sign up
        Button signUpButton = new Button("Sign Up");
        signUpButton.getStyleClass().add("button-sign-up");
        GridPane.setConstraints(signUpButton, 1, 3);

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, username, passwordLabel, password, loginButton, signUpButton);

        Scene scene = new Scene(grid, 300, 250);
//        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}