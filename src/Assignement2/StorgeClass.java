package Assignement2;

import java.io.*;
import java.util.*;
public class StorgeClass {
    public void saveChanges(Set<User> us)
    {
        try {
            FileOutputStream file = new FileOutputStream("userdata.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(us);
        } catch (IOException e) {
            System.out.println("IO Exception Caught ");
        }
        System.out.println("Saved to disk");
    }

    public Set<User> getUsers()
    {
        File fl=new File("userdetails.txt");
        Set<User> us = new TreeSet<>();
        try {
           FileInputStream fstream = new FileInputStream(fl);
            ObjectInputStream objectInputStream = new ObjectInputStream(fstream);
            us = (Set<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found");
        }
        return us;
    }

}
