/**
 *	TreeMap implemented using Self-adjusting Binary Search Tree (Splay Tree)
 */
/*

import tree.*;

public class SplayTreeMap<K extends Comparable<K>,V> {
	private BinaryTree<Element> map;
	java.util.Set<K> keys;  // to return keys in order
	private int size;
		
	public boolean containsKey(K key){
		return keys.contains(key);	
	}
	
	public V put(K key, V value){
		
	}
	public V get(K key){
		
	}
	public V remove(K key){
		
	}
	public int size(){
		
	}
	public int height(){
		
	}
	public String toString(){
		
	}
	public java.util.Set<K> keySet(){
		
	}

// Element class
	private class Element{
		K key; V value;
		public Element(K key, V value){
			this.key = key;
			this.value = value;
		}
		public int compareTo(Element that){
			return this.key.compareTo(that.key);
		}
		public String toString(){
			return value.toString();
		}
	}
	
// Private BST methods to support map operations
// Implements a top-down splay tree using BinaryTree methods
// Based on Danny Sleator's pointer-based java code: http://www.link.cs.cmu.edu/splay/
// Also see referenced article by Sleator and Tarjan, page 667-670.
//
	private Element search(Element element){
		
	}
	private Element insert(Element element){
		
	}
	private Element delete(Element element){
		
	}		
	private void inorder(BinaryTree<Element> tree){
		
	}
	private int height(BinaryTree<Element> tree){
		
	}
*/
 /**
 * Internal method to perform a top-down splay.
 * 
 *   splay(key) does the splay operation on the given key.
 *   If key is in the tree, then the node containing
 *   that key becomes the root.  If key is not in the tree,
 *   then after the splay, the key at the root is either
 *	 the greatest key in the tree that is less than the key 
 *   or the least key in the tree greater than the key.
 *
 *   This means, among other things, that if you splay with
 *   a key that's larger than any in the tree, the rightmost
 *   node of the tree becomes the root.  This property is used
 *   in the delete method.
 */
/*
	private void splay(Element e){
		
	}
	private void rotateRight(BinaryTree<Element> t){
		
	}
	private void rotateLeft(BinaryTree<Element> t){
		
	}
}
*/