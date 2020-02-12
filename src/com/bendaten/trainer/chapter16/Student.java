package com.bendaten.trainer.chapter16;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("Student id = %d, name = %s", id, name);
    }
}
