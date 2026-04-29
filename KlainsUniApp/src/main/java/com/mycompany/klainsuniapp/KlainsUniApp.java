package com.mycompany.klainsuniapp;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KlainsUniApp {

    public static void main(String[] args) {

        // ✅ NEW: Create Store (VERY IMPORTANT)
        Store store = new Store();

        JFrame frame = new JFrame("Klain's University Hall Application");
        frame.setSize(1200, 530);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text area
        JTextArea displayStudents = new JTextArea();
        displayStudents.setLineWrap(true);
        displayStudents.setWrapStyleWord(true);
        displayStudents.setEditable(false);
        frame.getContentPane().add(displayStudents, BorderLayout.CENTER);

        // Top panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Enter Student Details");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(titleLabel);
        topPanel.add(Box.createVerticalStrut(10));

        // Student details
        JPanel personPanel = new JPanel();
        personPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        JTextField givenNameField = new JTextField(10);
        JTextField surnameField = new JTextField(10);
        JTextField dobField = new JTextField(10);

        personPanel.add(new JLabel("Given Name:"));
        personPanel.add(givenNameField);

        personPanel.add(new JLabel("Surname:"));
        personPanel.add(surnameField);

        personPanel.add(new JLabel("Date of Birth:"));
        personPanel.add(dobField);

        topPanel.add(personPanel);
        topPanel.add(Box.createVerticalStrut(10));

        // Course info
        JPanel uniPanel = new JPanel();
        uniPanel.setBorder(BorderFactory.createTitledBorder("Course Information"));

        JTextField studentIdField = new JTextField(15);
        JTextField courseField = new JTextField(15);
        JTextField startDateField = new JTextField(15);

        uniPanel.add(new JLabel("Student ID:"));
        uniPanel.add(studentIdField);

        uniPanel.add(new JLabel("Course Name:"));
        uniPanel.add(courseField);

        uniPanel.add(new JLabel("Start Date:"));
        uniPanel.add(startDateField);

        topPanel.add(uniPanel);

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);

        // Buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JButton submitBtn = new JButton("Enter Student Details");

        submitBtn.addActionListener(e -> {

            // Validation
            if (givenNameField.getText().isEmpty() ||
                surnameField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Please enter at least a name and surname");
                return;
            }

            // Create Student object
            Student stuRes = new Student(
                    givenNameField.getText(),
                    surnameField.getText(),
                    dobField.getText(),
                    studentIdField.getText(),
                    courseField.getText(),
                    startDateField.getText()
            );

            // ✅ NEW: Add to Store
            store.addPerson(stuRes);

            // Display current student
            displayStudents.setText(stuRes.toString());
        });

        // ✅ NEW: Next Record Button
        JButton nextBtn = new JButton("Next Record");

        nextBtn.addActionListener(e -> {
            Person p = store.getNextPerson();

            if (p == null) {
                JOptionPane.showMessageDialog(null, "No records available");
            } else {
                displayStudents.setText(p.toString());
            }
        });

        JButton saveBtn = new JButton("Save Student Details");
        // (still to implement later)

        // Add buttons to panel
        leftPanel.add(submitBtn);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(nextBtn); // ✅ NEW
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(saveBtn);

        frame.add(leftPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }
}
