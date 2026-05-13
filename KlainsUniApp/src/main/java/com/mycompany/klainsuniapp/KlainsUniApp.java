package com.mycompany.klainsuniapp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;

public class KlainsUniApp {

    public static void main(String[] args) {

        Store store = new Store();

        JFrame frame = new JFrame("Klain's University Hall Application");
        frame.setSize(1200, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea displayStudents = new JTextArea();

        displayStudents.setLineWrap(true);
        displayStudents.setWrapStyleWord(true);
        displayStudents.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayStudents);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // ================= TOP PANEL =================

        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel =
                new JLabel("Enter Student or Employee Details");

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(titleLabel);
        topPanel.add(Box.createVerticalStrut(10));

        // ================= PERSON PANEL =================

        JPanel personPanel = new JPanel();

        personPanel.setBorder(
                BorderFactory.createTitledBorder("Person Details")
        );

        JTextField givenNameField = new JTextField(10);
        JTextField surnameField = new JTextField(10);
        JTextField dobField = new JTextField(10);

        personPanel.add(new JLabel("Given Name:"));
        personPanel.add(givenNameField);

        personPanel.add(new JLabel("Surname:"));
        personPanel.add(surnameField);

        personPanel.add(new JLabel("DOB (dd/mm/yyyy):"));
        personPanel.add(dobField);

        topPanel.add(personPanel);
        topPanel.add(Box.createVerticalStrut(10));

        // ================= STUDENT PANEL =================

        JPanel uniPanel = new JPanel();

        uniPanel.setBorder(
                BorderFactory.createTitledBorder("Student Information")
        );

        JTextField studentIdField = new JTextField(10);
        JTextField courseField = new JTextField(10);
        JTextField startDateField = new JTextField(10);

        uniPanel.add(new JLabel("Student ID:"));
        uniPanel.add(studentIdField);

        uniPanel.add(new JLabel("Course:"));
        uniPanel.add(courseField);

        uniPanel.add(new JLabel("Start Date:"));
        uniPanel.add(startDateField);

        topPanel.add(uniPanel);

        // ================= EMPLOYEE PANEL =================

        JPanel employeePanel = new JPanel();

        employeePanel.setBorder(
                BorderFactory.createTitledBorder("Employee Information")
        );

        JTextField employeeIdField = new JTextField(10);
        JTextField roleField = new JTextField(10);
        JTextField salaryField = new JTextField(10);

        employeePanel.add(new JLabel("Employee ID:"));
        employeePanel.add(employeeIdField);

        employeePanel.add(new JLabel("Role:"));
        employeePanel.add(roleField);

        employeePanel.add(new JLabel("Salary:"));
        employeePanel.add(salaryField);

        topPanel.add(employeePanel);

        // ================= EXTRA PANEL =================

        JPanel extraPanel = new JPanel();

        extraPanel.setBorder(
                BorderFactory.createTitledBorder("Extra Information")
        );

        String[] diets = {
            "standard",
            "vegan",
            "vegetarian"
        };

        JComboBox<String> dietBox =
                new JComboBox<>(diets);

        JCheckBox disabledBox =
                new JCheckBox("Disabled Student");

        JCheckBox paidBox =
                new JCheckBox("Fees/Rent Paid");

        extraPanel.add(new JLabel("Diet:"));
        extraPanel.add(dietBox);

        extraPanel.add(disabledBox);

        extraPanel.add(paidBox);

        topPanel.add(extraPanel);

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);

        // ================= LEFT PANEL =================

        JPanel leftPanel = new JPanel();

        leftPanel.setLayout(
                new BoxLayout(leftPanel, BoxLayout.Y_AXIS)
        );

        JPanel buttonRow = new JPanel();

        buttonRow.setLayout(
                new BoxLayout(buttonRow, BoxLayout.Y_AXIS)
        );

        JButton submitStudentBtn =
                new JButton("Create Student");

        JButton submitEmployeeBtn =
                new JButton("Create Employee");

        JButton nextBtn =
                new JButton("Next Record");

        JButton saveBtn =
                new JButton("Save Records");

        JButton loadBtn =
                new JButton("Load Records");

        JButton clearBtn =
                new JButton("Clear Form");

        Dimension buttonSize =
                new Dimension(180, 30);

        submitStudentBtn.setPreferredSize(buttonSize);
        submitEmployeeBtn.setPreferredSize(buttonSize);
        nextBtn.setPreferredSize(buttonSize);
        saveBtn.setPreferredSize(buttonSize);
        loadBtn.setPreferredSize(buttonSize);
        clearBtn.setPreferredSize(buttonSize);

        buttonRow.add(submitStudentBtn);
        buttonRow.add(Box.createVerticalStrut(5));

        buttonRow.add(submitEmployeeBtn);
        buttonRow.add(Box.createVerticalStrut(5));

        buttonRow.add(nextBtn);
        buttonRow.add(Box.createVerticalStrut(5));

        buttonRow.add(saveBtn);
        buttonRow.add(Box.createVerticalStrut(5));

        buttonRow.add(loadBtn);
        buttonRow.add(Box.createVerticalStrut(5));

        buttonRow.add(clearBtn);

        // ================= SEARCH PANEL =================

        JPanel searchPanel = new JPanel();

        searchPanel.setBorder(
                BorderFactory.createTitledBorder("Search")
        );

        JTextField searchField =
                new JTextField();

        searchField.setPreferredSize(
                new Dimension(180, 25)
        );

