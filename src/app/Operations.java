package app;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.Student;

public class Operations {

    public static <T> ArrayList<T> readAllData() {
        // ArrayList initialized with size 0
        ArrayList<T> list = new ArrayList<T>(0);
        // Input stream
        ObjectInputStream inputStream = null;
        try {
            // open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("students.ser"));
            // End Of File flag
            boolean EOF = false;
            // Keep reading file until file ends
            while (!EOF) {
                try {
                    // read object and type cast into CarDetails object
                    T myObj = (T) inputStream.readObject();
                    // add object into ArrayList
                    list.add(myObj);
                    // System.out.println("Read: " + myObj.getName());
                } catch (ClassNotFoundException e) {
                    // System.out.println("Class not found");
                } catch (EOFException end) {
                    // EOFException is raised when file ends
                    // set End Of File flag to true so that loop exits
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
            // System.out.println("Cannot find file");
        } catch (IOException e) {
            // System.out.println("IO Exception while opening stream");
            // e.printStackTrace();
        } finally { // cleanup code to close stream if it was opened
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
        }

        // returns ArrayList
        return list;
    }

    public static <T> void writeData(T s) {
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<T> list = readAllData();
            // Append new object into existing list
            list.add(s);
            // Open Stream for writing
            outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"));

            // Write all objects (old and new one) into the file

            for (T student : list)
                outputStream.writeObject(student);
        } catch (IOException e) {
            System.out.println("IO Exception while opening file");
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
        }
    }

    public static void updateData(Student s, String nameSearch) {
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<Student> StudentList = readAllData();
            // Append new object into existing list

            for (Student student : StudentList) {
                if (student.getName().equals(nameSearch)) {
                    student.setName(s.getName());
                    student.setPhone(s.getPhone());
                    student.setGpa(s.getGpa());
                    student.setSemester(s.getSemester());
                    student.setSection(s.getSection());
                    student.getDep().setName(s.getDep().getName());
                    student.getDep().setLoacation(s.getDep().getLoacation());
                    student.setGender(s.getGender());
                    break;
                }
            }

            // Open Stream for writing
            outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"));

            // Write all objects (old and new one) into the file

            for (Student student : StudentList)
                outputStream.writeObject(student);

        } catch (IOException e) {
            System.out.println("IO Exception while opening file");
        } finally { // cleanup code which closes output stream if its object was created
            try {
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
        }
    }

    public static boolean deleteStudent(String name) {
        boolean found = false;
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<Student> StudentList = readAllData();
            // Append new object into existing list

            found = StudentList.removeIf((std) -> (std.getName().equals(name)));

            // Open Stream for writing

            outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"));

            // Write all objects (old and new one) into the file

            for (Student student : StudentList)
                outputStream.writeObject(student);

        } catch (IOException e) {
            System.out.println("IO Exception while opening file");
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();

            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
            return found;

        }

    }

    public static ArrayList<Student> searchStudent(String name) {
        ObjectOutputStream outputStream = null;
        ArrayList<Student> student = new ArrayList<Student>(0);

        try {
            ArrayList<Student> StudentList = readAllData();

            for (Student std : StudentList) {
                if (std.getName().equals(name))
                    student.add(std);
            }

            // Open Stream for writing

            outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"));

            // Write all objects (old and new one) into the file

            for (Student stud : StudentList)
                outputStream.writeObject(stud);
        } catch (IOException e) {
            System.out.println("IO Exception while opening file");
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
            if (student.size() > 0)
                return student;
            return null;
        }

    }

    public static ArrayList<Student> searchStudentByDepartment(String deptName) {
        ObjectOutputStream outputStream = null;
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            ArrayList<Student> StudentList = readAllData();

            for (Student std : StudentList) {
                if (std.getDep().getName().equals(deptName))
                    students.add(std);
            }
            System.out.println(students);

            // Open Stream for writing

            outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"));

            // Write all objects (old and new one) into the file

            for (Student stud : StudentList)
                outputStream.writeObject(stud);
        } catch (IOException e) {
            System.out.println("IO Exception while opening file");
        } finally {

            try {
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
            return students;
        }
    }
}