package com.bendaten.trainer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter7 {
    protected static Logger logger = Logger.getLogger(Chapter7.class.getName());

    private class Overloaded {
        private int id;
        private double length;
        private String unit;

        public Overloaded(int id, double length, String unit) {
            this.id = id;
            this.length = length;
            this.unit = unit;
        }

        public Overloaded(double length, String unit) {
            this(0, length, unit);
        }

        public Overloaded() {
            this(0, 1.0, "m");
        }

        public String toString() {
            return String.format("id = %d   value = %g [%s]", this.id, this.length, this.unit);
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public Chapter7() {}

    public void work() {
        logger.log(Level.INFO, "In Chapter 7");

        // overloaded constructors
        Overloaded o1 = new Overloaded(12, 2.3, "in");
        String output = String.format("o1 - %s", o1.toString());
        logger.log(Level.INFO, output);
        Overloaded o2 = new Overloaded(3.3, "km");
        output = String.format("o2 - %s", o2.toString());
        logger.log(Level.INFO, output);
        Overloaded o3 = new Overloaded();
        output = String.format("o3 - %s", o3.toString());
        logger.log(Level.INFO, output);

        // pass by value - the hash reference to the object is passed and the object can be changed in the called method
        //                 and its contents will retain this change in the calling scope
        changeOverloaded(o3);
        output = String.format("After calling changeOverloaded()%no3 - %s", o3.toString());
        logger.log(Level.INFO, output);

        // however if the value itself is changed in the called method it will not affect the passed parameter in the
        // calling scope
        int tryToChangeMe = 3;
        output = String.format("tryToChangeMe is %d before calling changeInt()%n", tryToChangeMe);
        changeInt(tryToChangeMe);
        output += String.format("and it is still %d after changeInt() was called", tryToChangeMe);
        logger.log(Level.INFO, output);
    }

    private void changeOverloaded(Overloaded overloaded) {
        overloaded.setId(123);
    }

    private void changeInt(int param) {
        param = 123;
    }
}
