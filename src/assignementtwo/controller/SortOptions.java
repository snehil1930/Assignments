package assignementtwo.controller;

import assignementtwo.constant.ErrorConstants;
import assignementtwo.constant.MessageConstants;
import assignementtwo.constant.ValueConstants;
import assignementtwo.model.User;
import assignementtwo.sorting.SortByAddress;
import assignementtwo.sorting.SortByAge;
import assignementtwo.sorting.SortByName;
import assignementtwo.sorting.SortByRollNo;
import assignmentone.exceptions.InvalidInputError;

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
     * the value of choice of item in sorting parameter
     */
    private int choice;

    /*
     * order for ascending or descending
     */
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
        final var scan = new Scanner(System.in);
        MessageConstants.choiceMessage();

        try {
            choice = Integer.parseInt(scan.nextLine());
            MessageConstants.choiceMessage();
            order = Integer.parseInt(scan.nextLine());
            if (order < ValueConstants.CHOICE_1
                    || order > ValueConstants.CHOICE_2
                    || choice < ValueConstants.CHOICE_1
                    || choice > ValueConstants.CHOICE_4) {
                throw new InvalidInputError(ErrorConstants.ERROR_2);
            }
        } catch (InvalidInputError exception) {
            System.out.println("Invalid choice" + exception.getMessage());
        }
    }

    /*
     * performing actual sorting based on choice and order entered
     * and call required functions accordingly
     * and print the data
     */
    public void getSorted() {
        showdetails();
        final var tempUser = new ArrayList<>(users);
        switch (choice) {
            case ValueConstants.CHOICE_1:
                Collections.sort(tempUser, new SortByName());
                break;
            case ValueConstants.CHOICE_2:
                Collections.sort(tempUser, new SortByAge());
                break;
            case ValueConstants.CHOICE_3:
                Collections.sort(tempUser, new SortByRollNo());
                break;
            case ValueConstants.CHOICE_4:
                Collections.sort(tempUser, new SortByAddress());
                break;
            default:
                System.out.println(ErrorConstants.ERROR_1);
                break;
        }
        if (ValueConstants.CHOICE_2 == order) {
            Collections.reverse(tempUser);
        }

        tempUser.forEach(System.out::println);
    }
}
