/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafay Ameen
 */
public class ProjectTesting {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Project> projectList = new ArrayList<Project>();
        ProjectFactory pf = ProjectFactory.getInstance();

        //Add 3  Projects
//       projectList.add(new Project("OpenGl",2));
//       projectList.add(new Project("C++",0));
//       projectList.add(new Project("Java",1));
//        
//      pf.writeToProjectFile(projectList);
        try {

            Project p = pf.getProjectById(3);
            System.out.println(p.toString());
        } catch (NullPointerException e) {

        }

    }

}
