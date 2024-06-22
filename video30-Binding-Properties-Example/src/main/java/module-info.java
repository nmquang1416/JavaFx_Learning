module tutorial.video30 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video30 to javafx.fxml;
    exports tutorial.video30;
}