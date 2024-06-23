package tutorial.javafxapplication;

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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Student");
        alert.setHeaderText("Delete Student");
        alert.setContentText("Are you sure you want to delete this student?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            for (Student student : students) {
                if (selectedStudents.contains(student)) {
                    studentsRepository.delete(student.getId());
                    System.out.println("Student ID: " + student.getId());
                }
            }
        }
        students.removeAll(selectedStudents);
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
