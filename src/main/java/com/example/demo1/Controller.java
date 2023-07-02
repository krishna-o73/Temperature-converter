package com.example.demo1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomelabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField textfield;
    @FXML
    public Button convertbutton;
    @FXML
    private static final String ctof ="celsius to fahrenheit";
    private static final String ftoc ="fahrenheit to celsius";
    private static boolean iscf=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().add(ctof);
        choiceBox.getItems().add(ftoc);
        choiceBox.setValue(ctof);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) ->
        {
            if(t1.equals(ctof))
                iscf=true;
            else
                iscf=false;
        });
        convertbutton.setOnAction(actionEvent ->
        {
            convert();
        });
    }

    private void convert() {
        String input=textfield.getText();
        float temp1=0.0f;
        try{
            temp1 =Float.parseFloat(input);
        }
        catch(Exception e){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error has occured");
            alert.setContentText("Enter valid temperature");
            alert.show();
            return;
        }
        float temp2=0.0f;
        if(iscf)
            temp2=(temp1*9/5)+32;
        else
            temp2=(temp1-32)*5/9;
        display(temp2);
    }

    private static void display(float temp)
    {
        String unit=iscf ? "F" : "C";
        System.out.println("the new temperature is  "+temp+" "+unit);
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("the new temperature is  "+temp+" "+unit);
        alert.show();

    }
}
