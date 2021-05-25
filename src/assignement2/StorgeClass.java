package assignement2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
/*
 * This class is use to store all the users data
 * in the file sytsem
 */

public class StorgeClass {
    /*
     * it takes data from set amd store in file
     * before exiting
     * @param us set of user
     */
    public void saveChanges(final Set<User> us) {
        try {
            FileOutputStream file = new FileOutputStream("userdata.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(us);
        } catch (IOException e) {
            System.out.println("IO Exception Caught ");
        }
        System.out.println("Saved to disk");
    }

    /*
     * it fetches the data from the file
     * and store in the set of users
     * @return set of fetched user
     */

    public Set<User> getUsers() {
        Set<User> us = new TreeSet<>();
        try {
            FileInputStream fstream = new FileInputStream("userdetails.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fstream);
            us = (Set<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return us;
    }

}
