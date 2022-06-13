package hunt.rainey;

/**
 * a class that holds the total sales for a specific postal code
 * @author Rainey Hunt
 *
 */
public class Sale {
	private int saleData;
	private String postalCode;
	
	/**
	 * create a new total sales
	 * @param s
	 * @param i
	 */
	Sale(String s, int i){
		postalCode = s;
		saleData = i;
	}
	
	/**
	 * give the total sales for this postal code
	 * @return int
	 */
	public int giveSales() {
		return saleData;
	}
	
	/**
	 * show each total sales as a string
	 */
	@Override
	public String toString() {
		return String.format("%s: %d", postalCode, saleData);
	}
}
