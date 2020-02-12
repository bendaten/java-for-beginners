package com.bendaten.trainer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter4 {
    protected static Logger logger = Logger.getLogger(Chapter4.class.getName());

    private static String toBinary(int number) {
        return Integer.toBinaryString(number).replace(' ', '0');
    }

    public static void work() {
        logger.log(Level.INFO, "\nChapter 4\n\nI am in a packaged class.");

        byte b = 8;
        // the expression b = b * 2.5 fails compilation because the rhs is double and the lhs is byte
        b *= 2.5;
        String output = String.valueOf(b);
        logger.log(Level.INFO, output);

        int five = 0B101;
        output = String.valueOf(five);
        logger.log(Level.INFO, output);

        logger.log(Level.INFO, "Pre and post increments");
        int counter = 5;
        output = String.format("counter = %d;", counter);
        logger.log(Level.INFO, output);
        output = String.format("print(counter++) -> %d", counter++);
        logger.log(Level.INFO, output);
        output = String.format("Yet counter = %d;", counter);
        logger.log(Level.INFO, output);
        output = String.format("print(++counter) -> %d", ++counter);
        logger.log(Level.INFO, output);

        b = 0B11001;
        byte c = 0B01111;
        output = String.format("%s & %s -> %s", toBinary(b), toBinary(c), toBinary(b & c));
        logger.log(Level.INFO, output);
        output = String.format("%s | %s -> %s", toBinary(b), toBinary(c), toBinary(b | c));
        logger.log(Level.INFO, output);
        output = String.format("%s << 2 -> %s", toBinary(b), toBinary(b << 2));
        logger.log(Level.INFO, output);
        output = String.format("%s >> 2 -> %s", toBinary(b), toBinary(b >> 2));
        logger.log(Level.INFO, output);
    }
}
