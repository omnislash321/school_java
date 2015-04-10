/*
 *		Name: Xu, Roberto
 *		Project: #1
 *		Due: 10/19/2012
 *		Course: CS-141-01-f12
 *		Description: This is the optional extra credit for the project.
 *			Using user input instead of text files, it will report the bank account of a person.
 *			This will ask the user for initial balance, and then deposits and withdrawals,
 *			and then it will report the total account info.
 */

import java.util.Scanner;

public class MyBank2 {
	private static SavingsAccount bank;
	private static double totalDeposits = 0;
	private static double totalWithdraws = 0;
	private static int countDeposits = 0;
	private static int countWithdraws = 0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWelcome to jBank version 0.2");
		System.out.println("Copyright (C) Roberto Xu 2012. All rights reserved\n");
		
		System.out.println("Please enter initial Balance: ");
		double temp = sc.nextDouble();
		bank = new SavingsAccount(temp);
		
		report();
		System.out.println("");
	}
	
	public static void report()
	{
		double temp = bank.getBalance();
		
		depositAll();
		withdrawAll();
		
		System.out.printf("Initial Balance = %1$.2f\n", temp);		
		System.out.printf("Total Deposits  = %1$.2f (%2$1d)\n", totalDeposits, countDeposits);
		System.out.printf("Total Withdraws  = %1$.2f (%2$1d)\n", totalWithdraws, countWithdraws);
		System.out.printf("Interest = %1$.3f\n", bank.getInterest());
		System.out.println("-----------------------");
		bank.addInterest();
		System.out.printf("BALANCE = %1$.2f\n", bank.getBalance());
	}
	
	public static void depositAll(){
		double deposit = 0;
        Scanner sc = new Scanner(System.in);

        do{
        	System.out.println("Please enter amount to deposit(0 to end): ");
            deposit = sc.nextDouble();
        	
            if(deposit == 0)
            	break;
            
            countDeposits ++;
        	bank.deposit(deposit);
        	totalDeposits = totalDeposits + deposit;
        }while(deposit != 0);
	}
	
	public static void withdrawAll(){
		double withdraw = 0;
        Scanner sc = new Scanner(System.in);

        do{
        	System.out.println("Please enter amount to withdraw(0 to end): ");
            withdraw = sc.nextDouble();
        	
            if(withdraw == 0)
            	break;
            
            countWithdraws ++;
        	bank.deposit(withdraw);
        	totalWithdraws = totalWithdraws + withdraw;
        }while(withdraw != 0);
	}

}
