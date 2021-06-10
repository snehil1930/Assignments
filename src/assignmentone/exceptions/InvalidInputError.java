package assignmentone.exceptions;

public class InvalidInputError extends RuntimeException{

    public InvalidInputError(final String message){
        super(message);
    }
}
