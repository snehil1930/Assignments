package assignement2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * This class is inputing all the parameter required
 * for the User
 */

public class NewUser {

    /*
     * method is taking input of name
     * roll no
     * age
     * address
     * and the course he choices
     * @return user class
     */

    public static User getNewUser() {
        final Scanner sc = new Scanner(System.in);
        ArrayList<String> subj = new ArrayList<>();
        final int maxSub = Constants.ch_5;
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter roll no");
        int rollno = sc.nextInt();
        if (rollno < 0) {

            throw new NumberFormatException();
        }
        System.out.println("Enter age");
        int age = sc.nextInt();
        if (age < 0) {

            throw new NumberFormatException();
        }
        System.out.println("Enter address");
        String address = sc.next();
        int count = 0;
        System.out.println("Available Subjects are A,B,C,D,E,F ");
        final ArrayList<String> availableSubjects = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        subj.add("A");
        while (count < maxSub) {
            System.out.println("want to add subject ? if yes type 'y/Y' else type any character ");
            final String st = sc.next();
            final String yes = "y";
            if (yes.equalsIgnoreCase(st)) {
                final String sub = sc.next();
                if (availableSubjects.contains(sub)) {

                    subj.add(sub);
                } else {
                    System.out.println("Available Subjects are A,B,C,D,E,F only.Select Among these !!");
                    count = count - 1;
                }
            } else if (count < Constants.ch_4 && !(yes.equalsIgnoreCase(st))) {
                System.out.println("enter at least 4 subjects");
            } else {
                break;
            }
            count++;
        }
        return new User(name, age, rollno, address, subj);
    }
}
