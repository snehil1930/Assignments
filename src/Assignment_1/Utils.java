package Assignment_1;

public class Utils {
	
	private float rawTax(float price)
	{
		float tax_of_raw= (float) ((12.5/100.0)*price);
		System.out.println(tax_of_raw);
		return tax_of_raw;
	}
	
	private float manufacturedTax(float price)
	{
		float rem_tax=(float) ((12.5/100.0)*price);
		float tax_of_manf=(float) (rem_tax+(2.0/100)*price);
		return tax_of_manf;
	}
	
	private float importedTax(float price)
	{
		float tax_of_import = (float) ((10.0 / 100.0)* price);
        if (tax_of_import <= 100) tax_of_import+= 5;
        else if (tax_of_import <= 200) tax_of_import += 10;
        else tax_of_import += (5.0 / 100.0) * (tax_of_import + price);
        return tax_of_import;
	}
	
//	Logic for tax calculations are done
	public float calculateTax(String type,float price)
	{
		float tax=0;
		if(type.equalsIgnoreCase(Constants.raw))
			tax=rawTax(price);
		else if(type.equalsIgnoreCase(Constants.manufactured)) 
			tax=manufacturedTax(price);
		else if(type.equalsIgnoreCase(Constants.imported))
			tax=importedTax(price);
		return tax;
	}

}
