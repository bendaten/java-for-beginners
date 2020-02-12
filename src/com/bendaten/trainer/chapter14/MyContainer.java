package com.bendaten.trainer.chapter14;

public class MyContainer<T> {
    T value;  // T can be substituted by any type

    public MyContainer(T value) {
        this.value = value;
    }

    public void show() {
        System.out.println(value.getClass().getName());
    }
}
