package com.example.Assignment4.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * pojo class of the item
 */
@Entity
public class Items {


    @Id
    private String id;
    private String name;
    private float price;
    private int quantity;
    private String type;
    private float tax;
    private float finalPrice;

    /*
     *getter function of id
     */
    public String getId() {
        return id;
    }

    /*
     *getter function of name
     */
    public String getName() {
        return name;
    }

    /*
     *getter function of price
     */
    public float getPrice() {
        return price;
    }

    /*
     *getter function of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /*
     *getter function of type of item
     */
    public String getType() {
        return type;
    }

    /*
     *getter function of tax on sell
     */
    public float getTax() {
        return tax;
    }

    /*
     *getter function of final price after tax
     */
    public float getFinalPrice() {
        return finalPrice;
    }

    /*
     * setter function of id
     */

    public void setId(final String id) {
        this.id = id;
    }

    /*
     * setter function of name
     */

    public void setName(final String name) {
        this.name = name;
    }

    /*
     * setter function of price
     */
    public void setPrice(final float price) {
        this.price = price;
    }

    /*
     * setter function of quantity
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
    /*
     * setter function of type
     */

    public void setType(final String type) {
        this.type = type;
    }

    /*
     * setter function of tax
     */
    public void setTax(final float tax) {
        this.tax = tax;
    }

    /*
     * setter function of final price
     */
    public void setFinalPrice(final float finalPrice) {
        this.finalPrice = finalPrice;
    }

}
