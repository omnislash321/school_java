//-----------------------------------------------------------------------------
// Name: Roberto Hong Xu Kuang
// Project: 3
// Date: 11/17/2014
//-----------------------------------------------------------------------------
// Class InsertionSort - Will sort the array using the Insertion Sort.
// CHecking each individual element, it will find it's rightful position
// and then swap the elements. Efficiency: O(n^2).
public class InsertionSort implements SortAlgorithm{

//-----------------------------------------------------------------------------
// void sort(double array a, SortTimer t) - Will sort the array accordingly.
	public void sort(double[] a, SortTimer t){
		//Looping the first time.
		for (int loop = 1; loop < a.length; loop++){
			//This is done so the value can be used outside the for-loop.
			int loop2;

			//Second for loop, to compare the element to every other.
			for (loop2 = loop-1; loop2 >= 0; loop2--){
				//Adds a comparison since it is checked to enter loop.
				t.addComparison();
				
				//Adds a comparison to compare each element.
				t.addComparison();
				if(a[loop] < a[loop2]){
					//If the current value is smaller, shift elements right.
					t.addMove();
					a[loop2+1] = a[loop2];	
				}else //Break the loop to ensure that loop2 stops correctly.
					break;
			}	
			
			t.addMove();
			//Put the value in the right place.
			a[loop2 + 1] = a[loop];
		}	
	}
}
