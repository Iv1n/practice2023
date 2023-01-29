package com.example.bank;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddUser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancellation;

    @FXML
    private TextField check;

    @FXML
    private TextField nameU;

    @FXML
    private Button okButton;

    @FXML
    private TextField sum;

    DataBaseHendler dbHandler = new DataBaseHendler();
    @FXML
    void initialize() {
        okButton.setOnAction(event -> {
            addUser();
            addUAc();
            dbHandler.infUser(check.getText(),nameU.getText());
            okButton.getScene().getWindow().hide();
        });

    }
    private void addUser(){
        String account = check.getText();
        String name = nameU.getText();
        Clients clients = new Clients(account,name);
        dbHandler.signClients(clients);
    }

    private void addUAc(){
        Double reminder = Double.valueOf(sum.getText());
        System.out.println(reminder);
        Date date = new Date();
        System.out.println(date);
        Actions actions = new Actions(reminder,date);
        dbHandler.addUActions(actions);
    }
}
