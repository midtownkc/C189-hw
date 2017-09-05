
public class TestCase {
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
//		Test Case13: Delete John Doe
		// NEED TO ADD DELETION FUNCTION
		//phoneTree.delete("John", "Doe");
		
//		Test Case14: Insert Test Case 555-235-1121 Test_Case@testcase.com
//		Test Case15: Insert Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru
//		Test Case16: Insert Jo Wu 555-235-1123 wu@h.com
//		Test Case17: Insert Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us
//		Test Case18: Insert Bob vanDyke 555-235-1125 vandyke@nodomain.com
//		Test Case19: Insert Upside Down 555-235-1126 upsidedown@rightsideup.com
//		Test Case20: Lookup Jack Jones
//		Test Case21: Lookup Nadezhda Kanachekhovskaya
//		Test Case22: Delete Jill Jones
//		Test Case23: Delete John Doe
//		Test Case24: Lookup Jill Jones (What should happen if the “lookup” message doesn’t find the entry?)
//		Test Case25: Lookup John Doe
//		
		
		
		phoneTree.search("MAXwell", "FREDerickson");
		phoneTree.insert("Maxwell", "Frederickson", "jeebus@god.god", "223");
		phoneTree.insert("Jesus", "Jones", "jimbo@jimmy.us", "224");
		phoneTree.search("Maxwell", "frederickson");
		phoneTree.search("Jesus", "jones");
	}

}
