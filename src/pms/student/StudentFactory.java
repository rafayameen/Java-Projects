/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.student;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafay Ameen
 */
public class StudentFactory {

    static ArrayList<Student> totalStudents = new ArrayList<>();
    private boolean recordFound = false;

    public StudentFactory() {

    }

    public static StudentFactory getInstance() {
        return new StudentFactory();
    }

    public void add(Student p) {
        totalStudents.add(p);
    }

    public void writeToProjectFile(ArrayList<Student> projects) throws IOException {

        // write object to file
        FileOutputStream fos = new FileOutputStream("Students.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Student p : projects) {
            oos.writeObject(p);
        }
        oos.close();
    }

    public Student getStudentByID(int id) throws IOException, ClassNotFoundException, EOFException {

        // read object from file
        Student st = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        totalStudents.clear();
        try {
            fis = new FileInputStream("Students.ser");
            ois = new ObjectInputStream(fis);

            while (((st = (Student) ois.readObject()) != null)) {

                totalStudents.add(st);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (EOFException eof) {

        } finally {
            if (ois != null) {
                ois.close();
            }
        }

        for (Student s : totalStudents) {

            if (s.getId() == id) {
                recordFound = true;
                st = s;
            }

        }
        if (recordFound == true) {
            return st;
        } else {
            System.out.println("Record Not Found");
        }
        return null;
    }

    //getStudents List By using Variable Argument List
    public List<Student> getStudentsByID(int... id) throws IOException, ClassNotFoundException, EOFException {
        // read object from file
        Student st = null;
        List<Student> sList = new ArrayList<>();
        List<Student> sReturnList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("Students.ser");
            ois = new ObjectInputStream(fis);
            sList.clear();
            while (((st = (Student) ois.readObject()) != null)) {

                sList.add(st);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (EOFException eof) {

        } finally {
            if (ois != null) {
                ois.close();
            }
        }

        for (Student s : sList) {
            for (int i = 0; i < id.length; i++) {
                if (s.getId() == id[i]) {
                    sReturnList.add(s);
                }
            }

        }

        return sReturnList;
    }

}
