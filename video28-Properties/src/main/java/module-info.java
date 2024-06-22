module tutorial.video28properties {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video28properties to javafx.fxml;
    exports tutorial.video28properties;
}