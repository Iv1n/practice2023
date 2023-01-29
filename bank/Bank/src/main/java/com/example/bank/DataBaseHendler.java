package com.example.bank;

import java.sql.*;

import static com.example.bank.Actions.id_client;
public class DataBaseHendler extends Config{

    private static Connection con;
    private static ResultSet rs;

    private static Statement stmt;
    private PreparedStatement preparedStatement;

    public Connection getDbConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    public ResultSet getL() {
        String getUser = "select c.account, c.name, act.reminder from (select id_client, max(op_date) as op_date from bank.actions group by id_client) as a\n" +
                "inner join bank.actions act on a.id_client=act.id_client and a.op_date=act.op_date inner join bank.clients as c on a.id_client=c.id";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getUser);
            rs = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public  void signClients(Clients clients){
        String insert = "insert into bank.clients (account,name) values(?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, clients.getAccount());
            preparedStatement.setString(2,clients.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void infUser(String account,String name){
        try{
            getDbConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id from bank.clients where account=" + "'" + account +
                    "'" + " and name=" + "'" + name + "'");
            while (rs.next()){
                id_client = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUActions(Actions actions){
        String insert = "insert into bank.actions (id_client,deposit,withdrawl,reminder,op_date) values (" + id_client + ",0,0,?,?)";
        try{
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setDouble(1,actions.getReminder());
            preparedStatement.setDate(2, actions.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
