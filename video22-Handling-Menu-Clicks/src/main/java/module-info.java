module tutorial.video22 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video22 to javafx.fxml;
    exports tutorial.video22;
}