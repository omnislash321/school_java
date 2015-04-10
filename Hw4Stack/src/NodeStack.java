//
// Name: Xu Kuang, Roberto Hong
// Homework:#4
// Due: 2/28/14
// Course: cs-240-02-w14
//
// Description: Implementing the Stack interface and using a Node class, NodeStack is a
// Singly Linked List of Nodes, which contain Object nodes. Contains the methods for
// size, isEmpty, top, push, and pop. The head is always the last element added, 
// So it will also be the first one removed.


public class NodeStack implements Stack{
	//Since this is a Singly Linked List, we have a head node.
	private Node head;
	private int size;
	
	//Default Constructor
	public NodeStack(){
		size = 0;
		head = null;
	}

	//Returns size.
	public int size() {
		return size;
	}

	//Will return true if it's empty, false if it's not.
	public boolean isEmpty() {
		return (size==0);	
	}

	//This throws an exception if we try to look at an empty stack. Else, it will show you the top element.
	public Object top() {
		if(isEmpty())
			throw new RuntimeException("Stack empty");
		
		return head.getElement();
	}

	//Will add an element to the stack. Head will be the top of the stack.
	public void push(Object element) {
		Node temp = new Node(element,null);
		
		//If it's empty, then the element will be the head.
		if(isEmpty()){
			head = temp;
		}
		else{
		//Sets temp to point to the head
			temp.setNext(head);
		//Then the element becomes the new head.
			head = temp;
		}
		//Increases size.
		size++;
	}

	//Will remove the last element, and return it.
	public Object pop() {
		//Makes sure it's not an empty stack.
		if(isEmpty())
			throw new RuntimeException("Stack empty");
		
		//Temp will be the one returned.
		Node temp = head;
		
		//Moves head to the next element.
		head = head.getNext();
		//Makes sure temp points to nothing.
		temp.setNext(null);
		
		//Decreases size.
		size --;
		
		//Returns the element from temp.
		return temp.getElement();
	}
	
	public static void main(String[] args) {
		NodeStack ns = new NodeStack();
		
		ns.push("A");					// {A}
		ns.push(1);						// {1, A}

		System.out.println(ns.pop());	// {A}
		System.out.println(ns.pop());	// { }
		
		
		ns.push("B");
		
		System.out.println(ns.top());	//{B}
	}
}
