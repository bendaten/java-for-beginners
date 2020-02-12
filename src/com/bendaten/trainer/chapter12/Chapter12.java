package com.bendaten.trainer.chapter12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter12 {
    protected static Logger logger = Logger.getLogger(Chapter12.class.getName());

    public static void work() {
        logger.log(Level.INFO, "In Chapter 12");

        String output;

        String textToStore = "No one would have believed in the last years of the nineteen century that human affairs had been watched from the timeless worlds of space\n";
        String textToAppend = "No human even considered the possibility of life on other planets";
        String path = "./mytext.txt";
        try {
            MyFileHandler.writeTextToFile(textToStore, path);
            MyFileHandler.appendTextToFile(textToAppend, path);
            logger.log(Level.INFO, "File was written successfully");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not write to file", e);
        }

        logger.log(Level.INFO, "Now try to read it back");
        try {
            output = String.format("Read was successful and the text is%n%s", MyFileHandler.readTextFromFile(path));
            logger.log(Level.INFO, output);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not read from file", e);
        }

        PropsHandler ph = new PropsHandler();
        ph.add("url", "www.genfold.com");
        ph.add("uname", "danny");
        ph.add("pw", "dudu");
        String propertiesPath = "./config.properties";
        try {
            ph.store(propertiesPath);
            output = "Successfully stored properties";
            logger.log(Level.INFO, output);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not store properties", e);
        }

        PropsHandler ph1 = new PropsHandler();
        try {
            ph1.retrieve(propertiesPath);
            if (ph1.hasKey("uname")) {
                output = String.format("uname = %s", ph1.get("uname"));
                logger.log(Level.INFO, output);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not retrieve properties", e);
        }

        ToSerialize ts = new ToSerialize(3, "danny");
        output = String.format("ts: %s", ts.toString());
        logger.log(Level.INFO, output);

        String serialFilePath = "./ts_serialized.ser";
        try {
            MyFileHandler.serialize(ts, serialFilePath);
            logger.log(Level.INFO, "ts was serialized successfully");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not serialize ts", e);
        }

        try {
            ToSerialize readTs = (ToSerialize) MyFileHandler.deserialize(serialFilePath);
            output = String.format("readTs: %s", readTs.toString());
            logger.log(Level.INFO, output);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not read serialized file", e);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Unknown deserialized object", e);
        }

        College cc = new College("Technion");
        cc.addPerson(new Person(1234, Person.Type.STAFF, "Yehuda Tirosh"));
        cc.addPerson(new Person(4321, Person.Type.ADMIN, "Deborah Petrank"));
        cc.addPerson(new Person(10234, Person.Type.STUDENT, "Daniel Ben David"));

        output = cc.toString();
        logger.log(Level.INFO, output);

        String xmlPath = "./college.xml";
        try {
            MyFileHandler.serializeToXML(cc, xmlPath);
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Cannot serialize object to XML", e);
        }

        try {
            Object obj = MyFileHandler.deserializeFromXML(xmlPath);
            if (obj instanceof College) {
                College cd = (College) obj;

                output = cd.toString();
                logger.log(Level.INFO, output);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Cannot serialize object to XML", e);
        }

        // calling a private method
        try {
            String privacyClassStr = "com.bendaten.trainer.chapter12.Privacy";
            Class C = Class.forName(privacyClassStr);
            Privacy p = (Privacy) C.newInstance();

            Method m = C.getDeclaredMethod("show", null);
            m.setAccessible(true);
            m.invoke(p, null);

            output = isClassInterface(privacyClassStr);
            logger.log(Level.INFO, output);
            String interCheck = "com.bendaten.trainer.chapter12.InterCheck";
            output = isClassInterface(interCheck);
            logger.log(Level.INFO, output);
            output = getSuper(privacyClassStr);
            logger.log(Level.INFO, output);

        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Cannot find class for name", e);
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, "Cannot access class", e);
        } catch (InstantiationException e) {
            logger.log(Level.SEVERE, "Cannot instantiate class", e);
        } catch (NoSuchMethodException e) {
            logger.log(Level.SEVERE, "Cannot find method", e);
        } catch (InvocationTargetException e) {
            logger.log(Level.SEVERE, "Cannot invoke method", e);
        }
    }

    private static String isClassInterface(String className) {
        String negative = null;
        try {
            negative = Class.forName(className).isInterface() ? "" : "not ";
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Cannot find class for name", e);
        }
        return String.format("The class %s is %san interface", className, negative);
    }

    private static String getSuper(String className) {
        String superStr = null;
        try {
            superStr = Class.forName(className).getSuperclass().getName();
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Cannot find class for name", e);
        }
        return String.format("The class %s is a sub class of %s", className, superStr);
    }
}
