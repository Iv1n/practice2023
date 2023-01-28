package com.example.bank;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.bank.Actions;
import com.example.bank.Clients;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class formOne {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<Clients, String> check;

    @FXML
    private TableColumn<Clients, String> initials;

    @FXML
    private TableColumn<Actions, Double> remainder;

    @FXML
    void initialize() {

    }

}