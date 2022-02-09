package com.example.statgui.state;

import com.example.statgui.controller.calculator;
import javafx.scene.chart.XYChart;

public class meanState extends State {


    public meanState(calculator handle) {
        super(handle);
    }
<<<<<<< HEAD

    @Override
    public void calculate(){
=======
      @Override
    public void calculate() {
>>>>>>> feature/add-method

        int counter = 0;
        float sum = 0;
        float mean = 0;
            for (XYChart.Data<String, Number> data : handle.getDataSet().getData()) {
                sum += data.getYValue().floatValue();
                counter++;
            }
        if(counter >0)
            mean = sum/counter;

<<<<<<< HEAD
        setText(String.valueOf(mean));
        
=======
        handle.paramValue.setText(String.valueOf(mean));
>>>>>>> feature/add-method
    }
    
}

