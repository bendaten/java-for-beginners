package com.bendaten.trainer.chapter17;

public interface Actor {

    void act();

    void speak();

    default void joke() {
        System.out.println("Knock Knock. Who's there? Doris! Doris who? Door is locked that's why I'm knocking!");
    }
}
