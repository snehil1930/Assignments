package assignmentone;


/*
 * This class is use to save details of item
 * calulate final price
 * display details of item
 * getter fuctions of variable
 */
public class Item {
    private final String name;
    private final float price;
    private final String type;
    private final int quantity;
    private  float tax;
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
    public void totaling() {
        tax = new Utils().calculateTax(type, price);
        System.out.println("Tax on item is:  " + tax);
        final float totalPrice = price + tax;
        finalPrice = quantity * totalPrice;
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
     * This is a getter method of finalprice of item
     *
     * @return finalprice of item
     */
    public float getfinalPrice() {
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
    public void display() {
        System.out.println("Item_Name\tItem_price\tItem_Type\tItem_quantity\tTotalPrice");
        System.out.println(name + "\t\t" + price + "\t\t" + type + "\t\t" + quantity + "\t  " + finalPrice);
    }
}
