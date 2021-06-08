package assignementtwo.controller;

import assignementtwo.model.Constants;
import assignementtwo.model.User;
import assignementtwo.sorting.SortByAddress;
import assignementtwo.sorting.SortByAge;
import assignementtwo.sorting.SortByName;
import assignementtwo.sorting.SortByRollNo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

/*
 * This class is use to sort parameter according to choice
 */
public class SortOptions {

    /*
     * the users are stored in form of set for one build
     */
    private final Set<User> users;

    /*
     * the value of choice of item
     * and the order of choice in ascending or descending
     */
    private int choice;
    private int order;

    /*
     * parameterized constructor in initialise set
     * @param us set of user
     */
    public SortOptions(final Set<User> users) {
        this.users = users;
    }

    /*
     * Shows the options the user has to enter to do
     * any particular sorting
     */
    private void showdetails() {
        final Scanner scan = new Scanner(System.in);
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Age");
        System.out.println("3. Sort by RollNo.");
        System.out.println("4. Sort by Address");
        try {
            choice = Integer.parseInt(scan.nextLine());
            System.out.println("Please enter the order.Option are...");
            System.out.println("1.Ascending Order");
            System.out.println("2. Descending order");
            order = Integer.parseInt(scan.nextLine());
            if (order < Constants.CHOICE_1 || order > Constants.CHOICE_2
                    || choice < Constants.CHOICE_1 || choice > Constants.CHOICE_4) {
                throw new IOException("either order or choice is out of given range");
            }
        } catch (IOException e) {
            System.out.println(String.format("Invalid choice entered !%s", e.getMessage()));
        }
    }

    /*
     * performing actual sorting based on choice and order entered
     * and call required functions accordingly
     * and print the data
     */
    public void getSorted() {
        showdetails();
        ArrayList<User> tempUser = new ArrayList<>(users);
        switch (choice) {
            case Constants.CHOICE_1:
                Collections.sort(tempUser, new SortByName());
                break;
            case Constants.CHOICE_2:
                Collections.sort(tempUser, new SortByAge());
                break;
            case Constants.CHOICE_3:
                Collections.sort(tempUser, new SortByRollNo());
                break;
            case Constants.CHOICE_4:
                Collections.sort(tempUser, new SortByAddress());
                break;
            default:
                System.out.println("Invalid option for choice");
                break;
        }
        if (Constants.CHOICE_2 == order) {
            Collections.reverse(tempUser);
        }

        for (int i = 0; i < tempUser.size(); i++) {
            System.out.println(tempUser.get(i));
        }
    }
}
