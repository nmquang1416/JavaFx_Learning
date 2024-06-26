package tutorial.javafxapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        //Main menu bar
        MenuBar menuBar = new MenuBar();

        StudentController studentController = new StudentController();
        Student student = new Student();
        TableView<Student> firstLoadTable = studentController.showAllStudents();

        window = stage;
        window.setTitle("Students Table");
//        window.setResizable(false);

        menuBar.getMenus().addAll(studentController.menuFile(), studentController.menuEdit(), studentController.menuHelp());

        Button buttonAdd = new Button("Add Student");
        buttonAdd.setOnAction(event -> studentController.createNewStudent());

        Button buttonDelete = new Button("Delete Student");
        buttonDelete.setOnAction(event -> {
            studentController.deleteStudent();
        });

        Button buttonEdit = new Button("Edit Student");
        buttonEdit.setOnAction(event -> studentController.editStudent());

        TextField findInput = new TextField();
        findInput.setPromptText("Find Student by Id");
        findInput.setOnAction(event -> studentController.findStudent(findInput.getText()));

        HBox hbox = new HBox();
        hbox.getChildren().addAll(buttonAdd, buttonDelete, buttonEdit, findInput);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar, hbox, firstLoadTable);
        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }
}