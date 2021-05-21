package Assignment_1;

public class Utils {
	
	private float rawTax(fianl float price)
	{
		float tax_of_raw= (float) ((12.5/Constants.hun)*price);
		System.out.println(tax_of_raw);
		return tax_of_raw;
	}
	
	private float manufacturedTax(final float price)
	{
		float rem_tax=(float) ((12.5/Constants.hun)*price);
		float tax_of_manf=(float) (rem_tax+(2.0/Constants.hun)*price);
		return tax_of_manf;
	}
	
	private float importedTax(final float price)
	{
		float tax_of_import = (float) ((10.0 / Constants.hun)* price);
        if (tax_of_import <= 100) 
        	tax_of_import+= 5;
        else if (tax_of_import <= 200) 
        	tax_of_import += 10;
        else 
        	tax_of_import += (5.0 / Constants.hun) * (tax_of_import + price);
        return tax_of_import;
	}
	
//	Logic for tax calculations are done
	public float calculateTax(final String type,final float price)
	{
		float tax=0;
		if(type.equalsIgnoreCase(Constants.raw))
			return rawTax(price);
		else if(type.equalsIgnoreCase(Constants.manufactured)) 
			retrun manufacturedTax(price);
		else if(type.equalsIgnoreCase(Constants.imported))
			return importedTax(price);
	}

}
