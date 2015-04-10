//------------------------------------------------------------------------------
//  Name: Roberto Hong Xu Kuang
//  Class: CS 241
//  Project: Shortest Path Tree Graphs
//  Date: 12/01/2014
//------------------------------------------------------------------------------
// This is the GreedyVertex class. It is a greedy version of the vertex class
// and it is created by using the documentation given by the professor. It adds
// a cost and a fringe variable to Vertex.

import graph.*;

public class GreedyVertex extends Vertex implements Comparable<GreedyVertex>{
	//Two new variables that makes it a greedy vertex instead of regular.
	protected double cost;
	protected boolean fringe;
	
	//Calls the other constructor.
	public GreedyVertex(int index){
		//Using positive infinity which means it's not connected yet.
		this(index, Double.POSITIVE_INFINITY);
	}
	
	//Constructor with two parameters.
	public GreedyVertex(int index, double cost){
		//Calls the constructor of Vertex to intialize all the variables.
		super(index);
		
		//Then it initializes fringe to false and the new cost.
		fringe = false;
		this.cost = cost;
	}

	//--------------------------------------------------------------------------
	// int compareTo(GreedyVertex that) - Since we implement comparable, this
	// needs to be used. It will return -1, 0, or 1 depending on the comparison
	// of the cost. If cost is the same, then it will use the index to break the
	// tie.
	public int compareTo(GreedyVertex that){
		//If this cost is lesser than that.
		if (this.cost < that.cost) 
			return -1;
		//If this cost is the same as that cost,
		else if (this.cost == that.cost) {
			//Check the index.
			if (this.index < that.index) 
				return -1;
			else if (this.index > that.index)
				return 1;
			
			return 0;
		} 
		//Else, if this csot is greater than that cost.
		else 
			return 1;
	}
	
	//--------------------------------------------------------------------------
	// double getCost() - Returns the cost.
	public double getCost(){
		return cost;
	}
	
	//--------------------------------------------------------------------------
	// boolean isFringe() - Returns whether or not the vertex is a fringe.
	public boolean isFringe(){
		return fringe;
	}
	
	//--------------------------------------------------------------------------
	// void setCost(double cost) - Modifier method to set the cost.
	public void setCost(double cost){
		this.cost = cost;
	}
	
	//--------------------------------------------------------------------------
	// void setFringe(boolean fringe) - Modifier method to set the fringe.
	public void setFringe(boolean fringe){
		this.fringe = fringe;
	}
}
