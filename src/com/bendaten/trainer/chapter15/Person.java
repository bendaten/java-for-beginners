package com.bendaten.trainer.chapter15;

public class Person {

    public enum Type {
        STUDENT("Student"), STAFF("Prof."), ADMIN("Admin");

        String prefix;

        private Type(String prefix) {
            this.prefix = prefix;
        }

        String getPrefix() { return this.prefix; }

    }

    private Type type;
    private String name;

    public Person(Type type, String name) {
        this.type = type;
        this.name = String.format("%s: %s", this.type.getPrefix(), name);
    }

    @Override
    public String toString() {
        return String.format("Person {type = %s, name = '%s'}", type, name);
    }
}
