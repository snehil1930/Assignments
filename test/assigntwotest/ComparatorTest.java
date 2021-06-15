package assigntwotest;

import static org.junit.jupiter.api.Assertions.*;

import assignementtwo.sorting.*;
import assignementtwo.model.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

/*
 * This test will get all comparasion done in the code tested
 */

public class ComparatorTest {

    /*
     * to store the course of the user
     */
    private final ArrayList<String> courses = new ArrayList<>();

    /*
     * This will initialise the course selected
     */
    @BeforeEach
    public void init() {
        courses.add("A");
        courses.add("B");
        courses.add("C");
        courses.add("D");
    }

    /*
     * test the order in which record is store when name is different
     */
    @Test
    public void sortNameDifferTest() {
        final User user1 = new User("Snehil", 22, 2017021112, "Azamgarh", courses);
        final User user2 = new User("Shubham", 22, 2017021113, "Azamgarh", courses);
        assertEquals(6, user1.compareTo(user2));
    }

    /*
     * test the order in which record is store when name is same
     */
    @Test
    public void sortNameSameTest() {
        final User user1 = new User("Snehil", 22, 2017021112, "Azamgarh", courses);
        final User user2 = new User("Snehil", 22, 2017021113, "Azamgarh", courses);
        assertEquals(-1, user1.compareTo(user2));
    }

    /*
     * test the order in which record is sorted when name is different
     */
    @Test
    public void sortNameTest() {
        final User user1 = new User("Shubham", 22, 2017021112, "Azamgarh", courses);
        final User user2 = new User("Snehil", 22, 2017021113, "Azamgarh", courses);
        assertEquals(-6, new SortByName().compare(user1, user2));
    }

    /*
     * test the order in which record is sorted when age is different
     */
    @Test
    public void sortAgeTest() {
        final User user1 = new User("Sneh", 23, 2017021112, "Azamgarh", courses);
        final User user2 = new User("Snehil", 22, 2017021113, "Azamgarh", courses);
        assertEquals(1, new SortByAge().compare(user1, user2));
    }

    /*
     * test the order in which record is sorted when rollnumber is different
     */
    @Test
    public void sortRollNumberTest() {
        final User user1 = new User("Snehil", 22, 2017021112, "Azamgarh", courses);
        final User user2 = new User("Snehil", 22, 2017021113, "Azamgarh", courses);
        assertEquals(-1, new SortByRollNo().compare(user1, user2));
    }

    /*
     * test the order in which record is sorted when address is different
     */
    @Test
    public void sortAddressTest() {
        final User user1 = new User("Snehil", 22, 2017021112, "Azamgarh", courses);
        final User user2 = new User("Snehil", 22, 2017021113, "Lucknow", courses);
        assertEquals(-11, new SortByAddress().compare(user1, user2));
    }

}