        JButton searchBtn =
                new JButton("Search Surname");

        searchPanel.add(new JLabel("Surname:"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        leftPanel.add(buttonRow);
        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(searchPanel);

        frame.add(leftPanel, BorderLayout.WEST);

        // =========================================================
        // VALIDATION METHOD
        // =========================================================

        Runnable validateBasicInput = () -> {

            String givenName =
                    givenNameField.getText().trim();

            String surname =
                    surnameField.getText().trim();

            if (givenName.isEmpty()
                    || surname.isEmpty()
                    || dobField.getText().trim().isEmpty()) {

                throw new RuntimeException(
                        "Please fill in all required fields."
                );
            }

            if (!givenName.matches("[a-zA-Z ]+")
                    || !surname.matches("[a-zA-Z ]+")) {

                throw new RuntimeException(
                        "Names must only contain letters."
                );
            }

            String dob =
                    dobField.getText().trim();

            if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {

                throw new RuntimeException(
                        "DOB must use dd/mm/yyyy format."
                );
            }

            try {

                DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate dobDate =
                        LocalDate.parse(dob, formatter);

                LocalDate today =
                        LocalDate.now();

                if (dobDate.isAfter(today)) {

                    throw new RuntimeException(
                            "DOB cannot be in the future."
                    );
                }

                int age =
                        Period.between(dobDate, today).getYears();

                if (age > 122) {

                    throw new RuntimeException(
                            "DOB is unrealistic."
                    );
                }

            } catch (DateTimeParseException ex) {

                throw new RuntimeException(
                        "Invalid DOB entered."
                );
            }
        };

        // =========================================================
        // CREATE STUDENT
        // =========================================================

        submitStudentBtn.addActionListener(e -> {

            try {

                validateBasicInput.run();

                String startDate =
                        startDateField.getText().trim();

                if (studentIdField.getText().trim().isEmpty()
                        || courseField.getText().trim().isEmpty()
                        || startDate.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Complete all student fields."
                    );

                    return;
                }

                Student stuRes =
                        new Student(
                                givenNameField.getText(),
                                surnameField.getText(),
                                dobField.getText(),
                                studentIdField.getText(),
                                courseField.getText(),
                                startDate
                        );

                stuRes.setDiet(
                        (String) dietBox.getSelectedItem()
                );

                stuRes.setDisabled(
                        disabledBox.isSelected()
                );

                stuRes.setPaid(
                        paidBox.isSelected()
                );

                store.assignHall(stuRes);

                store.addPerson(stuRes);

                displayStudents.setText(
                        stuRes.toString()
                );

            } catch (RuntimeException ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // =========================================================
        // CREATE EMPLOYEE
        // =========================================================

        submitEmployeeBtn.addActionListener(e -> {

            try {

                validateBasicInput.run();

                if (employeeIdField.getText().trim().isEmpty()
                        || roleField.getText().trim().isEmpty()
                        || salaryField.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Complete all employee fields."
                    );

                    return;
                }

                double salary =
                        Double.parseDouble(
                                salaryField.getText()
                        );

                Employee emp =
                        new Employee(
                                givenNameField.getText(),
                                surnameField.getText(),
                                dobField.getText(),
                                employeeIdField.getText(),
                                roleField.getText(),
                                salary
                        );

                emp.setPaid(
                        paidBox.isSelected()
                );

                store.addPerson(emp);

                displayStudents.setText(
                        emp.toString()
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Salary must be a number."
                );

            } catch (RuntimeException ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // =========================================================
        // NEXT RECORD
        // =========================================================

        nextBtn.addActionListener(e -> {

            Person p =
                    store.getNextPerson();

            if (p == null) {

                JOptionPane.showMessageDialog(
                        null,
                        "No records available"
                );

            } else {

                displayStudents.setText(
                        p.toString()
                );
            }
        });

        // =========================================================
        // SAVE
        // =========================================================

        saveBtn.addActionListener(e -> {

            store.saveToFile("students.txt");

            JOptionPane.showMessageDialog(
                    null,
                    "Records Saved!"
            );
        });

        // =========================================================
        // LOAD
        // =========================================================

        loadBtn.addActionListener(e -> {

            store.loadFromFile("students.txt");

            JOptionPane.showMessageDialog(
                    null,
                    "Records Loaded!"
            );
        });

        // =========================================================
        // CLEAR FORM
        // =========================================================

        clearBtn.addActionListener(e -> {

            givenNameField.setText("");
            surnameField.setText("");
            dobField.setText("");

            studentIdField.setText("");
            courseField.setText("");
            startDateField.setText("");

            employeeIdField.setText("");
            roleField.setText("");
            salaryField.setText("");

            searchField.setText("");

            dietBox.setSelectedIndex(0);

            disabledBox.setSelected(false);
            paidBox.setSelected(false);

            displayStudents.setText("");

            JOptionPane.showMessageDialog(
                    null,
                    "Form Cleared"
            );
        });

        // =========================================================
        // SEARCH
        // =========================================================

        searchBtn.addActionListener(e -> {

            String query =
                    searchField.getText().trim();

            if (query.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Enter surname to search"
                );

                return;
            }

            Person result =
                    store.searchBySurname(query);

            if (result == null) {

                JOptionPane.showMessageDialog(
                        null,
                        "No record found"
                );

            } else {

                displayStudents.setText(
                        result.toString()
                );
            }
        });

        frame.setVisible(true);
    }
}