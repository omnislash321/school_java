//
// Name: Xu Kuang, Roberto Hong
// Project: #1
// Due: 2/3/14
// Course: cs-240-02-w14
//
// Description:
// This class will encrypt and decrypt a String using the Caesar Cipher method.
// It takes a letter and shifts the letter in accordance to the order of the alphabet.
// Also contains a print out method for the results in the string.
// Can also be used with command-line arguments in this order:
// CaesarCipher [int]
// CaesarCipher [int] [string]


import java.util.Scanner;

public class CaesarCipher {
	int shift; //The number to shift characters.
	//This is an array of the alphabet.
	char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Used to hold the shift number and code to be encrypted.
		int move;
		String code;
		
		//If user enters both shift and code in the command line.
		if (args.length >= 2){
			move = Integer.parseInt(args[0]);
			//This is used in case there is more than 1 word to be encrypted.
			code = "";
			for (int loop = 1; loop < args.length; loop++)
				code = code + args[loop] + " ";
		}
		//If user enters only shift in the command line.
		else if (args.length == 1){ 
			move = Integer.parseInt(args[0]);
			
			System.out.println("Enter plain text: ");
			code = sc.nextLine();
		}
		//If user enters nothing in command line.
		else {
			System.out.println("Enter shift: ");
			move = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter plain text: ");
			code = sc.nextLine();
		}
		
		//Creates a new CaesarCipher class using move as shift.
		CaesarCipher cc = new CaesarCipher(move);
		System.out.println("From: "); 
		System.out.println(code);  //Prints out what was entered.
		cc.printLetterCounts(code); // Prints out how many letters.
		System.out.println("To:"); 
		System.out.println(cc.encrypt(code)); //Prints out encrypted word.
		cc.printLetterCounts(cc.encrypt(code));  //Prints out encrypted letter count.
		
	}
	
	//Constructor
	public CaesarCipher(int shift){
		this.shift = shift;
	}
	
	//Will encrypt a string by shifting over the letters.
	public String encrypt(String plaintext){
		//Creating char arrays. One of the string, and one that will be the encrypted string.
		char[] cText = plaintext.toCharArray();
		char[] tText = new char [cText.length];
		
		//A giant loop to go through the entire array of chars.
		for (int loop = 0; loop < cText.length; loop++){
			if (cText[loop] == ' ') //In case of spaces.
				tText[loop] = ' ';
			else{
				//loc = index of the char in alphabet[];
				int loc = 0;
				//newLoc = index of char shifted in alphabet[];
				int newLoc = 0;
				
				//This will check the char through every single letter in alphabet[];
				for (int loop2 = 0; loop2 < alphabet.length; loop2++){
					if (cText[loop] == alphabet[loop2])
						loc = loop2;
				}
				
				newLoc = loc + shift;
				
				//This will make sure there are no out of bounds.
				if (newLoc >= 26)
					newLoc = 0 + (newLoc-26);
				else if (newLoc <= 0)
					newLoc = 26 + (newLoc);
				//Adds to the encrypted char array.
				tText[loop] = alphabet[newLoc];		
			}
		}		
		return new String(tText);
	}
	
	//This is for decrypting the string.
	public String decrypt(String cipherText){
		//Creates a new CaesarCipher, but shift is the negative/positive opposite.
		CaesarCipher temp = new CaesarCipher(0-shift);
		//Simply returns the encrypt method of the new object.
		return temp.encrypt(cipherText);
	}
	
	//Prints out the counts of each letter in the string.
	public void printLetterCounts(String text){
		char[] temp = text.toCharArray();
		int[] charCount = new int[26];
		
		//Will run through the entire array of chars.
		for (int loop = 0; loop < temp.length; loop++){
			
			//Will check the char with every single letter in alphabet[].
			for (int loop2 = 0; loop2 < alphabet.length; loop2++){
				if (temp[loop] == alphabet[loop2])
					charCount[loop2] ++; //Increases the number in the int array.
			}
		}
		
		//Prints out the results, excluding everything that's 0.
		for (int loop3 = 0; loop3 < alphabet.length; loop3++){
			if (charCount[loop3] != 0)
				System.out.println(alphabet[loop3] + ": " + charCount[loop3]);
		}
	}

}
