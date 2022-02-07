package com.example.statgui.state;

import com.example.statgui.controller.calculator;
import java.util.ArrayList;
import java.util.Objects;

public class modeState extends State {
    public modeState(calculator handle) {
        super(handle);
    }

    @Override
    public void calculate() {

        ArrayList<Float> list = handle.getDataArray();

        int frequencyList[] = new int[list.size()];
        int counter = 0;
        int mode = 0;
        StringBuilder modelist = new StringBuilder();

}
