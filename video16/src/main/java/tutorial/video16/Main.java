package tutorial.video16;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage window;
    TreeView<String> tree;
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("Video 16");
        window.setResizable(false);

        TreeItem<String> root, bucky, megan;

        //root
        root = new TreeItem<>();
//        root.setExpanded(true);

        //bucky
        bucky = makeBranch("bucky", root);
        makeBranch("hello1", bucky);
        makeBranch("hello2", bucky);
        makeBranch("hello3", bucky);

        //megan
        megan = makeBranch("megan", root);
        makeBranch("hello4", megan);
        makeBranch("hello5", megan);
        makeBranch("hello6", megan);

        //create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(newValue.getValue());
            }
        });

//        tree.getSelectionModel().select(bucky);
//        tree.getSelectionModel().select(megan);

        //layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
//        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        launch();
    }
}