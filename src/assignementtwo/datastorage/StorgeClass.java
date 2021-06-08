package assignementtwo.datastorage;

import assignementtwo.model.User;
import assignementtwo.validation.Validation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/*
 * This class is use to store all the users data
 * in the file system and extract the user details
 * from the file
 */
public class StorgeClass {

    /*
     * file where the data is store
     */
    private static final String FILENAME = "userdetails.txt";

    /*
     * Default constructor
     */
    public StorgeClass() {
    }

    /*
     * it takes data from set amd store in file
     * before exiting
     * @param us set of user
     */
    public void saveChanges(final Set<User> users) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            fileOutputStream = new FileOutputStream(FILENAME);
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(users);
        } catch (IOException e) {
            System.out.println("IO Exception Caught ");
        } finally {
            try {
                if (outputStream!=null && fileOutputStream!=null) {
                    fileOutputStream.close();
                    outputStream.close();
                }
            } catch (IOException exception) {
                System.out.println("Output Stream is not working");
            }
        }
        System.out.println("Saved to disk");
    }

    /*
     * it fetches the data from the file
     * and store in the set of users
     * @return set of fetched user
     */
    public Set<User> getUsers() {
        Set<User> users = new TreeSet<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILENAME);
            objectInputStream = new ObjectInputStream(fileInputStream);
            users = (Set<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream!=null && fileInputStream!=null) {
                    fileInputStream.close();
                    objectInputStream.close();
                }
            } catch (IOException exception) {
                System.out.println("Input stream is not working");
            }
        }
        return users;

    }

}
