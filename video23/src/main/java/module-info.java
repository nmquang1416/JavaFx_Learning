module tutorial.video23 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video23 to javafx.fxml;
    exports tutorial.video23;
}