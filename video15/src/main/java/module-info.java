module tutorial.video15 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video15 to javafx.fxml;
    exports tutorial.video15;
}