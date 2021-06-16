package assigntwotest;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import assignementtwo.validation.Validation;

/*
 * It test the method present in the validation class
 */
public class ValidationTest {

    /*
     * It will check whether it will give null value true or false
     */
    @Test
    public void checkNullTest() {
        Object checkObject = null;
        Validation validation = new Validation();
        assertEquals(true, validation.checkTheNull(checkObject));
    }

    /*
     * negative test of null value
     */
    @Test
    public void checkNotNullTest() {
        Object checkObject = new Integer(9);
        Validation validation = new Validation();
        assertNotEquals(true, validation.checkTheNull(checkObject));
    }

}