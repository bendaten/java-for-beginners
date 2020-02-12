package com.bendaten.trainer.chapter13;

public class HelloR implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello Runnable");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
