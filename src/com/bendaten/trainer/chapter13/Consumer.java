package com.bendaten.trainer.chapter13;

public class Consumer implements Runnable {

    Value v;

    public Consumer(Value v) {
        this.v = v;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        while (true) {
            v.get();
        }
    }
}
