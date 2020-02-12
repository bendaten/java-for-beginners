package com.bendaten.trainer.chapter15;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter15 {
    protected static Logger logger = Logger.getLogger(Chapter15.class.getName());

    public static void work() {
        logger.log(Level.INFO, "In Chapter 15");

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.hello();

        Outer.InnerStatic is = new Outer.InnerStatic();
        is.hello();

        Anonymous anonymous = new Anonymous() {
            public void hello() {
                System.out.println("local hello");
            }
        };
        anonymous.hello();

        Anonymable ano = new Anonymable() {
            @Override
            public void hello() {
                System.out.println("interface hello");
            }
        };
        ano.hello();

        Anonymable lambda = () -> System.out.println("lambda hello");
        lambda.hello();

        System.out.println(new Person(Person.Type.STAFF, "Yehuda Tirosh"));
        System.out.println(new Person(Person.Type.STUDENT, "Daniel Ben David"));
        for (Person.Type val : Person.Type.values()) {
            System.out.println(val);
        }
    }
}
