package tutorial.javafxapplication;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.CssParser;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

public class StudentController {
    Stage window = new Stage();
    ConfirmBox confirmBox = new ConfirmBox();
    StudentsRepository studentsRepository = new StudentsRepository();

    TextField nameField = new TextField();
    TextField ageField = new TextField();
    TextField addressField = new TextField();

    TableView<Student> tableView;

    public TableView<Student> showAllStudents() {
        StudentsRepository studentsRepository = new StudentsRepository();

        //tao cac cot
        TableColumn<Student, Long> idColumn = new TableColumn<>("Id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setMinWidth(100);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Student, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(200);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        //dua thong tin vao bang
        ObservableList<Student> students = FXCollections.observableArrayList();
        students.addAll(studentsRepository.findAll());

        //Tao va add vao bang
        tableView = new TableView<>();
        tableView.setItems(students);
        tableView.getColumns().addAll(idColumn, nameColumn, ageColumn, addressColumn);
        tableView.setEditable(true);
        return tableView;
    }

    public void createNewStudent() {
        Text errorEmpty = new Text();
        Student student = new Student();

        window.setTitle("Create New Student");
        window.setMinWidth(400);
        window.setResizable(false);
//        window.initModality(Modality.APPLICATION_MODAL);

        Text title = new Text("Create New Student");

        Label nameLabel = new Label("Name");
        nameField.setPromptText("Your Name...");

        Label ageLabel = new Label("Age");
        ageField.setPromptText("Your Age...");

        Label addressLabel = new Label("Address");
        addressField.setPromptText("Your Address...");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            if (nameField.getText().isEmpty()) {
                errorEmpty.setText("Name is Empty");
            } else if (ageField.getText().isEmpty()) {
                errorEmpty.setText("Age is Empty");
            } else if (addressField.getText().isEmpty()) {
                errorEmpty.setText("Address is Empty");
            } else {
                student.setName(nameField.getText());
                student.setAge(Integer.parseInt(ageField.getText()));
                student.setAddress(addressField.getText());

                if (confirmedBox(saveButton.getText())){
                    studentsRepository.save(student);
                    tableView.getItems().add(student);
                    ObservableList<Student> students = FXCollections.observableArrayList();
                    students.addAll(studentsRepository.findAll());
                    tableView.setItems(students);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success saved");
                    alert.setHeaderText("Saved");
                    alert.setContentText("Student Saved");
                    alert.showAndWait();
                    clear();
                }
            }
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> window.close());

        VBox field = new VBox();
        VBox label = new VBox();
        VBox text = new VBox();
        text.getChildren().addAll(title);
        label.getChildren().addAll(nameLabel, ageLabel, addressLabel);
        field.getChildren().addAll(nameField, ageField, addressField);
        text.setAlignment(Pos.CENTER);
        label.setAlignment(Pos.CENTER_RIGHT);
        field.setAlignment(Pos.CENTER);
        text.setSpacing(16);
        label.setSpacing(24);
        field.setSpacing(16);

        HBox layout = new HBox();
        layout.getChildren().addAll(label, field);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(8);

        HBox buttons = new HBox();
        buttons.getChildren().addAll(saveButton, cancelButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(8);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text, layout, buttons);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(24);

        Scene scene = new Scene(vbox, 300, 250);
        window.setScene(scene);
        window.showAndWait();
    }

    public void deleteStudent() {
        ObservableList<Student> students, selectedStudents;
        students = tableView.getItems();
        selectedStudents = tableView.getSelectionModel().getSelectedItems();
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Delete Student");
//        alert.setHeaderText("Delete Student");
//        alert.setContentText("Are you sure you want to delete this student?");
//        Optional<ButtonType> result = alert.showAndWait();
//        System.out.println(result.get());
        if (confirmedBox("Delete")) {
            for (Student student : students) {
                if (selectedStudents.contains(student)) {
                    studentsRepository.delete(student.getId());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Delete Notify");
                    alert.setHeaderText("Delete done!");
                    alert.setContentText("Student " + student.getName() + " are delete!");
                    alert.showAndWait();
                    System.out.println("Delete Student ID: " + student.getId());
                }
            }
            students.removeAll(selectedStudents);
        }
    }

    public void editStudent(){
        ObservableList<Student> students, selectedStudents;
        students = tableView.getItems();
        selectedStudents = tableView.getSelectionModel().getSelectedItems();
        Text errorEmpty = new Text();
        Student student = new Student();

        window.setTitle("Edit Student");
        window.setMinWidth(400);
        window.setResizable(false);
//        window.initModality(Modality.APPLICATION_MODAL);

        for (Student studentChoice : students) {
            if (selectedStudents.contains(studentChoice)) {
                student = studentChoice;
                System.out.println("before");
                System.out.println("Edit Student ID: " + student.getId());
                System.out.println("Edit Student name: " + student.getName());
                System.out.println("Edit Student address: " + student.getAddress());
                System.out.println("Edit Student age: " + student.getAge());
            }
        }

        Text title = new Text("Edit Student");

        Label nameLabel = new Label("Name");
        nameField.setText(student.getName());

        Label ageLabel = new Label("Age");
        ageField.setText(String.valueOf(student.getAge()));

        Label addressLabel = new Label("Address");
        addressField.setText(student.getAddress());

        Button updateButton = new Button("Update");

        Student finalStudent = student;

        updateButton.setOnAction(event -> {
            finalStudent.setName(nameField.getText());
            finalStudent.setAge(Integer.parseInt(ageField.getText()));
            finalStudent.setAddress(addressField.getText());
            studentsRepository.update(finalStudent);

            if (confirmedBox(updateButton.getText())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Student Update notify" );
                alert.setHeaderText("Student Updated");
                alert.setContentText("Student Updated successfully!" );
                alert.showAndWait();

                System.out.println("after");
                System.out.println("Edit Student ID: " + finalStudent.getId());
                System.out.println("Edit Student name: " + finalStudent.getName());
                System.out.println("Edit Student address: " + finalStudent.getAddress());
                System.out.println("Edit Student age: " + finalStudent.getAge());

                ObservableList<Student> studentsList = FXCollections.observableArrayList();
                studentsList.addAll(studentsRepository.findAll());
                tableView.setItems(studentsList);
            }
        });


        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> window.close());

        VBox field = new VBox();
        VBox label = new VBox();
        VBox text = new VBox();
        text.getChildren().addAll(title);
        label.getChildren().addAll(nameLabel, ageLabel, addressLabel);
        field.getChildren().addAll(nameField, ageField, addressField);
        text.setAlignment(Pos.CENTER);
        label.setAlignment(Pos.CENTER_RIGHT);
        field.setAlignment(Pos.CENTER);
        text.setSpacing(16);
        label.setSpacing(24);
        field.setSpacing(16);

        HBox layout = new HBox();
        layout.getChildren().addAll(label, field);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(8);

        HBox buttons = new HBox();
        buttons.getChildren().addAll(updateButton, cancelButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(8);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text, layout, buttons);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(24);

        Scene scene = new Scene(vbox, 300, 250);
        window.setScene(scene);
        window.showAndWait();
    }


    private void clear(){
        nameField.clear();
        ageField.clear();
        addressField.clear();
    }

    private Boolean confirmedBox(String nameFeature){
        return confirmBox.confirmBox("Are you sure?", "Do you really want to " + nameFeature + " this student?");
    }

    private boolean isInt(TextField input, String message){
        try {
            int value = Integer.parseInt(input.getText());
            System.out.println("Value: " + value);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(message + " is not a number");
            return false;
        }
    }


}
