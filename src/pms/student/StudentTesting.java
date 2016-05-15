/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafay Ameen
 */
public class StudentTesting {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Student> studentList = new ArrayList<Student>();
        StudentFactory sf = StudentFactory.getInstance();

        //Add 3  Students
//        studentList.add(new Student(12, "Abdullah", 3.4f));
//        studentList.add(new Student(14, "Rafay", 3.4f));
//        studentList.add(new Student(15, "Taimi", 3.4f));
//        sf.writeToProjectFile(studentList);
        //Print Required record
        try {

//            Student s = sf.getStudentByID(13);
//            System.out.println(s.toString());
            List<Student> sList = sf.getStudentsByID(12, 14);
            for (Student s : sList) {
                System.out.println(s.toString());
            }
        } catch (NullPointerException e) {

        }
    }

}
