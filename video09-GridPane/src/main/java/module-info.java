module tutorial.video09 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video09 to javafx.fxml;
    exports tutorial.video09;
}