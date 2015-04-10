//-----------------------------------------------------------------------------
// Name: Roberto Hong Xu Kuang
// Project: 3
// Date: 11/17/2014
//-----------------------------------------------------------------------------
// Main Driver - Compare the different types of sorting algorithms by using a 
// SortTimer and counting the time, moves, and comparisons. Allows command line 
// arguments, and if not there, then the user can input it. Must use the type
// of sort, and the size of the array.
import java.util.Scanner;
import java.util.Random;

public class SortingMain{
	
	public static void main(String[] args){
		//Declaring the type of the sort, and the size.
		String sortType;
		int exponent;

		//Checking for command line arguments.
		if (args.length > 0){
			//If found, then the first argument is the type. 
			sortType = args[0];
			//Second is the size.
			exponent = Integer.parseInt(args[1]);			
		}else{
			//If there is no command line argument, create a scanner class.

			//Asking the user for values.
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter sort type: ");
			sortType = sc.next();
			System.out.println("Enter exponent: "); 
			exponent = sc.nextInt();
			
			sc.close();
		}
		
		//Creating a new SortTimer object, and declaring a Sort Algorithm.
		SortTimer t = new SortTimer();
		SortAlgorithm s;
		
		//Using  switch statement for e first char of the type.
		//Since all of these sorts implements the same interface, we are able
		// to polymorph the sorts.
		switch(sortType.charAt(0)){
			case 'h': s = new HeapSort();
						 break;
			case 'i': s = new InsertionSort();
						 break;
			case 'm': s = new MergeSort();
						 break;
			case 'q': s = new QuickSort();
						 break;
			default: s = new InsertionSort();
						break;
		}
		
		//Formatting output headers.
		System.out.printf("%8s%12s%12s%12s\n", "Size", "Moves", "Comps", "Time");
		
		//Increments of sizes of 10^i
		for(int loop = 1; loop <= exponent; loop++){
			//Declaring some total counters.
			long totalMoves, totalComparisons, totalTime;
			//Assigning them all to 0 to reset.
			totalMoves = totalComparisons = totalTime = 0;
			
			//In order to get more accurate results, we run the test 5 times.
			for(int loop2 = 0; loop2 < 5; loop2 ++){
				
				//Generating random doubles.
				double a[] = new double[ (int) Math.pow(10, loop) ];
				Random r = new Random();
				
				//Filling up the array.
				for(int loop3 = 0; loop3 < (int) Math.pow(10, loop); loop3++)
					a[loop3] = r.nextDouble();
				
				//This will reset everything in the timer.
				t.reset();
				
				//Sort the array.
				s.sort(a,t);
				//Increment all of the counters.
				totalMoves += t.getMoves();
				totalComparisons += t.getComparisons();
				totalTime = t.getElapsedTime();
				
				//Make sure that the array is sorted.
				if(!verify(a))
					System.out.println("Error! Not sorted!");
			}
			//Average the results.
			totalMoves /= 5;
			totalComparisons /= 5;
			totalTime /= 5;
			
			//Display the formatted results.
			System.out.printf("%8.0f%12d%12d%12d\n", Math.pow(10,loop), t.getMoves(), t.getComparisons(), t.getElapsedTime());
	
		}
	}
	
//-----------------------------------------------------------------------------
// boolean verify (double array) - This will verify that the array is properly
//  sorted in ascending order.
	public static boolean verify(double[] a){
		double prev = a[0];
		for (int loop = 1; loop < a.length; loop++){
			if(a[loop] < prev)
				return false;
		}
		return true;
	}
}
