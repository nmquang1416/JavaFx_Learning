module tutorial.video20 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video20 to javafx.fxml;
    exports tutorial.video20;
}