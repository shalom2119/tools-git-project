package com.example.statgui.state;

import com.example.statgui.controller.calculator;
import javafx.scene.chart.XYChart;
import javafx.button.Button;

public class meanState extends State {


    public meanState(calculator handle) {
        super(handle);
    }

    @Override
    public void calculate(){

        int counter = 0;
        float sum = 0;
        float mean = 0;
            for (XYChart.Data<String, Number> data : handle.getDataSet().getData()) {
                sum += data.getYValue().floatValue();
                counter++;
            }
        if(counter >0)
            mean = sum/counter;
        

        handle.paramValue.setText(String.valueOf(mean));

    }
    
}

