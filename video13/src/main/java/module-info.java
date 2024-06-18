module tutorial.video13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video13 to javafx.fxml;
    exports tutorial.video13;
}