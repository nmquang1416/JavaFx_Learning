module tutorial.video16 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video16 to javafx.fxml;
    exports tutorial.video16;
}