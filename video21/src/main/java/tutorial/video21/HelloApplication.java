package tutorial.video21;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage window;
    BorderPane layout;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("video 21");

        //File menu
        Menu fileMenu = new Menu("File");

        //Menu items
        fileMenu.getItems().add(new MenuItem("New Project"));
        fileMenu.getItems().add(new MenuItem("Open Project"));
        fileMenu.getItems().add(new MenuItem("Import Project"));

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}