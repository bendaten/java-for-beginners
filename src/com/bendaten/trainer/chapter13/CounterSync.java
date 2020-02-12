package com.bendaten.trainer.chapter13;

public class CounterSync implements Counter {
    private int value;

    public CounterSync() { this.value = 0; }

    public int getValue() { return this.value; }

    public synchronized void increment() { this.value++; }
}
