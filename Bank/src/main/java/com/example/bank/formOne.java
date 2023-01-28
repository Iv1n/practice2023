package com.example.bank;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.bank.Actions;
import com.example.bank.Clients;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Clients, Double> remainder;

    @FXML
    private TableView<Clients> table;

    DataBaseHendler dataBase = new DataBaseHendler();
    private final ObservableList<Clients> data = FXCollections.observableArrayList();

    @FXML
    void initialize() {
date();
setD();
    }

    private void date(){
        ResultSet user = dataBase.getL();
        try {
            while (user.next()){
                Clients clients = new Clients(
                user.getString(1),
                user.getString(2),
                user.getDouble(3));
                data.add(clients);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setD(){
        check.setCellValueFactory(new PropertyValueFactory<>("account"));
        initials.setCellValueFactory(new PropertyValueFactory<>("name"));
        remainder.setCellValueFactory(new PropertyValueFactory<>("reminder"));
        table.setItems(data);
    }
}