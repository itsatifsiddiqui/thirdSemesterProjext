package app;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Operations {

    @SuppressWarnings("unchecked")
    public static <T>  ArrayList<T> readAllData(String fileName) {
        ArrayList<T> list = new ArrayList<T>(0);
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
            boolean EOF = false;
            while (!EOF) {
                try {
                    T myObj = (T) inputStream.readObject();
                    list.add(myObj);
                } catch (ClassNotFoundException e) {
                    // System.out.println("Class not found");
                } catch (EOFException end) {
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally { 
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
        }

        return list;
    }

    public static <T> void writeData(T s,String fileName) {
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<T> list =  readAllData(fileName);
            // Append new object into existing list
            list.add(s);
            // Open Stream for writing
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

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

    public static <T> void writeList(ArrayList<T> list,String fileName) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
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

    // public static void updateData(Student s, String nameSearch) {
    //     try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));) {
            // ArrayList<Student> StudentList = readAllData();
            // for (Student studentList : StudentList) {
            //     if (studentList.getName().equals(nameSearch)) {
            //         studentList.setName(s.getName());
            //         studentList.setPhone(s.getPhone());
            //         studentList.setGpa(s.getGpa());
            //         studentList.setSemester(s.getSemester());
            //         studentList.setSection(s.getSection());
            //         studentList.getDep().setName(s.getDep().getName());
            //         studentList.getDep().setLoacation(s.getDep().getLoacation());
            //         studentList.setGender(s.getGender());
            //         break;
            //     }
            // }

    //         for (Student studentList : StudentList)
    //             outputStream.writeObject(studentList);

    //     } catch (IOException e) {
    //         System.out.println("IO Exception while opening file");
    //     }
    // }

    // public static boolean deleteStudent(String name) {
    //     boolean found = false;
    //     try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));) {
            // ArrayList<Student> StudentList = readAllData();

            // found = StudentList.removeIf((std) -> (std.getName().equals(name)));

            // for (Student studentList : StudentList)
            //     outputStream.writeObject(studentList);

    //     } catch (IOException e) {
    //         System.out.println("IO Exception while opening file");
    //     }
    //     return found;
    // }

    // public static ArrayList<Student> searchStudent(String name) {
    //     ArrayList<Student> studentList = new ArrayList<Student>(0);

    //     try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));) {
    //         ArrayList<Student> StudentList = readAllData();
    //         for (Student std : StudentList) {
    //             if (std.getName().equals(name))
    //                 studentList.add(std);
    //         }

    //         for (Student stud : StudentList)
    //             outputStream.writeObject(stud);
    //     } catch (IOException e) {
    //         System.out.println("IO Exception while opening file");
    //     }
    //     return studentList;
    // }

    // public static ArrayList<Student> searchStudentByDepartment(String deptName) {
    //     ArrayList<Student> studentsList = new ArrayList<Student>();

    //     try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));) {
    //         ArrayList<Student> StudentList = readAllData();

    //         for (Student std : StudentList) {
    //             if (std.getDep().getName().equals(deptName))
    //                 studentsList.add(std);
    //         }
    //         for (Student stud : StudentList)
    //             outputStream.writeObject(stud);
    //     } catch (IOException e) {
    //         System.out.println("IO Exception while opening file");
    //     }
    //     return studentsList;
    // }
}