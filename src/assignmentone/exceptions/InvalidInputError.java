package assignmentone.exceptions;

/*
 * class is created to throw runtime exception
 */
public class InvalidInputError extends RuntimeException {

    /*
     * constructor use for calling super class with message that is pass
     */
    public InvalidInputError(final String message) {
        super(message);
    }
}
