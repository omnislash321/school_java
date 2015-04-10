
// LinkedList.java
//
// ICS 22 / CSE 22 Fall 2012
// Project #2: You Won't Find Me There


// The LinkedList class is a generic class that stores a singly-linked list
// of "E" objects, where "E" can be replaced by any kind of object.  As with
// the ArrayLists you've used in the past, you'll be able to specify what
// kind of object is contained within each of your LinkedLists by putting a
// particular type in angle brackets; for example:
//
//     LinkedList<ForwardingEntry> entries = new LinkedList<ForwardingEntry>();
//
// I've provided you with a skeletal version to get started.  You may find
// that you're not calling all of these methods in your program.  That's okay;
// you may find these methods useful in future projects.
import java.util.NoSuchElementException;
public class LinkedList<E>
{
	// The Node class is private, because code outside of the LinkedList class
	// ought not to be manipulating nodes.  It is static because nodes need not
	// know anything about the list that they're a part of.
	private static class Node<E>
	{
		public E data;
		public Node<E> next;
		
		public Node(E data, Node<E> next)
		{
			this.data = data;
			this.next = next;
		}
	}


	// a reference to the first node in the list (null if the list is empty)
	private Node<E> head;

	// the number of elements in the list
	private int count;

	
	// The constructor initializes this linked list to be empty.
	public LinkedList()
	{
		count = 0;
		head = null;//there are no objects in the linked list
	}


	// addToFront() adds an element to the front of this list.
	public void addToFront(E e)
	{
		head = new Node<E>(e, head);//sets a node's next = to head
		count++;//states that the total size of linked list increased by 1
	}
	
	
	// remove() removes the first object from the list that is equivalent
	// to the one passed as a parameter.  (Note that, by "equivalent," I
	// mean that you should use the equals() method to compare the objects.)
	// This method should throw a NoSuchElementException if no matching
	// element is found and removed.  To throw the exception, write this:
	//
	//     throw new NoSuchElementException();
	//
	// Notice that there is no "throws" clause in this method's signature.
	// That's because NoSuchElementException is an "unchecked" exception,
	// meaning that it can be thrown without being included in a throws
	// clause.
	public void remove(E e)
	{
		if(head == null) //if there are no objects in the linked list, exception thrown
			throw new java.util.NoSuchElementException();
		Node<E> temp = null;
		Node<E> tempAfter = head;
		//two nodes are created to substitute and compare with other nodes
		
		while(tempAfter!=null)//run this loop as long as the list isnt empty
		{					 
			if(tempAfter.data.equals(e)&&!tempAfter.equals(head))
			//checks to see if the data of tempAfter and the node in question are the same
			//also checks to see that the node in question isnt the first node				
			{
				temp.next = tempAfter.next;//sets the pointer of the previous node to a node two after to remove the middle node
				count--;//decreases count by one
				break;//breaks out of the while loop
			}
			else if(tempAfter==head&&tempAfter.data.equals(e))
			//if the data trying to be deleted is head, run the loop
			{
				tempAfter = tempAfter.next;//sets the head to the node after
				count--;//decreases count by 1
				break;//breaks out of the loop
			}
			
				temp = tempAfter;//sets temp equal to tempAfter
				tempAfter = tempAfter.next;//temp becomes the next node
			
		}
	}
	
	public void removeFirst()
	{
		head = head.next;
	}

	public E returnFirst()
	{
		return head.data;
	}

	// size() returns the number of elements in this list.
	public int size()
	{
		return count;//returns the size of the LinkedList
	}
	
	
	// clear() makes this list empty.
	public void clear()
	{
		head = null;//makes the LinkedList empty
		count = 0;//says that the LinkedList is size 0
	}
	
	
	// iterator() returns a new iterator that has not yet returned any of
	// the elements of this list.
	public Iterator iterator()
	{
		return new Iterator();
	}


	// An iterator is an object that allows access to each of the elements
	// in a collection (such as a linked list) without requiring knowledge
	// of how the collection is implemented.  In the case of our LinkedList
	// class, an iterator would allow you to write a loop that ran through
	// all of the elements in the linked list in order, without having an
	// understanding of nodes, next references, and so on.
	//
	// The Iterator class here is public, because we want code outside of
	// the LinkedList class to be able to use it.  It is non-static, because
	// it is important for iterators to know something about the lists
	// that they iterate over.
	//
	// The proper way to use an Iterator from outside of the LinkedList
	// class is something like this:
	//
	//     LinkedList<String> list = new LinkedList<String>();
	//
	//     // code that adds a bunch of elements to the list
	//
	//     LinkedList<String>.Iterator iterator = list.iterator();
	//     String s = "";
	//
	//     while (iterator.hasNext())
	//     {
	//         s += iterator.next();
	//     }
	//
	public class Iterator
	{
		// you'll need to add fields here
		Node<E> node;//creates a node object

		// The constructor initializes a new iterator that has not yet
		// returned any of the elements of the list.
		public Iterator()
		{
			node = head;//sets node equal to head
		}
		
		
		// hasNext() returns true if there are more elements in the list
		// that have not been returned, and false if there are no more
		// elements.
		public boolean hasNext()
		{
			return (node != null);//returns true if the node has a next and false if there isn't a node after
		}
		
		
		// next() returns the next element in the list.  The first time next()
		// is called on an iterator, the first element of the list is returned;
		// the second time next() is called, the second element is returned;
		// and so on.
		//
		// If there are no more elements in the list, a NoSuchElementException
		// should be thrown.  You generally won't want to catch this exception,
		// because it's an indication of a bug in your program; best to let
		// the program crash (with useful information about where the crash
		// occurred) so you can find and fix the problem.
		public E next()
		{
			if(!hasNext())//throws an exception if there isn't a node after the current node
				throw new NoSuchElementException();
			Node<E> temp = node;//sets temp equal to the node
			node = node.next;//sets the node equal to the following node
			return temp.data;//returns data of temp
		}
	}
}