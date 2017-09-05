/**
 * A Phone directory using a binary tree.
 * @author Maxwell Frederickson
 *
 */
public class DictionaryTree {
	private TreeNode root;
	
	public DictionaryTree() {
		root = null;
	}
	
	private String full_name(String firstName, String lastName) {
		String name = firstName + " " + lastName;
		return name;
	}
	
	/**
	 * Insert
	 * Adds a person to the directory.
	 * @param firstName First name.
	 * @param lastName Last name.
	 * @param email Email Address.
	 * @param string Phone Number.
	 */
	public boolean insert(String firstName, String lastName, String email, String phone) {
		Person newPerson = new Person(firstName, lastName, email, phone);
		if (root == null) {
			root = new TreeNode(newPerson);
			System.out.println("Successfully added " + newPerson.getFullName() + " to the database.");
			return true;
		} else
			root.insert(firstName, lastName, email, phone);
			System.out.println("Successfully added " + newPerson.getFullName() + " to the database.");
			return true;
	}
	
	/**
	 * Find a person in the directory
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	Person search(String firstName, String lastName) {
		String name = full_name(firstName, lastName);
		if (root == null) {
			System.out.println(name + " was not found.");
			return null;
		} else {
			return root.search(name);
		}
	}


	private class TreeNode {
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
		public void insert(String firstName, String lastName, String email, String phone) {
			Person newPerson = new Person(firstName, lastName, email, phone);
			// Update Person Entry for the Phone number if it already exists.
			if (newPerson.getFullName().compareTo(this.entry.getFullName()) == 0) {
				this.entry = newPerson;
				System.out.println("Updated entry for : " + this.entry.getFullName());
				// Traverse / Add person to the left node if it's less than the current node
			} else if (newPerson.getFullName().compareTo(this.entry.getFullName()) < 0 ) {
				if (left == null) {
					left = new TreeNode(newPerson);
					System.out.println("Added " + newPerson.getFullName() + " to the directory.");
				} else
					left.insert(firstName, lastName, email, phone);
				// Traverse / Add person to the right node if it's more than the current node.
			} else {
				if (right == null) {
					right = new TreeNode(newPerson);
					System.out.println("Added " + newPerson.getFullName() + " to the directory.");
				} else
					right.insert(firstName, lastName, email, phone);
			} 
	
		}
		
		Person search(String name) {
			if ( this.entry.getFullName().toUpperCase().compareTo(name.toUpperCase()) == 0) {
				System.out.println("Found and returned entry for: " + this.entry.getFullName() );
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
}
