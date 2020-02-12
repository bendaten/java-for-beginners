package com.bendaten.trainer.chapter12;

import java.util.ArrayList;
import java.util.List;

public class College {

    private String name;
    private List<Person> people;

    public College() {
        this.people = new ArrayList<>();
    }

    public College(String name) {
        this.name = name;
        this.people = new ArrayList<>();
    }

    // plain getters and setters are needed for XMLEncoder
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Person> getPeople() { return people; }

    public void addPerson(Person person) {
        if (this.people == null) {
            this.people = new ArrayList<>();
        }
        this.people.add(person);
    }

    public void setPeople(List<Person> people) { this.people = people; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s {%n    name = %s",
                this.getClass().getSimpleName(), this.name));
        if (!people.isEmpty()) {
            sb.append("\n    People: {");
            for (Person p : this.people) {
                sb.append("\n        ").append(p.toString());
            }
            sb.append("\n    }");
        }
        sb.append("\n}");
        return sb.toString();
    }
}
