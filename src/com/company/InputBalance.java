package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class InputBalance extends Thread implements Runnable {

    Random random = new Random();

    Account account;
    Semaphore m;

    public InputBalance(Account account, Semaphore m) {
        this.account = account;
        this.m = m;
    }

    @Override
    public void run() {
        while (true){
            try {
                m.acquire();
                account.addBalance(random.nextInt(100));
                System.out.println(account.balance);
                m.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
