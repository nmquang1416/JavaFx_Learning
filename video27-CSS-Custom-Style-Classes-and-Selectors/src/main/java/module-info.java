module tutorial.video27 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial.video27 to javafx.fxml, javafx.graphics, javafx.controls ;
    exports tutorial.video27;
}