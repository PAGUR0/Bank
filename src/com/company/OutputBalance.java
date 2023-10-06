package com.company;

import java.util.concurrent.Semaphore;

public class OutputBalance extends Thread implements Runnable{

    Account account;
    Semaphore m;
    String payment;

    public OutputBalance(Account account, Semaphore m, String payment) {
        this.account = account;
        this.m = m;
        this.payment = payment;
    }

    @Override
    public void run() {
        System.out.println("Start");
        while (true) {
            try {
                m.acquire();
                if(account.balance >= 1000){
                    account.subBalance(1000);
                    System.out.println(payment);
                }
                m.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}