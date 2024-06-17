module tutorial.video08 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video08 to javafx.fxml;
    exports tutorial.video08;
}