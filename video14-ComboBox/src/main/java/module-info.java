module tutorial.video14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video14 to javafx.fxml;
    exports tutorial.video14;
}