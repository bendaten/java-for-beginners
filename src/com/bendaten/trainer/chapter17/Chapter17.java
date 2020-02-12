package com.bendaten.trainer.chapter17;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.*;

public class Chapter17 {
    protected static Logger logger = Logger.getLogger(Chapter17.class.getName());

    public static void work() {
        logger.log(Level.INFO, "In Chapter 17");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        list.forEach(i -> System.out.println(i));

        Arrays.asList("a", "b", "c", "d", "e", "f", "g").forEach(c -> System.out.println(c));  // call by value

        Actor h = new Hero();
        h.act();    // these two are
        h.speak();  // defined in the class Hero
        h.joke();   // joke is defined in the interface Actor (default)

        Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21).forEach(System.out::println);  // call by reference

        // sum the squares of a list
        int sum = Stream.of(1, 1, 2, 3, 5, 8, 13, 21).map(i -> i * i).reduce(0, (c, e) -> c + e);
        System.out.println(sum + "\n\n");

        // how is this working?
        Stream<Integer> s1 = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21).stream();  // now we have the stream of Fibo

        Function<Integer, Integer> mySquare = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i * i;
            }
        };
        Stream<Integer> s2 = s1.map(mySquare);  // now s2 has the squares

        BinaryOperator<Integer> mySum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        sum = s2.reduce(0, mySum);
        System.out.println(sum);

        // replacing the bifunction with Integer::sum
        sum = Stream.of(1, 1, 2, 3, 5, 8, 13, 21).map(i -> i * i).reduce(0, Integer::sum);
        System.out.println(sum + "\n\n");

        // sum the squares of only the even Fibo numbers
        sum = Stream.of(1, 1, 2, 3, 5, 8, 13, 21)
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .reduce(0, Integer::sum);
        System.out.println(sum + "\n");

        // how filter works
        Predicate<Integer> p = new Predicate<Integer>() {
            public boolean test(Integer i) {
                return i % 2 == 0;
            }
        };
        sum = Stream.of(1, 1, 2, 3, 5, 8, 13, 21)
                .filter(p)
                .map(i -> i * i)
                .reduce(0, Integer::sum);
        System.out.println(sum + "\n");

        // find first entity greater than 10
        int first = Stream.of(1, 1, 2, 3, 5, 8, 13, 21)
                .filter(i -> i > 10)
                .findFirst().orElse(-1);
        System.out.println(first + "\n");

        // Date and time
        LocalDate now = LocalDate.now();
        LocalDate then = LocalDate.of(1961, Month.FEBRUARY, 19);
        System.out.println(now);
        System.out.println(then);
        System.out.println(DAYS.between(then, now) + " days since I was born");
        System.out.println(MONTHS.between(then, now) + " months since I was born");
        System.out.println(YEARS.between(then, now) + " years since I was born");
        System.out.println(DECADES.between(then, now) + " decades since I was born");

        LocalTime nowT = LocalTime.now();
        System.out.println(nowT);
        LocalTime nowJ = LocalTime.now(ZoneId.of("Asia/Jerusalem"));
        System.out.println(nowJ);

        Instant nowI = Instant.now();
        System.out.println(nowI);

        LocalDateTime nowDt = LocalDateTime.now();
        System.out.println(nowDt);

        // methods reference
        List<String> names = Arrays.asList("Yossi", "Haim", "Moshe", "Yaacov");

        names.forEach(str -> System.out.println(str));
        names.forEach(System.out::println);

        MyPrinter mp = new MyPrinter();
        mp.print("daniel ben david", MyNameParser::convert);
        mp.print("daniel ben david", MyUppercaseParser::convert);
    }
}
