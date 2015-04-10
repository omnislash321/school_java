//-----------------------------------------------------------------------------
// Name: Roberto Hong Xu Kuang
// Project: 3
// Date: 11/17/2014
//-----------------------------------------------------------------------------
// Class QuickSort - Will sort the array using the Quick Sort.
// This quick sort will use a random pivot point in order to start the sorting.
// First, it will get the pivot, then partition the array into two parts,
// with one side being less than the pivot, and the other side greater, then
// using recursion, it will sort the small arrays. Efficiency : n log_2 n.

//Random is used to select the pivot point.
import java.util.Random;

public class QuickSort implements SortAlgorithm{
	
//-----------------------------------------------------------------------------
// void sort(double array a, SortTimer t) - Starts the quick sorting.
	public void sort(double[] a, SortTimer t){
		quickSort(0, a.length-1, a, t);
	}
	
//-----------------------------------------------------------------------------
// void quickSort (integer left, integer right, double array a, SortTimer t) -
// This is the recursively called method that will sort the array using a 
// random pivot.
	public void quickSort(int left, int right, double[] a, SortTimer t){
		//Base case checking.
		t.addComparison();
		if(left < right){
			//New random object created.
			Random r = new Random();
			
			//Getting a new random integer within the ranges.
			t.addMove();
			int pivot = r.nextInt(right - left + 1) + left;
			
			//Partition will return the new position of the pivot.
			t.addMove();
			int pos = partition(left, right, pivot, a, t);
			
			//Recursively call the left and right arrays.
			quickSort(left, pos-1, a, t);
			quickSort(pos+1, right, a, t);
		}
	}
	
//-----------------------------------------------------------------------------
// int partition(integer left, integer right, integer pivot, double array a, 
// 		SortTimer t) - This will return the new position of the pivot, after 
// everything has been sorted accordingly, with everything smaller on the left
// and everything bigger on the right.
	public int partition(int left, int right, int pivot, double[] a, SortTimer t){
		//First, this will be used to compare the values.
		t.addMove();
		double value = a[pivot];
		
		//Then, move away the pivot to the very right.
		swap(pivot, right, a, t);
		
		//Start the checking from the left.
		t.addMove();
		int pos = left;
		
		//Go through the array.
		for(int loop = left; loop < right; loop++){
			//If the value of the element is smaller than the pivot, swap them.
			t.addComparison();
			if(a[loop] <= value){
				swap(loop,pos, a, t);
				//Then, increment the pos to the next element.
				pos ++;
			}
		}
		t.addComparison();
		
		//At the very end, pos is the most left element that's greater than the pivot.
		// So, swap the pos and the pivot.
		swap(right, pos, a, t);
		
		//Return the new position of the pivot.
		return pos;
	}

//-----------------------------------------------------------------------------
// void swap(integer x, integer y, double array a, SortTimer t) - Will swap
// the two indexes in the array.
	public void swap(int x, int y, double[] a, SortTimer t){
		double temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		
		//Takes 3 moves.
		t.addMoves(3);
	}	
}
