//
// Name: Xu Kuang, Roberto Hong
// Homework: #1
// Due: 1/31/14
// Course: cs-240-02-w14
//
// Description:
// Creating a Spreadsheet ADT in the form of a 2d array, up to a size of 40 rows and 26 columns.
//  Will have accessor and mutator methods, along with a formatted print method.
// Also has convert methods to find out the correct row and column from a String.
// Rows are labeled with numbers, and Columns with letters.

public class Spreadsheet {
	private String [][] excel;
	
	//Default constructor of 40 rows and 26 columns.
	public Spreadsheet(){
		excel = new String[40][26];
	}
	
	//Allows to set up a specific size of Spreadsheet.
	public Spreadsheet(int r, int c){
		excel = new String[r][c];
	}
	
	//Will take a String and find the Row, which is all the numbers after the first char.
	public int convertR(String s){
		return Integer.parseInt(s.substring(1)) - 1;
	}
	
	//The column number is the letter in the String, which is the first char.
	public int convertC(String s){
		String x = s.substring(0,1).toUpperCase();  //Ensures that it will be upper case.
		
		return x.charAt(0) - 'A'; // Subtracts 'A' so that A is index 0;
	}
	
	//This set method is used if there's a row and column given.
	public void set(int r, int c, String input){
		excel[r][c] = input;		
	}
	
	//This set method is used if location is given in a String.
	public void set(String loc, String input){
		int r = this.convertR(loc);
		int c = this.convertC(loc);
		
	   this.set(r,c,input); //Calls the other set method.
	}
	
	//Returns the String at the row and column given.
	public String get(int r, int c){
		return excel[r][c];
	}
	
	//Returns the String if location is given in a String.
	public String get(String loc){
		int r = this.convertR(loc);
		int c = this.convertC(loc);
		
		return this.get(r,c); //Calls the other get method.
	}
	
	//Prints out in semi-formatted way.
	//Uses 'x' instead of null to be printed out.
	public void print(){
		//First for-loop for the rows.
		for (int x = 0; x < excel.length; x ++){
			//Second for-loop for the columns.
			for (int y = 0; y < excel[0].length; y++){
				if (excel[x][y] == null) //Checks if it's empty. 
					System.out.print("x "); //If it is, print out an x.
				else  //IF not, print out the String, and put a space as gap.
					System.out.print(excel[x][y] + " ");
			}
			//Jumps to the next line/row.
			System.out.println();
		}
	}

}
