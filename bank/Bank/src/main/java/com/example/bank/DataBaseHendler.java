package com.example.bank;

import java.sql.*;

public class DataBaseHendler extends Config{

    private static Connection con;
    private static ResultSet rs;

    public Connection getDbConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection: yes");
        } catch (SQLException e) {
            System.out.println("Connection: no");
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


}
