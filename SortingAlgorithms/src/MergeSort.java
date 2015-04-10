//-----------------------------------------------------------------------------
// Name: Roberto Hong Xu Kuang
// Project: 3
// Date: 11/17/2014
//-----------------------------------------------------------------------------
// Class MergeSort - Will sort the array according to the Merge Sort algorithm.
// The merge sort will recursively split itself down to arrays of size 2 or 1.
// Then, it will put the left as smaller and the right as bigger, and then 
// merge the two arrays together, recursively doing so. Efficiency: n log_2 n
public class MergeSort implements SortAlgorithm{

//-----------------------------------------------------------------------------
// void sort(double array a, SortTimer t) - The merge sort.
	public void sort(double[] a, SortTimer t){
		//This temp will be used to help hold the new sorted arrays before
		// being copied to the original array.
		double[]temp = new double[a.length];
		
		//Call the merge sort.
		mergeSort(0, a.length-1, a, temp, t);
	}
//-----------------------------------------------------------------------------
// void mergeSort(integer left, integer right, double array a, double array
//		temp, SortTimer t) - This will use left and right as the boundaries of
// the array, and then recursively call itself.
	public void mergeSort(int left, int right, double[] a, double[] temp, SortTimer t){
		//Since we check that left is always smaller than right, also a base-case, 
		// we add a comparison.
		t.addComparison();
		if(left < right){
			//Recursively call itself, splitting itself into two separate arrays.
			// (left+right)/2 = middle index. 
			//To save a move, I decided not to use a variable.
			mergeSort(left, (left + right)/2, a, temp, t);
			mergeSort( ((left + right)/2)+1, right, a, temp, t);
			
			//Call the merge method, which will merge the two arrays together.
			merge(left, ((left + right)/2)+1, right, a, temp, t);
		}
	}

//-----------------------------------------------------------------------------
// void merge (integer left, integer right, integer endRight, double array a,
//		double array temp, SortTimer t) - left and right are the two heads of 
// the two arrays. endRight and endLeft are the ends of those two arrays.
	public void merge(int left, int right, int endRight, double[] a, double[] temp, SortTimer t){
		//First, I initialize some variables.
		t.addMoves(3);
		int endLeft = right-1; // The end of the left array.
		int index = left; //Iterator.
		int bound = endRight - left + 1; // The size of the initial array together
		
		//Checks for both arrays.
		t.addComparisons(2);
		while(left <= endLeft && right <= endRight){
			
			//Check which element is smaller, then move it into new array.
			//If equal, move both into the new array.
			t.addComparison();
			t.addMove();
			if(a[left] < a[right])
				temp[index++] = a[left++];
			else if(a[left] > a[right])
				temp[index++] = a[right++];
			else{
				t.addMove();
				temp[index++] = a[left++];
				temp[index++] = a[right++];
			}
		}
		
		//At this point, only one of the two arrays are remaining.
		t.addComparison();
		//For the left array,
		if(left <= endLeft){
			//This will put the rest of the left array into the new array.
			while(left <= endLeft){
				t.addComparison();
				t.addMove();
				temp[index++] = a[left++];
			}
			t.addComparison();
		}
		else{
			//The right element.
			while(right <= endRight){
				t.addMove();
				temp[index++] = a[right++];
			}
			t.addComparison();
		}
		
		//Returning the sorted array into the original array.
		for(int loop = 0; loop < bound; loop++, endRight --){
			t.addComparison();
			t.addMove();
			a[endRight] = temp[endRight];
		}
		t.addComparison();
	} 	
}
