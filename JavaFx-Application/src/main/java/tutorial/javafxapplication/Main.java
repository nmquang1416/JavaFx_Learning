package tutorial.javafxapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
        StudentController studentController = new StudentController();
        Student student = new Student();
        window = stage;
        window.setTitle("Students Table");
        window.setResizable(false);

        Button buttonAdd = new Button("Add Student");
        buttonAdd.setOnAction(event -> studentController.createNewStudent());

        Button buttonDelete = new Button("Delete Student");
        buttonDelete.setOnAction(event -> {studentController.deleteStudent();});

        Button buttonEdit = new Button("Edit Student");
        buttonEdit.setOnAction(event -> {});

        TextField findStudent = new TextField();
        findStudent.setPromptText("Find Student");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(buttonAdd, buttonDelete, buttonEdit, findStudent);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, studentController.showAllStudents());
        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }
}