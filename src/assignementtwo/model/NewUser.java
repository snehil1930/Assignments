package assignementtwo.model;

import assignementtwo.constant.MessageConstants;
import assignementtwo.constant.ValueConstants;

import java.util.Scanner;
import java.util.ArrayList;

/*
 * This class is inputting all the parameter required
 * for the User
 */
public class NewUser {

    /*
     * the function to enter the courses the user want to study
     * @return subjects the user has selected
     */
    private static ArrayList<String> getCourse() {
        final var scan = new Scanner(System.in);
        int count = ValueConstants.ZERO;
        final ArrayList<String> subjects = new ArrayList<>();
        System.out.println(MessageConstants.MESSAGE_1);
        String decision;
        String subjectsInput;
        while (count < ValueConstants.CHOICE_5) {
            System.out.println(MessageConstants.MESSAGE_2);
            decision = scan.next();
            if (ValueConstants.YES.equalsIgnoreCase(decision)) {
                subjectsInput = scan.next();
                if (ValueConstants.AVAILABLE_SUBJECTS.contains(subjectsInput)) {
                    subjects.add(subjectsInput);
                } else {
                    System.out.println(MessageConstants.MESSAGE_3);
                    count--;
                }
            } else if (count < ValueConstants.CHOICE_4
                    && !(ValueConstants.YES.equalsIgnoreCase(decision))) {
                System.out.println(MessageConstants.MESSAGE_4);
            } else {
                break;
            }
            count++;
        }
        return subjects;
    }

    /*
     * method is taking input of name
     * roll no
     * age
     * address
     * and the course he choices
     * @return user class
     */
    public static User getNewUser() {
        final var scan = new Scanner(System.in);
        System.out.println(MessageConstants.MESSAGE_5);
        final String name = scan.next();
        System.out.println(MessageConstants.MESSAGE_6);
        final var rollno = scan.nextInt();
        System.out.println(MessageConstants.MESSAGE_7);
        final var age = scan.nextInt();
        System.out.println(MessageConstants.MESSAGE_8);
        final String address = scan.next();
        if (ValueConstants.ZERO > rollno || ValueConstants.ZERO > age) {
            throw new NumberFormatException("Number is less than zero");
        }
        return new User(name, age, rollno, address, getCourse());
    }
}
