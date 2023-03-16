/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sarah
 */
public class FileHandler {
    
    
    private File file;

    public FileHandler(String file) {
        // Aggregation/Losely Coupled
        this.file = new File(file);
    }

    public FileHandler(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    // Read the Student's File
    public List<Student> readFromStudentFile() {
        List studentList = new ArrayList();
        try {
            Scanner s = new Scanner(System.in);
            s = new Scanner(file);
            String line;
            while(s.hasNext()) {
                line = s.nextLine();
                if (!(line.isEmpty())) {
                    String[] studentArray = line.split("/");
                    Student student = new Student(studentArray[1], studentArray[2], studentArray[3], studentArray[4], studentArray[5], studentArray[6]);
                    student.setStudentID(Integer.parseInt(studentArray[0].trim()));
                    studentList.add(student);
                }
            }
        } catch (FileNotFoundException  e) {
            System.err.println("ReadFileStudent Error" + e);
        }
        System.out.println(studentList);
        return studentList;
    }
    
    public Student searchFileStudent(int studentID) {
        List<Student> studentList = this.readFromStudentFile();
        Student studMatch = new Student();
        for(Student stud: studentList) {
            if(Integer.toString(studentID).replaceAll("/", "").equals(Integer.toString(stud.getStudentID()).replaceAll("/", ""))) {
                studMatch = stud;
            }
        }
        return studMatch; 
    } 
    
    //read from Coach file:
    public List<Coach> readFromCoachFile() {
        List coachList = new ArrayList();
        try {
            Scanner s = new Scanner(System.in);
            s = new Scanner(file);
            String line;
            while(s.hasNext()) {
                line = s.nextLine();
                if (!(line.isEmpty())) {
                    String[] coachArray = line.split("/");
                    Coach coach = new Coach ( coachArray[2], coachArray[3], coachArray[4], coachArray[5], coachArray[6], coachArray[7]);
                    coach.setCoachID(Integer.parseInt(coachArray[0].trim()));
                    coach.setRating(Integer.parseInt(coachArray[1].trim()));
                    coachList.add(coach);
                    
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ReadFileCoach Error" + e);
        }
        System.out.println(coachList);
        return coachList;
    }
    
    
    public Coach searchFileCoach(int coachID) {
        List<Coach> coachList = this.readFromCoachFile();
        Coach coachMatch = new Coach();
        for(Coach coach: coachList) {
            if(Integer.toString(coachID).replaceAll("/", "").equals(Integer.toString(coach.getCoachID()).replaceAll("/", ""))) {  
                coachMatch = coach;
            }
        }
        return coachMatch;
    } 
    
    public Coach searchFileCoachRating(int rating) {
        List<Coach> coachList = this.readFromCoachFile();
        Coach coachMatch = new Coach();
        for(Coach coach: coachList) {
            if(Integer.toString(rating).replaceAll("/", "").equals(Integer.toString(coach.getRating()).replaceAll("/", ""))) {  //Integer.toString()
                coachMatch = coach;
            }
        }
        return coachMatch;
    } 
 
   public List<Sport> readFromSportFile() {
        List <Sport> sportList = new ArrayList();
        try {
            Scanner s = new Scanner(System.in);
            s = new Scanner(file);
            String line;
            while(s.hasNext()) {
                line = s.nextLine();
                if (!(line.isEmpty())) {
                    String[] sportArray = line.split("/");
                    Sport sport = new Sport(Integer.parseInt(sportArray[0].trim()), sportArray[1], sportArray[2], sportArray[3], sportArray[4], sportArray[5]);
                    sportList.add(sport);
                }
            }
        } catch (Exception e) {
            System.err.println("ReadFileUser Error" + e);
        }
        System.out.println(sportList);
        return sportList;
    }
   
    public Sport searchFileSport(int sportID) {
        List<Sport> sportList = this.readFromSportFile();
        Sport sportMatch = new Sport();
        for(Sport spor: sportList) {
            if(Integer.toString(sportID).replaceAll("/", "").equals(Integer.toString(spor.getSportID()).replaceAll("/", ""))) {
                sportMatch = spor;
            }

        }
        return sportMatch; 
    } 
    
        // Read the Schedule File
    public List<SportSchedule> readFromScheduleFile() {
        List scheduleList = new ArrayList();
        try {
            Scanner s = new Scanner(System.in);
            s = new Scanner(file);
            String line;
            while(s.hasNext()) {
                line = s.nextLine();
                if (!(line.isEmpty())) {
                    String[] scheduleArray = line.split("/");
                    SportSchedule ss = new SportSchedule (Integer.parseInt(scheduleArray[0].trim()), scheduleArray[1], scheduleArray[2], scheduleArray[3],scheduleArray[4]);
                    scheduleList.add(ss);
                }
            }
        } catch (Exception e) {
            System.err.println("ReadFileUser Error" + e);
        }
        System.out.println(scheduleList);
        return scheduleList;
    }
    
    
    
    public void editRecord(Sport sp, Sport newsp){
        //Temp file:
        File newfile = new File("TempSport.txt");
        //read from old file and write to temp file
        try{
            FileWriter fw = new FileWriter(newfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            Scanner sc = new Scanner(System.in);
            sc = new Scanner(file);
            
            while(sc.hasNext()){
                String line = sc.nextLine();
                
                if(!(line.isEmpty())){
                    String [] spArray = line.split("/");
                    if(Integer.parseInt(spArray[0].replaceAll("\\s+", "")) != sp.getSportID()){
                        pw.write(line);
                        pw.println();
                    } else {
                        pw.write(newsp.sportDetails());
                        pw.println();
                    }
                    
                }
 
            }
            pw.flush();
            pw.close();
            file.delete();
            File f = new File("sport.txt");
            newfile.renameTo(f);
        
        } catch (IOException ex) {
            System.err.println("Read file Error" + ex);

        }
        
        
    }
    
    public void editRecord(Coach c, Coach newC){
        //Temp file:
        File newfile = new File("TempCoach.txt");
        //read from old file and write to temp file
        try{
            FileWriter fw = new FileWriter(newfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                Scanner sc = new Scanner(System.in);
                sc = new Scanner(file);
                
                while(sc.hasNext()){
                    String line = sc.nextLine();
                    
                    if(!(line.isEmpty())){
                        String [] cArray = line.split("/");
                        
                        if(Integer.parseInt(cArray[0].replaceAll("\\s+", "")) != c.getCoachID()){
                            pw.write(line);
                            pw.println();
                            
                        } else {
                            pw.write(newC.coachDetails());
                            pw.println();
                        }
                    } 
                }
                pw.flush(); 
                pw.close();
                file.delete();
                File f = new File("coach.txt");
                newfile.renameTo(f);  
            }
            
        } catch (IOException ex) {
            System.err.println("Read file Error" + ex);

        }
        
    }
    
    
    
    public void editRecord(SportSchedule ss, SportSchedule newS){
        //Temp file:
        File newfile = new File("TempSchedule.txt");
        //read from old file and write to temp file
        try{
            FileWriter fw = new FileWriter(newfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                Scanner sc = new Scanner(System.in);
                sc = new Scanner(file);
                
                while(sc.hasNext()){
                    String line = sc.nextLine();
                    
                    if(!(line.isEmpty())){
                        String [] schedArray = line.split("/");
                        if(Integer.parseInt(schedArray[0].replaceAll("\\s+", "")) != ss.getId() ){
                            pw.write(line);
                            pw.println();
                            
                            
                        } else {
                            pw.write(newS.scheduleDetails());
                            pw.println();
                        }

                    }
                    
                }     
                pw.flush(); 
                pw.close();
                file.delete();
                File f = new File("schedule.txt");
                newfile.renameTo(f);
            }
            
        } catch (IOException ex) {
            System.err.println("Read file Error" + ex);

        }
        
    }
    
    
    
    

    
    
    
    

}
