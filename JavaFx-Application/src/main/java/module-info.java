module tutorial.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens tutorial.javafxapplication to javafx.fxml;
    exports tutorial.javafxapplication;
}