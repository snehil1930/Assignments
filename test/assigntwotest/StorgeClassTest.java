package assigntwotest;

import assignementtwo.datastorage.StorgeClass;
import assignementtwo.model.User;
import org.junit.Test;

import java.util.*;

import static org.testng.Assert.*;

/*
 * It will test whether the content in the file is stored is in proper format
 */
public class StorgeClassTest {

    /*
     * content of user is stored in the file
     * Then content of file will be fetch to match the given record
     */
    @Test
    public void fileContentTest() {
        final ArrayList<String> courses = new ArrayList<>();
        courses.add("A");
        courses.add("B");
        courses.add("C");
        courses.add("D");
        final var user1 = new User("Snehil", 22, 112, "Azamgarh", courses);
        final Set<User> list = new TreeSet<>();
        list.add(user1);
        final var storgeClass = new StorgeClass();
        storgeClass.saveChanges(list);
        final var checklist = storgeClass.getUsers();
        assertEquals(list.iterator().next().toString(), checklist.iterator().next().toString());
    }

}