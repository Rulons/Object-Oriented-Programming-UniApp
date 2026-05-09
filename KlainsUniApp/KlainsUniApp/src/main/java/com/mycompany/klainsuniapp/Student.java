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

    /**
     * The Constructor
     *
     * @param givenName - Given name of the student
     * @param surname - Surname of the student
     * @param dob - Date of birth of the student
     * @param studentId - Student ID of the student
     * @param courseName - Course the student is studying
     * @param startDate - Start date of the course
     */
    public Student(String givenName, String surname, String dob,
            String studentId, String courseName, String startDate) {

        super(givenName, surname, dob);

        this.studentId = studentId;
        this.courseName = courseName;
        this.startDate = startDate;

        this.diet = "standard";
        this.disabled = false;
        this.assignedHall = "Unassigned";
    }

    // Getters
    /**
     *
     * @return - Returns a student ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     *
     * @return - Returns the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     *
     * @return - Returns the start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @return - Returns 'standard', 'vegetarian' or 'vegan'
     */
    public String getDiet() {
        return diet;
    }

    /**
     *
     * @return - Returns boolean representing disability 
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     *
     * @return - Returns whether ground floor access is needed
     */
    public String getAssignedHall() {
        return assignedHall;
    }

    // Setters
    /**
     *
     * @param diet - to set diet to 'standard', 'vegetarian' or 'vegan'
     */
    public void setDiet(String diet) {
        this.diet = diet;
    }

    /**
     *
     * @param disabled - sets boolean  representing disability 
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     *
     * @param assignedHall- Sets whether ground floor access is needed
     */
    public void setAssignedHall(String assignedHall) {
        this.assignedHall = assignedHall;
    }

    /**
     * Override of built in toString method
     * @return - a string represemting the main attributes of a student in a clear accessible format
     */
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
                + "Hall: " + assignedHall;
    }
}
