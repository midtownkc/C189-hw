
public class TreeTestCase {
	
	public static void main(String args[]) {
		DirectoryTree phoneTree = new DirectoryTree();
		
		phoneTree.insert("Bob", "Smith", "bsmith@somewhere.com", "555-235-1111");
		phoneTree.insert("Jane", "Williams", "jw@something.com", "555-235-1112");
		phoneTree.insert("Mohammed", "al-Salam", "mas@someplace.com", "555-235-1113");
		phoneTree.insert("Pat", "Jones", "pjones@homesweethome.com", "555-235-1114");
		phoneTree.insert("Billy", "Kidd", "billy_the_kid@nowhere.com", "555-235-1115");
		phoneTree.insert("H.", "Houdini", "houdini@noplace.com", "555-235-1116");
		phoneTree.insert("Jack", "Jones", "jjones@hill.com", "555-235-1117");
		phoneTree.insert("Jill", "Jones", "jillj@hill.com", "555-235-1118");
		phoneTree.insert("John", "Doe", "jdoe@somedomain.com", "555-235-1119");
		phoneTree.insert("Jane", "Doe", "jdoe@somedomain.com", "555-235-1120");
		
		phoneTree.search("Pat", "Jones");
		phoneTree.search("Billy", "Kidd");
		
		phoneTree.delete("John", "Doe");
		
		phoneTree.insert("Test", "Case", "Test_Case@testcase.com", "555-235-1121");
		phoneTree.insert("Nadezhda", "Kanachekhovskaya", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru", "555-235-1122"); 
		phoneTree.insert("Jo", "Wu", "wu@h.com", "555-235-1123");
		phoneTree.insert("Millard", "Fillmore", "millard@theactualwhitehouse.us", "555-235-1124");
		phoneTree.insert("Bob", "vanDyke", "vandyke@nodomain.com", "555-235-1125");
		phoneTree.insert("Upside", "Down", "upsidedown@rightsideup.com", "555-235-1126");
		 
		phoneTree.search("Jack", "Jones");
		phoneTree.search("Nadezhda", "Kanachekhovskaya");
		
		phoneTree.delete("Jill", "Jones");
		phoneTree.delete("John", "Doe");
		
		phoneTree.search("Jill", "Jones");
		phoneTree.search("John", "Doe");
	}

}
