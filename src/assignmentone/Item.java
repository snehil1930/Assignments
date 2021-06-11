package assignmentone;

/*
 * This class is use to save details of item
 * calculate final price
 * display details of item
 * getter functions of variable
 */
public class Item {

    /*
     * This will store the name of item
     */
    private final String name;

    /*
     * This  will store the price of one item
     */
    private final float price;

    /*
     * This will store the type of item
     */
    private final String type;

    /*
     * This will store number of item
     */
    private final int quantity;

    /*
     * This will store the tax applied on that item
     */
    private float tax;

    /*
     * This will store the final  payable amount needed to be paid
     */
    private float finalPrice;

    /*
     * This is a constructor
     *
     * @param name     This is the first parameter to initialize name
     * @param price    This is the second parameter to initialize price
     * @param quantity this is the third parameter to initialize quantity
     * @param type     This is the fourth parameter to initialize type
     */
    public Item(final String name, final float price, final int quantity, final String type) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    /*
     * This is a method to sum up the tax and generate final price
     */
    public void calculateFinalPrice() {
        tax = TaxUtils.calculateTax(type, price);
        System.out.println("Tax on item is:  " + tax);
        finalPrice = quantity * (price+tax);
    }

    /*
     * This is a getter method of name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /*
     * This is a getter method of price
     *
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /*
     * This is a getter method of quantity
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /*
     * This is a getter method of type
     *
     * @return item type
     */
    public String getType() {
        return type;
    }

    /*
     * This is a getter method of final price of item
     *
     * @return final price of item
     */
    public float getFinalPrice() {
        return finalPrice;
    }

    /*
     * This is a getter method of tax on item
     *
     * @return tax on item
     */
    public float getTax() {
        return tax;
    }

    /*
     * This is a printing method details in item
     */
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", tax=" + tax +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
