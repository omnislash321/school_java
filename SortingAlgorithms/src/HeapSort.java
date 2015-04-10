//-----------------------------------------------------------------------------
// Name: Roberto Hong Xu Kuang
// Project: 3
// Date: 11/17/2014
//-----------------------------------------------------------------------------
// Class HeapSort - Will sort the array using the Heap Sort.
// First, it will turn the array into a heap. Then, using the siftDown method,
// it will properly sort the heap, and then poll the array in order to get a
// final sorted array. Efficiency : n log_2 n.

public class HeapSort implements SortAlgorithm{
	
//-----------------------------------------------------------------------------
// void sort(double array a, SortTimer t) - Properly sorts the array using the
// heap sort method.
	public void sort(double[] a, SortTimer t){
		//Calls the heapify method to turn the array into a heap.
		heapify(a, t);
		
		//Creating a new array where the values will be sorted.
		double b[] = new double[a.length];
		
		//Pulls the smallest value from the heap, and then adds it to the array.
		for(int y = 0; y < a.length; y ++)
			b[y] = poll(a.length-1,a,t);
		
		//Copies the new array into the original array.
		System.arraycopy(b, 0, a, 0, a.length);

	}

//-----------------------------------------------------------------------------	
// void heapify(double array a, SortTimer t) - Will turn the array into a heap.
	public void heapify(double[] a, SortTimer t){
		//Adding a move for initializing the size variable.
		t.addMove();
		int size = a.length - 1;
		
		//A for-loop to properly turn the array into a heap, starting from the
		//Last node that has a child.
		for(int k = size/2 - 1; k >= 0; k--){
			//Adding a comparison to get into this for-loop.
			t.addComparison();

			//Sifting down the elements to make sure it's sorted.
			siftDown(k, size, a, t);
		}
		//Since the last for-loop won't reach inside, a comparison is added
		// because that last check isn't counted.
		t.addComparison();
	}

//-----------------------------------------------------------------------------
// void siftDown(int index, int last, double array a, SortTimer t) - This will
// correctly move any element down the heap because it is bigger than either
// of the children.
	public void siftDown(int index, int last, double[] a, SortTimer t){
		//Initializing b, the child to be replaced.
		t.addMove();
		int b = index;

		//If b has a child,
		while( b < last/2 ){
			//Add a comparison for checking.
			t.addComparison();
			
			//Setting the first child to be the smallest.
			t.addMove();
			int smallIndex = b*2 + 1;
			
			//Check if there is a right child.
			t.addComparison();
			if(b*2 + 2 < last){

				//Checking which child is smaller.
				t.addComparison();
				if(a[b*2 + 2] < a[b*2 + 1]){
					//Setting the right child to be the small child.
					t.addMove();
					smallIndex = b*2 + 2;
				}
			}
			
			//Checking if the parent is bigger than the child.
			t.addComparison();
			if(a[b] > a[smallIndex]){
				//Swap the child and the parent.
				double temp = a[b];
				a[b] = a[smallIndex];
				a[smallIndex] = temp;
				
				//3 moves for swapping.
				t.addMoves(3);
			}
			
			//Moving the parent index.
			t.addMove();
			b = smallIndex;
		}
		//The last comparison in the while loop.
		t.addComparison();
	}

//-----------------------------------------------------------------------------	
// double poll(integer size, double array a, SortTimer t) - This will return
// the smallest value in the heap, and also decrease the size of the heap.
	public double poll(int size, double[] a, SortTimer t){
		//First, swap the smallest and the biggest,
		double min = a[0];
		a[0] = a[size];
		t.addMoves(2);
		
		//Decrease the size to not count the last element(smallest)
		size --;
		
		//Sift down the biggest element (at 0)
		siftDown(0, size, a, t);
		
		//Return the smallest value.
		return min;
	}
}
