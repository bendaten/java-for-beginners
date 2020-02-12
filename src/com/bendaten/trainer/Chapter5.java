package com.bendaten.trainer;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter5 {
    protected static Logger logger = Logger.getLogger(Chapter5.class.getName());
    protected static ArrayList<Integer> primaryCache;

    private Chapter5() {}

    public static void work(){
        logger.log(Level.INFO, "\nChapter 5\n\n");
        primaryCache = new ArrayList<>();
        primaryCache.add(2);
        primaryCache.add(3);

        // booleans
        boolean boo = true;
        String output = String.format("true is %s and !true is %s", String.valueOf(boo), String.valueOf(!boo));
        logger.log(Level.INFO, output);

        // if else
        int number = 5;
        output = String.format("%d is %s", number, parity(number));
        logger.log(Level.INFO, output);
        number = 32;
        output = String.format("%d is %s", number, parity(number));
        logger.log(Level.INFO, output);
        output = String.format("The largest of 6, 4, 12 is %d", max3(6, 4, 12));
        logger.log(Level.INFO, output);

        // The following shows that the result type of a ternary op is not the one selected but the bigger of the two.
        // obj below is the java.lang.Double 2.0!
        Object obj = true ? new Integer(2) : new Double(3.0);
        output = obj.getClass().getName();
        logger.log(Level.INFO, output);
        // to avoid unexpected results use ternary op only for same types

        // switch case
        number = 3;
        output = String.format("The digit name of %d is %s", number, digitName(number));
        logger.log(Level.INFO, output);
        number = 9;
        output = String.format("The digit name of %d is %s", number, digitName(number));
        logger.log(Level.INFO, output);

        // loops
        int low = 0;
        int high = 9;
        String formatStr = "The digits between %d and %d are %s";
        output = String.format(formatStr, low, high, digitNameRange(low, high, "for"));
        logger.log(Level.INFO, output);
        low = 2;
        high = 7;
        output = String.format(formatStr, low, high, digitNameRange(low, high, "while"));
        logger.log(Level.INFO, output);
        low = 3;
        high = 2;
        output = String.format("The digits between %d and %d are %s", low, high, digitNameRange(low, high, "dowhile"));
        logger.log(Level.INFO, output);  // do while will print the first one before checking if it's less than high

        output = breakOuter();
        logger.log(Level.INFO, output);
        output = printAscii();
        logger.log(Level.INFO, output);

        // patterns
        output = fourByFour();
        logger.log(Level.INFO, output);
        output = fourByFourLower();
        logger.log(Level.INFO, output);
        output = fourByFourBorder();
        logger.log(Level.INFO, output);
        output = fourByFourNumbers();
        logger.log(Level.INFO, output);
        output = zeroOneTriangle();
        logger.log(Level.INFO, output);

        // series
        output = fibonacciStr(10);
        logger.log(Level.INFO, output);

        // palindrome
        number = 123;
        output = String.format("reverse(%d)->%d; palindrome? - %B", number, myReverse(number), isPalindrome(number));
        logger.log(Level.INFO, output);
        number = 135531;
        output = String.format("reverse(%d)->%d; palindrome? - %B", number, myReverse(number), isPalindrome(number));
        logger.log(Level.INFO, output);

        // perfect numbers
        for (number = 1; number < 30; number++) {
            if (isPerfect(number)) {
                output = String.format("%n%d is a perfect number", number);
                logger.log(Level.INFO, output);
            }
        }

        // Armstrong numbers
        for (number = 1; number < 160; number++) {
            if (isArmstrong(number)) {
                output = String.format("%n%d is an Armstrong number", number);
                logger.log(Level.INFO, output);
            }
        }

        // Primary numbers
        int[] checkNumbers = {1, 2, 53, 62, 123, 1234567};
        for (int n : checkNumbers) {
            output = String.format("The number %d is %s primary", n, notStr(isPrimary(n)));
            logger.log(Level.INFO, output);
        }

        // Swap ints
        int a = 123;
        int b = 234;
        output = String.format("Before swap a=%d and b=%d", a, b);
        logger.log(Level.INFO, output);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        output = String.format("After swap a=%d and b=%d", a, b);
        logger.log(Level.INFO, output);

        b = a + b - (a = b);
        output = String.format("After swapping again a=%d and b=%d", a, b);
        logger.log(Level.INFO, output);
    }

    private static boolean isPrimary(int n) {
        if (n < 1) {
            logger.log(Level.SEVERE, "isPrimary works only for positive numbers");
            return false;
        }

        if (n == 1) return true;

        if (primaryCache.contains(n)) return true;

        int last = primaryCache.get(primaryCache.size() - 1);

        if (n < last) return false;  // n was checked before and not included in the cache

        for (int factor : primaryCache) {
            if (n % factor == 0) return false;
        }

        while (last * last < n) {
            last += 2;  // always odd
            if (isPrimary(last)) {
                primaryCache.add(last);
                if (n % last == 0) return false;
            }
        }
        return true;
    }

    private static boolean isArmstrong(int number) {
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit * digit * digit;
            temp /= 10;
        }
        return sum == number;
    }

    private static boolean isPerfect(int number) {
        int sum = 0;
        int high = number / 2 + 1;
        for (int i = 1; i <= high; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    private static String notStr(boolean yesNo) {
        if (yesNo) {
            return "";
        } else {
            return "not";
        }
    }

    private static boolean isPalindrome(int number) {
        return number == myReverse(number);
    }

    private static int myReverse(int number) {
        int result = 0;
        while (number > 0) {
            result = result * 10 + number % 10;
            number /= 10;
        }
        return result;
    }

    private static String fibonacciStr(int items) {
        StringBuilder sb = new StringBuilder("\n");
        int prev1 = 1;
        int prev2 = 0;
        sb.append(1).append(" ");
        for (int i = 1; i < items; i++) {
            int cur = prev1 + prev2;
            sb.append(cur).append(" ");
            prev2 = prev1;
            prev1 = cur;
        }
        return sb.toString();
    }

    private static String zeroOneTriangle() {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append((i + j + 1) % 2).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String fourByFourNumbers() {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append((i + j) % 4 + 1).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String fourByFourBorder() {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 || i == 3 || j == 0 || j == 3) {
                    sb.append("* ");
                } else {
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String fourByFourLower() {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append("* ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String fourByFour() {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append("* ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String printAscii() {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i <= 0B01111111; i++) {
            sb.append(String.format("%d : %c%n", i, i));
        }
        return sb.toString();
    }

    private static String breakOuter() {  // Avoid at any price!!!
        StringBuilder sb = new StringBuilder("\n");
        outer:
        for (int i = 1; i <= 4; i++) {
            inner:
            for (int j = 1; j <= 4; j++) {
                if (i >= 3) {
                    break outer;
                }
                sb.append("* ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String digitNameRange(int low, int high, String loopType) {
        StringBuilder sb = new StringBuilder();
        switch (loopType) {
            case "for":
                for (int i = low; i <= high; i++) {
                    sb.append(digitName(i));
                    if (i < high) {
                        sb.append(", ");
                    }
                }
                break;

            case "while":
                int i = low;
                while (i <= high) {
                    sb.append(digitName(i));
                    if (i < high) {
                        sb.append(", ");
                    }
                    i++;
                }
                break;

            case "dowhile":
                i = low;
                do {
                    sb.append(digitName(i));
                    if (i < high) {
                        sb.append(", ");
                    }
                    i++;
                } while (i <= high);
                break;

            default:
                sb.append("Bad loop type");
        }
        return sb.toString();
    }

    private static String digitName(int digitIn) {
        switch (digitIn) {
            // no need of break because each case exits
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "bad digit";
        }
    }

    private static int max3(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > c) {
            return b;
        }
        return c;
    }

    private static String parity(int number) {
        return number % 2 == 0 ? "even" : "odd";
    }
}
