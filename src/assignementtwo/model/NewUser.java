package assignementtwo.model;

import assignementtwo.model.Constants;
import assignementtwo.model.User;

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
        final Scanner scan = new Scanner(System.in);
        int count = Constants.ZERO;
        final ArrayList<String> subjects = new ArrayList<>();
        System.out.println("Available Subjects are A,B,C,D,E,F ");
        String decision;
        String subjectsInput;
        while (count < Constants.CHOICE_5) {
            System.out.println("want to add subject ? if yes type 'y/Y' else type any character ");
            decision = scan.next();
            if (Constants.YES.equalsIgnoreCase(decision)) {
                subjectsInput = scan.next();
                if (Constants.AVAILABLE_SUBJECTS.contains(subjectsInput)) {
                    subjects.add(subjectsInput);
                } else {
                    System.out.println("Available Subjects are A,B,C,D,E,F only.Select Among these !!");
                    count--;
                }
            } else if (count < Constants.CHOICE_4 && !(Constants.YES.equalsIgnoreCase(decision))) {
                System.out.println("enter at least 4 subjects");
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
        final Scanner scan = new Scanner(System.in);
        System.out.println("Enter name");
        final String name = scan.next();
        System.out.println("Enter roll no");
        final int rollno = scan.nextInt();
        System.out.println("Enter age");
        final int age = scan.nextInt();
        System.out.println("Enter address");
        final String address = scan.next();
        if (Constants.ZERO > rollno || Constants.ZERO > age) {
            throw new NumberFormatException("Number is less than zero");
        }
        return new User(name, age, rollno, address, getCourse());
    }
}
