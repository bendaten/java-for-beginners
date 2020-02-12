package com.bendaten.trainer.chapter13;

public class CounterAsync implements Counter {
    private int value;

    public CounterAsync() { this.value = 0; }

    public int getValue() { return this.value; }

    public void increment() { this.value++; }
}
