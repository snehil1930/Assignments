package assignementtwo.model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * get the details of class parameter
 */
public class User implements Comparable<User>, Serializable {

    /*
     * name of the user is store
     */
    private final String name;

    /*
     * age of the user is store
     */
    private final int age;

    /*
     * address of the user is stored
     */
    private final String address;

    /*
     * unique roll number is stored
     */
    private final int rollNumber;

    /*
     * courses the user selected is store here
     */
    private final ArrayList<String> enrolledCourses;

    /*
     * parameterize constructor
     * @param name name of user
     * @param age user age
     * @param rollNumber user roll number
     * @param address user address
     * @param enrolledCourse list of Course
     */
    public User(final String name, final int age, final int rollNumber, final String address, final ArrayList<String> enrolledCourses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNumber = rollNumber;
        this.enrolledCourses = enrolledCourses;
    }


    @Override
    public int compareTo(final User other) {
        if (name.equals(other.name)) {
            return rollNumber - other.rollNumber;
        } else {
            return name.compareTo(other.name);
        }
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", rollNumber=" + rollNumber +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }


}
