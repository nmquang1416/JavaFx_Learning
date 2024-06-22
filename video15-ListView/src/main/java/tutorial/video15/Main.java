package tutorial.video15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("Video 15 - ListView");
        window.setResizable(false);
        button = new Button("Submit");

        listView = new ListView<>();
        listView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(event -> buttonClicked());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked() {
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for (String movie : movies) {
            message += movie + "\n";
        }
        System.out.println(message);
    }

    public static void main(String[] args) {
        launch();
    }
}