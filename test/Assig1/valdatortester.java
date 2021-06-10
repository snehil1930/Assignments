package Assig1;

import assignmentone.*;

import static org.junit.jupiter.api.Assertions.*;

import assignmentone.exceptions.InvalidInputError;
import org.junit.jupiter.api.Test;

/*
 * This class tests Assignment 1 on different testcase
 */
class valdatortester {

    private Validator validator;

    /*
     * This test method is used to check whether correct input is passing test or not
     */
    @Test
    void devTest() throws Exception {

        String[] args = new String[]{"-name", "snehil", "-type", "raw", "-price", "123", "-quantity", "2"};
        validator = new Validator();
        Item item = validator.getDetails(args);
        assertNotNull(item);
        assertNotNull(item.getName());
        assertEquals(item.getType(), "raw");
        assertNotNull(item.getPrice());
        assertEquals(item.getPrice(), 123);
        assertEquals(item.getName(), "snehil");
        assertEquals(item.getQuantity(), 2);
    }


    /*
     * test case for wrong name
     */
    @Test
    public void invalidNameTest() throws Exception {

        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-type", "raw", "-name", "snehil"};
            new Validator().getDetails(temp);
        });
    }

    /*
     * test case for invalid type
     */
    @Test
    public void invalidTypeTest() throws Exception {
        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "-type", "exported"};
            new Validator().getDetails(temp);
        });
    }

    /*
     * test case for negative price
     */
    @Test
    public void invalidPriceTest() throws Exception {
        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "-type", "exported", "-price", "-34"};
            new Validator().getDetails(temp);
        });
    }

    /*
     * test case for negative quantity
     */
    @Test
    public void invalidQuantityTest() throws Exception {
        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "type", "exported", "price", "34", "quantity", "-3"};
            new Validator().getDetails(temp);
        });
    }

    /*
     * test case for type is missing in input
     */
    @Test
    public void typeMissingTest() throws Exception {
        assertThrows(InvalidInputError.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "-price", "34"};
            new Validator().getDetails(temp);
        });
    }

    /*
     * test case for correct input
     */
    @Test
    public void negativeErrorTest() throws Exception {
        Throwable exception=assertThrows(NumberFormatException.class, () -> {
            String[] temp = new String[]{"-name", "snehil", "-type", "imported", "-price", "34"};
            new Validator().getDetails(temp);
        });
        assertNotEquals("Invalid Input",exception.getMessage());
    }

    /*
     * this method is tested after valid and invalid inputs is tested
     * it test the final price of raw item after calculation
     */
    @Test
    void finalPriceRawTest() throws Exception {
        validator = new Validator();
        String[] args = new String[]{"-name", "snehil", "-type", "raw", "-price", "123", "-quantity", "2"};
        Item it = validator.getDetails(args);
        it.totaling();
        float expected = (float) 276.75;
        assertEquals(it.getfinalPrice(), expected);
    }


    /*
     * it test the final price of imported item after calculation
     */
    @Test
    void finalPriceImportedTest() throws Exception {
        String[] args = new String[]{"-name", "snehil", "-type", "imported", "-price", "123", "-quantity", "2"};
        validator = new Validator();
        Item item = validator.getDetails(args);
        item.totaling();
        float expected = (float) 280.6;
        assertEquals(item.getfinalPrice(), expected);
    }

    /*
     * it test the final price of manufactured item after calculation
     */
    @Test
    public void finalPriceManufacturedTest() {
        String[] args = new String[]{"-name", "snehil", "-type", "manufactured", "-price", "123", "-quantity", "2"};
        validator = new Validator();
        Item it = validator.getDetails(args);
        it.totaling();
        float expected = (float) 281.66998;
        assertEquals(it.getfinalPrice(), expected);
    }

}
