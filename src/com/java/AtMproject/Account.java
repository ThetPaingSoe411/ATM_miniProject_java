package com.java.AtMproject;

public  class Account {
    private int id;
    private String name;
    private Double amount;
    private AccountType accountType;

    public Account(int id, String name, Double amount,AccountType accountType) {
        this.id = id;
        this.name = name;
        this.amount = amount;
       this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String displayAccount() {
        return id+" "+name+" "+amount+" "+accountType;
    }
}
