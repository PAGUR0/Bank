package com.company;

public class Account extends Thread {

    int balance;

    Account(int balance){
        this.balance = balance;
    }

    void addBalance(int add){
        balance += add;
    }

    void subBalance(int sub){
        balance -= sub;
    }
}
