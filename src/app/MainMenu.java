package app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.*;
import mdlaf.utils.MaterialColors;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JFrame {

    JButton addStudentBtn;
    JButton searchBtn;
    JButton searchByDeptbtn;
    JButton updateByNameBtn;
    JButton delteByNameBtn;
    JButton displayBtn;

    public MainMenu() {

        setSize(640, 480);
        setTitle("Menu");
        setLayout(new GridLayout(6, 1));

        addStudentBtn = new JButton("Add Student");
        addStudentBtn.setFont(new Font(null, Font.BOLD, 26));
        addStudentBtn.setForeground(MaterialColors.GREEN_600);
        addStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new AddStuent(null);
            }
        });

        searchBtn = new JButton("Search Student");
        searchBtn.setFont(new Font(null, Font.BOLD, 26));
        searchBtn.setForeground(MaterialColors.RED_500);
        searchBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = JOptionPane.showInputDialog("Enter Student Name To Search").trim();
                ArrayList<Student> student = Operations.searchStudent(name);
                if (student != null) {
                    new Table<DefaultTableModel>(student);
                } else
                    JOptionPane.showMessageDialog(null, "Student Not Found");
            }
        });

        searchByDeptbtn = new JButton("Search Student By Department");
        searchByDeptbtn.setFont(new Font(null, Font.BOLD, 26));
        searchByDeptbtn.setForeground(MaterialColors.BLUE_500);
        searchByDeptbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = JOptionPane.showInputDialog("Enter Deartment Name").trim().toLowerCase();
                ArrayList<Student> students = Operations.searchStudentByDepartment(name);
                if (students.size() > 0) {
                    new Table<DefaultTableModel>(students);
                } else
                    JOptionPane.showMessageDialog(null, "Student Not Found");

            }
        });

        updateByNameBtn = new JButton("Update Student");
        updateByNameBtn.setForeground(MaterialColors.PURPLE_600);
        updateByNameBtn.setFont(new Font(null, Font.BOLD, 26));
        updateByNameBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = JOptionPane.showInputDialog("Enter Student Name To Search").trim().toLowerCase();
                ArrayList<Student> student = Operations.searchStudent(name);
                if (student != null) {
                    new AddStuent(student.get(0));
                } else
                    JOptionPane.showMessageDialog(null, "Student Not Found");
            }
        });

        delteByNameBtn = new JButton("Delete Student");
        delteByNameBtn.setForeground(MaterialColors.ORANGE_500);
        delteByNameBtn.setFont(new Font(null, Font.BOLD, 26));
        delteByNameBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                String name = JOptionPane.showInputDialog("Enter Student Name To Delete").trim().toLowerCase();
                if (Operations.deleteStudent(name))
                    JOptionPane.showMessageDialog(null, "Student Deleted");
                else
                    JOptionPane.showMessageDialog(null, "Student Not Found");

            }
        });

        displayBtn = new JButton("Display");
        displayBtn.setForeground(MaterialColors.CYAN_600);
        displayBtn.setFont(new Font(null, Font.BOLD, 26));
        displayBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Table<DefaultTableModel>(Operations.readAllData());
            }
        });

        add(addStudentBtn);
        add(searchBtn);
        add(searchByDeptbtn);
        add(updateByNameBtn);
        add(delteByNameBtn);
        add(displayBtn);
        setVisible(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

}