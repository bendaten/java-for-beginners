package com.bendaten.trainer.chapter14;

public class MyNumberContainer<T extends Number> {
    T value;  // T can be substituted only by class Number and its sub classes

    public MyNumberContainer(T value) {
        this.value = value;
    }

    public void show() {
        System.out.println(value.getClass().getName());
    }
}
