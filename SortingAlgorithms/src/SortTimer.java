//-----------------------------------------------------------------------------
// Name: Roberto Hong Xu Kuang
// Project: 3
// Date: 11/17/2014
//-----------------------------------------------------------------------------
// Public Class SortTimer - The class that will keep track of all the moves, 
// comparisons, and time elapsed during the sorting.
//-----------------------------------------------------------------------------
public class SortTimer{
	
	//Private variables for the timer.
	private long comparisons, move, time;

//-----------------------------------------------------------------------------
// void reset () - Will reset everything to 0, and then set the time to the 
// current time of the system.
	void reset(){
		comparisons = 0;
		move = 0;
		time = System.nanoTime();
	}

//-----------------------------------------------------------------------------
// void addComparison() - Adds one comparison to the counter.	
	void addComparison(){
		comparisons++;
	}
//-----------------------------------------------------------------------------
// void addComparisons(integer n) - Will add n comparisons to the counter.
	void addComparisons(int n){
		comparisons += n;
	}

//-----------------------------------------------------------------------------
// void addMove() - Will add one move to the counter.	
	void addMove(){
		move++;
	}

//-----------------------------------------------------------------------------
// void addMoves(integer n) - Will add n moves to the counter.	
	void addMoves(int n){
		move += n;
	}

//-----------------------------------------------------------------------------
// long getComparisons() - returns the total comparisons.
	long getComparisons(){
		return comparisons;
	}
//-----------------------------------------------------------------------------
// long getMoves() - returns the total moves.
	long getMoves(){
		return move;
	}

//-----------------------------------------------------------------------------
// long getElapsedTime() - returns current time - elapsed time.
	long getElapsedTime(){
		return (System.nanoTime() - time)/1000;
	}	
}
