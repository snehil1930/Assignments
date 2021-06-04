package Assignment_1;

import java.util.*;

/**
 * This class  validate input on exception
 */
public class Validator {
    /*
     * this is a default constructor
     */
    public Validator() {
//		empty for future
    }

    /**
     * This method check validity of type and name
     *
     * @param args list of arguments
     */

    private void credCheck(final ArrayList<String> args) throws Exception {
        final String name = (Constants.dash).concat(Constants.name);
        final String type = (Constants.dash).concat(Constants.type);
        if (args.indexOf(name) != 0) {
            throw new Exception("Input should start with -name");
        }
        if (args.indexOf(type) < 0) {
            throw new Exception("Input should have type");
        }
    }

    /**
     * This method check format of input in price and quantity
     *
     * @param args list of arguments
     */

    private void parsingCheck(final ArrayList<String> args) throws Exception {
        final String quantity = (Constants.dash).concat(Constants.quantity);
        final String price = (Constants.dash).concat(Constants.price);
        int quant = 0;
        double pr = 0;
        try {
            if (args.indexOf(quantity) >= 0) {
                quant = Integer.parseInt(args.get(args.indexOf(quantity) + 1));
            }
            if (args.indexOf(price) >= 0) {
                pr = Double.parseDouble(args.get(args.indexOf(price) + 1));
            }
            if (pr < 0 || quant < 0) {
                throw new Exception("Wrong value enterd");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input for price and quantity !");
        }
    }

    /**
     * This method check null value of type
     *
     * @param mp hash of arguments
     */

    public void nullCheck(final Map<String, String> mp) throws Exception {
        if (mp.get((Constants.dash).concat(Constants.type)) == null) {
            throw new Exception("Null value entered for type");
        }
    }

    /**
     * This method check type entered
     *
     * @param mp hash of arguments
     */

    public void borderCheck(final Map<String, String> mp) throws Exception {
        final String s = (Constants.dash).concat(Constants.type);
        if (!mp.get(s).equals(Constants.raw) && !mp.get(s).equals(Constants.manufactured) && !mp.get(s).equals(Constants.imported)) {
            throw new Exception("This Type is not in option");
        }
    }

    /**
     * This method combine all validity check
     *
     * @param args list of arguments
     * @param mp   hash of arguments
     */


    public void checker(final ArrayList<String> args, final Map<String, String> mp) throws Exception {
        credCheck(args);
        parsingCheck(args);
        nullCheck(mp);
        borderCheck(mp);

    }

    /**
     * This method check validity of type and name
     *
     * @param args list of arguments
     * @return item class
     */


    public item getDetails(final String[] args) throws Exception {
        final ArrayList<String> list = new ArrayList<>(Arrays.asList(args));
        final Map<String, String> mp = new HashMap<String, String>();
        for (int i = 0; i < args.length; i += 2) {
            mp.put(args[i], args[i + 1]);
        }
        checker(list, mp);
        System.out.println("Exception are fine");
        String name;
        String type;
        float price;
        int quantity;
        name = mp.get((Constants.dash).concat(Constants.name));
        price = Float.parseFloat(mp.get((Constants.dash).concat(Constants.price)));
        type = mp.get((Constants.dash).concat(Constants.type));
        quantity = Integer.parseInt(mp.get((Constants.dash).concat(Constants.quantity)));
        return new item(name, price, quantity, type);
    }
}
