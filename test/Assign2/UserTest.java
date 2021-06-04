package Assign2;

import assignement2.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
 * this gives the test over user class in the assignment 2
 */

class UserTest {
    @Test
    public void inputTest() {
        final ArrayList<String> courses = new ArrayList<>(
                Arrays.asList("A", "B", "C", "D"));
        final String name = "sneh";
        final int age = 21;
        final int rollno = 112;
        final String address = "azh";
        final User user = new User(name, age, rollno, address, courses);
        assertEquals(user.getName(), "sneh");
        assertEquals(user.getRollNumber(), 112);
        assertEquals(user.getAge(), 21);
        assertEquals(user.getEnrolledCourses(), courses);
    }
}