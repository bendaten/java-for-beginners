package com.bendaten.trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter9 {
    protected static Logger logger = Logger.getLogger(Chapter9.class.getName());

    public Chapter9() {}

    public static void work() {
        logger.log(Level.INFO, "In Chapter 9");

        String output = exercise1("This is String 1", "and string 2.");
        logger.log(Level.INFO, output);

        output = exercise2();
        logger.log(Level.INFO, output);

//        output = exercise3();
//        logger.log(Level.INFO, output);

        output = exercise4();
        logger.log(Level.INFO, output);

        output = String.format("The third name is ###%s###", getThirdName("Yossi, Haim, Baruch, Yaacov"));
        logger.log(Level.INFO, output);

        try {
            getThirdName("Yoel, Nava");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "bad", e);
        }
    }

    private static String getThirdName(String s) {
        String [] splits = s.split(", ");
        if (splits.length < 3) {
            logger.log(Level.SEVERE, "CSV has less than 3 items");
            return "";
        }
        return splits[2];
    }

    private static String exercise1(String s1, String s2) {
        StringBuilder sb = new StringBuilder(String.format("Lengths: %d and %d%n", s1.length(), s2.length()));
        sb.append(String.format("Concatenation: %s %s%n", s1, s2));
        sb.append(String.format("First UPPER: %s", s1.toUpperCase()));
        return sb.toString();
    }

    private static String exercise2() {
        try {
            System.out.print("Enter a character: ");
            return String.format("The character entered has ascii code of %d", System.in.read());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "could not read", e);
        }
        return "";
    }

    private static String exercise3() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int number = 0;
        try {
            number = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "could not read", e);
        }
        return String.format("The entered number is %d", number);
    }

    private static String exercise4() {
        boolean goodRead = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        int number = 0;
        while (!goodRead) {
            try {
                number = sc.nextInt();
                goodRead = true;
            } catch (InputMismatchException e) {
                System.out.println("*** This is not an integer; Try again");
                sc.nextLine();  // clean the buffer
            }
        }
        return String.format("The number entered is %d", number);
    }
}
