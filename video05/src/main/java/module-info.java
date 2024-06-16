module org.openjfx.video05 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.video05 to javafx.fxml;
    exports org.openjfx.video05;
}