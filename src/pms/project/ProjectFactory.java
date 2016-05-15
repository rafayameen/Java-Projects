/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.project;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Rafay Ameen
 */
public class ProjectFactory {

    static ArrayList<Project> totalProjects = new ArrayList<>();
    private boolean recordFound = false;

    public ProjectFactory() {

    }

    public static ProjectFactory getInstance() {
        return new ProjectFactory();
    }

    public void add(Project p) {
        totalProjects.add(p);
    }

    public void writeToProjectFile(ArrayList<Project> projects) throws IOException {

        // write object to file
        FileOutputStream fos = new FileOutputStream("D:\\Projects.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Project p : projects) {
            oos.writeObject(p);
        }
        oos.close();
    }

    public Project getProjectById(int id) throws IOException, ClassNotFoundException, EOFException {

        // read object from file
        Project pr = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        totalProjects.clear();
        try {
            fis = new FileInputStream("D:\\Projects.ser");
            ois = new ObjectInputStream(fis);

            while (((pr = (Project) ois.readObject()) != null)) {

                totalProjects.add(pr);
            }

        } catch (FileNotFoundException | InvalidClassException e) {
            System.out.println("File Not Found");
        } catch (EOFException eof) {

        } finally {
            if (ois != null) {
                ois.close();
            }
        }

        for (Project p : totalProjects) {

            if (p.getId() == id) {
                recordFound = true;
                pr = p;
            }

        }
        if (recordFound == true) {
            return pr;
        } else {
            System.out.println("Record Not Found");
        }
        return null;
    }

}
