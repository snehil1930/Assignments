package assignementtwo.controller;

import assignementtwo.constant.ErrorConstants;
import assignementtwo.constant.MessageConstants;
import assignementtwo.constant.ValueConstants;
import assignementtwo.exception.InvalidInputError;
import assignementtwo.model.NewUser;
import assignementtwo.datastorage.StorgeClass;
import assignementtwo.model.User;
import assignementtwo.validation.Validation;

import java.util.Scanner;
import java.util.Set;

/*
 * This class takes choice from the user
 * and try to class various method accordingly
 * It has us as a set of user
 */
public class StartTheChoicing {

    /*
     *data structure to store the each user
     */
    private final Set<User> users;

    /*This is a default constructor
     * it instant set from file
     */
    public StartTheChoicing() {
        this.users = new StorgeClass().getUsers();
    }

    /*
     * This method print choice and there details
     * @return choice of user
     */
    private int showOptions() {

        MessageConstants.openingMessage();
        try {
            final var scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (NumberFormatException exception) {
            return ValueConstants.CHOICE_5;
        }
    }

    /*
     * This method adds new user in the list
     */
    private void addUser() {

        users.add(NewUser.getNewUser());
        throw new InvalidInputError(ErrorConstants.ERROR_1);
    }

    /*
     * This method method takes order in which user details are sorted
     * and parameter according to which ordering is done
     */
    private void sortingByChoice() {
        new SortOptions(users).getSorted();
    }

    /*
     * Delete the record if roll number is found
     */
    private void deleteRecordByRollNumber() {
        final var scan = new Scanner(System.in);
        User record = null;
        var searchRollNumber = ValueConstants.ZERO;
        try {
            searchRollNumber = Integer.parseInt(scan.next());
            throw new InvalidInputError(ErrorConstants.ERROR_1);
        } catch (InvalidInputError exception) {
            System.out.println(ErrorConstants.ERROR_1);
        }
        for (final var iterator : users) {
            if (iterator.getRollNumber() == searchRollNumber) {
                record = iterator;
                break;
            }
        }
        if (!new Validation().checkTheNull(record)) {
            users.remove(record);
        }
    }

    /*
     * Driver method for other options
     */
    public void menu() {
        final var storgeClass = new StorgeClass();
        for (var count = ValueConstants.ZERO;
             count <= ValueConstants.MAX_LIMIT; count++) {
            final var choice = showOptions();
            if (choice == ValueConstants.CHOICE_1) {
                addUser();
            } else if (choice == ValueConstants.CHOICE_2) {
                sortingByChoice();
            } else if (choice == ValueConstants.CHOICE_3) {
                deleteRecordByRollNumber();
            } else if (choice == ValueConstants.CHOICE_4) {
                storgeClass.saveChanges(users);
            } else if (choice == ValueConstants.CHOICE_5) {
                storgeClass.saveChanges(users);
                System.exit(ValueConstants.ZERO);
            }
        }
    }
}
