package com.bendaten.trainer;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter6 {
    protected static Logger logger = Logger.getLogger(Chapter6.class.getName());
    private static Random random;

    static {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Cannot start a random generator ", e);
        }
    }

    private Chapter6() {}

    public static void work(){
        logger.log(Level.INFO, "Chapter 6");
        String output;

        int [] a = new int[12];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(50);
        }
        output = Arrays.toString(a);
        logger.log(Level.INFO, output);

        // 2d
        int [][] twoD = {{1, 2, 3, 4},
                         {2, 3, 4, 5},
                         {3, 4, 5, 6},
                         {4, 5, 6, 7}};
        output = twoDtoString(twoD);
        logger.log(Level.INFO, output);

        // print range of integers
        output = rangeStr(1, 13);
        logger.log(Level.INFO, output);
        output = rangeStr(44, 12, -3);
        logger.log(Level.INFO, output);
        try {
            output = rangeStr(12, 3, 2);
            logger.log(Level.INFO, output);
        } catch (ValueException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        try {
            output = rangeStr(12, 24, -2);
            logger.log(Level.INFO, output);
        } catch (ValueException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        output = rangeStr(13, 13);
        logger.log(Level.INFO, output);
        output = rangeStr(13, 11);
        logger.log(Level.INFO, output);

        // varargs
        output = show(1, 2, 3);
        logger.log(Level.INFO, output);
        output = show(1111);
        logger.log(Level.INFO, output);
    }

    private static String show(int ... a) {
        StringBuilder sb = new StringBuilder("in a varargs method\n");
        for (int i : a) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    private static String show(int a) {
        return  "in a single arg method with a = " + a;
    }

    private static String rangeStr(int from, int toExcluded) {
        int interval;
        if (toExcluded < from) {
            interval = -1;
        } else {
            interval = 1;
        }
        return rangeStr(from, toExcluded, interval);
    }

    private static String rangeStr(int from, int toExcluded, int interval) {
        if (interval == 0) throw new ValueException("interval must be nonzero");
        StringJoiner sj = new StringJoiner(", ");
        if (toExcluded < from) {
            if (interval > 0) {
                throw new ValueException("toExcluded is smaller than from but interval is positive");
            } else {
                for (int num = from; num > toExcluded; num += interval) {
                    sj.add(String.valueOf(num));
                }
            }
        } else {
            if (interval < 0) {
                throw new ValueException("toExcluded is larger than from but interval is negative");
            } else {
                for (int num = from; num < toExcluded; num += interval) {
                    sj.add(String.valueOf(num));
                }
            }
        }

        return sj.toString();
    }

    private static String twoDtoString(int[][] twoD) {
        StringJoiner sjRows = new StringJoiner("\n", "\n{\n", "\n}");
        for (int [] row : twoD) {
            StringJoiner sjCols = new StringJoiner(" ", " {", "}");
            for (int col : row) {
                sjCols.add(String.valueOf(col));
            }
            sjRows.add(sjCols.toString());
        }
        return sjRows.toString();
    }
}
