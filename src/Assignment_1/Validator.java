package Assignment_1;

import java.util.*;

/**
	* This class  validate input on exceptions
	* @param price of item
	* @return tax of raw item
    */
public class Validator {
	
  /**
	* This method check validity of type and name
	* @param list of arguments
    */
	
	private void credCheck(final ArrayList<String> args) throws Exception
	{
		String name="-".concat(Constants.name);
		String type="-".concat(Constants.type);
		if(args.indexOf(name)!=0)
			throw new Exception("Input should start with -name");
		if(args.indexOf(name)<0)
			throw new Exception("Input should have type");
	}

	/**
	* This method check format of input in price and quantity
	* @param list of arguments
    */
	
	private  void parsingCheck(final ArrayList<String> args) throws Exception {
		String quantity="-".concat(Constants.quantity);
		String price="-".concat(Constants.price);
		int quant=0;
		double pr=0;
        try {
            if (args.indexOf(quantity) >= 0)
                 quant = Integer.parseInt(args.get(args.indexOf(quantity) + 1));
            if (args.indexOf(price) >= 0)
                pr=Double.parseDouble(args.get(args.indexOf(price) + 1));
            if(pr<0||quant<0)
            	throw new Exception("Wrong value enterd");
 
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for price and quantity !");
        }
    }

    /**
	* This method check null value of type 
	* @param mp hash of arguments
    */
	
	public void nullCheck(Map<String,String> mp) throws Exception
	{
		if(mp.get("-".concat(Constants.type))==null)
		{
			throw new Exception("Null value entered for type") ;
		}
	}
	/**
	* This method check type entered
	* @param mp hash of arguments
    */
	
	public void borderCheck(Map<String,String> mp) throws Exception
	{
		String s="-".concat(Constants.type);
		if (mp.get(s).equals(Constants.raw)==false && mp.get(s).equals(Constants.manufactured)==false && mp.get(s).equals(Constants.imported)==false)
			throw new Exception("This Type is not in option");
	}

	/**
	* This method combine all validity check
	* @param args list of arguments
	* @param mp hash of arguments
    */
	
	
	public void checker(final ArrayList<String> args,final Map<String,String> mp) throws Exception
	{
		credCheck(args);
		parsingCheck(args);
		nullCheck(mp);
		borderCheck(mp);
		
	}
	
	/**
	* This method check validity of type and name
	* @param args list of arguments
	* @return item class 
    */
	
	
	public item getDetails(final  String[]args) throws Exception
	{ 
		ArrayList<String> list=new ArrayList<>(Arrays.asList(args));
		Map<String, String> mp = new HashMap<String, String>();
		for(int i=0;i<args.length;i+=2)
		{
			mp.put(args[i],args[i+1]);	
		}
		checker(list,mp);
		System.out.println("Exception are fine");
		String name,type;
		float price;
		int quantity;
		name=mp.get("-".concat(Constants.name));
		price=Float.parseFloat(mp.get("-".concat(Constants.price)));
		type=mp.get("-"+Constants.type);
		quantity=Integer.parseInt(mp.get("-".concat(Constants.quantity)));
		return new item(name,price,quantity,type);
	}

}
