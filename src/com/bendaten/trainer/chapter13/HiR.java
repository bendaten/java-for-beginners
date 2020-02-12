package com.bendaten.trainer.chapter13;

public class HiR implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi Runnable");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
