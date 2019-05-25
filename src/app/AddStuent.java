// package app;

// import java.awt.BorderLayout;
// import java.awt.GridLayout;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.JButton;
// import javax.swing.JComboBox;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import javax.swing.JTextField;

// import models.Department;
// import models.Student;

// public class AddStuent extends JFrame {
//     JLabel nameLabel;
//     JLabel phoneLabel;
//     JLabel genderLabel;
//     JLabel GPALabel;
//     JLabel semesterLabel;
//     JLabel sectionLabel;
//     JLabel deptNameLabel;
//     JLabel locationLabel;
//     JTextField name;
//     JTextField phone;
//     JComboBox<String> gender;
//     JTextField GPA;
//     JTextField semester;
//     JTextField section;
//     JTextField deptName;
//     JTextField locaion;
//     JButton addButton;
//     String nameSearch = null;

//     public AddStuent(Student std) {

//         JPanel panel = new JPanel();
//         panel.setSize(640, 350);
//         panel.setLayout(new GridLayout(8, 2));
//         add(panel, BorderLayout.CENTER);
//         setSize(640, 420);
//         if (std == null)
//             setTitle("Add New Student");
//         else {
//             setTitle("Edit Student");
//             nameSearch = std.getName();
//         }
//         setLayout(new BorderLayout());
//         setResizable(false);

//         nameLabel = new JLabel("    Student Name");
//         phoneLabel = new JLabel("    Student Phone Number");
//         genderLabel = new JLabel("    Student Gender");
//         GPALabel = new JLabel("    Student Gpa");
//         semesterLabel = new JLabel("    Student Semester ");
//         sectionLabel = new JLabel("    Student Section");
//         deptNameLabel = new JLabel("    Department Name");
//         locationLabel = new JLabel("    Department Location");

//         addButton = new JButton(std == null ? "Add Student" : "Edit Student");

//         name = new JTextField(std == null ? "" : std.getName());
//         phone = new JTextField(std == null ? "" : std.getPhone());
//         GPA = new JTextField(std == null ? "" : std.getGpa());
//         semester = new JTextField(std == null ? "" : std.getSemester());
//         section = new JTextField(std == null ? "" : std.getSection());
//         deptName = new JTextField(std == null ? "" : std.getDep().getName());
//         locaion = new JTextField(std == null ? "" : std.getDep().getLoacation());
//         gender = new JComboBox<>(new String[] { "MALE", "FEMALE" });

//         panel.add(nameLabel);
//         panel.add(name);
//         panel.add(phoneLabel);
//         panel.add(phone);
//         panel.add(genderLabel);
//         panel.add(gender);
//         panel.add(GPALabel);
//         panel.add(GPA);
//         panel.add(semesterLabel);
//         panel.add(semester);
//         panel.add(sectionLabel);
//         panel.add(section);
//         panel.add(deptNameLabel);
//         panel.add(deptName);
//         panel.add(locationLabel);
//         panel.add(locaion);
//         add(addButton, BorderLayout.SOUTH);

//         addButton.addActionListener(new ActionListener() {

//             @Override
//             public void actionPerformed(ActionEvent arg0) {

//                 String gname = name.getText().toLowerCase();
//                 String gphone = phone.getText().toLowerCase();
//                 String gGPA = GPA.getText().toLowerCase();
//                 String gsemester = semester.getText().toLowerCase();
//                 String gsection = section.getText().toLowerCase();
//                 String gdeptName = deptName.getText().toLowerCase();
//                 String glocaion = locaion.getText().toLowerCase();

//                 if (std == null) {
//                     if (gname.isEmpty() || gphone.isEmpty() || gGPA.isEmpty() || gsemester.isEmpty()
//                             || gsection.isEmpty() || gdeptName.isEmpty() || glocaion.isEmpty()) {
//                         JOptionPane.showMessageDialog(null, "Please Fill Out All Fields");
//                     } else {
//                         Student newStudent = new Student(gname, gphone, gender.getSelectedItem().toString(), gGPA,
//                                 gsemester, gsection, new Department(gdeptName, glocaion));
//                         Operations.writeData(newStudent);
//                         setVisible(false);
//                         dispose();
//                         JOptionPane.showMessageDialog(null, "Student Added Successfully");

//                     }
//                 } else {
//                     if (gname.isEmpty() || gphone.isEmpty() || gGPA.isEmpty() || gsemester.isEmpty()
//                             || gsection.isEmpty() || gdeptName.isEmpty() || glocaion.isEmpty()) {
//                         JOptionPane.showMessageDialog(null, "Please Fill Out All Fields");
//                     } else {
//                         Student newStudent = new Student(gname, gphone, gender.getSelectedItem().toString(), gGPA,
//                                 gsemester, gsection, new Department(gdeptName, glocaion));
//                         Operations.updateData(newStudent, nameSearch);
//                         setVisible(false);
//                         dispose();
//                         JOptionPane.showMessageDialog(null, "Student Edited Successfully");
//                     }
//                 }

//             }
//         });

//         setVisible(true);
//         setLocationRelativeTo(null);

//     }

// }