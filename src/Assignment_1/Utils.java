package Assignment_1;
/**
 * This class is use to calulate tax of different items
 */

public final class Utils {
	/**
	* This method calulate tax of raw item
	* @param price  prive  of item
	* @return tax of raw item
    */
	
	private float rawTax(final float price)
	{
		float tax_of_raw= (float) ((12.5/Constants.hun)*price);
		System.out.println(tax_of_raw);
		return tax_of_raw;
	}
	
	/**
	* This method calulate tax of raw item
	* @param price price of item in real number
	* @return tax of manufactured item
    */

	private float manufacturedTax(final float price)
	{
		float rem_tax=(float) ((12.5/Constants.hun)*price);
		float tax_of_manf=(float) (rem_tax+(2.0/Constants.hun)*price);
		return tax_of_manf;
	}
	/**
	* This method calulate tax of imported item
	* @param price price of item in real number
	* @return tax of imported item
    */
	
	private float importedTax(final float price)
	{
		float tax_of_import = (float) ((10.0 / Constants.hun)* price);
        if (tax_of_import <= 100)
		{
			tax_of_import+= 5;
		}
        else if (tax_of_import <= 200)
		{
			tax_of_import += 10;
		}
        else
		{
			tax_of_import += (5.0 / Constants.hun) * (tax_of_import + price);
		}
        return tax_of_import;
	}
	
	/**
	* This method calulate tax of  item
	* @param price  price of item
	* @param type   type of item
	* @return tax of item
    */
	public float calculateTax(final String type,final float price)
	{
		if(type.equalsIgnoreCase(Constants.raw))
		{
			return rawTax(price);
		}
		else if(type.equalsIgnoreCase(Constants.manufactured))
		{
			retrun manufacturedTax(price);
		}
		else if(type.equalsIgnoreCase(Constants.imported))
		{
			return importedTax(price);
		}
	}

}
