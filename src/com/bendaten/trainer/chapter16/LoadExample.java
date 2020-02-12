package com.bendaten.trainer.chapter16;

public class LoadExample {
    static {
        System.out.println("static block in LoadExample");
    }

    {
        System.out.println("instance block in LoadExample");
    }
}
