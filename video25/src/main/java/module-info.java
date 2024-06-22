module tutorial.video25 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video25 to javafx.fxml;
    exports tutorial.video25;
}