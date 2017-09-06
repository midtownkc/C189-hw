
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
	
	public int hashinator(String name) {
		int hash = name.hashCode() % directory.length;
		if (hash < 0)
			hash += directory.length;
		return hash;
	}
	
	Person search(String firstName, String lastName) {
		String name = full_name(firstName, lastName);
		int hash = hashinator(name);
		if (directory[hash] == null) {
			System.out.println(name + " wasn't found in the directory.\n");
			return null;
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
	
	public void insert(String firstName, String lastName, String email, String phone) {
		Person newPerson = new Person(firstName, lastName, email, phone);
		int hash = hashinator(newPerson.getFullName());
		if (directory[hash] == null) {
			System.out.println("Added " + newPerson.getFullName() + " to the directory.");
			directory[hash] = new hashRecord(newPerson);
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
