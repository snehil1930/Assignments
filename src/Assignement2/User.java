package Assignement2;

import java.io.Serializable;
import java.util.List;

public class User implements Comparable<User>, Serializable {
    private final String name;
    private final int age;
    private final String address;
    private final int rollNumber;
    private final List<String> enrolledCourses;

    public User(final String name, final int age, final int rollNumber, final String address, final  List<String> enrolledCourses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNumber = rollNumber;
        this.enrolledCourses = enrolledCourses;
    }

    public void display() {
        System.out.println(name+"\t\t\t"+rollNumber+"\t\t\t"+ age+"\t\t\t"+ address+"\t\t\t"+ enrolledCourses);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public int compareTo(final User o) {
        if (name.equals(o.name))
            return rollNumber - o.rollNumber;
        else
            return name.compareTo(o.name);
    }
}
