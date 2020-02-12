package com.bendaten.trainer.chapter13;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter13 {
    protected static Logger logger = Logger.getLogger(Chapter13.class.getName());

    private static void sleep(int millis) {
        try {Thread.sleep(millis);} catch (Exception e) { logger.log(Level.SEVERE, "cannot sleep", e);}
    }

    private static void join(Thread t1, Thread t2) {
        try {
            if (t1.isAlive()) {
                t1.join();
            }
            if (t2.isAlive()) {
                t2.join();
            }
            String output = String.format("%nWaiting for threads '%s' and '%s' to finish", t1.getName(), t2.getName());
            logger.log(Level.INFO, output);
            output = String.format("With priorities %d and %d to finish%n", t1.getPriority(), t2.getPriority());
            logger.log(Level.INFO, output);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "cannot join", e);
            Thread.currentThread().interrupt();
        }
    }

    public static void work() {
        logger.log(Level.INFO, "In Chapter 13");

        Hi hi = new Hi();
        hi.setName("Hi Thread");
        hi.setPriority(Thread.MIN_PRIORITY);
        Hello hello = new Hello();
        hello.setName("Hello Thread");
        hello.setPriority(Thread.MAX_PRIORITY);

        hi.start();
        sleep(5);
        hello.start();

        join(hi, hello);

        Thread tHiR = new Thread(new HiR(), "tHiR Thread");
        Thread tHelloR = new Thread(new HelloR(), "tHelloR Thread");

        sleep(5);
        tHiR.start();
        sleep(5);
        tHelloR.start();

        join(tHiR, tHelloR);

        Thread hiLambda = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                logger.log(Level.INFO, "Hi Lambda");
                sleep(300);
            }
        });
        Thread helloLambda = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                logger.log(Level.INFO, "Hello Lambda");
                sleep(300);
            }
        });

        hiLambda.start();
        sleep(5);
        helloLambda.start();

        join(hiLambda, helloLambda);

        Counter async = new CounterAsync();
        Thread c1 = new Thread(new Increment1000(async));
        Thread c2 = new Thread(new Increment1000(async));

        c1.start();
        c2.start();
        join(c1, c2);

        String output = String.format("async counter got incremented %d times", async.getValue());
        logger.log(Level.INFO, output);

        Counter sync = new CounterSync();
        c1 = new Thread(new Increment1000(sync));
        c2 = new Thread(new Increment1000(sync));

        c1.start();
        c2.start();
        join(c1, c2);

        output = String.format("sync counter got incremented %d times", sync.getValue());
        logger.log(Level.INFO, output);

        Value v = new Value();
        new Producer(v);
        new Consumer(v);
    }
}
