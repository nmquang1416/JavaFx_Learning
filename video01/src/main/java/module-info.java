module org.openjfx.video01 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.openjfx.video01 to javafx.fxml;
    exports org.openjfx.video01;
}