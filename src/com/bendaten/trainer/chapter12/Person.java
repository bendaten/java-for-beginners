package com.bendaten.trainer.chapter12;

public class Person implements Comparable<Person> {

    public enum Type {STUDENT, STAFF, ADMIN}

    private int id;
    private Type type;
    private String name;

    public Person() {}

    public Person(int id, Type type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Type getType() { return type; }

    public String getName() {
        return name;
    }

    public void setId(int id) { this.id = id; }

    public void setType(Type type) { this.type = type; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return String.format("%s {id = %d, type = %s, name = %s}",
                this.getClass().getSimpleName(), this.id, this.type, this.name);
    }

    @Override
    public int compareTo(Person that) {
        return Integer.compare(this.id, that.id);
    }
//    @Override
//    public boolean equals(Person that) {
//        return this.id == that.id;
//    }
}
