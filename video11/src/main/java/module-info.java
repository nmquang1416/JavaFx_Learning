module tutorial.video11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video11 to javafx.fxml;
    exports tutorial.video11;
}