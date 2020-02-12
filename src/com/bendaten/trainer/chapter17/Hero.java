package com.bendaten.trainer.chapter17;

public class Hero implements Actor {

    @Override
    public void act() {
        System.out.println("To be or not to be - this is the question");
    }

    @Override
    public void speak() {
        System.out.println("Ask not what your country can do for you – ask what you can do for your country");
    }
}
