
public class TestCase {
	public static void main(String args[]) {
		DictionaryTree newTree = new DictionaryTree();
		
		newTree.insert("Maxwell", "Frederickson", "Maxfred@me.com", "816-665-0678");
		
		newTree.search("MAXwell", "FREDerickson");
	}

}
