package com.example.Assignment4.entity;

import com.example.Assignment4.utils.TaxUtils;

/*
 * It is use to build the item class
 */
public class ItemsBuilder {
    /*
     * to get item and set attributes of items class
     */
    private final Items item;

    /*
     *Parameterise constructor to set attribute and calculate tax on type
     * of item given
     * @param id id of item
     * @param name name of the item
     * @param price price of item
     * @param quantity quantity of item
     * @param type type of item
     */
    public ItemsBuilder(final int id, final String name,
                        final float price, final int quantity, final String type) {
        this.item = new Items();
        item.setId(id);
        item.setName(name);
        item.setPrice(price);
        item.setQuantity(quantity);
        item.setType(type);
        final float tax = TaxUtils.calculateTax(type, price);
        item.setTax(tax);
        final float finalPrice = (price + tax) * quantity;
        item.setFinalPrice(finalPrice);
    }

    /*
     * Getter of items class
     */
    public Items getItem() {
        return item;
    }
}
