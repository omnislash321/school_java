/*
 *		Name: Xu, Roberto
 *		Homework: #4
 *		Due: 11/9/12
 *		Course: CS-141-01-f12
 *		Description: The take-home quiz given to us during class, due at midnight of the very same day. 
 *			A Complex object class with mutators, accessors, and several constructors and methods
 *			that include interactions with other Complex objects through the arguments of the methods.
 */

import java.io.*;
import java.util.Scanner;



public class LetterCount {
	
	public static void main (String[] args) throws FileNotFoundException{
		String filename;
		String sentences = "";
		int[] countLetters = new int [26];
		
		for (int loop = 0; loop < 26; loop ++)
			countLetters[loop] = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Xu, Roberto - CS141 Homework #4");
		
		System.out.print("Enter the file name: ");
		filename = sc.nextLine();
		
		System.out.println("");
		
		sc = new Scanner(new File(filename));
		
		while (sc.hasNextLine()){
			sentences = sc.nextLine().toLowerCase();
			
			for (int loop = 0; loop < sentences.length(); loop ++){
				int ascii = (int)sentences.charAt(loop);
				
				if (ascii <= 122 && ascii >= 97)
					countLetters[ascii - 97] ++;
			}
			
		}
		
		PrintWriter output = new PrintWriter("LettersCount.txt");
		output.println("Xu, Roberto - CS141 Homework #4");
		output.println("Enter the file name: " + filename);
		output.println("");
		
		for (int loop = 0; loop < countLetters.length; loop ++){
			char character = (char) (loop+97);
			
			output.println(character + ": " + countLetters[loop]);
		}
		
		output.close();
		sc.close();
		
		
	}

}
