package hunt.rainey;

public class Sale {
	private int saleData;
	private String postalCode;
	
	Sale(String s, int i){
		postalCode = s;
		saleData = i;
	}
	
	public int giveSales() {
		return saleData;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %d", postalCode, saleData);
	}
}
