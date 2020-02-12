package com.bendaten.trainer.chapter13;

public class Increment1000 implements Runnable {

    private Counter counter;

    public Increment1000(Counter counter) { this.counter = counter; }

    public void run() {
        for (int i = 0; i < 1000; i++) { counter.increment(); }
    }
}
