module org.openjfx.video03 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.video03 to javafx.fxml;
    exports org.openjfx.video03;
}