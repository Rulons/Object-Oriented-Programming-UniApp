package com.mycompany.klainsuniapp;

import java.util.ArrayList;
import java.io.*;

public class Store {

    private ArrayList<Person> people;
    private int currentIndex;

    public Store() {
        people = new ArrayList<>();
        currentIndex = 0;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public Person getNextPerson() {
        if (people.isEmpty()) return null;

        Person p = people.get(currentIndex);
        currentIndex = (currentIndex + 1) % people.size();
        return p;
    }

    public ArrayList<Person> getAllPeople() {
        return people;
    }

    public boolean isEmpty() {
        return people.isEmpty();
    }

    // ================= SAVE =================
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for (Person p : people) {

                if (p instanceof Student) {
                    Student s = (Student) p;

                    writer.println(s.getGivenName());
                    writer.println(s.getSurname());
                    writer.println(s.getDob());
                    writer.println(s.getStudentId());
                    writer.println(s.getCourseName());
                    writer.println(s.getStartDate());
                    writer.println(s.getDiet());
                    writer.println(s.isDisabled());
                    writer.println(s.getAssignedHall());
                    writer.println("----");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ================= LOAD =================
    public void loadFromFile(String filename) {
        people.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String givenName = line;
                String surname = reader.readLine();
                String dob = reader.readLine();
                String studentId = reader.readLine();
                String course = reader.readLine();
                String startDate = reader.readLine();
                String diet = reader.readLine();
                boolean disabled = Boolean.parseBoolean(reader.readLine());
                String hall = reader.readLine();

                reader.readLine(); // ----

                Student s = new Student(
                        givenName,
                        surname,
                        dob,
                        studentId,
                        course,
                        startDate
                );

                s.setDiet(diet);
                s.setDisabled(disabled);
                s.setAssignedHall(hall);

                people.add(s);
            }

            currentIndex = 0;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ================= SEARCH =================
    public Person searchBySurname(String surname) {

        for (Person p : people) {
            if (p.getSurname().equalsIgnoreCase(surname)) {
                return p;
            }
        }

        return null;
    }

    // ================= HALL ASSIGNMENT =================
    public void assignHall(Student s) {

        if (s.isDisabled()) {
            s.setAssignedHall("Ground Floor Hall");
        }
        else if (s.getDiet().equalsIgnoreCase("vegan")) {
            s.setAssignedHall("Vegan Hall");
        }
        else if (s.getDiet().equalsIgnoreCase("vegetarian")) {
            s.setAssignedHall("Vegetarian Hall");
        }
        else {
            s.setAssignedHall("Standard Hall");
        }
    }
}