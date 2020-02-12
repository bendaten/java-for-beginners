package com.bendaten.trainer.chapter13;

public class Value {

    private int val;
    private boolean valueSet;

    public Value() {
        val = 0;
        valueSet = false;
    }

    public synchronized void put(int value) {
        while (valueSet) {
            try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        this.val = value;
        System.out.println(String.format("Thread %s put %d", Thread.currentThread().getName(), value));
        valueSet = true;
        notify();
    }

    public synchronized void get() {
        while (!valueSet) {
            try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println(String.format("Thread %s get %d%n", Thread.currentThread().getName(), this.val));
        valueSet = false;
        notify();
    }
}
