package Assig1;

import Assignment_1.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
    * This class tests Asignment 1 on different testcase
    */

class valdatortester {

	@Test
	/*
	* This test method is used to check whether correct input is passing test or not
	*/
	void devTest() throws Exception {
		
		String [] args = new String[]{"-name" , "snehil" , "-type" , "raw" , "-price" , "123" , "-quantity" , "2"} ;
		Validator vc=new Validator();
		item it=vc.getDetails(args);
		assertNotNull(it) ;
        assertNotNull(it.getName()) ;
        assertEquals(it.getType() , "raw" );
        assertNotNull(it.getPrice()) ;
        assertEquals(it.getPrice(), 123) ;
        assertEquals(it.getName() , "snehil") ;
        assertEquals(it.getQuantity(), 2) ;
	}

	/*
	*This method is use to test inputs on various invalid input and test exceptions
	 */

	@Test
	void exceptionsTest() throw Exception
	{

//		this checks name paramter should be alway come first

		assertThrows(Exception.class , ()->{
			String[] temp = new String[]{"-type" , "raw" , "-name" , "snehil"} ;
			new Validator().getDetails(temp) ;
		});

//		This is use to throw error when option of type doesnot match

		assertThrows(Exception.class,()->{
			String[] temp = new String[]{"-name" , "snehil","-type","exported"} ;
			new Validator().getDetails(temp);
		});

//		this is invalid input as price<0

		assertThrows(Exception.class,()->{
			String[] temp = new String[]{"-name" , "snehil","-type","exported","-price","-34"} ;
			new Validator().getDetails(temp);
		});

//		this is invalid as quantity<0
		assertThrows(Exception.class,()->{
			String[] temp = new String[]{"-name" , "snehil","type","exported","price","34","quantity","-3"} ;
			new Validator().getDetails(temp);
		});

//		this is invalid as type is compulsory paramter and it is missing
		assertThrows(Exception.class,()->{
			String[] temp = new String[]{"-name" , "snehil","-price","34"} ;
			new Validator().getDetails(temp);
		});

//		this is valid input

		assertThrows(Exception.class,()->{
			String[] temp = new String[]{"-name" , "snehil","-type","imported","-price","34"} ;
			new Validator().getDetails(temp);
		});
	}

	/*
	* this method is tested afer valid and invalid inputs is tested
	* it test the finalprice of item after calculation
	*/

	@Test
	void finalPriceTest()
	{
//		it test results for "raw" item

		args = new String[]{"-name" , "snehil" , "-type" , "raw" , "-price" , "123" , "-quantity" , "2"} ;
		vc=new Validator();
		it=vc.getDetails(args);
		it.totaling();
		float actual=it.getfinalPrice();
		float expected=(float)276.75;
		assertEquals(actual,expected);

//		it test for imported item

		args = new String[]{"-name" , "snehil" , "-type" , "imported" , "-price" , "123" , "-quantity" , "2"} ;
		vc=new Validator();
		it=vc.getDetails(args);
		it.totaling();
		actual=it.getfinalPrice();
		expected=(float)280.6;
		assertEquals(actual,expected);

//		it test for manufactured item type

		args = new String[]{"-name" , "snehil" , "-type" , "manufactured" , "-price" , "123" , "-quantity" , "2"} ;
		vc=new Validator();
		it=vc.getDetails(args);
		it.totaling();
		actual=it.getfinalPrice();
		expected=(float)281.66998;
		assertEquals(actual,expected);
	}

}
