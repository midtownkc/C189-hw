
public class TreeNode {
	private Person entry;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode() {
		left = null;
		right = null;
		this.entry = null;
	}
	
	public TreeNode(Person newPerson) {
		left = null;
		right = null;
		this.entry = newPerson;
	}
	
	/**
	 * Insert a new Person into the directory by passing the raw values into the directory.
	 * @param firstName The first name of the person being added to the directory.
	 * @param lastName The last name of the person being added to the directory.
	 * @param email The email of the person being added to the directory.
	 * @param phone The phone number of the person being added to the directory.  This is used as the Node value.
	 * @return A person object created by the directory.
	 */
	Person insert(String firstName, String lastName, String email, int phone) {
		Person newPerson = new Person(firstName, lastName, email, phone);
		// Update Person Entry for the Phone number if it already exists.
		if (newPerson.getFullName().compareTo(this.entry.getFullName()) == 0) {
			this.entry = newPerson;
			System.out.println("Updated entry for : " + this.entry.getFullName());
			return this.entry;
		} else if (newPerson.getFullName().compareTo(this.entry.getFullName()) < 0 ) {
			if (left == null) {
				left = new TreeNode(newPerson);
				System.out.println("Added " + newPerson.getFullName() + " to the directory.");
				return newPerson;
			} else
				left.insert(firstName, lastName, email, phone);
				return newPerson;	
		} else {
			if (right == null) {
				right = new TreeNode(newPerson);
				return newPerson;
			} else
				right.insert(firstName, lastName, email, phone);
				return newPerson;
		} 

	}
	
	Person search(String name) {
		if ( this.entry.getFullName().toUpperCase() == name.toUpperCase()) {
			return this.entry;
		} else if (name.toUpperCase().compareTo(this.entry.getFullName().toUpperCase()) < 0 ) {
			if ( left == null ) {
				System.out.println("No entry found matching: " + name);
				return null;
			} else
				return left.search(name);
		} else {
			if (right == null) {
				System.out.println("No entry found matching: " + name);
				return null;
			} else
				return right.search(name);
		}
		
	}
	
}
