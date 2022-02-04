package com.example.statgui.controller;

import com.example.statgui.Publish_Subscribe.BarchartListener;
import com.example.statgui.Publish_Subscribe.Event;
import com.example.statgui.Publish_Subscribe.NotificationService;
import com.example.statgui.Publish_Subscribe.StatePickerListener;
import com.example.statgui.state.State;
import com.example.statgui.state.meanState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class calculator {

    @FXML
    public CategoryAxis catAxisCategory;
    @FXML
    public NumberAxis numAxisValue;
    @FXML
    public Pane board;
    @FXML
    public SplitPane splitPane;
    @FXML
    public AnchorPane topAnchor;
    @FXML
    public AnchorPane bottomAnchor;
    @FXML
    private BarChart<String, Number> chart;
    @FXML
    public Label nameLabel;
    @FXML
    public TextField dataName;
    @FXML
    public Label dataPointLabel;
    @FXML
    public TextField dataInputField;
    @FXML
    private Button addPoint;
    @FXML
    public Label param;
    @FXML
    public Label paramValue;
    @FXML
    public Label pickerLabel;
    @FXML
    public ChoiceBox<String> statePicker;

    private State state = new meanState(this);;
    private BarchartListener barchartListener;
    private StatePickerListener statePickerListener;
    private NotificationService notificationService = new NotificationService();

    private XYChart.Series<String, Number> dataSet = new XYChart.Series<>();
    private String[] menu = {"mean", "mode"};

    public XYChart.Series<String, Number> getDataSet() {
        return dataSet;
    }

    public ArrayList<Float> getDataArray(){

        ArrayList<Float> list = new ArrayList<>();

        for (XYChart.Data<String, Number> data : getDataSet().getData()) {
            list.add(data.getYValue().floatValue());
        }

        return list;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void initData(Stage stage){

        barchartListener = new BarchartListener(this);
        statePickerListener = new StatePickerListener(this);
        notificationService.subscribe(barchartListener, Event.ADD);
        notificationService.subscribe(statePickerListener, Event.PICKER_CHANGE);


        param.setText("mean");
        dataSet.setName("Date Set");
        chart.getData().add(dataSet);

        catAxisCategory = new CategoryAxis();
        numAxisValue = new NumberAxis();

        statePicker.getItems().addAll(menu);
        statePicker.setOnAction(this::changeStateAction);

        chart.prefWidthProperty().bind(topAnchor.prefWidthProperty());
        chart.prefHeightProperty().bind(topAnchor.prefHeightProperty());
        topAnchor.prefWidthProperty().bind(splitPane.prefWidthProperty());
        splitPane.prefWidthProperty().bind(board.prefWidthProperty());
        splitPane.prefHeightProperty().bind(board.prefHeightProperty());
        board.prefWidthProperty().bind(stage.widthProperty());
        board.prefHeightProperty().bind(stage.heightProperty());

    }

    public void calculate(){
        state.calculate();
    }

    public void addAction(ActionEvent actionEvent) {

        notificationService.notifyListners(Event.ADD);
        calculate();

    }

    public void changeStateAction(ActionEvent actionEvent){

        notificationService.notifyListners(Event.PICKER_CHANGE);
        calculate();
    }
}