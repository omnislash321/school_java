//
// Name: Xu Kuang, Roberto Hong
// Homework:#3
// Due: 2/17/14
// Course: cs-240-02-w14
//
// Description: Implementing the DoublyLinkedList.java that was given, we had to add a listSort() method.
// The listSort method is a selection sort, where it would be a class instance method of the DLL.
// The listSort will go through the DoublyLinkedList and look for the biggest value,
// Then it will insert that Node into the head of another DLL. Then it will return the sorted DLL.


//Copied from the source java.
public class DoublyLinkedList {

    protected DNode head;
    protected DNode tail;
    protected int size;

    //Default Constructor with no parameters.
    public DoublyLinkedList() {
        size = 0;
        head = new DNode(0);
        tail = new DNode(0);
        tail.setPrevious(head);
        head.setNext(tail);
    }

    //Returns true if size is zero.
    public boolean isEmpty() {
        return size == 0;
    }

    //Inserts a node at the beginning of the DLL.
    public void insertBeginning(DNode node) {
        node.setNext(head.getNext());
        node.setPrevious(head);
        head.getNext().setPrevious(node);
        head.setNext(node);
        ++size;
    }

    //Inserts a node at the end of the DLL.
    public void insertEnd(DNode node) {
        node.setPrevious(tail.getPrevious());
        node.setNext(tail);
        tail.getPrevious().setNext(node);
        tail.setPrevious(node);
        ++size;
    }

    //Was empty in the source.java.
    public void insertAfter(String value, DNode node) {
    	 //Was empty in the source.java.
    }
    //Was empty in the source.java.
    public void insertBefore(DNode node, String value) {
    	 //Was empty in the source.java.	
    }
    
    //Will get the Previous Node.
    public DNode getPrevious (DNode v) throws IllegalArgumentException {
        if (v == tail)
            throw  new IllegalArgumentException("cannot not remove past head");
        return v.getPrevious();
    }
    
    //Will get the Next Node.
    public DNode getNext (DNode v)  throws IllegalArgumentException {
        if (v == tail)
            throw  new IllegalArgumentException("cannot not remove past tail");
        return v.getNext();
    }
    
    //Removes a Node from the DLL.
    public void remove (DNode v) {
        DNode u = getPrevious(v);
        DNode w = getNext(v);
        w.setPrevious(u);
        u.setNext(w);
        v.setPrevious(null);
        v.setNext(null);
        --size;
    }
    
    
    //listSort() method
    // Will return a DLL that is the original, but sorted.
    public DoublyLinkedList listSort(){
    	//Creating the new DLL.
    	DoublyLinkedList dll = new DoublyLinkedList();
    	
    	//Will run as long as the original DLL isn't empty.
    	while (!isEmpty()){
    		//Temp is a cursor.
    		DNode temp = this.head;
    		//Bigger is the biggest value of node.
    		DNode bigger = temp;
    		
    		//A for loop to go through the entire DLL.
    		for(int loop = 0; loop < this.size; loop++){
    			//Will move the cursor.
    			temp = temp.getNext();
    			
    			//If bigger is lower in value of the cursor
    			if (bigger.getValue() <= temp.getValue())
    				//the cursor will become the new bigger
    				bigger = temp;
    		}

    		//Removes bigger from the DLL,
    		this.remove(bigger);
    		//Then adds it to the new DLL from the head.
    		dll.insertBeginning(bigger);
    	}
    	
    	//Returns the new DLL that is sorted.
    	return dll;
    }

 //The rest is code that was copied from the original source java
    public String toString() {
        String s = "[";
        DNode trav = head.getNext();
        while (trav != tail) {
            s += trav.getValue();
            trav = trav.getNext();
            if (trav != tail) {
                s += ",";
            }
        }

        return s + "]";
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        int[] listofInts = {10, 34, 55, 5, 10, 20, 45, 99, 0};

        for (int n : listofInts) {
            dll.insertBeginning(new DNode(n));
        }

        System.out.println(dll);

        dll = dll.listSort();

        System.out.println(dll);
    }

}

class DNode {

    protected int value;
    protected DNode next;
    protected DNode prev;

    public DNode(int value) {
        this.value = value;
        this.next = this.prev = null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public void setPrevious(DNode prev) {
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrevious() {
        return prev;
    }

}