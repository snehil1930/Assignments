package com.example.Assignment4.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*
 * pojo class of the item
 */
@Entity
@Table(name = "item_detail")
public class Items {


    /*
     * id of item
     */
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    /*
     * name of the item
     */
    @Column(name = "name")
    private String name;

    /*
     * price of item
     */
    @Column(name = "price")
    private float price;

    /*
     * quantity of item
     */
    @Column(name = "quantity")
    private int quantity;

    /*
     * type of the item
     */
    @Column(name = "type")
    private String type;

    /*
     * tax per item
     */
    @Column(name = "tax")
    private float tax;

    /*
     * final price of item
     */
    @Column(name = "finalprice")
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
