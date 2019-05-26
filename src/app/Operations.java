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

    private static final String fileName = "students.ser";

    @SuppressWarnings("unchecked")
    public static <T>  ArrayList<T> readAllData(String fileName) {
        // ArrayList initialized with size 0
        ArrayList<T> list = new ArrayList<T>(0);
        // Input stream
        ObjectInputStream inputStream = null;
        try {
            // open file for reading
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
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
    //         ArrayList<Student> StudentList = readAllData();
    //         for (Student studentList : StudentList) {
    //             if (studentList.getName().equals(nameSearch)) {
    //                 studentList.setName(s.getName());
    //                 studentList.setPhone(s.getPhone());
    //                 studentList.setGpa(s.getGpa());
    //                 studentList.setSemester(s.getSemester());
    //                 studentList.setSection(s.getSection());
    //                 studentList.getDep().setName(s.getDep().getName());
    //                 studentList.getDep().setLoacation(s.getDep().getLoacation());
    //                 studentList.setGender(s.getGender());
    //                 break;
    //             }
    //         }

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