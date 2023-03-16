
package classes;

import java.util.List;

/**
 *
 * @author sarah
 */
public class Sport {

    private int sportID;
    private String centerCode;
    private String centerName;
    private String sportCode;
    private String sportName;
    private String fee;

    public Sport(int sportID, String centerCode, String centerName, String sportCode, String sportName, String fee) {
        this.sportID = sportID;
        this.centerCode = centerCode;
        this.centerName = centerName;
        this.sportCode = sportCode;
        this.sportName = sportName;
        this.fee = fee;
    }
    
    public Sport( String centerCode, String centerName, String sportCode, String sportName) {
       
        this.centerCode = centerCode;
        this.centerName = centerName;
        this.sportCode = sportCode;
        this.sportName = sportName;
      
    }
    
    public Sport(int sportID, String centerCode, String centerName, String sportCode, String sportName) {
        this.sportID = sportID;
        this.centerCode = centerCode;
        this.centerName = centerName;
        this.sportCode = sportCode;
        this.sportName = sportName;
       
    }
    

    public Sport(String sportName, String centerName) {
        this.sportName = sportName;
        this.centerName = centerName;
    }

    public Sport() {
    }

    public int getSportID() {
        return sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getSportCode() {
        return sportCode;
    }

    public void setSportCode(String sportCode) {
        this.sportCode = sportCode;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
    
    
    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
    
    public static List<Sport> getAllSports(){
        FileHandler f = new FileHandler("sport.txt");
        List<Sport> sportArray = f.readFromSportFile();
        return sportArray;
    }
    
    public Sport searchSport(){
        FileHandler f = new FileHandler("sport.txt");
        Sport returnSports = f.searchFileSport(this.sportID);
        System.out.println(returnSports);
        return returnSports;
    }


    
    public void editSport(Sport newsp) {
        FileHandler fo = new FileHandler("sport.txt");
        fo.editRecord(this, newsp);
    }
    
    
    
    public String sportDetails() {
        return this.sportID + "/" + this.centerCode + "/" + this.centerName + "/" + this.sportCode + "/" + this.sportName  + "/" + this.fee;
    }


    @Override
    public String toString() {
        return "Sport{" + "sportID=" + sportID + ", centerCode=" + centerCode + ", centerName=" + centerName + ", sportCode=" + sportCode + ", sportName=" + sportName + ", fee=" + fee + '}';
    }
    
    
    

   
    
    
}
