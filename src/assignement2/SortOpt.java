package assignement2;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

/*
 * This class is use to sort parameter according to choice
 */
public class SortOpt {

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
    public SortOpt(final Set<User> users) {
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
            if (order < Constants.CHOICE1 || order > Constants.CHOICE2 || choice < Constants.CHOICE1 || choice > Constants.CHOICE4) {
                throw new IOException("either order or choice is out of given range");
            }
        } catch (IOException e) {
            System.out.println(String.format("Invalid choice entered !%s", e.getMessage()));
        }
    }

    /*
     * performing actual sorting based on choice and order entered
     * @return the sorted user set
     */
    public Set<User> getSorted() {
        showdetails();
        users.stream().sorted((a, b) -> {
            int result = Constants.ZERO;
            switch (choice) {
                case Constants.CHOICE1:
                    result = a.getName().compareTo(b.getName());
                    break;
                case Constants.CHOICE2:
                    result = a.getRollNumber() - b.getRollNumber();
                    break;
                case Constants.CHOICE3:
                    result = a.getAge() - b.getAge();
                    break;
                case Constants.CHOICE4:
                    result = a.getAddress().compareTo(b.getAddress());
                    break;
                default:
                    System.out.println("Invalid option for choice");
                    break;
            }
            if (order == Constants.CHOICE2) {
                result = -result;
            }
            return result;
        }).forEach(System.out::println);
        return users;
    }
}
