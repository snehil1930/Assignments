package assignement2;

import java.util.Scanner;
import java.util.Set;
/*
 * This class takes choice from the user
 * and try to class various method accordingly
 * It has us as a set of user
 */

public class Starter {

    //    variable used to store the user details
    private Set<User> us;

    /*This is a default constructor
     * it instanties set from file
     */
    public Starter() {
        this.us = new StorgeClass().getUsers();
    }

    /*
     * This method print choice and there details
     * @return choice of user
     */

    private int showOptions() {
        System.out.println("Here is options number and task they perform on pressing them");
        System.out.println("1. Add user details");
        System.out.println("2. Display user details");
        System.out.println("3. Delete user details");
        System.out.println("4. Save user details");
        System.out.println("5. Exit");
        try {
            final Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (NumberFormatException e) {
            return Constants.ch_5;
        }
    }

    /*
     * This method adds new user in the list
     */


    private void addUser() {
        try {
            us.add(NewUser.getNewUser());
        } catch (Exception e) {
            System.out.println("Invalid Details entered : " + e.getMessage());
        }
    }

    /*
     * This method method takes order in which user details are sorted
     * and parameter according to which ordering is done
     */


    private void sortingByChoice() {
        us = new SortOpt(us).getSorted();
    }

    /*
     * Delete the record if roll no is found
     */

    private void deleteRecord() {
        final Scanner sc = new Scanner(System.in);
        int searchRol = 0;
        try {
            searchRol = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }
        User rec = null;
        for (final User it : us) {
            if (it.getRollNumber() == searchRol) {
                rec = it;
                break;
            }
        }
        if (rec == null) {
            System.out.println("Record Not Present");
        } else {
            us.remove(rec);
        }
    }

    /*
     * Driver method for other options
     */


    public void menu() {
        int count = 0;
        final StorgeClass stc = new StorgeClass();
        final Constants constants = new Constants();
        while (count <= constants.max_limit) {
            count++;
            final int choice = showOptions();
            if (choice == constants.ch_1) {
                addUser();
            } else if (choice == constants.ch_2) {
                sortingByChoice();
            } else if (choice == constants.ch_3) {
                deleteRecord();
            } else if (choice == constants.ch_4) {
                stc.saveChanges(us);
            } else if (choice == constants.ch_5) {
                stc.saveChanges(us);
                System.exit(0);
            }
        }

    }
}
