package com.example.statgui.Publish_Subscribe;

import com.example.statgui.controller.calculator;
import javafx.scene.chart.XYChart;

import java.util.Objects;

public class BarchartListener implements EventListner{

    private calculator calculator;

    public BarchartListener(calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void update(Event eventType) {

        if (calculator.dataInputField.getText() != "" && calculator.dataName.getText() != ""){
            for (XYChart.Data<String, Number> data : calculator.getDataSet().getData()) {
                if(Objects.equals(data.getXValue(), calculator.dataName.getText()))
                    return;
            }
            calculator.getDataSet().getData().add(new XYChart.Data<>(calculator.dataName.getText(), Float.parseFloat(calculator.dataInputField.getText())));
        }
        else {
            calculator.dataInputField.setText("no value");
            calculator.dataName.setText("no value");
        }

    }
}
