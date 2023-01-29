package com.example.bank;

public class Clients {
    public int id;
    public double reminder;
    public String account,name;

    public Clients(String account, String name, double reminder) {
        this.reminder = reminder;
        this.account = account;
        this.name = name;
    }

    public Clients(String account, String name) {
        this.account = account;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getReminder() {
        return reminder;
    }

    public void setReminder(Double reminder) {
        this.reminder = reminder;
    }
}
