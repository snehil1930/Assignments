package assignement2;

import java.util.Scanner;
import java.util.Set;

/*
 * This class takes choice from the user
 * and try to class various method accordingly
 * It has us as a set of user
 */
public class Starter {

    /*
     *data structure to store the each user
     */
    private Set<User> users;

    /*This is a default constructor
     * it instanties set from file
     */
    public Starter() {
        this.users = new StorgeClass().getUsers();
    }

    /*
     * This method print choice and there details
     * @return choice of user
     */
    private int showOptions() {
        System.out.println("Here is options number and task they perform on pressing them");
        System.out.println("1. Add user details");
        System.out.println("2. Sort user details according to choice and order specified");
        System.out.println("3. Delete user details");
        System.out.println("4. Save user details");
        System.out.println("5. Exit");
        try {
            final Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (NumberFormatException e) {
            return Constants.CHOICE5;
        }
    }

    /*
     * This method adds new user in the list
     */
    private void addUser() {
        try {
            users.add(NewUser.getNewUser());
        } catch (Exception e) {
            System.out.println(String.format("Invalid Details entered : %s", e.getMessage()));
        }
    }

    /*
     * This method method takes order in which user details are sorted
     * and parameter according to which ordering is done
     */
    private void sortingByChoice() {
        users = new SortOpt(users).getSorted();
    }

    /*
     * Delete the record if roll no is found
     */
    private void deleteRecord() {
        final Scanner scan = new Scanner(System.in);
        int searchRoll = Constants.ZERO;
        try {
            searchRoll = Integer.parseInt(scan.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input less than zero for roll number");
        }
        User record = null;
        for (final User iterator : users) {
            if (iterator.getRollNumber() == searchRoll) {
                record = iterator;
                break;
            }
        }
        if (record == null) {
            System.out.println("Record Not Present in the data");
        } else {
            users.remove(record);
        }
    }

    /*
     * Driver method for other options
     */
    public void menu() {
        final StorgeClass stc = new StorgeClass();
        for (int count = Constants.ZERO; count <= Constants.MAX_LIMIT; count++) {
            final int choice = showOptions();
            if (choice == Constants.CHOICE1) {
                addUser();
            } else if (choice == Constants.CHOICE2) {
                sortingByChoice();
            } else if (choice == Constants.CHOICE3) {
                deleteRecord();
            } else if (choice == Constants.CHOICE4) {
                stc.saveChanges(users);
            } else if (choice == Constants.CHOICE5) {
                stc.saveChanges(users);
                System.exit(Constants.ZERO);
            }
        }
    }
}
