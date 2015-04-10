/*
 *		Name: Xu, Roberto
 *		Project: #3
 *		Due: 11/30/2012
 *		Course: CS-141-01-f12
 *		Description: This is the ShipDemo program that takes the file and calculates
 *			the total ships, passengers or tons, and prints it out in an orderly fashion.
 *			It uses an array of Ships, which is then polymorphed into either a 
 *			Cruise or Cargo ship.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ShipDemo {

	public static void main(String[] args) throws FileNotFoundException{
		Ship[] shipArray;
		String companyName;
		int numShips;
		int totalPass = 0;
		int totalTon = 0;
		int count = 0;
		
		Scanner sc;
		
		if (args.length != 0)
			sc = new Scanner(new File(args[0]));
		else
			sc = new Scanner(new File("myShips.txt"));
		
		companyName = sc.nextLine();
		numShips = sc.nextInt();
		
		shipArray = new Ship[numShips];
		
		do{
			
			char type = sc.next().charAt(0);
			String shipName = sc.next();
			String shipYear = sc.next();
			int capacity = sc.nextInt();
			
			if (type == 'c')
			{	
				shipArray[count] = new CruiseShip(shipName, shipYear, capacity);
				totalPass += capacity;
			}
			else if (type == 'C')
			{
				shipArray[count] = new CargoShip(shipName, shipYear, capacity);
				totalTon += capacity;
			}

			count ++;
			
		}while (sc.hasNext());
		
		sc.close();
		
		System.out.println("\nWelcome to " + companyName + " version 0.1");
		System.out.println("Copyright (C) Roberto Xu 2012. All rights reserved\n");
		
		System.out.println(String.format("%-20s %s", "Ship name", "Type"));
		System.out.println("-------------------- ---------------");
		
		
		for (int x = 0; x < numShips; x++)
			System.out.println(shipArray[x].toString());
		
		
		System.out.println("Total Ships: " + numShips);
		System.out.println("Total Passengers: " + totalPass);
		System.out.println("Total Tonnage: " + totalTon);
		
	}
}
