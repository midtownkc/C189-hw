/**
 * Phone Directory made with bucket hashing & linked list.
 * @author Maxwell Frederickson
 *MF
 */
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
	
	private int hashinator(String name) {
		int hash = name.hashCode() % directory.length;
		if (hash < 0)
			hash += directory.length;
		return hash;
	}
	
	/**
	 * Deletes a record from the phone directory.
	 * @param firstName First Name.
	 * @param lastName Last Name.
	 * MF
	 */
	public void delete(String firstName, String lastName) {
		String name = full_name(firstName, lastName);
		int hash = hashinator(name);
		if (directory[hash] != null) {
			hashRecord previous = null;
			hashRecord focusRecord = directory[hash];
			// iterate through until either the record is found, or a null record is reached.  Delete the value if found. MF
			while (focusRecord.getName() != null && hashinator(focusRecord.getName()) != hashinator(name)) {
				previous = focusRecord;
				focusRecord = focusRecord.getNext();
			}
			if (focusRecord.getName().equals(name)) {
				if (previous == null) {
					directory[hash] = focusRecord.getNext();
					System.out.println("Deleted: " + name + " from the directory.");
				} else {
					previous.setNext(focusRecord.getNext());
				}
			}
		}
				
		
	}
	
	/**
	 * Search for a person in the phone directory.
	 * @param firstName First Name.
	 * @param lastName Last Name
	 * @return Person The person being searched for, or null if not found.
	 * MF
	 */
	Person search(String firstName, String lastName) {
		String name = full_name(firstName, lastName);
		int hash = hashinator(name);
		// if it's empty, then it's not found. MF
		if (directory[hash] == null) {
			System.out.println(name + " wasn't found in the directory.\n");
			return null;
			// iterate through the entries until a matching entry is found, or a null entry is found in which case it's not present. MF
		} else {
			hashRecord focusRecord = directory[hash];
			while ((focusRecord != null) && ((focusRecord.getPerson().getFullName()).hashCode() != name.hashCode())) {
				focusRecord = focusRecord.getNext();
			}
			if (focusRecord == null) {
				System.out.println(name + " wasn't found in the directory\n");
				return null;
			} else {
				System.out.println("Located the following entry:\n");
				focusRecord.getPerson().printInfo();
				return focusRecord.getPerson();
			}
				
		}
	}
	
	/**
	 * Insert a person into the directory hash
	 * @param firstName First Name
	 * @param lastName Last Name
	 * @param email Email Address
	 * @param phone Phone number.
	 * MF
	 */
	public void insert(String firstName, String lastName, String email, String phone) {
		Person newPerson = new Person(firstName, lastName, email, phone);
		int hash = hashinator(newPerson.getFullName());
		// check if hash is empty and add if not MF
		if (directory[hash] == null) {
			System.out.println("Added " + newPerson.getFullName() + " to the directory.");
			directory[hash] = new hashRecord(newPerson);
			// iterate through entries until either a match or a null entry is found.  Insert the value.
		} else { 
			hashRecord focusRecord = directory[hash];
			while (focusRecord.getNext() != null && hashinator(focusRecord.getName()) != hashinator(newPerson.getFullName())) {
				focusRecord.getNext();
			}
			if (focusRecord.getPerson().getFullName().equals(newPerson.getFullName())) {
				System.out.println("Added " + newPerson.getFullName() + " to the directory.");
				focusRecord.setValue(newPerson);
			} else {
				System.out.println("Added " + newPerson.getFullName() + " to the directory.");
				focusRecord.setNext(new hashRecord(newPerson));
			}
			
		}
	}

	private class hashRecord {
		private String name;
		private Person person;
		private hashRecord next;
		
		hashRecord(Person person) {
			this.name = person.getFullName();
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
		
		String getName() {
			return name;
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
