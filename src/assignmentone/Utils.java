package assignmentone;

/*
 * This class is use to calculate tax of different items
 */

public final class Utils {
    /*
     * This method calculate tax of raw item
     *
     * @param price price  of item
     * @return tax of raw item
     */

    private float rawTax(final float price) {
        final float taxOfRaw = (float) ((12.5 / Constants.hundred) * price);
        System.out.println(taxOfRaw);
        return taxOfRaw;
    }

    /*
     * This method calulate tax of raw item
     *
     * @param price price of item in real number
     * @return tax of manufactured item
     */

    private float manufacturedTax(final float price) {
        final float remTax = (float) ((12.5 / Constants.hundred) * price);
        return (float) (remTax + (2.0 / Constants.hundred) * price);
    }

    /*
     * This method calulate tax of imported item
     *
     * @param price price of item in real number
     * @return tax of imported item
     */

    private float importedTax(final float price) {
        float taxOfImport = (float) ((10.0 / Constants.hundred) * price);
        if (taxOfImport <= 100) {
            taxOfImport += 5;
        } else if (taxOfImport <= 200) {
            taxOfImport += 10;
        } else {
            taxOfImport += (5.0 / Constants.hundred) * (taxOfImport + price);
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
    public float calculateTax(final String type, final float price) {
        if (type.equalsIgnoreCase(Constants.raw)) {
            return rawTax(price);
        } else if (type.equalsIgnoreCase(Constants.manufactured)) {
            return manufacturedTax (price);
        } else if (type.equalsIgnoreCase(Constants.imported)) {
            return importedTax(price);
        }
        else{
            return 0;
        }
    }

}
