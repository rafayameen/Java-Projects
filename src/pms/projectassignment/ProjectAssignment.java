/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.projectassignment;



import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import pms.project.Project;
import pms.student.Student;

/**
 *
 * @author Rafay Ameen
 */
public class ProjectAssignment implements Serializable {

    private ArrayList<Student> assignmentList = new ArrayList<>();
    private boolean projectAssigned;

    private int totalProjects;
    private int totalStudents;
    private static int count;

    private void incrementAssignedStudents() {
        count++;

        totalStudents = count;
    }

    public int getAssignedStudents() {
        return count;
    }

    ProjectAssignment(Project p, List<Student> sList) {
        for (Student s : sList) {
            if (p.getDifficulty().equalsIgnoreCase("MEDIUM")) {
                if (s.getCgpa() >= 2.5) {
                    s.setProjectOfStudent(p);
                }
                projectAssigned = true;

            }
            if (p.getDifficulty().equalsIgnoreCase("HARD")) {
                if (s.getCgpa() >= 3.0 && s.getCgpa() <= 4.0) {
                    s.setProjectOfStudent(p);
                }
                projectAssigned = true;
            }
            if (p.getDifficulty().equalsIgnoreCase("EASY")) {
                if (s.getCgpa() >= 2.0 && s.getCgpa() < 2.5) {
                    s.setProjectOfStudent(p);
                }
                projectAssigned = true;
            }

            if (projectAssigned) {
                assignmentList.add(s);
                incrementAssignedStudents();
            } else {
                System.out.println("Cannot Assign Project");
                System.out.println("Project Difficulty : " + p.getDifficulty());
                System.out.println("CGPA : " + s.getCgpa());
            }

        }
    }

    @Override
    public String toString() {
        return assignmentList.toString();
    }

    public List<Student> getAssignedStudentsList() {
        if (assignmentList.isEmpty()) {
            return null;
        }

        List<Student> sList = new ArrayList<>();
        for (Student s : assignmentList) {
            sList.add(s);
        }

        return sList;
    }

    public int getTotalProjects() {
        totalProjects = Project.totalProjects();
        return totalProjects;
    }

}
