package hunt.rainey;

public class Customer {
	private String first;
	private String last;
	private int id;
	private String city;
	private String pCode;
	private int cCard;
	
	Customer(String s, String a, String d, String g, int h){
		first = s;
		last = a;
		id = 1;
		city = d;
		pCode = g;
		cCard = h;
	}
	
	@Override
	public String toString() {
		return String.format("Customer ID: %d %nName: %s %s %nCity: %s Postal Code: %s", id,first,last,city, pCode);
	}
}
