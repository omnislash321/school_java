/*
 *		Name: Xu, Roberto
 *		Project: #1
 *		Due: 10/19/2012
 *		Course: CS-141-01-f12
 *		Description: The SavingsAccount class that will be used by MyBank.java and MyBank2.java
 *			It contains accessor and mutator methods in order to get the private fields.
 */

public class SavingsAccount {
	private double balance;
	private final double INTEREST = 0.009;
	
	public SavingsAccount(double b){
		balance = b;
	}
	
	public void withdraw(double x){
		balance = balance - x;
	}
	
	public void deposit(double x){
		balance = balance + x;
	}
	
	public void addInterest()
	{
		balance = balance + getInterest();
	}
	
	public double getInterest(){
		double temp = INTEREST/12.0;
		return balance*temp;
	}
	
	public double getBalance(){
		return balance;
	}


}
