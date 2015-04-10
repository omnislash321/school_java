/*
 *		Name: Xu, Roberto
 *		Project: #1
 *		Due: 10/19/2012
 *		Course: CS-141-01-f12
 *		Description: This is the main part of the project. This class will create a new SavingsAccount class, and then
 *			read from text files the total withdrawals and deposits into the bank account. Then, it will report
 *			the complete info on the account.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MyBank {
	private static SavingsAccount bank = new SavingsAccount(500);
	
	public static void main(String[] args){
		System.out.println("\nWelcome to jBank version 0.1");
		System.out.println("Copyright (C) Roberto Xu 2012. All rights reserved\n");
		
		report();
		System.out.println("");
	}
	
	public static void report()
	{
		System.out.printf("Initial Balance = %1$.2f\n", bank.getBalance());
		depositAll();
		withdrawAll();
		System.out.printf("Interest = %1$.3f\n", bank.getInterest());
		System.out.println("-----------------------");
		bank.addInterest();
		System.out.printf("BALANCE = %1$.2f\n", bank.getBalance());
	}
	
	public static void depositAll(){
		try {
			int count = 0;
			double total = 0;
            Scanner sc = new Scanner(new File("Deposits.txt"));
            while (sc.hasNextDouble()) {
            	count ++;
            	double temp = sc.nextDouble();
            	bank.deposit(temp);
            	total = total + temp;
            }
            System.out.printf("Total Deposits  = %1$.2f (%2$1d)\n", total,count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public static void withdrawAll(){
		try {
			int count = 0;
			double total = 0;
            Scanner sc = new Scanner(new File("Withdraws.txt"));
            while (sc.hasNextDouble()) {
            	count ++;
            	double temp = sc.nextDouble();
            	bank.withdraw(temp);
            	total = total + temp;
            }
            System.out.printf("Total Withdraws = %1$.2f (%2$1d)\n", total,count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

}
