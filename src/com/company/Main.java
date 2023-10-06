package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Semaphore m = new Semaphore(1);
        Account account = new Account(250);
        InputBalance inputBalance = new InputBalance(account, m);
        OutputBalance outputBalance = new OutputBalance(account, m, "Купил сырок");
        inputBalance.start();
        outputBalance.start();
    }
}

