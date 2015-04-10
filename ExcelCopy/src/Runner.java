
public class Runner {
	
	public static void main(String[] args) {
		Spreadsheet s1 = new Spreadsheet(3, 4);
		s1.set("A1", "1");
		s1.set(1, 0, "2");
		s1.set("A3", "3");
		s1.set("B1", "2");
		s1.set("C1", "3");
		s1.set("D3", "cs240");
		s1.print(); // provide a simple output of the entire spreadsheet
		System.out.println(s1.get("D3").equals(s1.get(2, 3)));
	}

}
