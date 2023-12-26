package com.example.lab_3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField xAxisTextField;

    @FXML
    private TextField yAxisTextField;

    @FXML
    private TextField NumberOfVisible;


    private final Plot plot =
            new Plot("X", 0, 20, 10, "Y", 0, 20, 2);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.getChildren().addAll(plot);
    }

    public void addPoint() {
        plot.addPoint(new Point2D(Double.parseDouble(xAxisTextField.getText()), Double.parseDouble(yAxisTextField.getText())));
    }

    public void getNumberOfVisiblePoints() {
        plot.renderLastPoints(Integer.valueOf(NumberOfVisible.getText()));
        Map<Long, Point2D> dotTime = plot.getLastPoints(Integer.valueOf(NumberOfVisible.getText()));
        System.out.println(dotTime);
        for(int i = 0; i < dotTime.size(); i++) {
            System.out.println(String.format("%1$TH:%1$TM:%1$TS", dotTime.keySet().toArray()[i]) + dotTime.values().toArray()[i]);
        }
    }


    public void getAllPoints() {
        plot.renderAllPlot();
    }
}