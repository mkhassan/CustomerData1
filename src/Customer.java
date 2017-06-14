import java.util.Scanner;

public class Customer {
	
	private String title;
	private String firstname;
	private String lastname;
	private String city;
	private String state;
	private String zipcode;
	private String email;
	private String position;
	private String company;
	private String customerid;
	private String address;
	


	public Customer() {
	
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter your last name");
		
		String lastName = kb.nextLine();
		this.lastname = lastName;
		
		kb.close();
		
	}
	
	// learn constructor chaining
	
	public Customer (String firstname, String lastname, String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}
	
	public Customer(String title, String firstname, String lastname, String city, String state, String email,
			String position, String company, String customerid, String address,String zipcode) {
		this(firstname, lastname,address);
		this.title = title;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.position = position;
		this.company = company;
		this.customerid = customerid;
	}	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}