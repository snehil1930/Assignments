package Assig1;

import Assignment_1.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
    * This class tests Asignment 1 on different testcase
    */

class valdatortester {

	@Test
	void validateTest() throws Exception {
		
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
        
//        Exception and Invalid tests
        
        assertThrows(Exception.class , ()->{
            String[] temp = new String[]{"-type" , "raw" , "-name" , "snehil"} ;
            new Validator().getDetails(temp) ;
        });
        assertThrows(Exception.class,()->{
        	String[] temp = new String[]{"-name" , "snehil","-type","exported"} ;
        	new Validator().getDetails(temp);
        });
        assertThrows(Exception.class,()->{
        	String[] temp = new String[]{"-name" , "snehil","-type","exported","-price","-34"} ;
        	new Validator().getDetails(temp);
        });
        assertThrows(Exception.class,()->{
        	String[] temp = new String[]{"-name" , "snehil","type","exported","price","34","quantity","-3"} ;
        	new Validator().getDetails(temp);
        });
        
        
        assertThrows(Exception.class,()->{
        	String[] temp = new String[]{"-name" , "snehil","-price","34"} ;
        	new Validator().getDetails(temp);
        });
        
        assertThrows(Exception.class,()->{
        	String[] temp = new String[]{"-name" , "snehil","-type","imported","-price","34"} ;
        	new Validator().getDetails(temp);
        });
        
//        testing for last price
        args = new String[]{"-name" , "snehil" , "-type" , "raw" , "-price" , "123" , "-quantity" , "2"} ;
        vc=new Validator();
		it=vc.getDetails(args);
		it.totaling();
		float actual=it.getfinalPrice();
//		System.out.println(actual);
		float expected=(float)276.75;
		assertEquals(actual,expected);
		
		args = new String[]{"-name" , "snehil" , "-type" , "imported" , "-price" , "123" , "-quantity" , "2"} ;
        vc=new Validator();
		it=vc.getDetails(args);
		it.totaling();
		actual=it.getfinalPrice();
//		System.out.println(actual);
	    expected=(float)280.6;
		assertEquals(actual,expected);
		
		
		args = new String[]{"-name" , "snehil" , "-type" , "manufactured" , "-price" , "123" , "-quantity" , "2"} ;
        vc=new Validator();
		it=vc.getDetails(args);
		it.totaling();
		actual=it.getfinalPrice();
//		System.out.println(actual);
	    expected=(float)281.66998;
		assertEquals(actual,expected);
		
	}

}
