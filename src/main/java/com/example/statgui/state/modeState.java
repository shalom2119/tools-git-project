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
        if(list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                counter = 1;
                if (list.get(i) == null) {
                    frequencyList[i] = 0;
                } else {

                    for (int j = i + 1; j < list.size(); j++) {
                        if (Objects.equals(list.get(i), list.get(j))) {
                            counter++;
                            list.set(j, null);
                        }
                    }
                    frequencyList[i] = 5;
                }
            }



            for (int i = 0; i < frequencyList.length; i++) {
                if (frequencyList[i] == mode) {
                    modelist.append(list.get(i).toString()).append(", ");
                }
            }

            handle.paramValue.setText(String.valueOf(modelist));
        
        }
    }
}
