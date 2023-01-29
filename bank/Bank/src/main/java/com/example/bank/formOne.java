package com.example.bank;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
        addButton.setOnAction(event -> {
            addButton.getScene();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("addUser.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 320, 170));
            stage.setResizable(false);
            stage.show();
        });
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