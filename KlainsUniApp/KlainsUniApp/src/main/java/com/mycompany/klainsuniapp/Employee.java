package com.mycompany.klainsuniapp;

/**
 * Employee class representing university staff members
 * living or working in the halls.
 * 
 * @author Klain
 */
public class Employee extends Person {

    private String employeeId;
    private String role;
    private double salary;
    private boolean paid;

    /**
     * Employee constructor
     * 
     * @param givenName Employee first name
     * @param surname Employee surname
     * @param dob Employee date of birth
     * @param employeeId Employee ID
     * @param role Employee role/job title
     * @param salary Employee salary
     */
    public Employee(String givenName,
            String surname,
            String dob,
            String employeeId,
            String role,
            double salary) {

        super(givenName, surname, dob);

        this.employeeId = employeeId;
        this.role = role;
        this.salary = salary;
        this.paid = false;
    }

    // ================= GETTERS =================

    /**
     * @return Employee ID
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @return Employee role
     */
    public String getRole() {
        return role;
    }

    /**
     * @return Employee salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @return Payment status
     */
    public boolean isPaid() {
        return paid;
    }

    // ================= SETTERS =================

    /**
     * @param employeeId Set employee ID
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @param role Set employee role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @param salary Set employee salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @param paid Set payment status
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    // ================= TOSTRING =================

    /**
     * Returns employee details in readable format
     * 
     * @return Employee details
     */
    @Override
    public String toString() {

        return "Employee Details:\n"
                + "Name: " + getGivenName() + " "
                + getSurname() + "\n"
                + "DOB: " + getDob() + "\n"
                + "Employee ID: " + employeeId + "\n"
                + "Role: " + role + "\n"
                + "Salary: £" + salary + "\n"
                + "Paid: " + paid;
    }
}