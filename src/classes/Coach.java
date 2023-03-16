/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author sarah
 */
public class Coach {
    private int coachID;
     private int rating;
    private String coachName;
    private String phone;
    private String sportName;
    private String dateJoined ;
    private String hourlyRate;
    private String address;
    
   

    public Coach(int coachID, String coachName) {
        this.coachID = coachID;
        this.coachName = coachName;
    }


    
    public Coach(String coachName, String phone, String sportName, String dateJoined, String hourlyRate, String address) {
        
        this.coachName = coachName;
        this.phone = phone;
        this.sportName = sportName;
        this.dateJoined = dateJoined;
        this.hourlyRate = hourlyRate;
        this.address = address;
    }
    
    
    

    //empty constructor:
    public Coach() {
    }
    
    //complete constructor:

    public Coach(int coachID, int rating, String coachName, String phone, String sportName, String dateJoined, String hourlyRate,  String address) {
        this.coachID = coachID;
        this.coachName = coachName;
        this.dateJoined = dateJoined;
        this.hourlyRate = hourlyRate;
        this.phone = phone;
        this.address = address;
        this.sportName = sportName;
        this.rating = rating;
    }
   

    public int getCoachID() {
        return coachID;
    }

    public void setCoachID(int coachID) {
        this.coachID = coachID;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
    
   
    public static List<Coach> getAllCoach(){
        FileHandler f = new FileHandler("coach.txt");
        List<Coach> coachArray = f.readFromCoachFile();
        return coachArray;
    }
    
    public Coach searchCoachbyRating(){
        FileHandler f = new FileHandler("coach.txt");
        Coach returnCoach = f.searchFileCoachRating(this.rating);
        System.out.println(returnCoach);
        return returnCoach;
    }
 
    public Coach searchCoachbyID(){
        FileHandler f = new FileHandler("coach.txt");
        Coach returnCoach = f.searchFileCoach(this.coachID);
        System.out.println(returnCoach);
        return returnCoach;
    }
    
    public void editCoach(Coach newC) {
        FileHandler fo = new FileHandler("coach.txt");
        fo.editRecord(this, newC);
    }
    
    
    public String coachDetails() {
        return this.coachID + "/" + this.rating + "/" + this.coachName + "/" + this.phone  + "/"+  this.sportName + "/" + this.dateJoined + "/" + this.hourlyRate + "/"   + this.address;
    }

    @Override
    public String toString() {
        return "Coach{" + "coachID=" + coachID + ", rating=" + rating + ", coachName=" + coachName + ", phone=" + phone + ", sportName=" + sportName + ", dateJoined=" + dateJoined + ", hourlyRate=" + hourlyRate + ", address=" + address + '}';
    }
    
    
    
    
    
    

    



 

    
    
}
