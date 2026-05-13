package com.mycompany.klainsuniapp;

/**
 * The Main Student Class
 * @author Klain
 */
public class Student extends Person {

    private String studentId;
    private String courseName;
    private String startDate;

    private String diet;
    private boolean disabled;
    private String assignedHall;

    private boolean paid;

    public Student(String givenName, String surname, String dob,
            String studentId, String courseName, String startDate) {

        super(givenName, surname, dob);

        this.studentId = studentId;
        this.courseName = courseName;
        this.startDate = startDate;

        this.diet = "standard";
        this.disabled = false;
        this.assignedHall = "Unassigned";
        this.paid = false;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getDiet() {
        return diet;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public String getAssignedHall() {
        return assignedHall;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setAssignedHall(String assignedHall) {
        this.assignedHall = assignedHall;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Student Details:\n"
                + "Name: " + getGivenName() + " " + getSurname() + "\n"
                + "DOB: " + getDob() + "\n"
                + "ID: " + studentId + "\n"
                + "Course: " + courseName + "\n"
                + "Start Date: " + startDate + "\n"
                + "Diet: " + diet + "\n"
                + "Disabled: " + disabled + "\n"
                + "Hall: " + assignedHall + "\n"
                + "Paid: " + paid;
    }
}