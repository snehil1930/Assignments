package Assign2;

import assignementtwo.model.User;
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
    @Test
    public void inputTest2(){
        final ArrayList<String> courses = new ArrayList<>(
                Arrays.asList("A", "B", "C", "D","E"));
        final String name = "vishal";
        final int age = 22;
        final int rollno = 121;
        final String address = "Baliya";
        final User user = new User(name, age, rollno, address, courses);
        assertNotNull(user);
        assertEquals(user.getName(), "vishal");
        assertEquals(user.getRollNumber(), 121);
        assertEquals(user.getAge(), 22);
        assertEquals(user.getEnrolledCourses(), courses);
    }

    @Test
    public void inputTest3(){
        final ArrayList<String> courses = new ArrayList<>(
                Arrays.asList("A", "B", "C","E"));
        final String name = "shubh";
        final int age = 22;
        final int rollno = 111;
        final String address = "Bali";
        final User user = new User(name, age, rollno, address, courses);
        assertNotNull(user);
        assertEquals(user.getName(), "shubh");
        assertEquals(user.getRollNumber(), 111);
        assertEquals(user.getAge(), 22);
        assertEquals(user.getEnrolledCourses(), courses);
    }

}