
package classes;

import java.util.List;

/**
 *
 * @author sarah
 */
public class SportSchedule extends Sport {
    //other methods inherited from sport
    private int id;
    private String day;
    private String time;

    
    //COMPLETE CONSTRUCTOR
    public SportSchedule(int sportID, String centerCode, String centerName, String sportCode, String sportName, String day, String time) {
        super(sportID, centerCode, centerName, sportCode, sportName);
        this.day = day;
        this.time = time;
    }

    public SportSchedule() {
    }
    
    

    public SportSchedule(String day, String time) {
        this.day = day;
        this.time = time;
    }

    //USED IN SCHEDULE TEXT
    public SportSchedule(int id, String sportName, String centerName, String day, String time ) {
        super(sportName, centerName);
        this.id = id;
        this.day = day;
        this.time = time;
    }
    

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public static List<SportSchedule> getAllSchedule(){
        FileHandler f = new FileHandler("schedule.txt");
        List<SportSchedule> schedArray = f.readFromScheduleFile();
        return schedArray;
    }
    
    public String scheduleDetails(){
        return this.id + "/"  + this.getSportName() + "/" + this.getCenterName() + "/" + this.day + "/" + this.time;
    }
    
    
    public void editSchedule(SportSchedule newS) {
        FileHandler fo = new FileHandler("schedule.txt");
        fo.editRecord(this, newS);
    }
    
    
    

    @Override
    public String toString() {
        return "SportSchedule{" + "id=" + id + ", sportname=" + getSportName() + ", centername=" + getCenterName() + ", day=" + day + ", time=" + time + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    
    
}
