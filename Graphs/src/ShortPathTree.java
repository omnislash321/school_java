//------------------------------------------------------------------------------
//  Name: Roberto Hong Xu Kuang
//  Class: CS 241
//  Project: Shortest Path Tree Graphs
//  Date: 12/01/2014
//------------------------------------------------------------------------------
// Using the graph package that is provided, this class will create a shortest
// path tree from the start to the end vertex. Since it will extend the class
// GreedyGraph, the method newCost needs to be overwritten.
import graph.*;
import java.io.IOException; // To handle file exceptions.
import java.util.Scanner; // To get input from user.
import java.util.Arrays; // To sort and output in a nice format.
import java.util.ArrayList; // To store and hold the tree path.

public class ShortPathTree extends GreedyGraph{
	
	//Constructor
	public ShortPathTree(String name) throws IOException{
		//Calls the constructor from GreedyGraph.
		super(name);
	}
	
	//--------------------------------------------------------------------------
	//double newCost(int v, int w) - Overwrites GreedyGraph's hook method. It 
	// returns the value of the current vertex added with the weight of the
	// edge connecting current to the next vertex.
	public double newCost(int v, int w){
		return costOf(v) + weightOf(getEdge(v,w));
	}
	
	//--------------------------------------------------------------------------
	//int readVertex(Scanner sc, String name) - This is a method used to get the
	// start and the end vertex from the user using the scanner.
	private int readVertex(Scanner sc, String name){
		//Ask the user, and it also shows the available options.
		System.out.println("Enter " + name + " vertex [0..." + (this.getOrder()-1) + "]:");
		//This checks to make sure it's an integer.
		while(!sc.hasNextInt()) sc.next();
		int temp = sc.nextInt();
	
		//This makes sure the value is in the correct range.
		while(temp < 0 || temp > (this.getOrder()-1)){
			//Checking to make sure it's an integer.
			while(!sc.hasNextInt()) sc.next();
			temp = sc.nextInt();
		}
		
		//Return the value from the inputs.
		return temp;
	}

	//--------------------------------------------------------------------------
	//void printAdjacency() - Printing out the list of neighbors that every
	// vertex has, and in ascending order.
	public void printAdjacency(){
		System.out.println("Adjacency list: ");
		//For every single vertex,
		for(int loop = 0; loop < this.getOrder(); loop++){
			System.out.print(loop + " >> ");
			//Use an array, and then use the built in java sort method.
			int[] neighbors = this.getNeighbors(loop);
			Arrays.sort(neighbors);
			//Then, use the built in java toString method for arrays.
			System.out.println(Arrays.toString(neighbors));
		}
	}
	
	//--------------------------------------------------------------------------
	//void printResults() - Simply prints out te order and the size of the graph
	public void printResults(){
		System.out.println("Order of graph: " + this.getOrder());
		System.out.println("Size of graph: "+ this.getSize());
	}
	
	//--------------------------------------------------------------------------
	//void createTree(int start, int end) - This method will create the SPT and
	// then report the exact path and the cost of the tree to go from the start
	// to the end vertex.
	public void createTree(int start, int end){
		
		//Using Dijkstra's method, this will calculate all the costs.
		this.greedy(start);
		
		//Use an ArrayList to store the path.
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		int temp = end;
		
		//This will start from the end of the tree, then add them to the list
		// in reverse of the tree using getParent.
		while(temp != start){
			GreedyVertex e = this.getVertex(temp);
			path.add(temp);
			temp = e.getParent();
		}
		//Add the start to the path.
		path.add(start);
		
		//Now, print out the tree, but in backwards order of the ArrayList,
		// which is actually the correct order since it was put on backwards,
		// sort of like a stack.
		System.out.print("Path of SPT: ");
		for(int loop = path.size()-1; loop >= 0; loop --){
			System.out.print(path.get(loop) + " ");
		}
		System.out.println("");
		
		//Simply print out the cost of the end vertex that was calculated
		System.out.println("Cost of SPT: " + this.getVertex(end).getCost());
	}
	
	//--------------------------------------------------------------------------
	//void main(String[] args) - The main method that will drive everything.
	public static void main(String[] args) throws IOException{
		//Declare some initial variables.
		String filename, adjacency;
		int start, end;
		
		//This is the class object.
		ShortPathTree spt;
		
		//Use a scanner to read input.
		Scanner sc = new Scanner(System.in);
		
		//Either use command-line argument or enter with input.
		if(args.length == 0){
			System.out.println("Enter file name of graph: ");
			filename = sc.next();
		}else
			filename = args[0];
	
		//Now, create a new ShortPathTree with the filename.
		spt = new ShortPathTree(filename);
		
		//Ask whether or not to print out the adjacency list.
		System.out.println("Print out adjacency list? (y/n)");
		adjacency = sc.next();
		while(!adjacency.equals("y") && !adjacency.equals("n")) adjacency = sc.next();
		
		//Now, get the start and end vertexes.
		start = spt.readVertex(sc, "start");
		end = spt.readVertex(sc, "end");
		
		//Close scanner.
		sc.close();
		
		//If print out the adjacency, call the print method.
		if(adjacency.equals("y"))
			spt.printAdjacency();
		
		//Print out the results.
		spt.printResults();
		
		//Create the short path tree using the method.
		spt.createTree(start, end);
	}
}
