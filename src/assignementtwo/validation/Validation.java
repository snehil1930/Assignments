package assignementtwo.validation;

import java.util.Objects;

/*
 * it check the constraints on the variable and objects
 */
public class  Validation {

    /*
     * it will check if the object value is null or not
     */
    public boolean checkTheNull(Object var) {
        return Objects.isNull(var);
    }
}
