package hunt.rainey;

public class Customer {
	private String first;
	private String last;
	private int id;
	private String city;
	private String pCode;
	private long cCard;
	
	Customer(String s, String a, String d, String g, long e){
		first = s;
		last = a;
		id = 1;
		city = d;
		pCode = g;
		cCard = e;
	}
	
	@Override
	public String toString() {
		return String.format("Customer ID: %d %nName: %s %s %nCity: %s Postal Code: %s", id,first,last,city, pCode);
	}
}
