module org.openjfx.video04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.video04 to javafx.fxml;
    exports org.openjfx.video04;
}