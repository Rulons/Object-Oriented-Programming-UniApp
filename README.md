# KlainsUniApp

## Overview
KlainsUniApp is a Java application designed to manage student and employee records for university halls of residence.  
It demonstrates **object-oriented programming (OOP)** principles including inheritance, encapsulation, and class management.  
The program provides a GUI for entering, storing, and navigating student data, along with functionality to save and load records from a text file.

---

## Features
- Enter student details including:
  - Given Name, Surname, Date of Birth
  - Student ID, Course Name
- Store multiple students in memory using a `Store` class
- Navigate through stored records (Next Record functionality)
- Save and load records to/from a text file
- Clear input fields after submission
- Simple GUI built using **Swing** components (manual coding, no GUI builder)
- Demonstrates OOP concepts: `Person` base class, `Student` and `Employee` subclasses, `Store` class to manage records

---


---

## Requirements
- Java Development Kit (JDK) 17
- Visual Studio Code (or another Java IDE)
- Java Extension Pack installed in VS Code

---

## How to Run
1. Open the project folder in VS Code.
2. Ensure JDK 17 is installed and detected by VS Code.
3. Compile and run `KlainsUniApp.java`:
   - Right-click `KlainsUniApp.java` → **Run Java**
   - Or click the run button in VS Code
4. Use the GUI to:
   - Enter student information
   - Click **Enter Student Details** to add to the store
   - Click **Next Record** (if implemented) to navigate through records
   - Save or load records from a text file (if implemented)

---

## How It Works
- The GUI collects input from text fields and creates `Student` objects.
- `Student` extends `Person` to demonstrate inheritance.
- All objects are stored in a `Store` object using an `ArrayList`.
- You can navigate through records using the next-record feature.
- Data can be saved to a text file for persistence and loaded back when needed.

---

## Notes
- Input validation is applied to ensure sensible values (optional: can expand later)
- GUI is coded manually using Swing — no drag-and-drop editors were used
- Designed for simplicity and demonstration of OOP concepts in a coursework setting





