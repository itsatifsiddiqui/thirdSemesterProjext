package app;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Student;

public class Table<StudentTableModel> extends JFrame {

    JTable table;

    public Table(ArrayList<Student> students) {

        setSize(800, 600);
        setTitle("Student Records");

        String[] columnNames = { "Student Name", "Phone", "Gender", "GPA", "Semester", "Section", "Department Name",
                "Department Location" };

        // ArrayList<Student> students = Operations.readAllData();

        if (students.size() == 0) {
            JOptionPane.showMessageDialog(null, "No Student Exist Try Adding Some");
            return;
        }

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);

        students.forEach((student) -> {
            Object[] x = { student.getName(), student.getPhone(), student.getGender(), student.getGpa(),
                    student.getSemester(), student.getSection(), student.getDep().getName(),
                    student.getDep().getLoacation() };
            tableModel.addRow(x);
        });

        table.setPreferredScrollableViewportSize(new Dimension(640, 480));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        setResizable(false);
        setVisible(true);
    }

}