package assignementtwo.datastorage;

import assignementtwo.constant.ErrorConstants;
import assignementtwo.constant.MessageConstants;
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
            System.out.println(ErrorConstants.ERROR_3);
        } finally {
            try {
                if (!new Validation().checkTheNull(outputStream)
                        && !new Validation().checkTheNull(fileOutputStream)) {
                    fileOutputStream.close();
                    outputStream.close();
                }
            } catch (IOException exception) {
                System.out.println(ErrorConstants.ERROR_4);
            }
        }
        System.out.println(MessageConstants.MESSAGE_9);
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
            System.out.println(e.getMessage());
        } finally {
            try {
                if (!new Validation().checkTheNull(objectInputStream)
                        && !new Validation().checkTheNull(fileInputStream)) {
                    fileInputStream.close();
                    objectInputStream.close();
                }
            } catch (IOException exception) {
                System.out.println(ErrorConstants.ERROR_4);
            }
        }
        return users;

    }

}
