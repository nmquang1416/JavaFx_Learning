package tutorial.video23;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    Stage window;
    BorderPane layout;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("Hello World");

        //Menu
        Menu fileMenu = new Menu("File");

        //Menu items
        MenuItem newFile = new MenuItem("New");
        newFile.setOnAction(event -> System.out.println("Create a new file"));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open"));
        fileMenu.getItems().add(new MenuItem("Import"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Setting"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        //Edit Menu
        Menu editMenu = new Menu("_Edit");

        MenuItem cutItem = new MenuItem("Cut");
        cutItem.setOnAction(event -> System.out.println("Cutting"));
        editMenu.getItems().add(cutItem);
        MenuItem copyItem = new MenuItem("Copy");
        copyItem.setOnAction(event -> System.out.println("Copying"));
        editMenu.getItems().add(copyItem);
        MenuItem pasteItem = new MenuItem("Paste");
        pasteItem.setOnAction(event -> System.out.println("Pasting"));
        editMenu.getItems().add(pasteItem);
        pasteItem.setDisable(true);

        //Help Menu
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show lines");
        showLines.setOnAction(event -> showCheckMenu(showLines));
        CheckMenuItem autoSave = new CheckMenuItem("Auto save");
        autoSave.setOnAction(event -> showCheckMenu(autoSave));
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Main Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    public void showCheckMenu(CheckMenuItem checkMenuItemMenuItem){
        if (checkMenuItemMenuItem.isSelected()){
            System.out.println(checkMenuItemMenuItem.getText() + "Showing lines");
        } else {
            System.out.println(checkMenuItemMenuItem.getText() + "Hiding lines");
        }
    }

}