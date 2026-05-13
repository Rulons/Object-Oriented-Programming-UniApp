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

        if (people.isEmpty()) {
            return null;
        }

        Person p = people.get(currentIndex);

        currentIndex = (currentIndex + 1) % people.size();

        return p;
    }

    public Person searchBySurname(String surname) {

        for (Person p : people) {

            if (p.getSurname().equalsIgnoreCase(surname)) {
                return p;
            }
        }

        return null;
    }

    // ================= SAVE =================

    public void saveToFile(String filename) {

        try (PrintWriter writer =
                new PrintWriter(new FileWriter(filename))) {

            for (Person p : people) {

                // ================= STUDENT =================

                if (p instanceof Student) {

                    Student s = (Student) p;

                    writer.println("STUDENT");

                    writer.println(s.getGivenName());
                    writer.println(s.getSurname());
                    writer.println(s.getDob());

                    writer.println(s.getStudentId());
                    writer.println(s.getCourseName());
                    writer.println(s.getStartDate());

                    writer.println(s.getDiet());
                    writer.println(s.isDisabled());
                    writer.println(s.getAssignedHall());
                    writer.println(s.isPaid());

                    writer.println("----");
                }

                // ================= EMPLOYEE =================

                else if (p instanceof Employee) {

                    Employee e = (Employee) p;

                    writer.println("EMPLOYEE");

                    writer.println(e.getGivenName());
                    writer.println(e.getSurname());
                    writer.println(e.getDob());

                    writer.println(e.getEmployeeId());
                    writer.println(e.getRole());
                    writer.println(e.getSalary());

                    writer.println(e.isPaid());

                    writer.println("----");
                }
            }

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    // ================= LOAD =================

    public void loadFromFile(String filename) {

        people.clear();

        try (BufferedReader reader =
                new BufferedReader(new FileReader(filename))) {

            String type;

            while ((type = reader.readLine()) != null) {

                // ================= STUDENT =================

                if (type.equals("STUDENT")) {

                    String givenName = reader.readLine();
                    String surname = reader.readLine();
                    String dob = reader.readLine();

                    String studentId = reader.readLine();
                    String course = reader.readLine();
                    String startDate = reader.readLine();

                    String diet = reader.readLine();
                    boolean disabled =
                            Boolean.parseBoolean(reader.readLine());

                    String hall = reader.readLine();

                    boolean paid =
                            Boolean.parseBoolean(reader.readLine());

                    reader.readLine();

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
                    s.setPaid(paid);

                    people.add(s);
                }

                // ================= EMPLOYEE =================

                else if (type.equals("EMPLOYEE")) {

                    String givenName = reader.readLine();
                    String surname = reader.readLine();
                    String dob = reader.readLine();

                    String employeeId = reader.readLine();
                    String role = reader.readLine();

                    double salary =
                            Double.parseDouble(reader.readLine());

                    boolean paid =
                            Boolean.parseBoolean(reader.readLine());

                    reader.readLine();

                    Employee e = new Employee(
                            givenName,
                            surname,
                            dob,
                            employeeId,
                            role,
                            salary
                    );

                    e.setPaid(paid);

                    people.add(e);
                }
            }

            currentIndex = 0;

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    // ================= HALL ASSIGNMENT =================

    public void assignHall(Student s) {

        if (s.isDisabled()) {

            s.setAssignedHall("Ground Floor Hall");

        } else if (s.getDiet().equalsIgnoreCase("vegan")) {

            s.setAssignedHall("Vegan Hall");

        } else if (s.getDiet().equalsIgnoreCase("vegetarian")) {

            s.setAssignedHall("Vegetarian Hall");

        } else {

            s.setAssignedHall("Standard Hall");
        }
    }
}