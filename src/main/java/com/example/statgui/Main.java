package com.example.statgui;

import com.example.statgui.controller.calculator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("calculator.fxml"));
        fxmlLoader.load();
        calculator calculatorHandle = fxmlLoader.getController();
        calculatorHandle.initData(stage);

        stage.setTitle("Stat Calculator!");
        stage.setScene(new Scene(fxmlLoader.getRoot(), 600,400));
        stage.show();
    }

    @Override
    public void stop() throws Exception {

    }

    public static void main(String[] args) {
        launch();
    }
}