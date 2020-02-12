package com.bendaten.trainer.chapter13;

public class Producer implements Runnable {

    Value v;

    public Producer(Value v) {
        this.v = v;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;

        while (true) {
            v.put(i++);
            try {Thread.sleep(3000);} catch (Exception e) { /* nothing */ }
        }
    }
}
