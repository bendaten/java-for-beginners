package com.bendaten.trainer;

import com.bendaten.trainer.chapter11.Chapter11;
import com.bendaten.trainer.chapter12.Chapter12;
import com.bendaten.trainer.chapter13.Chapter13;
import com.bendaten.trainer.chapter14.Chapter14;
import com.bendaten.trainer.chapter15.Chapter15;
import com.bendaten.trainer.chapter16.Chapter16;
import com.bendaten.trainer.chapter17.Chapter17;
import com.bendaten.trainer.chapter8.Chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapters {
    protected static Logger logger = Logger.getLogger(Chapters.class.getName());

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int chapter;
        int maxChapter = 17;
        System.out.println(String.format("Enter chapter number [4 to %d or 0 for all]", maxChapter));
        try {
            chapter = sc.nextInt();
        } catch (InputMismatchException e) {
            logger.log(Level.SEVERE, "Only integer numbers are valid");
            return;
        }
        if (chapter != 0 && (chapter < 4 || chapter > maxChapter)) {
            logger.log(Level.SEVERE, "Wrong chapter number");
            return;
        }

//        String className = String.format("com.bendaten.trainer.Chapter%d", chapter);
//        String packageName = String.format("com.bendaten.trainer.chapter%d..Chapter%d", chapter, chapter);

//        if (chapter == 7) {
//            Chapter7 c7 = new Chapter7();
//            c7.work();
//            return;
//        }
//
//        Class<?> cls;
//        try {
//            cls = Class.forName(className);
//        } catch (ClassNotFoundException e) {
//            try {
//                cls = Class.forName(packageName);
//            } catch (ClassNotFoundException ex) {
//                logger.log(Level.SEVERE, "cannot find class", e);
//                return;
//            }
//        }
//
//        try {
//            Method m = cls.getMethod("work", String[].class);
//            String[] params = null;
//            m.invoke(null, (Object) params);
//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            logger.log(Level.SEVERE, "cannot invoke work", e);
//        }

        if (chapter == 0 || chapter == 4) {
             Chapter4.work();
        }
        if (chapter == 0 || chapter == 5) {
            Chapter5.work();
        }
        if (chapter == 0 || chapter == 6) {
            Chapter6.work();
        }
        if (chapter == 0 || chapter == 7) {
            Chapter7 c7 = new Chapter7();
            c7.work();
        }
        if (chapter == 0 || chapter == 8) {
            Chapter8.work();
        }
        if (chapter == 0 || chapter == 9) {
            Chapter9.work();
        }
        if (chapter == 0 || chapter == 10) {
            Chapter10.work();
        }
        if (chapter == 0 || chapter == 11) {
            Chapter11.work();
        }
        if (chapter == 0 || chapter == 12) {
            Chapter12.work();
        }
        if (chapter == 0 || chapter == 13) {
            Chapter13.work();
        }
        if (chapter == 0 || chapter == 14) {
            Chapter14.work();
        }
        if (chapter == 0 || chapter == 15) {
            Chapter15.work();
        }
        if (chapter == 0 || chapter == 16) {
            Chapter16.work();
        }
        if (chapter == 0 || chapter == 17) {
            Chapter17.work();
        }
    }
}
