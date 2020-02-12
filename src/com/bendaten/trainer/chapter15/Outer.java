package com.bendaten.trainer.chapter15;

public class Outer {
    public class Inner {
        public void hello() {
            System.out.println("Hello");
        }
    }

    public static class InnerStatic {
        public void hello() {
            System.out.println("Static Hello");
        }
    }
}
