package assignmentone;

import assignmentone.constants.MessageConstants;
import assignmentone.constants.ValueConstants;

import java.util.*;

/*
 * This class is use to check inputs of item
 */
public class ItemCheck {

    /*
     * creating validation check on the input
     */
    public static  Validator validator;

    /*
     * This method is use to validate input on exceptions and format of input
     */
    private void nextInputs() {
        System.out.println(MessageConstants.MESSAGE1);
        final var scan = new Scanner(System.in);
        var choice = scan.nextLine();
        while (ValueConstants.YES.equalsIgnoreCase(choice)) {
            final var inputs = scan.nextLine();
            final var inputsArray = inputs.split(" ");
            final var item = validator.getDetails(inputsArray);
            item.calculateFinalPrice();
            System.out.println(item);
            System.out.println(MessageConstants.MESSAGE1);
            choice = scan.nextLine();
        }
        System.out.println(MessageConstants.LASTMESSAGE);
    }

    /*
     * This method is use to take details of item
     * @param args array of string is taken as input
     */
    public void initials(final String... args) {
        validator =new Validator();
        final var item = validator.getDetails(args);
        System.out.println(item);
        nextInputs();
    }

}
