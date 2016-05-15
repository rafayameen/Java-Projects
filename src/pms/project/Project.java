/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.project;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Rafay Ameen
 */
public final class Project implements Serializable {

    private int id;
    private String description;
    private String difficulty;

    private String projectCode;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Date dateOfAssignment;


    //to increment id
    private static int count = 0;

    private enum DifficultyLevel {

        EASY(0), MEDIUM(1), HARD(2);
        private int value;

        DifficultyLevel(int value) {
            this.value = value;
        }

    }

    public Project() {

        this.id = 0;
        this.description = "";
        this.difficulty = "";
     
    }

    public Project(String description, int difficulty) {
        if (id < 0 || description == null || (difficulty < 0 || difficulty > 2)) {
            return;
        }

        count++;
        id = count;
        this.description = description;
        if (difficulty == 0) {
            setDifficulty(DifficultyLevel.valueOf("EASY").toString());
        } else if (difficulty == 1) {
            setDifficulty(DifficultyLevel.valueOf("MEDIUM").toString());
        }
        if (difficulty == 2) {
            setDifficulty(DifficultyLevel.valueOf("HARD").toString());
        }
        
        //Set randrom Project Code
        setProjectCode();
        
        //Set Date to current System Date
         dateOfAssignment = new Date();
         dateFormat.format(dateOfAssignment);

    }

    @Override
    public String toString() {
        return "CODE " + this.projectCode + "  ID: " + this.id + " Description: " + 
                this.description + "\n   Difficulty: " + difficulty ;
    }

    public String getProjectCode() {
        return projectCode;
    }
    
    private  void setProjectCode()
    {
        Random random= new Random();
        this.projectCode =  new BigInteger(20, random).toString(20).toUpperCase();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Date getDateOfAssignment() {
        return dateOfAssignment;
    }

    public void setDateOfAssignment(Date dateOfAssignment) {
        this.dateOfAssignment = dateOfAssignment;
    }
    
    public static int totalProjects()
    {
        return count;
    }
    
    
    

}
