//
// Name: Xu Kuang, Roberto Hong
// Project:#2
// Due: 2/26/14
// Course: cs-240-02-w14
//
// Description: Implementing the Node class, with type Object, we create a Set ADT
// that is a singly linked list with a dummy head.
// It has several functions, such as add, remove, contain, subset,
// union, intersection, complement, and isEqual. Also has a toString.


public class Set {
	private Node head;
	private int size;

	//Default Constructor
	public Set(){
		head = new Node(null,null);
		size = 0;
	}
	
	//This method will check if the Set has a certain Object.
	public boolean contain(Object x){
		
		//This is to check for an empty list.
		if(size <= 0)
			return false;
		
		//Since it's not empty, we can traverse the list.
		Node cur = head.getNext();
		
		while(cur != null){
			if(cur.getElement().equals(x))
				return true; //If there is the Object in the list, return true;
			
			cur = cur.getNext(); //Keeps traversing.
		}
		
		return false;
	}
	
	//Removes an object from the list. True if removed, False if not.
	public boolean remove(Object x){
		//This first checks if there is an Object in the list to be removed.
		if (this.contain(x)){ //If there is, it can be removed, so this will run.
			//I use a prev and a cur because we need the prev's next Node to be cur's next Node.
			Node cur = head.getNext();
			Node prev = head;
			
			//This will go until it finds the right Object.
			while(cur != null && !cur.getElement().equals(x)){
				prev = cur;
				cur = cur.getNext();
			}
			
			//Once the object is found, Prev's next Node is set to cur's Next Node
			prev.setNext(cur.getNext());
			//Then, cur's next Node is null.
			cur.setNext(null);
			//Subtracting the size;
			size --;
			//Returns true since it was removed;
			return true;
			
		}else   //If the list doesn't have the object, return false;
			return false;	
	}
	
	//Adds an object to the list. True if added, false if not added.
	public boolean addElement(Object x){
		//Checks if the object is already in the list.
		if(this.contain(x)) // If it is, then return false so there's no duplicates.
			return false;
		else{//If it doesn't have it in the list, we can run this.
			
			//Traverses the list so we can add to the end.
			Node curs = head;
			
			//Once we're at the end.
			while(curs.getNext() != null){
				curs = curs.getNext();
			}
			//Just creates a quick temp Node with the object.
			Node temp = new Node(x,null);
			
			//Sets the very last Node's nextNode to be the temp Node.
			curs.setNext(temp);	
			
			//Increases size.
			size ++;
			//returns true since we added it.
			return true;
		}		
	}
	
	//Checks if A is a subset of B in A.subsetOf(B).
	public boolean subsetOf(Set x){
		
		//If A is an empty set, it is always a subset.
		if(this.size() < 1)
			return true;
		else{ //If it's not an empty set, then we have to check.
			//Traverses the node.
			Node cur = head.getNext();
			
			while(cur != null){
				//As we're traversing. If Set B doesn't have the element,
				if(!x.contain(cur.getElement()))
					//Return false.
					return false;
				else
					//Otherwise, just keep traversing.
					cur = cur.getNext();
			}
		}
		//Return true if all of A's objects are in B.
		return true;
	}
	
	//Boolean to check for equality.
	public boolean isEqual(Set x){
		//First is size. If size isn't the same, then it's not equal.
		if(this.size() != x.size())
			return false;
		else{ //Next, it will return true or false depending on if they're subsets of each other.
			return (this.subsetOf(x) && x.subsetOf(this));
		}	
	}
	
	//Returns a Set that is the union of A and B.
	public Set union(Set x){
		Set C = new Set();
		
		//We need to get Set B's head so we can get the elements from that list.
		Node cur = head.getNext();
		Node cur2 = x.getHead().getNext();

		//This adds A's elements to C.
		while(cur != null){
			//Checks for duplicates.
			if (!C.contain(cur.getElement()))
				C.addElement(cur.getElement());
			
			cur = cur.getNext();
		}
		//This adds B's elements to C.
		while(cur2 != null){
			//Makes sure there's no duplicates.
			if (!C.contain(cur2.getElement()))
				C.addElement(cur2.getElement());
			
			cur2 = cur2.getNext();
		}

		return C;
	}
	
	//Returns a Set that is the intersection of A and B.
	public Set intersection(Set x){
		Set C = new Set();
		Node cur = head.getNext();
		
		//Traverses A's list.
		while(cur != null){
			//If X has the element also, we can add it to C.
			if (x.contain(cur.getElement()))
				C.addElement(cur.getElement());
			//Else do nothing.
			
			cur = cur.getNext();
		}

		return C;
	}
	
