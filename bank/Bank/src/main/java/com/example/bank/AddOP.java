package com.example.bank;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AddOP {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField account;

    @FXML
    private Button chancelButton;

    @FXML
    private Button check;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField name;

    @FXML
    private Button okButton;

    @FXML
    private TextField op_date;

    @FXML
    private TextField reminder;

    @FXML
    private TextField sum;

    DataBaseHendler dataBase = new DataBaseHendler();



    @FXML
    void initialize() {
        chancel();
        loadDate();
        pop();
        nam();

    }

    private void nam(){
        name.setText(Clients.na);
    }

    private void pop(){
        String nme = account.getText();
        dataBase.setName(nme);
    }
    private void loadDate(){
        account.setText(Clients.acc);
        Calendar calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD-HH-mm-ss");
        String date = formatter.format(calendar.getTime());

        Calendar calendar1 = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        String date1 = format.format(calendar1.getTime());
        op_date.setText(date1);}

    private void chancel() {
        chancelButton.setOnAction(event -> {
            chancelButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("action.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
        });
    }
}