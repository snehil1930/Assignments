package Assignment_1;

import java.util.*;
public class item {
	private  String name;
	private  float price;
	private  String type;
	private  int quantity;
	private float Tax;
	private float finalPrice;
	
//	Constructor
	
	public item(final String name,final float price,final int quantity,final String type)
	{
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.type=type;
	}
	
	//	summing total price
	
	public void totaling()
	{
	    Tax=new Utils().calculateTax(type,price);
		System.out.println("Tax on item is:  "+Tax);
		float totalPrice=price+Tax;
		finalPrice=quantity*totalPrice;
	}
	
//	return name of item
	public String getName()
	{
		return name;
	}
	
// return price of item
	
	public float getPrice()
	{
		return price;
	}
	
//return quantity of item
	
	public int getQuantity()
	{
		return quantity;
	}
	
// return type of item
	
	public String getType()
	{
		return type;
	}
	
//	return final price
	public float getfinalPrice()
	{
		return finalPrice;
	}
	
//	return tax
	public float getTax()
	{
		return Tax;
	}
//	Printing the Details of item 
	
	void display()
	{
		System.out.println("Item_Name\tItem_price\tItem_Type\tItem_quantity\tTotalPrice");
		System.out.println(name+"\t\t"+price+"\t\t"+type+"\t\t"+quantity+"\t  "+finalPrice);
	}
}
