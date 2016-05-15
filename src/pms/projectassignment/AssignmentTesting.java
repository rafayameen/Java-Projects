/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.projectassignment;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import pms.project.Project;
import pms.project.ProjectFactory;
import pms.student.Student;
import pms.student.StudentFactory;

/**
 *
 * @author Rafay Ameen
 */
public class AssignmentTesting {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        StudentFactory sf = StudentFactory.getInstance();

        ProjectFactory pf = ProjectFactory.getInstance();

        //Add 3  Students
//        studentList.add(new Student(12, "Abdullah", 3.4f));
//        studentList.add(new Student(14, "Rafay", 3.4f));
//        studentList.add(new Student(15, "Taimi", 3.4f));
//        sf.writeToProjectFile(studentList);
        //Print Required record
        try {
            studentList = sf.getStudentsByID(12, 15);
            Project p = pf.getProjectById(3);
            ProjectAssignment pa = new ProjectAssignment(p, studentList);
            studentList.clear();

            studentList = pa.getAssignedStudentsList();
//          
            ProjectAssignmentFactory paf = ProjectAssignmentFactory.getInstance();
            paf.add(studentList);

            List<Project> pList = paf.getProjectsById(3);
            List<Student> sList = paf.getStudentsByProjectID(3);

//            for (Student s : sList) {
//                System.out.println(s.toString());
//            }
            System.out.println(pa.getAssignedStudents());

        } catch (NullPointerException e) {

        }

    }

}
