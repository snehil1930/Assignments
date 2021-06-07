package assign3.Exception;

public class InvalidInput extends RuntimeException {
    public InvalidInput(final String message){
        super(message);
    }
}
