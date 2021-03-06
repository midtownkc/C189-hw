/**
 * A Phone directory using a binary tree.
 * @author Maxwell Frederickson
 * MF
 *
 */
public class DirectoryTree {
	private TreeNode root;
	
	public DirectoryTree() {
		root = null;
	}
	
	/**
	 * Concatenate input into a name string.
	 * @param firstName First Name.
	 * @param lastName Last Name.
	 * @return name firstName + " " + lastName
	 */
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
	 * MF
	 */
	public boolean insert(String firstName, String lastName, String email, String phone) {
		Person newPerson = new Person(firstName, lastName, email, phone);
		if (root == null) {
			root = new TreeNode(newPerson);
			System.out.println("Added " + newPerson.getFullName() + " to the directory.");
			return true;
		} else
			root.insert(firstName, lastName, email, phone);
			return true;
	}
	
	/**
	 * Find a person in the directory
	 * @param firstName
	 * @param lastName
	 * @return Person object
	 * MF
	 */
	Person search(String firstName, String lastName) {
		String name = full_name(firstName, lastName);
		if (root == null) {
			System.out.println("No entry found matching: " + name);
			return null;
		} else {
			return root.search(name);
		}
	}
	
	/**
	 * Delete an entry from the Directory using a person's name.
	 * @param firstName First name.
	 * @param lastName Last Name.
	 * @return true if the entry was deleted.
	 * MF
	 */
	public boolean delete(String firstName, String lastName) {
		String name = full_name(firstName, lastName);
		
		// MF: if String name isn't present, it can't be deleted.
		if (root == null) {
			System.out.println(name + " can't be deleted, because it was not found.");
			return false;
		} else {
			// MF: check if person is root.  IF they are the root, shift them over with a temporary root.
			if (root.entry.getFullName().toUpperCase().compareTo(name.toUpperCase()) == 0) {
				TreeNode currentNode = new TreeNode();
				currentNode.left = root;
				boolean result = root.delete(name, currentNode);
				root = currentNode.left;
				
				System.out.println(name + " was deleted from the directory.");
                return result;
			} else {
				return root.delete(name, null);
			}
		}
	}


	private class TreeNode {
		private Person entry;
		private TreeNode left;
		private TreeNode right;
		
		private TreeNode() {
			left = null;
			right = null;
			this.entry = null;
		}
		
		private TreeNode(Person newPerson) {
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
		 * MF
		 */
		public boolean insert(String firstName, String lastName, String email, String phone) {
			Person newPerson = new Person(firstName, lastName, email, phone);
			// MF: Update Person Entry for the Phone number if it already exists.
			if (newPerson.getFullName().compareTo(this.entry.getFullName()) == 0) {
				this.entry = newPerson;
				System.out.println("Updated entry for : " + this.entry.getFullName() + "\n");
				return true;
				// MF: Traverse / Add person to the left node if it's less than the current node
			} else if (newPerson.getFullName().compareTo(this.entry.getFullName()) < 0 ) {
				if (left == null) {
					left = new TreeNode(newPerson);
					System.out.println("Added " + newPerson.getFullName() + " to the directory.");
					return true;
				} else
					return left.insert(firstName, lastName, email, phone);
				// MF: Traverse / Add person to the right node if it's more than the current node.
			} else {
				if (right == null) {
					right = new TreeNode(newPerson);
					System.out.println("Added " + newPerson.getFullName() + " to the directory.");
					return true;
				} else
					return right.insert(firstName, lastName, email, phone);
			} 
	
		}
		
		/**
		 * Search for a person in the directory by name.
		 * @param name firstName + lastName of person searching for.
		 * @return Person entry matching the name or null if it's not found.
		 * MF
		 */
		Person search(String name) {
			// return if it matches MF
			if ( this.entry.getFullName().toUpperCase().compareTo(name.toUpperCase()) == 0) {
				System.out.println("\nLocated the following entry: ");
				this.entry.printInfo();
				return this.entry;
				
				// search left MF
			} else if (name.toUpperCase().compareTo(this.entry.getFullName().toUpperCase()) < 0 ) {
				if ( left == null ) {
					System.out.println("No entry found matching: " + name + "\n");
					return null;
				} else
					return left.search(name);
			} else {
				// search right MF
				if (right == null) {
					System.out.println("No entry found matching: " + name + "\n");
					return null;
				} else
					return right.search(name);
			}
			
		}
		
		/**
		 * Delete someone from the directory.
		 * @param name
		 * @param parentNode
		 * @return true if the string was deleted.  False if it wasn't found / not deleted.
		 * MF
		 */
		public boolean delete(String name, TreeNode parentNode) {

			// If the node is less than the entry, traverse left. MF
			if (name.toUpperCase().compareTo(entry.getFullName().toUpperCase()) < 0) {
				if (left != null) {
					return left.delete(name, this);
				} else 
					System.out.println("Could not delete: "+ name + " \nIt was not found in the directory.\n");
					return false;
			// If the node is greater than the entry, traverse right. MF
			} else if (name.toUpperCase().compareTo(this.entry.getFullName().toUpperCase()) > 0) {
				if (right != null)
					return right.delete(name, this);
				else 
					System.out.println("Could not delete: "+ name + " \nIt was not found in the directory.\n");
					return false;
			} else {
				if (left != null && right != null) {
					this.entry = right.lowestPerson();
					right.delete(this.entry.getFullName().toUpperCase(), this);
					// delete the entry MF
				} else if (parentNode.left == this) {
					parentNode.left = (left != null) ? left : right;
 				} else if (parentNode.right == this) {
 					parentNode.right = (left != null) ? left: right;
 				}
				System.out.println("Deleted: " + name + " from the directory.\n");
				return true;
			}
		}// end delete MF
		
		// find the person with the lowest entry. MF
		private Person lowestPerson() {
			if (left == null)
				return entry;
			else
				return left.lowestPerson();
		}
		
	} // end TreeNode MF
}
