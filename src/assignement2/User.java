package assignement2;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/*
 * get the details of class parameter
 */

public class User implements Comparable<User>, Serializable {
    private String name;
    private int age;
    private String address;
    private int rollNumber;
    private ArrayList<String> enrolledCourses;

    /*
     * parameterize constructor
     * @param name name of user
     * @param age user age
     * @param rollNumber user rollnumber
     * @param address user address
     * @param enrolledCourse list of Course
     */
    User(final String name, final int age, final int rollNumber, final String address, final ArrayList<String> enrolledCourses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNumber = rollNumber;
        this.enrolledCourses = enrolledCourses;
        System.out.println("i ams ");
    }

    //    display details

    public void display() {
        System.out.println(name + Constants.tabs + rollNumber + Constants.tabs + age + Constants.tabs + address + Constants.tabs + enrolledCourses);
    }

    // getter fuction of name
    public String getName() {
        return name;
    }

    // getter fuction of age
    public int getAge() {
        return age;
    }

    // getter fuction of address
    public String getAddress() {
        return address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    // getter fuction of course
    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public int compareTo(final User o) {
        if (name.equals(o.name)) {
            return rollNumber - o.rollNumber;
        } else {
            return name.compareTo(o.name);
        }
    }
}
