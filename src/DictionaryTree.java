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
	 * Adds a person to the Dictionary.
	 * @param firstName First name.
	 * @param lastName Last name.
	 * @param email Email Address.
	 * @param phone Phone Number.
	 * @return
	 */
	Person insert(String firstName, String lastName, String email, int phone) {
		Person newPerson = new Person(firstName, lastName, email, phone);
		if (root == null) {
			root = new TreeNode(newPerson);
			return newPerson;
		} else
			root.insert(firstName, lastName, email, phone);
			return newPerson;
	}
	
	Person search(String firstName, String lastName) {
		String name = full_name(firstName, lastName);
		if (root == null) {
			System.out.println(name + " was not found.");
			return null;
		} else {
			root.search(name);
		}
	}
}
