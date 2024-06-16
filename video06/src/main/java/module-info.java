module org.openjfx.video06 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.video06 to javafx.fxml;
    exports org.openjfx.video06;
}