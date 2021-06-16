package assignonetest;

import assignmentone.model.Item;
import assignmentone.utils.ValidatorUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testng.Assert.*;

public class ItemTest {

    /*
     * This test method is used to check whether correct input is passing test or not
     */
    @Test
    void devTest() throws Exception {

        String[] args = new String[]{"-name", "snehil", "-type", "raw", "-price", "123", "-quantity", "2"};
        Item item = ValidatorUtils.getDetails(args);
        assertNotNull(item);
        assertNotNull(item.getName());
        assertEquals("raw",item.getType());
        assertNotNull(item.getPrice());
        assertEquals(123,item.getPrice());
        assertEquals("snehil",item.getName());
        assertEquals(2,item.getQuantity());
    }

    /*
     * this method is tested after valid and invalid inputs is tested
     * it test the final price of raw item after calculation
     */
    @Test
    public void finalPriceRawTest() {
        final var args = new String[]{"-name", "snehil", "-type", "raw", "-price", "123", "-quantity", "2"};
        final Item item = ValidatorUtils.getDetails(args);
        item.calculateFinalPrice();
        final float expected = (float) 276.75;
        assertEquals(item.getFinalPrice(), expected);
    }


    /*
     * it test the final price of imported item after calculation
     */
    @Test
    public void finalPriceImportedTest() throws Exception {
        final var args = new String[]{"-name", "snehil", "-type", "imported", "-price", "123", "-quantity", "2"};
        final Item item = ValidatorUtils.getDetails(args);
        item.calculateFinalPrice();
        final float expected = (float) 280.6;
        assertEquals(item.getFinalPrice(), expected);
    }

    /*
     * it test the final price of manufactured item after calculation
     */
    @Test
    public void finalPriceManufacturedTest() {
        final var args = new String[]{"-name", "snehil", "-type", "manufactured", "-price", "123", "-quantity", "2"};
        final Item item = ValidatorUtils.getDetails(args);
        item.calculateFinalPrice();
        final float expected = (float) 281.66998;
        assertEquals(item.getFinalPrice(), expected);
    }

}