/**
 * Person class to store information: First & last names, email & phone numbers.
 * @author Maxwell Frederickson
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public Person(String firstName, String lastName, String email, String phone) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
		
	}// end default constructor
	
	public Person() {
		setFirstName(null);
		setLastName(null);
		setEmail(null);
		setPhone(null);
	}

	/**
	 * Concatenates first & last names to a full name.
	 * @return firstName + ' ' + lastName
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public void printInfo() {
		System.out.println("Name: " + this.getFullName());
		System.out.println("Email: " + this.getEmail());
		System.out.println("Phone: " + this.getPhone());
	}
	
	// setters
	public void setPhone(String newPhone) {
		this.phone = newPhone;	
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}

	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	
	// getters
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
}
