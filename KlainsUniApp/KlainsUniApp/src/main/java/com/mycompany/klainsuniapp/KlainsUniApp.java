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
        frame.setSize(1200, 600);
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

        JLabel titleLabel = new JLabel("Enter Student Details");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(titleLabel);
        topPanel.add(Box.createVerticalStrut(10));

        // ================= STUDENT PANEL =================
        JPanel personPanel = new JPanel();
        personPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

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

        // ================= COURSE PANEL =================
        JPanel uniPanel = new JPanel();
        uniPanel.setBorder(BorderFactory.createTitledBorder("Course Information"));

        JTextField studentIdField = new JTextField(10);
        JTextField courseField = new JTextField(10);
        JTextField startDateField = new JTextField(10);

        uniPanel.add(new JLabel("ID:"));
        uniPanel.add(studentIdField);

        uniPanel.add(new JLabel("Course:"));
        uniPanel.add(courseField);

        uniPanel.add(new JLabel("Start Date (dd/mm/yyyy):"));
        uniPanel.add(startDateField);

        topPanel.add(uniPanel);
        topPanel.add(Box.createVerticalStrut(10));

        // ================= EXTRA FIELDS =================
        JPanel extraPanel = new JPanel();
        extraPanel.setBorder(BorderFactory.createTitledBorder("Hall Preferences"));

        String[] diets = {"standard", "vegan", "vegetarian"};

        JComboBox<String> dietBox = new JComboBox<>(diets);
        JCheckBox disabledBox = new JCheckBox("Disabled Student");

        extraPanel.add(new JLabel("Diet:"));
        extraPanel.add(dietBox);
        extraPanel.add(disabledBox);

        topPanel.add(extraPanel);

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);

        // ================= LEFT PANEL =================
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel buttonRow = new JPanel();
        buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.Y_AXIS));

        JButton submitBtn = new JButton("Enter Student Details");
        JButton nextBtn = new JButton("Next Record");
        JButton saveBtn = new JButton("Save Student Details");
        JButton loadBtn = new JButton("Load Student Details");

        Dimension buttonSize = new Dimension(160, 30);

        submitBtn.setPreferredSize(buttonSize);
        nextBtn.setPreferredSize(buttonSize);
        saveBtn.setPreferredSize(buttonSize);
        loadBtn.setPreferredSize(buttonSize);

        buttonRow.add(submitBtn);
        buttonRow.add(Box.createVerticalStrut(5));

        buttonRow.add(nextBtn);
        buttonRow.add(Box.createVerticalStrut(5));

        buttonRow.add(saveBtn);
        buttonRow.add(Box.createVerticalStrut(5));

        buttonRow.add(loadBtn);

        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search Student"));

        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(180, 25));

        JButton searchBtn = new JButton("Search Surname");

        searchPanel.add(new JLabel("Surname:"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        leftPanel.add(buttonRow);
        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(searchPanel);

        frame.add(leftPanel, BorderLayout.WEST);

        // ================= BUTTON ACTIONS =================

        submitBtn.addActionListener(e -> {

            // ================= EMPTY FIELD VALIDATION =================
            if (givenNameField.getText().trim().isEmpty()
                    || surnameField.getText().trim().isEmpty()
                    || dobField.getText().trim().isEmpty()
                    || studentIdField.getText().trim().isEmpty()
                    || courseField.getText().trim().isEmpty()
                    || startDateField.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Please fill in all required fields.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // ================= NAME VALIDATION =================
            String givenName = givenNameField.getText().trim();
            String surname = surnameField.getText().trim();

            if (!givenName.matches("[a-zA-Z ]+")
                    || !surname.matches("[a-zA-Z ]+")) {

                JOptionPane.showMessageDialog(
                        null,
                        "Names must only contain letters.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // ================= DATE FORMAT VALIDATION =================
            String dob = dobField.getText().trim();
            String startDate = startDateField.getText().trim();

            if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")
                    || !startDate.matches("\\d{2}/\\d{2}/\\d{4}")) {

                JOptionPane.showMessageDialog(
                        null,
                        "Dates must be in the format dd/mm/yyyy",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // ================= REALISTIC DATE VALIDATION =================
            try {

                DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate dobDate = LocalDate.parse(dob, formatter);
                LocalDate courseStartDate =
                        LocalDate.parse(startDate, formatter);

                LocalDate today = LocalDate.now();

                // DOB cannot be in future
                if (dobDate.isAfter(today)) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Date of birth cannot be in the future.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }

                // Max realistic human age = 122
                int age = Period.between(dobDate, today).getYears();

                if (age > 122) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Date of birth is unrealistic.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }

                // Start year cannot be before 2027
                if (courseStartDate.getYear() < 2027) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Course start year cannot be before 2027.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }

            } catch (DateTimeParseException ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Invalid date entered.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            try {

                Student stuRes = new Student(
                        givenName,
                        surname,
                        dob,
                        studentIdField.getText(),
                        courseField.getText(),
                        startDate
                );

                stuRes.setDiet((String) dietBox.getSelectedItem());
                stuRes.setDisabled(disabledBox.isSelected());

                store.assignHall(stuRes);
                store.addPerson(stuRes);

                displayStudents.setText(stuRes.toString());

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Error creating student",
                        "System Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        nextBtn.addActionListener(e -> {

            Person p = store.getNextPerson();

            if (p == null) {
                JOptionPane.showMessageDialog(null, "No records available");
            } else {
                displayStudents.setText(p.toString());
            }
        });

        saveBtn.addActionListener(e -> {

            store.saveToFile("students.txt");

            JOptionPane.showMessageDialog(null, "Saved!");
        });

        loadBtn.addActionListener(e -> {

            store.loadFromFile("students.txt");

            JOptionPane.showMessageDialog(null, "Loaded!");
        });

        searchBtn.addActionListener(e -> {

            String query = searchField.getText().trim();

            if (query.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Enter a surname to search"
                );

                return;
            }

            Person result = store.searchBySurname(query);

            if (result == null) {

                JOptionPane.showMessageDialog(
                        null,
                        "No student found"
                );

            } else {

                displayStudents.setText(result.toString());
            }
        });

        frame.setVisible(true);
    }
}