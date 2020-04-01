module org.wachholz {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.wachholz to javafx.fxml;
    exports org.wachholz;
}