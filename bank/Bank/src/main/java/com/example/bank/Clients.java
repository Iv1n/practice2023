package com.example.bank;

public class Clients {
    public int id;
    public String account,name;

    public Clients(int id, String account, String name) {
        this.id = id;
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
}
