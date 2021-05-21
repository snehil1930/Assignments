package Assignment_1;

import java.util.*;
public class ItemCheck {
	ItemCheck(){
		
//		Constructor of class
	}
	
//	Taking other inputs after pressing Y
	
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
			
			final item it=new Validator().getDetails(ar);
			it.totaling();
			it.display();
			System.out.println("Do you want to enter more choice.Enter Y/N");
			ch=sc.nextLine();
		}
		
//		Exiting from inputs
		
		System.out.println("Thank you purchase!Hope to see you soon..");
		System.exit(1);
	}
	
	
	
	
	void initials(final String[]args)
	{
    	try
		{
			final item it=new Validator().getDetails(args);
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
