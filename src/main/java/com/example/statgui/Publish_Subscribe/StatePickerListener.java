package com.example.statgui.Publish_Subscribe;

import com.example.statgui.controller.calculator;
import com.example.statgui.state.meanState;
import com.example.statgui.state.modeState;

public class StatePickerListener implements EventListner{
    calculator calculator;

    public StatePickerListener(calculator calculator) {
        this.calculator = calculator;

    }

    @Override
    public void update(Event eventType) {
        if(calculator.statePicker.getValue() == "mean")
        {
            calculator.param.setText("mean");
            calculator.setState(new meanState(calculator));
        }
        else if(calculator.statePicker.getValue() == "mode")
        {
            calculator.param.setText("mode");
            calculator.setState(new modeState(calculator));
        }
    }
}
