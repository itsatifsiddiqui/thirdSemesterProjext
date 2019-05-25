// package models;

// import java.io.Serializable;
// import java.lang.Cloneable;

// public class Student extends Person implements Serializable {

//     private String gpa, semester, section;

//     private Department dep;

//     public Student() {
//         super();
//         dep = new Department();
//     }

//     public Student(String name, String phone, String gender, String gpa, String semester, String section,
//             Department dep) {
//         super(name, phone, gender);
//         this.gpa = gpa;
//         this.semester = semester;
//         this.section = section;
//         this.dep = dep;
//     }

//     public String getGpa() {
//         return this.gpa;
//     }

//     public void setGpa(String gpa) {
//         this.gpa = gpa;
//     }

//     public String getSemester() {
//         return this.semester;
//     }

//     public void setSemester(String semester) {
//         this.semester = semester;
//     }

//     public String getSection() {
//         return this.section;
//     }

//     public void setSection(String section) {
//         this.section = section;
//     }

//     public Department getDep() {
//         return this.dep;
//     }

//     public void setDep(Department dep) {
//         this.dep = dep;
//     }

//     @Override
//     public String toString() {
//         return super.toString() + "GPA: " + gpa + "  Semester: " + semester + "  Section: " + section
//                 + "\nDepartment Name: " + dep.getName() + "  Department Location: " + dep.getLoacation() + "\n";

//     }

// }