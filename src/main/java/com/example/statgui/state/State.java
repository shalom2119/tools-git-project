package com.example.statgui.state;

import com.example.statgui.controller.calculator;

public abstract class State {
    protected calculator handle;
    public State(calculator handle) {
        this.handle = handle;
    }

    public abstract void calculate();

    public void update (){
        
    }

}
