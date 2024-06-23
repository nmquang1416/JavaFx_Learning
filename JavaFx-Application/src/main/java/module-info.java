module tutorial.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens tutorial.javafxapplication to javafx.fxml;
    exports tutorial.javafxapplication;
}