module tutorial.video17 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video17 to javafx.fxml;
    exports tutorial.video17;
}