package hunt.rainey;

public class Customer implements Comparable<Customer>{
	private String first;
	private String last;
	static int nextId = 1;
	private String city;
	private String pCode;
	private long cCard;
	private int id;
	Customer(String s, String a, String d, String g, long e){
		first = s;
		last = a;
		id = nextId;
		city = d;
		pCode = g;
		cCard = e;
		nextId++;
	}
	
	@Override
	public String toString() {
		return String.format("%nCustomer ID: %d %nName: %s %s %nCity: %s Postal Code: %s", id,first,last,city, pCode);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return first + " " + last;
	}

	public String getCity() {
		return city;
	}

	public String getCode() {
		return pCode;
	}

	public long getCard() {
		return cCard;
	}

	@Override
	public int compareTo(Customer o) {
		if (getId() <o.getId()){
			return -1;
		}
		else if (getId()> o.getId()){
			return 1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			Customer a = (Customer) o;
			if (id == a.getId()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

}
