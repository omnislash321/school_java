/*
 *		Name: Xu, Roberto
 *		Homework: #3
 *		Due: 10/21/2012
 *		Course: CS-141-01-f12
 *		Description: This assignment was to implement the methods convertString(), getMaximum(), and printValue().
 *			I used the provided .java found in web/files, and completed the missing methods.
 */

import java.util.Random;

public class Rational {
    
    private int numerator, denominator;
    
    public Rational (int numerator, int denominator) {
        assert denominator != 0 : "den is 0";
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public Rational () {
        this(0, 1);
    }
    
    public Rational (int numerator) {
        this(numerator, 1);
    }
    
    public void setRational (int numerator, int denominator) {
        assert denominator != 0;
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public double convertDouble () {
        return numerator / denominator;
    }
    
    private static void randomInitialize (Rational[] array) {
        
        Random  rand = new Random();
        
        for (int i = 0; i < array.length; i++)
            array[i].setRational(rand.nextInt(9) + 1, rand.nextInt(9) + 1);
    }
    
    public String print () {
        
        return numerator + "/" + denominator;
        
    }
    
//The completed method that was missing from the original.
    
    public String convertString (int numberOfDigits) {    	
    	String temp = "" + (numerator/denominator) + ".";
        double tempNum = numerator;
        double tempDen = denominator;
        
        double remainder = tempNum/tempDen;
        int tempRem = numerator/denominator;
        
        //This for loop will continue until it reaches the amount of digits required.
        for (int loop = 0; loop < numberOfDigits;loop++){
        	remainder = (remainder - tempRem) * 10;
    		tempRem = (int)remainder;
    		
    		
    		temp = temp + "" + tempRem;
        }
    	
        //return the value of the Rational number up to the numberOfDigits fractional digits
        return temp;
    }

    public void printValue(int numberOfDigits) {
    	Rational temp = new Rational(numerator,denominator);
    	
    	
        //print out the value of the Rational number up to the numberOfDigits fractional digits    	
    	System.out.println(temp.convertString(numberOfDigits));
    }
    
    static public Rational getMaximum (Rational[] ratArray) {
        
    	Rational maxRat = new Rational();
    	double max = 0;
    	
        for (Rational x : ratArray){
        	double temp = x.convertDouble();
        	
        	if (temp > max)
        	{	
        		max = temp;
        		maxRat = x;
        	}
        }
        
        //Returns the Rational object that has the highest value.
    	return maxRat;
	}
 
    public static void main (String[] args) {
           
        Rational[] array = new Rational[50];
        
        for (int i = 0; i < array.length; i++)
            array[i] = new Rational();
        
        Rational.randomInitialize(array);
        
        double  sum = 0;
        
        for (Rational r : array)
            sum += r.convertDouble();

        System.out.println("maximum = " + Rational.getMaximum(array).print());
        System.out.println("sum = " + sum);
        
        Rational    api = new Rational(22, 7);
        
        System.out.println(api.print());
        System.out.println(api.convertString(50));
        api.printValue(100);
        System.out.println();
	}

}