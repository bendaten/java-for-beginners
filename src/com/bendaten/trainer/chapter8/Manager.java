package com.bendaten.trainer.chapter8;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Manager extends Employee {
    private ArrayList<Employee> reportees;

    public Manager(String firstName, String lastName) {
        super(firstName, lastName);
        reportees = new ArrayList<>();
    }

    public void addReportee(Employee employee) {
        reportees.add(employee);
    }

    @Override
    public String toString() {
        if (reportees.isEmpty()) {
            return String.format("%s%nReportees - none%n", super.toString());
        } else {
            StringJoiner sj = new StringJoiner("\n  ", String.format("%s%nReportees (%d):%n  ", super.toString(), reportees.size()), "\n");
            for (Employee employee : reportees) {
                sj.add(employee.toString());
            }
            return sj.toString();
        }
    }
}
