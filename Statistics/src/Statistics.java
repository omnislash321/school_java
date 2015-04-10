/*
 *		Name: Xu, Roberto
 *		Homework: #2
 *		Due: 10/19/2012
 *		Course: CS-141-01-f12
 *		Description:
 *			Implementing the getStandardDeviation and printHistogramLandscape methods into the
 *   		Statistics.java provided from the online website.
 *   		The getStandardDeviation will find the standard deviation of the array of numbers, while
 *   		the Histogram method will print out a histogram that is formatted horizontally.
 */

import java.util.Random;

public class Statistics {
    
    private int[] numberArray;
    private final int MAX_VALUE = 100;
    
    public Statistics (int n) {
        numberArray = new int[n];
    }
    
    public void randomInitalize (int seed) {
        Random rand = new Random();
        
        if (seed != 0)
            rand.setSeed(seed);
        for (int i = 0; i < numberArray.length; i++)
            numberArray[i] = rand.nextInt(MAX_VALUE + 1);

    }
    
    public int getMaximum () {
        int max = numberArray[0];
        for (int i = 1; i < numberArray.length; i++)
           if (numberArray[i] > max)
               max = numberArray[i];
        
        return max;
    }
        
    public int getMinimum () {
        int min = numberArray[0];
        for (int num : numberArray)
           if (num < min)
               min = num;
        
        return min;
    }
    
        
    public double getAverage () {
        
        int sum = 0;
        for (int num : numberArray)
           sum += num;
        
        return (double)sum / numberArray.length;
    }

    // Will find the standard deviation of the global numberArrays
    public double getStandardDeviation () {
        double mean = getAverage();
        double total = 0;
        
        for(double x : numberArray){
        	double temp = x - mean;
        	total = total + Math.pow(temp,2);
        }
           
        return (total/numberArray.length);
    }

    
    public void print (int perline) {
        int itemCount = 0;
        for (int num : numberArray) {
            System.out.printf("%6d", num);
            if (++itemCount % perline == 0)
                System.out.println();
        }
        if (itemCount % perline != 0)
            System.out.println();
    }
    
    public void printPseudoHistogram () {
        int[] modeArray = new int[MAX_VALUE + 1];
        
        for (int num : numberArray)
            modeArray[num]++;
        for (int i = 0; i < modeArray.length; i++) {
            if (modeArray[i] > 0) {
                System.out.printf("%4d: ", i);
                for (int j = 0; j < modeArray[i]; j++)
                    System.out.printf("*");
                System.out.println();
            }
        }
    }
    
    //Will print out the histogram.
    public void printHistogramLandscape () {
    	int[] organizedNums = new int[MAX_VALUE +1];
    	int maxAmt = 0;
    	
    	for (int x : numberArray)
    		organizedNums[x]++;
    	
    	for (int i = 1; i < organizedNums.length; i++)
            if (organizedNums[i] > maxAmt)
                maxAmt = organizedNums[i];
    	
    	for(int j = maxAmt; j >= 1; j--){
    		for(int x : organizedNums){
    			if (x >= j)
    				System.out.print("*");
    			else
    				System.out.print(" ");
    		}
    		System.out.println("");
    	}
   
    	
    	//These for-loops are for displaying the bottom part of the histogram.
    	//I decided to use for-loops instead of just typing it out normally.
    	
    	for (int loop = 0; loop <= 9; loop++){
    		for (int loop2 = 0; loop2 <= 9; loop2++){
    			if (loop2 != 0)
    				System.out.print("-");
    			else
    				System.out.print("+");
    		}
    	}
    	
    	System.out.println("+");
    	
    	for (int loop = 0; loop <= 10; loop++){
    		for (int loop2 = 0; loop2 < 10; loop2++){
    			if(loop2 != 0)
    				System.out.print(" ");
    			else 
    				System.out.print(loop);
    		}
    	}
    	
    	System.out.println("");
    	
    	for (int loop = 0; loop <= 9; loop++){
    		for (int loop2 = 0; loop2 <= 9; loop2++){
    			System.out.print(loop2);
    		}
    	}
    	System.out.println("0");
    	
    }

	public static void main (String[] args) {

        Statistics stats = new Statistics(250);     
        
        stats.randomInitalize(100);
        
        System.out.println("\nXu, Roberto - CS141 Homework #2\n");
        
        
        stats.print(10);
        
        System.out.println("Maximum = " + stats.getMaximum());
        System.out.println("Minimum = " + stats.getMinimum());
        System.out.printf("Average = %.2f\n", stats.getAverage());
        stats.printHistogramLandscape();        
	}
}