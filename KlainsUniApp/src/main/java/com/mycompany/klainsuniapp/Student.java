package com.mycompany.klainsuniapp;

public class Student extends Person {
    private String studentId;
    private String courseName;
    private String startDate;

    public Student(String givenName, String surname, String dob,
                   String studentId, String courseName, String startDate) {
        super(givenName, surname, dob);
        this.studentId = studentId;
        this.courseName = courseName;
        this.startDate = startDate;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStartDate() {
        return startDate;
    }

    // Setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    // Useful for displaying data (VERY important)
    @Override
    public String toString() {
        return "Student Details:\n" +
               "Name: " + givenName + " " + surname + "\n" +
               "DOB: " + dob + "\n" +
               "Student ID: " + studentId + "\n" +
               "Course: " + courseName + "\n" +
               "Start Date: " + startDate;
    }

    String getgName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getsName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}