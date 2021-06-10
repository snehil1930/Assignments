package assignmentone;

import assignmentone.exceptions.InvalidInputError;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/*
 * This class is use to check the inputs entered by user
 */
public class Validator {

    /*
     * This method check validity of type and name
     *
     * @param args list of arguments
     */
    private void nameAndTypeCheck(final List<String> args) {
        final var name = Constants.dash.concat(Constants.name);
        final var type = Constants.dash.concat(Constants.type);
        if (args.indexOf(name) != Constants.ZERO) {
            throw new InvalidInputError("Input should start with -name");
        }
        if (args.indexOf(type) < Constants.ZERO) {
            throw new InvalidInputError("Input should have -type");
        }
    }

    /*
     * This method check format of input in price and quantity
     * @param args list of arguments
     */
    private void parsingCheck(final List<String> args) {
        final var quantity = Constants.dash.concat(Constants.quantity);
        final var price = Constants.dash.concat(Constants.price);
        var quantityValue = Constants.ZERO;
        var priceValue = 0.0;
        try {
            if (args.indexOf(quantity) >= Constants.ZERO) {
                quantityValue = Integer.parseInt(
                        args.get(args.indexOf(quantity) + 1));
            }
            if (args.indexOf(price) >= Constants.ZERO) {
                priceValue = Double.parseDouble(
                        args.get(args.indexOf(price) + 1));
            }
            if (priceValue < 0 || quantityValue < 0) {
                throw new InvalidInputError("Wrong value entered");
            }
        } catch (NumberFormatException exception) {
            System.out.println("Invalid input for price and quantity !");
        }
    }

    /*
     * This method check null value of type
     * @param mp hash of arguments
     */
    public void nullCheck(final Map<String, String> map) {
        if (map.get(Constants.dash.concat(Constants.type)) == null) {
            throw new NullPointerException("Null value entered for type");
        }
    }

    /*
     * This method check type entered
     * @param mp hash of arguments
     */
    public void borderCheck(final Map<String, String> map) {
        final var type = Constants.dash.concat(Constants.type);
        if (!map.get(type).equals(Constants.raw)
                && !map.get(type).equals(Constants.manufactured)
                && !map.get(type).equals(Constants.imported)) {
            throw new InvalidInputError("This Type is not in option");
        }
    }

    /*
     * This method combine all validity check
     *
     * @param args list of arguments
     * @param mp   hash of arguments
     */
    public void checker(final List<String> args, final Map<String, String> map) {
        nameAndTypeCheck(args);
        parsingCheck(args);
        nullCheck(map);
        borderCheck(map);
    }

    /*
     * This method check validity of type and name
     *
     * @param args list of arguments
     * @return item class
     */
    public Item getDetails(final String[] args) {
        final var list = new ArrayList<>(Arrays.asList(args));
        final var map = new HashMap<String, String>();
        for (var i = 0; i < args.length; i += 2) {
            map.put(args[i], args[i + 1]);
        }
        checker(list, map);
        final var name = map.get(Constants.dash.concat(Constants.name));
        final var price = Float.parseFloat(
                map.get(Constants.dash.concat(Constants.price)));
        final var type = map.get(Constants.dash.concat(Constants.type));
        final var quantity = Integer.parseInt(
                map.get(Constants.dash.concat(Constants.quantity)));
        return new Item(name, price, quantity, type);
    }
}
