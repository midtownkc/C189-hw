/**
 * Person class to store information: First & last names, email & phone numbers.
 * @author Maxwell Frederickson
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private String email;
	private int phone;
	
	public Person(String firstName, String lastName, String email, int phone) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
		
	}// end default constructor
	
	public Person() {
		setFirstName(null);
		setLastName(null);
		setEmail(null);
		setPhone(0);
	}

	// setters
	public void setPhone(int newPhone) {
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
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getPhone() {
		return phone;
	}
}