	//Returns a Set that is the complement of A and B.
	public Set complement(Set x){
		Set C = new Set();
		Node cur = head.getNext();
		
		while(cur != null){
			///This includes only those that aren't in B.
			if (!x.contain(cur.getElement()))
				C.addElement(cur.getElement());
			
			cur = cur.getNext();
		}

		return C;
		
	}
	
	//Returns a formatted output of the set.
	public String toString(){
		String temp = "{";
		
		Node cur = head.getNext();
		//Traverses the list.
		while(cur != null){
			//This is to check if there is only one element. 
			if(cur.equals(head.getNext()))
				temp += cur.getElement();
			else//If there is more than one elemnet, we can add a comma.
				temp += "," + cur.getElement() + "";
			
			cur = cur.getNext();
		}
		temp += "}";
		
		return temp;
	}
	
	//Accessor method for the head.
	public Node getHead(){
		return head;
	}
	//Accessor method for size;
	public int size(){
		return this.size;
	}
	
	public class Node {

	    private Object element; 
	    private Node next;


	    public Node(Object element, Node next) {
	        this.element = element;
	        this.next = next;
	    }

	    
	    public Object getElement() {
	        return element;
	    }


	    public Node getNext() {
	        return next;
	    }

	    public void setElement(Object newElement) {
	        element = newElement;
	    }


	    public void setNext(Node newNext) {
	        next = newNext;
	    }
	    
	    public String toString () {
	        return "[" + element + ":" + next + "]";
	    }
	}
	
	public static void main(String[] args) {
		//Case 1 - Equal but Distinct
		Set A = new Set();
		Set B = new Set();
		Set C = new Set();
		
		A.addElement(1);
		A.addElement(2);
		A.addElement(3);
		
		B.addElement(2);
		B.addElement(1);
		B.addElement(3);
		
		C = A.union(B);
		
		System.out.println("A:"+A);
		System.out.println("B:"+B);
		System.out.println("Subset: " + A.subsetOf(B));
		System.out.println("Union:"+C);
		C = A.intersection(B);
		System.out.println("Intersect:"+C);
		C = A.complement(B);
		System.out.println("Complement:"+C);
		
		//Case 2 - Diff Size but subset
		A = new Set();
		B = new Set();
		C = new Set();
		
		A.addElement(1);
		
		B.addElement(1);
		B.addElement(2);
		
		C = A.union(B);
		
		System.out.println("A:"+A);
		System.out.println("B:"+B);
		System.out.println("Subset: " + A.subsetOf(B));
		System.out.println("Union:"+C);
		C = A.intersection(B);
		System.out.println("Intersect:"+C);
		C = A.complement(B);
		System.out.println("Complement:"+C);
		
		//Case 3 - Non-empty, diff size, common elements.
		A = new Set();
		B = new Set();
		C = new Set();
		
		A.addElement(1);
		A.addElement(2);
		A.addElement(3);
		
		B.addElement(2);
		B.addElement(3);
		B.addElement(4);
		B.addElement(5);
		
		C = A.union(B);
		
		System.out.println("A:"+A);
		System.out.println("B:"+B);
		System.out.println("Subset: " + A.subsetOf(B));
		System.out.println("Union:"+C);
		C = A.intersection(B);
		System.out.println("Intersect:"+C);
		C = A.complement(B);
		System.out.println("Complement:"+C);
		
		//Case 4 - Non-empty, nothing in common.
		A = new Set();
		B = new Set();
		C = new Set();
		
		A.addElement(1);
		
		B.addElement(2);
		B.addElement(3);
		
		C = A.union(B);
		
		System.out.println("A:"+A);
		System.out.println("B:"+B);
		System.out.println("Subset: " + A.subsetOf(B));
		System.out.println("Union:"+C);
		C = A.intersection(B);
		System.out.println("Intersect:"+C);
		C = A.complement(B);
		System.out.println("Complement:"+C);
		
		//Case 5 - One empty, one non-empty.
		A = new Set();
		B = new Set();
		C = new Set();
		
		A.addElement(1);		
		
		C = A.union(B);
		
		System.out.println("A:"+A);
		System.out.println("B:"+B);
		System.out.println("Subset: " + A.subsetOf(B));
		System.out.println("Union:"+C);
		C = A.intersection(B);
		System.out.println("Intersect:"+C);
		C = A.complement(B);
		System.out.println("Complement:"+C);
	}

}


