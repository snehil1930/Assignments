package com.example.Assignment4.utils;

import com.example.Assignment4.constants.ParameterConstants;
import com.example.Assignment4.constants.ValueConstants;


/*
 * This class is use to calculate tax of different items
 */
public final class TaxUtils {

    /*
     * tax percentage on raw item
     */
    private static final float RAW_TAX_PERCENTAGE = 12.5f;

    /*
     * tax percentage on manufactured item
     */
    private static final float MANUFACTURED_TAX_PERCENTAGE = 2.0f;
    /*
     * tax percentage on imported  item
     */
    private static final float IMPORTED_TAX_PERCENTAGE = 10.0f;
    /*
     * tax percentage on imported item when price is grater than 200
     */
    private static final float IMPORTEDTAXPERCENTAGE_2 = 5.0f;
    /*
     * tax slab for imported item
     */
    private static final float TAX_SLAB_OF_IMPORTED_ITEM_1 = 100;
    /*
     * tax slab for imported item
     */
    private static final float TAX_SLAB_OF_IMPORTED_ITEM_2 = 200;
    /*
     * tax addition  for slab 1 on imported item
     */
    private static final float TAX_SLAB_ADDITION_1 = 5;
    /*
     * tax addition  for slab 2 on imported item
     */
    private static final float TAX_SLAB_ADDITION_2 = 10;

    /*
     * This method calculate tax of raw item
     *
     * @param price price  of item
     * @return tax of raw item
     */
    private static float rawTax(final float price) {
        return (RAW_TAX_PERCENTAGE / ValueConstants.HUNDRED) * price;
    }

    /*
     * This method calulate tax of raw item
     *
     * @param price price of item in real number
     * @return tax of manufactured item
     */
    private static float manufacturedTax(final float price) {
        final var remTax = (RAW_TAX_PERCENTAGE / ValueConstants.HUNDRED) * price;
        return remTax + (
                MANUFACTURED_TAX_PERCENTAGE / ValueConstants.HUNDRED) * price;
    }

    /*
     * This method calculate tax of imported item
     *
     * @param price price of item in real number
     * @return tax of imported item
     */
    private static float importedTax(final float price) {
        var taxOfImport = (IMPORTED_TAX_PERCENTAGE / ValueConstants.HUNDRED) * price;
        if (taxOfImport <= TAX_SLAB_OF_IMPORTED_ITEM_1) {
            taxOfImport += TAX_SLAB_ADDITION_1;
        } else if (taxOfImport <= TAX_SLAB_OF_IMPORTED_ITEM_2) {
            taxOfImport += TAX_SLAB_ADDITION_2;
        } else {
            taxOfImport += (
                    IMPORTEDTAXPERCENTAGE_2 / ValueConstants.HUNDRED)
                    * (taxOfImport + price);
        }
        return taxOfImport;
    }

    /*
     * This method calculate tax of  item
     *
     * @param price price of item
     * @param type  type of item
     * @return tax of item
     */
    public static float calculateTax(final String type, final float price) {
        var tax = ValueConstants.REALZERO;
        if (type.equalsIgnoreCase(ParameterConstants.RAW)) {
            tax = rawTax(price);
        } else if (type.equalsIgnoreCase(ParameterConstants.MANUFACTURED)) {
            tax = manufacturedTax(price);
        } else if (type.equalsIgnoreCase(ParameterConstants.IMPORTED)) {
            tax = importedTax(price);
        }
        return tax;
    }

}
