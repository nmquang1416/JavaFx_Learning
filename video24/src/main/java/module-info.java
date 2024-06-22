module tutorial.video24 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video24 to javafx.fxml;
    exports tutorial.video24;
}