module com.example.statgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.statgui to javafx.fxml;
    exports com.example.statgui;
    exports com.example.statgui.controller;
    opens com.example.statgui.controller to javafx.fxml;
    exports com.example.statgui.Publish_Subscribe;
    opens com.example.statgui.Publish_Subscribe to javafx.fxml;
}