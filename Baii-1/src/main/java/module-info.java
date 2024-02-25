module com.example.baii1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.baii1 to javafx.fxml;
    exports com.example.baii1;
}