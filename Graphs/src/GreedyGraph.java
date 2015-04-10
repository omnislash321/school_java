//------------------------------------------------------------------------------
//  Name: Roberto Hong Xu Kuang
//  Class: CS 241
//  Project: Shortest Path Tree Graphs
//  Date: 12/01/2014
//------------------------------------------------------------------------------
// This is the GreedyGraph class, rewritten from the documentation given from
// the professor. It uses the psuedocode written by the professor for the 
// greedy, addFringe, and modifyFringe methods.

import graph.*;

import java.io.IOException;

public class GreedyGraph extends Graph{
	//GreedyPriorityQueue is used to get the SPT.
	private GreedyPriorityQueue gpq;
	
	//Constructor that initializes the queue and tree from the filename given.
	public GreedyGraph(String name) throws IOException{
		gpq = new GreedyPriorityQueue();
		process_header(name);
		add_vertices();
		add_edges();
	}
	
	//--------------------------------------------------------------------------
	//void add_vertices() - Initializes the vertices array in Vertex with
	// GreedyVertices, and then fills it up with the indexes.
	protected void add_vertices(){
		vertices = new GreedyVertex[order];
		for(int loop = 0; loop < order; loop ++)
			vertices[loop] = new GreedyVertex(loop);
	}

	//--------------------------------------------------------------------------
	// double costOf(int v) - Returns the cost of the vertex.
	public double costOf(int v){
		return getVertex(v).getCost();
	}

	//--------------------------------------------------------------------------
	// GreedyVertex getVertex(int v) - Returns the GreedyVertex of the index
	public GreedyVertex getVertex(int v){
		return (GreedyVertex)vertices[v];
	}
	
	//--------------------------------------------------------------------------
	// void greedy(int u) - Using Dijkstra's method, from the professor's psuedo
	// code, this will basically go through the entire graph and make the short
	// path tree.
	public void greedy(int u){
		GreedyVertex uVertex = getVertex(u);
		//Set u's cost to zero
		uVertex.setCost(0);
		//Add u to priority queue.
		gpq.add(uVertex);
		
		//While priority queue is not empty,
		while(gpq.size() > 0){
			//Remove node from the head of queue, and mark it.
			int v = gpq.poll().getIndex();
			markVertex(v);
			
			//For every node in neighbors of v,
			for(int w : getNeighbors(v)){
				//If it's a fringe vertex,
				if(getVertex(w).isFringe()){
					//If it has a cheaper cost through v,
					if(costOf(w) > newCost(v,w))
						//Update the fringe vertex.
						modifyFringe(v,w);
				}else // If it's not a fringe vertex,
					//Create a fringe and set the cost.
					addFringe(v,w);
			}
		}
	}

	//--------------------------------------------------------------------------
	// boolean isSelected(Edge e) - Return whether or not the edge is selected.
	public boolean isSelected(Edge e){
		return getEdge(e).isSelected();
	}
	
	//--------------------------------------------------------------------------
	// double newCost(int v, int w) - This will return the cost of vertex w,
	// which is the weight of the edge along with the cost of v.
	public double newCost(int v, int w){
		return costOf(v) + weightOf(getEdge(v,w));
	}
	
	//--------------------------------------------------------------------------
	// double weightOf(Edge e) - Returns the weight of the edge e.
	public double weightOf(Edge e){
		return getEdge(e).getWeight();
	}
	
	//--------------------------------------------------------------------------
	// void addFringe(int v, int w) - This method is used to create a fringe
	// vertex, set the parent, and the cost, and then add it back to the queue.
	public void addFringe(int v, int w){
		//Select the edge.
		getEdge(v,w).setSelected(true);
	
		GreedyVertex fringe = getVertex(w);
		
		//Set it to a fringe.
		fringe.setFringe(true);
		//Set the parent of w to v.
		fringe.setParent(v);
		//Set the new cost of w.
		fringe.setCost(newCost(v,w));
		
		//Add it back to the priority queue.
		gpq.add(fringe);
	}
	
	//--------------------------------------------------------------------------
	// void modifyFringe(int v, int w) - This will modify the fringe vertex
	// and set the new parent along with the new cost. Also adds it back to the
	// priority queue.
	public void modifyFringe(int v, int w){
		//Select the edge.
		getEdge(v,w).setSelected(true);
		
		GreedyVertex fringe = getVertex(w);
		
		//Unselect the previous parent.
		getEdge(fringe.getParent(), w).setSelected(false);
		
		//Set the new parent.
		fringe.setParent(v);
		//Set then ew cost.
		fringe.setCost(newCost(v,w));
		
		//Add it back to the priority queue.
		gpq.promote(fringe);
	}

}
