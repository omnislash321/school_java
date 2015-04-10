//-----------------------------------------------------------------------------
// Name: Roberto Hong Xu Kuang
// Class: CS 241
// Project: My Tree Map
// Date: 10/27/2014
//-----------------------------------------------------------------------------
// MyTreeMap class - Creating a personal version of the java TreeMap,
// using a shell that was given by the professor. It also uses a BinaryTree
// class that is given by the professor. 
//-----------------------------------------------------------------------------

//Sets are used to keep track of the keys.
import java.util.Set;
import java.util.TreeSet;

//This is the class called BinaryTree that was given by the professor.
import tree.*;

public class MyTreeMap<K extends Comparable<K>,V> {
	//The main BinaryTree that will become the very top root/tree.
	private BinaryTree<Element> map;
	//Used to keep track of the keys;
	java.util.Set<K> keys;
	//Size counter of the keys.
	private int size;
	
//-----------------------------------------------------------------------------	
// boolean containsKey with parameter generic K key
// Will check the tree to see if there is a key found. Will return true if
// found, and false if the key is not in the tree.
//-----------------------------------------------------------------------------
	public boolean containsKey(K key){
		//Calls the search method written below using a null value Element.
		//If the search returns null, then nothing was found, returning false.
		// Otherwise, it returns true.
		return (search(new Element(key,null),map) != null);
	}
	
//-----------------------------------------------------------------------------
// generic V put with parameter generic K key, generic V value
// This method will insert the key and value as an Element, that is mapped
// to each other. It will also add the size, and add to the set of keys.
// Will return old value if the key already exists, otherwise null
//-----------------------------------------------------------------------------
	public V put(K key, V value){
		//Calls the insert method with a new Element with key and value,
		// Insert returns the old Element.
		Element query = insert(new Element(key,value));
		// If query is not null, that means there was an old element replaced
		if(query != null) return query.value;
		
		//If query is null, which means there was no previous key,
		//Size is incremented.
		size++;

		return null;
	}
//-----------------------------------------------------------------------------
// generic V get with parameter generic K key
// Will return the value of the key that is desired. Null if not found;
//-----------------------------------------------------------------------------
	public V get(K key){
		//First, make sure that the key is inside the tree.
		// Then, use the search method to find the key.
		// Since it will only run search if the key is there, search will not
		// be null. So there wil be an element found, and the value can be
		// used.
		if(containsKey(key)) return search(new Element(key,null),map).value;
		
		// If key is not found, then return null.
		return null;
	}
	
//-----------------------------------------------------------------------------
// generic V remove with parameter generic K key
// Removes the desired key that is given.
// Will return the value of the key that was removed. Null if not removed.
//-----------------------------------------------------------------------------
	public V remove(K key){
		//First, check if the key is in the tree.
		if(containsKey(key)){
			//Then, run the delete method with the map as the tree, 
			// A new element of the key with null value as the desired key,
			// Then null for the parent.
			Element result =  delete(map, new Element(key,null), null);
			// If successfully deleted,
			if(result!=null){ 
				//Decrement size.
				size--;
				//Return the value that was deleted.
				return result.value;
			}
		}
		
		//If the key is not found or not successfully deleted, then return null.
		return null;
	}
	
//-----------------------------------------------------------------------------
// int size with no parameter
// Returns the size of the tree, which are all the nodes.
//-----------------------------------------------------------------------------
	public int size(){
		return this.size;
	}
	
//-----------------------------------------------------------------------------
// int height with no parameter
// Returns the height of the tree, zero-based numbering.
//-----------------------------------------------------------------------------
	public int height(){
		return height(map);
	}
	
//-----------------------------------------------------------------------------
// String toString with no parameter
// Overwrites the default toString() method, and just uses the BinaryTree's
// toString() method.
//-----------------------------------------------------------------------------
	public String toString(){
		return map.toString();
	}
	
//-----------------------------------------------------------------------------
// Set<generic K> keySet with no parameters
// Returns the set of the keys.
//-----------------------------------------------------------------------------
	public java.util.Set<K> keySet(){
		keys = new TreeSet();
		inorder(map);
		return keys;
	}
//-----------------------------------------------------------------------------
// Element search with parameter Element lement, BinaryTree<Element> tree
// Searches for the desired Element in the tree recursively and returns the 
// Element that is found.
//-----------------------------------------------------------------------------
	private Element search(Element element, BinaryTree<Element> tree){
		//First, check if the tree is empty.
		if(tree == null) return null;
		else{//Otherwise
			//Compare the root of the tree to the desired element.
			Element root = tree.getRoot();
			int compare = tree.getRoot().compareTo(element);
			
			//If the root is the correct desired element, then return the element.
			if(compare == 0)return root;
			//If the root is greater than the desired element,
			//Recursively call, but use the left subtree instead.
			else if(compare > 0) return search(element, tree.getLeft());
			//If the root is less than the desired element,
			//Recursively call usingt he right subtree.
			else return search(element,tree.getRight());
		}
	}
//-----------------------------------------------------------------------------
// Element insert with parameter Element element
// Inserts the element, and also initializes the map BinaryTree.
//-----------------------------------------------------------------------------
	private Element insert(Element element){
		//If the map is not initialized yet,
		if(map == null){
			//Initialize/fill the tree.
			map = new BinaryTree<Element>(element);
			//Return null since it successfully added.
			return null;
		}else{
			//If the tree is already started, then call the overloaded insert
			return insert(element, map);
		}
	}
//-----------------------------------------------------------------------------
// Element insert with parameter Element element, BinaryTree<Element> tree
// Overloaded method. Will insert the element into the tree, using the correct
// Left or Right child. If the key is already in this tree, it will be replaced
//-----------------------------------------------------------------------------
	private Element insert(Element element, BinaryTree<Element> tree){
		//Compare the root of the tree to the element to be added.
		Element root = tree.getRoot();
		int compare = root.compareTo(element);
		//This will replace the old element with the new element.
		if(compare == 0) return tree.setRoot(element);
		//If the root is bigger than the element,
		else if(compare > 0)
			//If the tree does not have a left child,
			if(tree.getLeft() == null)
			{
				//Then set the left child to the element.
				tree.setLeft(new BinaryTree<Element>(element));
				//Return null since successfully added.
				return null;
			//If there is a left child, then recursively call itself.
			}else return insert(element,tree.getLeft());
		//If the root is smaller then the element,
		else
			//If the tree does not have a right child,
			if(tree.getRight() == null){
				//Set the right child to the element.
				tree.setRight(new BinaryTree<Element>(element));
				//Return null since successfully added.
				return null;
			//If there is a right child, then recursively call itself.
			}else return insert(element,tree.getRight());
	}
	
//-----------------------------------------------------------------------------
// Element delete with parameter BinaryTree<Element> tree, Element element,
//		BinaryTree<Element> parent
// This will delete the element desired from the tree that is given.
// The parent argument is used for keeping track of the parent in order to 
// properly keep the flow of the nodes.
// Will return the element deleted, or null if not deleted succcessfully.
//-----------------------------------------------------------------------------
	private Element delete(BinaryTree<Element> tree, Element element, BinaryTree<Element> parent){
		//First, check if the tree is empty.
		if(tree == null) return null;
		else{
			//Now, compare the root of the tree to the element.
			Element root = tree.getRoot();
			int compare = tree.getRoot().compareTo(element);
			//If the element is smaller than the root, then recursively call,
			// But this time, use the left child as the tree and the tree as the parent.
			if(compare > 0) return delete(tree.getLeft(), element, tree);
			//Likewise, if the element is bigger than the root.
			else if(compare < 0) return delete(tree.getRight(), element, tree);
			//If the root is the correct element to delete
			else{

				//First, if it has no children, then set the parent's child to null.
				if(tree.isLeaf())
					promote(tree, parent, null);
				//If there is only a left child,
				else if(tree.getLeft() != null && tree.getRight() == null)
					promote(tree, parent, tree.getLeft());
				//If there is only a right child,
				else if(tree.getLeft() == null && tree.getRight() != null)
					promote(tree, parent, tree.getRight());
				//If there are two children.
				else{
					inorderSuccessor(tree);
				}
				//Return the deleted element.
				return root;
			}
		}
	}
//-----------------------------------------------------------------------------
// void promote with parameter BinaryTree<element> tree, BinaryTree<Element> parent,
//			BinaryTree<Element> newChild
// This will promote the newChild to the correct left or right child of the 
// Parent, effectively removing tree from the Tree Map.
//-----------------------------------------------------------------------------
	private void promote(BinaryTree<Element> tree, BinaryTree<Element> parent, BinaryTree<Element> newChild){
		//Comparing the root of the parent to see if it's bigger or smaller than the element.
		//If the newChild is bigger, then set the right child to be newChild.
		if(parent.getRoot().compareTo(tree.getRoot()) < 0) parent.setRight(newChild);
		//Otherwise, set the left child to newChild.
		else parent.setLeft(newChild);
	}
//-----------------------------------------------------------------------------
// void inorderSuccessor with parameter BinaryTree<Element> tree
// Finds the inorder successor of the root of the tree. This is achieved by
// getting the most outer left child of the first right child of the root.
// Then, swap the inorder successor to the root, and promote everything else.
//-----------------------------------------------------------------------------
	private void inorderSuccessor(BinaryTree<Element> tree){
		//First, start off on the right child.
		BinaryTree<Element> successor = tree.getRight();
		//A way to remember the parent.
		BinaryTree<Element> parent = tree;
		//While loop to keep finding the left child.
		while(successor.getLeft() != null){
			//Keeps changing the parent and the successor.
			parent = successor;
			successor = successor.getLeft();
		}
		//Once found, set the root of the tree to the successor element.
		tree.setRoot(successor.getRoot());
		//Then, promote the parent's left child to the right child of the successor.
		//Can be null, or another subtree.
		parent.setLeft(successor.getRight());
	}
//-----------------------------------------------------------------------------
// void inorder with parameter BinaryTree<Element> tree
// Will add the keys in order to the global variable keys.
//-----------------------------------------------------------------------------
	private void inorder(BinaryTree<Element> tree){
		if(tree.getLeft() != null) inorder(tree.getLeft());
		keys.add(tree.getRoot().key);
		if(tree.getRight() != null) inorder(tree.getRight());
	}	
	
//-----------------------------------------------------------------------------
// int height with parameter BinaryTree<Element> tree
// Will recursively count the height of the tree, using zero-based numbering.
//-----------------------------------------------------------------------------
	private int height(BinaryTree<Element> tree){
		//To keep track of the left and right heights.
		int countLeft = 0;
		int countRight = 0;
		//If the tree is empty, then return -1.
		if(tree.getRoot() == null)
			return -1;
		//If tree is not empty,
		else{
			//Will recursively add to the count.
			//Left side
			if(tree.getLeft() != null)
				countLeft = 1 + height(tree.getLeft());
			//Right side.
			if(tree.getRight() != null)
				countRight = 1 + height(tree.getRight());
		}
		//Compare the bigger side and then return it.
		if (countLeft >= countRight)
			return countLeft;
		else
			return countRight;
	}

//-----------------------------------------------------------------------------
// Element class - A way to map a key to the value using generics.
// Has one constructor for the key and value. Will compare using the keys
// and uses the Comparable interface to compare the keys.
//-----------------------------------------------------------------------------
	private class Element{
		//Generic for the keys and values, global.
		K key; V value;
//-----------------------------------------------------------------------------
// Constructor for Element, two parameters generic K key, generic V value
// Initializes the two global variables key and value.
//-----------------------------------------------------------------------------
		public Element(K key, V value){
			this.key = key;
			this.value = value;
		}
//-----------------------------------------------------------------------------
// int compareTo with parameter Element that
// Using comparable interface to compare this element to that.
// According to Comparable, it will return the difference between the two
//-----------------------------------------------------------------------------
		public int compareTo(Element that){
			return this.key.compareTo(that.key);
		}

//-----------------------------------------------------------------------------
// String toString with no parameter
// Overwrites the default toString() method, and simply returns the value in 
// String form.
//-----------------------------------------------------------------------------
		public String toString(){
			return this.value+"";
		}
	}	
}	