
public class DirectoryHash {
	
	private final static int DIRECTORY_SIZE = 13;
	
	hashRecord[] directory;
	
	DirectoryHash() {
		directory = new hashRecord[DIRECTORY_SIZE];
		for (int i = 0; i < DIRECTORY_SIZE; i++) {
			directory[i] = null;
		}
	}
	
	private String full_name(String firstName, String lastName) {
		String name = firstName + " " + lastName;
		return name;
	}
	
	Person search(String firstName, String lastName) {
		// STUB return person
	}
	
	public void insert(String firstName, String lastName, String email, String phone) {
		Person newPerson = new Person(firstName, lastName, email, phone);
		// STUB FOR REST OF INSERT
		}

	private class hashRecord {
		private int key;
		private Person person;
		private hashRecord next;
		
		hashRecord(Person person) {
			this.key = person.getFullName().hashCode();
			this.person = person;
			this.next = null;
		}
		
		// getters MF
		
		Person getPerson() {
			return person;
		}
		
		hashRecord getNext() {
			return next;
		}
		
		int getHash() {
			return key;
		}
		
		// setters MF
		
		public void setValue(Person person) {
			this.person = person;
		}
		
		public void setNext(hashRecord next) {
			this.next = next;
		}
		
	}
}
