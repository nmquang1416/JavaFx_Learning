module tutorial.video21 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video21 to javafx.fxml;
    exports tutorial.video21;
}