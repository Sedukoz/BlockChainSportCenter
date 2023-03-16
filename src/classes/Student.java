
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarah
 */
public class Student {
    private int studentID; //auto-generate = 10001
    private String name;
    private String username; 
    private String password;
    private String phoneNumber;
    private String address;
    private String sportName;
    private ArrayList<SportSchedule> mySchedule = new ArrayList <>();

    public Student(int studentID, String name, String username, String password, String phoneNumber, String address, String sportName) {
        this.studentID = studentID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        
    }

    public Student() {
    }

    public Student(String name, String username, String password, String phoneNumber, String address, String sportName) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public static List<Student> getAll(){
        FileHandler f = new FileHandler("student.txt");
        List<Student> studArray = f.readFromStudentFile();
        return studArray;
    }
    
    public ArrayList<SportSchedule> getMySchedule() {
        return mySchedule;
    }
    
    public boolean validateStudent(Student stud) {
        FileHandler fo = new FileHandler("student.txt");
        List<Student> studArray = fo.readFromStudentFile();
        boolean valid = false;
        for(Student s: studArray) {
              if(stud.getUsername().replaceAll("/s+", "").equals(s.getUsername().replaceAll("/s+", ""))
                      && stud.getPassword().replaceAll("/s+", "").equals(s.getPassword().replaceAll("/s+", "")) ) {
                System.out.println("Match Found");
                valid = true;
                break;
            } else {
                valid = false;
            }
        }
        return valid;
    }
    
    
    public Student searchStudent(){
        FileHandler f = new FileHandler("student.txt");
        Student returnStudents = f.searchFileStudent(this.studentID);
        System.out.println(returnStudents);
        return returnStudents;
    }
    
    





    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", username=" + username + ", password=" + password + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }

    
}
