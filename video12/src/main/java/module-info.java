module tutorial.video12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video12 to javafx.fxml;
    exports tutorial.video12;
}