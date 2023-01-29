package com.example.bank;

import java.util.Date;

public class Actions {
    private int id;
    public static int id_client;
    private double deposit, withdrawal,reminder;
    private Date date;

    public Actions(double reminder, Date date) {
        this.reminder = reminder;
        this.date = date;
    }

    public Actions(int id, int id_client, double deposit, double withdrawal, double reminder, Date date) {
        this.id = id;
        this.id_client = id_client;
        this.deposit = deposit;
        this.withdrawal = withdrawal;
        this.reminder = reminder;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getReminder() {
        return reminder;
    }

    public void setReminder(double reminder) {
        this.reminder = reminder;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
