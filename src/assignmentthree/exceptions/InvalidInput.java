package assignmentthree.exceptions;

/*
 * exception class for wrong input by user
 */
public class InvalidInput extends RuntimeException {

    /*
     * constructor for message passing
     * @param message string to print error
     */
    public InvalidInput(final String message) {
        super(message);
    }
}
