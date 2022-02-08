package com.example.statgui.state;

import com.example.statgui.controller.calculator;

public abstract class State {
    protected calculator handle;

    public void calculate(){
        
    }
    public void show(){
        System.out.println("some text");
    }
}
