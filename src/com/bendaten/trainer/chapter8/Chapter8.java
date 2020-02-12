package com.bendaten.trainer.chapter8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter8 {
    protected static Logger logger = Logger.getLogger(Chapter8.class.getName());

    public Chapter8() {}

    public static void work() {
        logger.log(Level.INFO, "In Chapter 8");
        String output;

        // use static members
        output = "use static members\n";
        logger.log(Level.INFO, output);
        Employee yossi = new Employee("Yossi", "Abulafia");
        output = yossi.toString();
        logger.log(Level.INFO, output);
        Employee haim = new Employee("Haim", "Buskila");
        output = haim.toString();
        logger.log(Level.INFO, output);

        // inheritance
        output = "\n\ninheritance\nbefore adding reportees";
        logger.log(Level.INFO, output);
        Manager tal = new Manager("Tal", "Har Shoshanim");
        output = tal.toString();
        logger.log(Level.INFO, output);
        output = "after adding two reportees";
        logger.log(Level.INFO, output);
        tal.addReportee(yossi);
        tal.addReportee(haim);
        output = tal.toString();
        logger.log(Level.INFO, output);

        // abstraction
        output = "\n\nabstraction";
        logger.log(Level.INFO, output);
        Complex complex1 = new CompleteComplex(5.5, -7.2);
        Complex complex2 = new CompleteComplex(-1.5, 8);
        output = String.format("%na = %s,  b = %s%na + b = %s", complex1.toString(), complex2.toString(), complex1.add(complex2).toString());
        logger.log(Level.INFO, output);

        output = String.format("%na - b = %s", complex1.subtract(complex2).toString());
        logger.log(Level.INFO, output);

        output = String.format("%na * b = %s", complex1.multiply(complex2).toString());
        logger.log(Level.INFO, output);

        output = String.format("%na / b = %s", complex1.divide(complex2).toString());
        logger.log(Level.INFO, output);

        complex2 = new CompleteComplex(0, 0);
        try {
            output = String.format("%na / b = %s", complex1.divide(complex2).toString());
            logger.log(Level.INFO, output);
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "The denominator is zero", e);
        }

        // interface and implementation in instantiation
        Dimension dimension = new Dimension() {
            private String name = "Yossi";

            @Override
            public String getName() {
                return name;
            }
        };
        output = String.format("the dimension name is %s", dimension.getName());
        logger.log(Level.INFO, output);

        // SAM - Single Abstract Method -> functional interface with "Lambda expression"
        Dimension dimension1 = () -> "Haim";
        output = String.format("the dimension instantiated with lambda is %s", dimension1.getName());
        logger.log(Level.INFO, output);
    }
}
