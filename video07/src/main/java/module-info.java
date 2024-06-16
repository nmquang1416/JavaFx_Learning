module org.openjfx.video07 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.video07 to javafx.fxml;
    exports org.openjfx.video07;
}