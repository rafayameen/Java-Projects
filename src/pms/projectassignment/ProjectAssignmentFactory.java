/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.projectassignment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pms.project.Project;
import pms.student.Student;

/**
 *
 * @author Rafay Ameen
 */
public class ProjectAssignmentFactory {

    private ArrayList<ProjectAssignment> assignedProjects = new ArrayList<>();
    private ArrayList<Student> assignedStudents = new ArrayList<>();
    private boolean addedSuccessfully;
    private boolean recordFound;

    public static ProjectAssignmentFactory getInstance() {
        return new ProjectAssignmentFactory();
    }

    public boolean add(List<Student> st) throws FileNotFoundException, IOException {
        for (Student s : st) {
            assignedStudents.add(s);
        }
        // write object to file
        FileOutputStream fos = new FileOutputStream("AssignedProjects.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Student s : assignedStudents) {
            oos.writeObject(s);
            addedSuccessfully = true;
        }
        oos.close();

        return addedSuccessfully;
    }

    public List<Project> getProjectsById(int... id) throws IOException, ClassNotFoundException, EOFException {
        // read object from file
        Student st = null;
        List<Project> pList = new ArrayList<>();
        List<Project> pReturnList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("AssignedProjects.ser");
            ois = new ObjectInputStream(fis);
            pList.clear();
            while (((st = (Student) ois.readObject()) != null)) {

                pList.add(st.getProjectOfStudent());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (EOFException eof) {

        } finally {
            if (ois != null) {
                ois.close();
            }
        }

        for (Project p : pList) {
            for (int i = 0; i < id.length; i++) {
                if (p.getId() == id[i]) {
                    pReturnList.add(p);
                }
            }

        }

        return pReturnList;
    }

    //getStudentsByProjectID
    public List<Student> getStudentsByProjectID(int... id) throws IOException, ClassNotFoundException, EOFException {
        // read object from file
        Student st = null;
        List<Student> sList = new ArrayList<>();
        List<Student> sReturnList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("AssignedProjects.ser");
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
                if (s.getProjectOfStudent().getId() == id[i]) {
                    sReturnList.add(s);
                }
            }

        }

        return sReturnList;
    }

}
