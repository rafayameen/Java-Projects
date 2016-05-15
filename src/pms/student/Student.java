/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.student;

import java.io.Serializable;
import pms.project.Project;

/**
 *
 * @author Rafay Ameen
 */
public class Student implements Serializable {

    private int id;
    private String name;
    private float cgpa;
    private Project projectOfStudent;

    public Student() {
        id = 0;
        name = "";
        cgpa = 0.0f;
    }

    public Student(int id, String name, float cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public Project getProjectOfStudent() {
        return projectOfStudent;
    }

    public void setProjectOfStudent(Project projectOfStudent) {
        this.projectOfStudent = projectOfStudent;
    }

    @Override
    public String toString() {

        return "Student[ ID: " + this.id + " Name: " + this.name + "  CGPA: " + this.cgpa + " ]"
                + "Project[ " + this.getProjectOfStudent() + " ]" + "Date: " + this.getProjectOfStudent().getDateOfAssignment();
    }

}
