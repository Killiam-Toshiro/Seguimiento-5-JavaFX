module com.icesi.classroom {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.icesi.classroom to javafx.fxml;
    exports com.icesi.classroom;
    exports com.icesi.classroom.control;
    exports com.icesi.classroom.model;

    opens com.icesi.classroom.control to javafx.fxml;
}