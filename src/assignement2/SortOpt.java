package assignement2;

import java.util.Scanner;
import java.util.Set;
/*
 * This class is use to sort parameter according to choice
 */

public class SortOpt {

    private Set<User> us;
    private int choice;
    private int order;
    /*
     * parameterized constructor in initialise set
     * @param us set of user
     */

    public SortOpt(final Set<User> us) {
        this.us = us;
    }

    /*
     * Shows the options the user has to enter to do
     * any particular sorting
     */


    private void showdetails() {
        final Scanner sc = new Scanner(System.in);
        try {
            System.out.println("1. Sort by Name");
            System.out.println("2. Sort by Age");
            System.out.println("3. Sort by RollNo.");
            System.out.println("4. Sort by Address");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println("Please enter the order.Option are...");
            System.out.println("1.Ascending Order");
            System.out.println("2. Descending order");
            order = Integer.parseInt(sc.nextLine());
            if (order < Constants.ch_1 || order > Constants.ch_2 || choice < Constants.ch_1 || choice > Constants.ch_4) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid choice entered !");
        }
    }

    /*
     * performing actual sorting based on choice and order entered
     * @return the sorted user set
     */
    public Set<User> getSorted() {
        showdetails();
        us.stream().sorted((a, b) -> {
            int result = 0;
            switch (choice) {
                case Constants.ch_1:
                    result = a.getName().compareTo(b.getName());
                    break;
                case Constants.ch_2:
                    result = a.getRollNumber() - b.getRollNumber();
                    break;
                case Constants.ch_3:
                    result = a.getAge() - b.getAge();
                    break;
                case Constants.ch_5:
                    result = a.getAddress().compareTo(b.getAddress());
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            if (order == Constants.ch_2) {
                result = -result;
            }
            return result;
        }).forEach(System.out::println);
        return us;

    }
}
