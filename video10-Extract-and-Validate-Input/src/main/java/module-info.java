module tutorial.video10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video10 to javafx.fxml;
    exports tutorial.video10;
}