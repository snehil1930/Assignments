package Assignment_1;

import java.util.*;
/**
 * This class is use to check inputs of item
 */
public class ItemCheck {

	public static Validator vc=new Validator();
	/**
	  * default constructor
      */
	ItemCheck(){
		
	}
	/**
      * This method is use to validate input on exceptions and format of input
      */
	
	void nextInputs() throws Exception
	{
		System.out.println("Do you want to enter more choice.Enter Y/N");
		final Scanner sc=new Scanner(System.in);
		String ch=sc.nextLine();
		while(ch.equalsIgnoreCase("n")==false)
		{
			String inputs=sc.nextLine();
			String ar[]=inputs.split(" ");
			
//			Inputs taken are verified in Validator
			
			final item it=vc.getDetails(ar);
			it.totaling();
			it.display();
			System.out.println("Do you want to enter more choice.Enter Y/N");
			ch=sc.nextLine();
		}
		
		System.out.println("Thank you purchase!Hope to see you soon..");
	}
	
	/**
      * This method is use to take details of item
      * @param args array of string is taken as input
      */
	
	
	void initials(final String[]args)
	{
    	try
		{
			final item it=vc.getDetails(args);
			it.display();
			nextInputs();
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input"+e.getMessage());
			System.exit(0);
		}
    	
	}

}
