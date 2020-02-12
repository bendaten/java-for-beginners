package com.bendaten.trainer.chapter14;

import com.bendaten.trainer.chapter12.Person;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter14 {
    protected static Logger logger = Logger.getLogger(Chapter14.class.getName());

    public static void work() {
        logger.log(Level.INFO, "In Chapter 14");

        Collection<Object> values = new ArrayList<>();
        values.add(12);
        values.add("Daniel");
        values.add(3.14159265);

        Iterator<Object> i = values.iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }

        for (Object o : values) {
            System.out.println(o);
        }

        Collection<Integer> iValues = new ArrayList<>();
        iValues.add(11);
        iValues.add(22);
        iValues.add(44);
        for (int v : iValues) {
            System.out.println(v);
        }
        iValues.remove(22);
        for (int v : iValues) {
            System.out.println(v);
        }

        MyContainer<Integer> myInt = new MyContainer<>(12);
        myInt.show();
        MyContainer<String> myString = new MyContainer<>("Daniel");
        myString.show();

        // MyNumberContainer<String> = new MyNumberContainer<>("abc"); is expected to give a compilation error

        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(1, 33);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(1));
        list.forEach(System.out::println);  // Stream API ... Lambda expression
        
        Vector<Integer> v = new Vector<>();
        v.add(12);
        System.out.println("v.capacity() = " + v.capacity());
        for (int c = 24; c < 300; c += 12) {
            v.add(c);
        }
        System.out.println("v.capacity() = " + v.capacity()); // capacity doubles itself once exhausted

        Collections.reverse(list);
        System.out.println(list);

        // sort by ones value with Comparator
        list.clear();
        list.add(785);
        list.add(498);
        list.add(641);
        list.add(803);
        list.sort(new OnesComparator());
        System.out.println(list);

        // sort by tens value with Lambda Comparator
        list.sort((first, second) -> Integer.compare(first % 100, second % 100));
        System.out.println(list);

        List<Person> people = new ArrayList<>();
        people.add(new Person(12, Person.Type.STUDENT, "Daniel Ben David"));
        people.add(new Person(10, Person.Type.STUDENT, "Yossi Abulafia"));
        people.add(new Person(34, Person.Type.STUDENT, "Haim Buskila"));
        people.add(new Person(122, Person.Type.STUDENT, "Harry Busiba"));
        people.add(new Person(2, Person.Type.STUDENT, "Albert Einstein"));
        people.add(new Person(1234, Person.Type.STUDENT, "S'chn T'gai Spock"));

        people.forEach(System.out::println);

        System.out.println("Sort by id");
        people.sort((first, second) -> Integer.compare(first.getId(), second.getId()));
        people.forEach(System.out::println);


        System.out.println("Sort by Name");
        people.sort((first, second) -> first.getName().compareTo(second.getName()));
        people.forEach(System.out::println);

        System.out.println("Sort by id again");
        people.sort((first, second) -> first.compareTo(second));
        people.forEach(System.out::println);

        System.out.println("Sort by name again");
        people.sort(Comparator.comparing(Person::getName));
        people.forEach(System.out::println);

        // Sets
        Set<Integer> nums = new HashSet<>();
        nums.add(12);
        nums.add(76);
        nums.add(53);
        nums.add(72);
        nums.add(2);

        System.out.println("print HashSet");
        System.out.println(nums);

        System.out.println("print TreeSet");  // already sorted
        System.out.println(new TreeSet<>(nums));

        // Maps
        Map<String, Object> person = new HashMap<>();
        person.put("First Name", "Daniel");
        person.put("Last Name", "BenDavid");
        person.put("id", 123456);
        person.put("Weight", 260);
        person.put("Weight Unit", "lbs");

        for (String key : person.keySet()) {
            System.out.println(String.format("%s = %s", key, person.get(key)));
        }

        for (Map.Entry<String, Object> entry : person.entrySet()) {
            System.out.println(String.format("%s = %s", entry.getKey(), entry.getValue()));
        }

        List<String> dups = new ArrayList<>();
        dups.add("Yossi");
        dups.add("Haim");
        dups.add("Moshe");
        dups.add("Yossi");
        dups.add("Yacov");
        dups.add("Yacov");
        dups.add("Itzik");
        printDuplicates(dups);

        doSomething();

    }

    private static void printDuplicates(List<String> list) {
        Set<String> uniques = new HashSet<>();
        for (String name : list) {
            if (!uniques.add(name)) {
                System.out.println(name);
            }
        }
    }

    private static void doSomething() {
        long duration = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(String.format("%d", i));
        }
        int numElements = list.size();

        duration = System.currentTimeMillis() - duration;
        System.out.println(String.format("It took %d milliseconds to add %d elements to the list", duration, numElements));
    }
}
