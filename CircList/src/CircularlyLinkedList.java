//
// Name: Xu Kuang, Roberto Hong
// Homework:#2
// Due: 2/10/14
// Course: cs-240-02-w14
//
// Description: A Circularly Linked List is a list of nodes that has no head or tail. There is only a cursor.
//   There are three methods. One is an add method, which will add a new Node after the cursor.
//	 The remove method will remove the node that is after the cursor.
//	 The last method is the advance method, which will move the cursor to the next node.

public class CircularlyLinkedList {
	private Node cursor;
	
	//default constructor
	public CircularlyLinkedList(){
		cursor = null;	
	}
	
	//The add method.
	public void add(Node v){
		//Checks if the list is empty. If it is,
		if (cursor == null){
			cursor = v; //then v will be the new cursor. 
		} 
		//If the list isn't empty, then v's next Node is whatever the cursor's next node is.
		// Note: If cursor is the only node, cursor.getNext() will simply return cursor itself.
		else{
			v.setNext(cursor.getNext());
		}
		
		//This will set cursor's next Node.
		// Note: If cursor is the only node, this is what will make cursor.getNext() return itself.
		// Because v and cursor is the same if there's only one node.
		cursor.setNext(v);
	}
	
	//The remove method, which also returns the node that was removed.
	public Node remove(){
		
		//This is to make sure remove() isn't being used in an empty list.
		if (cursor == null)
			return null;
		
		//Creating a temporary Node to hold the node.
		Node temp = cursor.getNext();
		
		//If there's only one Node
		if (cursor == temp){
			cursor = null; //Cursor is set to null, turning it into an empty list.
		}
		//If there's more than one Node
		else {
			//Then cursor is set to temp's next Node.
			cursor.setNext(temp.getNext());
			//Temp's next Node is set to null.
			temp.setNext(null);
		}
		
		//Will return what was removed from the list.
		return temp;
	}
	
	//Will move the cursor.
	public void advance(){
		//If cursor isn't null, meaning it's not an empty list, then this will move the cursor.
		if (cursor != null)
			cursor = cursor.getNext();
		//Otherwise, it will do nothing.
	}
	
	//The toString method, which will print out the list.
	public String toString() {
		//Makes sure that the list isn't empty.
        if (cursor != null) {
        	//temp String to be returned.
	        String temp = cursor.getElement();
	        //An oldCursor is needed to save the position of where the Cursor is. The beginning.
        	Node oldCursor = cursor;
        	//A for-loop that will keep on running the advance() method while cursor isn't OldCursor, the beginning.
        	for (advance(); oldCursor != cursor; advance()) {
        			//Adds to the string.
            		temp += " " + cursor.getElement();
        	}
        	return temp;
        } else
        	return null;
    }
	
	//A generic Node class.
	class Node{
		private String element;
		private Node next;
		
		public Node(String element){
			this.element = element;
			this.next=null;			
		}
		public Node(String element, Node next){
			this.element = element;
			this.next = next;
		}
		
		public String getElement(){
			return element;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setElement(String element){
			this.element=element;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public String toString(){
			return "[" + element + ":" + next + "]";
	    }
	}
	
	public static void main(String[] args) {
		CircularlyLinkedList cll = new CircularlyLinkedList();
		
		//Node is a nested class, so it needs to be created using the outer class first.
		CircularlyLinkedList.Node v = cll.new Node("One");
		CircularlyLinkedList.Node w = cll.new Node("Two");
		CircularlyLinkedList.Node x = cll.new Node("Three");
		CircularlyLinkedList.Node y = cll.new Node("Four");
		CircularlyLinkedList.Node z = cll.new Node("Five");
		
											//Removing a Node from an empty list.
		System.out.println(cll.remove());
											//Adding v and w to the circularly linked list.
		cll.add(v);
		cll.add(w);
		System.out.println(cll.toString()); //Print out the list so far.
		
		System.out.println(cll.remove() + " removed"); //Print out what was removed.
		
		System.out.println(cll.toString()); //Prints out the list,
		cll.add(x); 						//Adds x,
		System.out.println(cll.toString()); //Then prints out the list again.
		
		cll.advance();						//Moves the cursor.
		cll.add(y);							//Adds Y and Z.
		cll.add(z);
		System.out.println(cll.toString()); //Prints out the list.
		
	}
}
