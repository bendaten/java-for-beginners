package com.bendaten.trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter10 {
    protected static Logger logger = Logger.getLogger(Chapter10.class.getName());
    private static final int MAX_FAILURES = 5;

    public static void work() {
        logger.log(Level.INFO, "In Chapter 10");

        String output;
        int numerator = 5;
        int denominator = getIntegerFromStdIn("Enter the value of the denominator");
        try {
            int result = divide(5, denominator);
            output = String.format("%d / %d = %d", numerator, denominator, result);
            logger.log(Level.INFO, output);
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Attempting to divide by 0", e);
        } finally {
            logger.log(Level.INFO, "Bye");
        }

        output = getStringFromStdIn("This time enter any string:");
        logger.log(Level.INFO, output);
    }

    private static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }

    private static int getIntegerFromStdIn(String prompt) {
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        int countFailures = 0;
        while (countFailures < MAX_FAILURES) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                countFailures++;
                logger.log(Level.INFO, "Enter only an integer");
                s.nextLine();
            }
        }
        s.close();
        logger.log(Level.WARNING, "Exhausted 5 attempts to get an integer from the user");
        return 0;
    }

    private static String getStringFromStdIn(String prompt) {
        System.out.println(prompt);
        // the following saves br.close() in a finally block
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Couldn't receive user input", e);
        }
        return "";
    }
}
