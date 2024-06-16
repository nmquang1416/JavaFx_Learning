module org.openjfx.video02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.video02 to javafx.fxml;
    exports org.openjfx.video02;
}