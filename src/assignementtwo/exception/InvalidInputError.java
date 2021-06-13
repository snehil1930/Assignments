package assignementtwo.exception;

/*
 * class for generic exception
 */
public class InvalidInputError extends RuntimeException {

    /*
     * parametrize constructor
     */
    public InvalidInputError(final String message) {
        super(message);
    }
}
