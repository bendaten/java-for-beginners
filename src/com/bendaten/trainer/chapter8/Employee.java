package com.bendaten.trainer.chapter8;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;

    private static int employeesCounter = 0;

    // static block to be executed when the class is loaded to the JVM
    static {
        System.out.println(String.format("When the class Employee is loaded to the JVM the value of employeeCounter is %d", employeesCounter));
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = employeesCounter;
        employeesCounter++;
    }

    public String toString() {
        return String.format("Name: %s %s, ID: %d", firstName, lastName, id);
    }
}

