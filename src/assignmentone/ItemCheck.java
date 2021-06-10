package assignmentone;

import java.util.*;

/*
 * This class is use to check inputs of item
 */
public class ItemCheck {

    /*
     * creating validation check on the input
     */
    public static final Validator VALIDATOR = new Validator();

    /*
     * This method is use to validate input on exceptions and format of input
     */
    private void nextInputs() {
        System.out.println("Do you want to enter more choice.Enter Y/N");
        final var scan = new Scanner(System.in);
        var choice = scan.nextLine();
        while ("y".equalsIgnoreCase(choice)) {
            final var inputs = scan.nextLine();
            final String[] inputsArray = inputs.split(" ");
            final Item item = VALIDATOR.getDetails(inputsArray);
            item.totaling();
            item.display();
            System.out.println("Do you want to enter more choice.Enter Y/N");
            choice = scan.nextLine();
        }
        System.out.println("Thank you purchase!Hope to see you soon..");
    }

    /*
     * This method is use to take details of item
     * @param args array of string is taken as input
     */
    public void initials(final String[] args) {
        final var item = VALIDATOR.getDetails(args);
        item.display();
        nextInputs();
    }

}
