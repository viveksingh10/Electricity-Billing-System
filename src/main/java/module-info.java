module Frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens Frontend to javafx.fxml;
    exports Frontend;
}