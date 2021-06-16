package assignonetest;

import static org.junit.jupiter.api.Assertions.*;

import assignmentone.exceptions.InvalidInputError;
import assignmentone.model.Item;
import assignmentone.utils.ValidatorUtils;
import org.junit.jupiter.api.Test;

/*
 * This class tests Assignment 1 on different testcase
 */
class ValidatorTest {

    /*
     * test case for wrong name
     */
    @Test
    public void invalidNameTest() throws Exception {

        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-type", "raw", "-name", "snehil"};
            ValidatorUtils.getDetails(temp);
        });
    }

    /*
     * test case for invalid type
     */
    @Test
    public void invalidTypeTest() throws Exception {
        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "-type", "exported"};
            ValidatorUtils.getDetails(temp);
        });
    }

    /*
     * test case for negative price
     */
    @Test
    public void invalidPriceTest() throws Exception {
        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "-type", "exported", "-price", "-34"};
            ValidatorUtils.getDetails(temp);
        });
    }

    /*
     * test case for negative quantity
     */
    @Test
    public void invalidQuantityTest() throws Exception {
        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "type", "exported", "price", "34", "quantity", "-3"};
            ValidatorUtils.getDetails(temp);
        });
    }

    /*
     * test case for type is missing in input
     */
    @Test
    public void typeParameterMissingTest() throws Exception {
        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "-price", "34"};
            ValidatorUtils.getDetails(temp);
        });
    }

    /*
     * test case for correct input
     */
    @Test
    public void negativeValueTest() throws Exception {
        Throwable exception=assertThrows(NumberFormatException.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "-type", "imported", "-price", "34"};
            ValidatorUtils.getDetails(temp);
        });
        assertNotEquals("Invalid Input",exception.getMessage());
    }
}
