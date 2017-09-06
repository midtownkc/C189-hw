/**
 * Person class to store information: First & last names, email & phone numbers.
 * @author Maxwell Frederickson
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private String name;
	private String email;
	private String phone;
	
	/**
	 * 
	 * @param firstName First Name.
	 * @param lastName Last Name.
	 * @param email Email Address.
	 * @param phone Phone Number: xxx-xxx-xxxx format.
	 */
	public Person(String firstName, String lastName, String email, String phone) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
		setName(firstName, lastName);
		
	}// MF: end default constructor

	/**
	 * Concatenates first & last names to a full name.
	 * @return firstName + ' ' + lastName
	 * MF
	 */
	
	/**
	 * Prints out the Name, Email and Phone number to the console.
	 * MF
	 */
	public void printInfo() {
		System.out.println("Name: " + this.getFullName());
		System.out.println("Email: " + this.getEmail());
		System.out.println("Phone: " + this.getPhone() + "\n");
	}
	
	// MF: setters
	
	public void setName(String firstName, String lastName) {
		this.name = firstName + " " + lastName;
	}
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
	
	// MF: getters
	
	public String getFullName() {
		return this.name;
	}
	
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
