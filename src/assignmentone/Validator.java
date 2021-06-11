package assignmentone;

import assignmentone.constants.ErrorConstants;
import assignmentone.constants.ParameterConstants;
import assignmentone.constants.ValueConstants;
import assignmentone.exceptions.InvalidInputError;

import java.util.*;

/*
 * This class is use to check the inputs entered by user
 */
public final class Validator {

    /*
     * This method check validity of type and name
     *
     * @param args list of arguments
     */
    private void nameAndTypeCheck(final List<String> args) {
        final var name = ParameterConstants.DASH.concat(ParameterConstants.NAME);
        final var type = ParameterConstants.DASH.concat(ParameterConstants.TYPE);
        if (args.indexOf(name) != ValueConstants.ZERO) {
            throw new InvalidInputError(ErrorConstants.ERROR1);
        }
        if (args.indexOf(type) < ValueConstants.ZERO) {
            throw new InvalidInputError(ErrorConstants.ERROR2);
        }
    }

    /*
     * This method check format of input in price and quantity
     * @param args list of arguments
     */
    private void parsingCheck(final List<String> args) {
        final var quantity =
                ParameterConstants.DASH.concat(ParameterConstants.QUANTITY);
        final var price =
                ParameterConstants.DASH.concat(ParameterConstants.PRICE);
        var quantityValue = ValueConstants.ZERO;
        var priceValue = ValueConstants.REALZERO;
        try {
            if (args.indexOf(quantity) >= ValueConstants.ZERO) {
                quantityValue = Integer.parseInt(
                        args.get(args.indexOf(quantity) + 1));
            }
            if (args.indexOf(price) >= ValueConstants.ZERO) {
                priceValue = (float) Double.parseDouble(
                        args.get(args.indexOf(price) + 1));
            }
            if (priceValue < ValueConstants.ZERO
                    || quantityValue < ValueConstants.ZERO) {
                throw new InvalidInputError(ErrorConstants.ERROR3);
            }
        } catch (NumberFormatException exception) {
            System.out.println(ErrorConstants.ERROR4);
        }
    }

    /*
     * This method check null value of type
     * @param mp hash of arguments
     */
    public void nullCheck(final Map<String, String> map) {
        if (Objects.isNull(map)) {
            throw new NullPointerException(ErrorConstants.ERROR5);
        }
    }

    /*
     * This method check type entered
     * @param mp hash of arguments
     */
    public void borderCheck(final Map<String, String> map) {
        final var type = ParameterConstants.DASH.concat(ParameterConstants.TYPE);
        if (!map.get(type).equals(ParameterConstants.RAW)
                && !map.get(type).equals(ParameterConstants.MANUFACTURED)
                && !map.get(type).equals(ParameterConstants.IMPORTED)) {
            throw new InvalidInputError(ErrorConstants.ERROR6);
        }
    }

    /*
     * This method combine all validity check
     *
     * @param args list of arguments
     * @param mp   hash of arguments
     */
    public void checker(final List<String> args,
                        final Map<String, String> map) {
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
    public Item getDetails(final String... args) {
        final var list = new ArrayList<>(Arrays.asList(args));
        final var map = new HashMap<String, String>();
        for (var i = 0; i < args.length; i += 2) {
            map.put(args[i], args[i + 1]);
        }
        checker(list, map);
        final var name =
                map.get(ParameterConstants.DASH.concat(ParameterConstants.NAME));
        final var price = Float.parseFloat(
                map.get(ParameterConstants.DASH.concat(
                        ParameterConstants.PRICE)));
        final var type = map.get(
                ParameterConstants.DASH.concat(ParameterConstants.TYPE));
        final var quantity = Integer.parseInt(
                map.get(ParameterConstants.DASH.concat(
                        ParameterConstants.QUANTITY)));
        return new Item(name, price, quantity, type);
    }
}
