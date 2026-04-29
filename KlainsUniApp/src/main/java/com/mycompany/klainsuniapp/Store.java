package com.mycompany.klainsuniapp;

import java.util.ArrayList;

public class Store {

    private ArrayList<Person> people;
    private int currentIndex;

    public Store() {
        people = new ArrayList<>();
        currentIndex = 0;
    }

    // Add a person to the list
    public void addPerson(Person p) {
        people.add(p);
    }

    // Get next person (loops back to start)
    public Person getNextPerson() {
        if (people.isEmpty()) {
            return null;
        }

        Person p = people.get(currentIndex);
        currentIndex = (currentIndex + 1) % people.size();
        return p;
    }

    // Optional (useful later)
    public ArrayList<Person> getAllPeople() {
        return people;
    }

    public boolean isEmpty() {
        return people.isEmpty();
    }
}