/*
 * Erin Blaskowski
 */

public class LinkedBST <T extends Comparable<T>> {
	
	private class Node
	{
		T data;
		Node leftChild;
		Node rightChild;
		public Node(T aData) 
		{
			data = aData;
		}
	}
	
	private Node root; //Start of the tree
	
	public LinkedBST() 
	{
		root = null;
	}
	
	public void add(T aData) 
	{
		if(root == null)
			root = new Node(aData);
		else {
			add(root, aData);
		}
	}
	
	private Node add(Node aNode, T aData) //Recursive method
	{
		if(aNode == null) {
			aNode = new Node(aData);
		}
		else if(aData.compareTo(aNode.data) < 0) { // Go left!
			aNode.leftChild = add(aNode.leftChild, aData);
		}
		else if(aData.compareTo(aNode.data) > 0) { // Go right!
			aNode.rightChild = add(aNode.rightChild, aData);
		}
		return aNode;
	}
	
	public void printPreOrder()
	{
		printPreOrder(root);
	}
	
	private void printPreOrder(Node aNode)
	{
		if(aNode == null) {
			return;
		}
		System.out.println(aNode.data); // Process
		printPreOrder(aNode.leftChild); // Left
		printPreOrder(aNode.rightChild); // Right
	}
	
	public void printInOrder()
	{
		printInOrder(root);
	}
	
	private void printInOrder(Node aNode)
	{
		if(aNode == null) {
			return;
		}
		printInOrder(aNode.leftChild); // Left
		System.out.println(aNode.data); // Process
		printInOrder(aNode.rightChild); // Right
	}
	
	public boolean search(T aData)
	{
		return search(root, aData);
	}
	
	private boolean search(Node aNode, T aData)
	{
		if(aNode == null) {
			return false;
		}
		else if(aData.compareTo(aNode.data) < 0) {
			return search(aNode.leftChild, aData);
		}
		else if(aData.compareTo(aNode.data) > 0) {
			return search(aNode.rightChild, aData);
		}
		else {
			return true;
		}
	}
	
	public void remove(T aData)
	{
		root = remove(root, aData);
	}
	
	public Node remove(Node aNode, T aData)
	{
		if(aNode == null) {
			return null; //Value not found
		}
		else if(aData.compareTo(aNode.data) < 0) { //GO LEFT
			aNode.leftChild = remove(aNode.leftChild, aData);
		}
		else if(aData.compareTo(aNode.data) > 0) { //GO RIGHT
			aNode.rightChild = remove(aNode.rightChild, aData);
		}
		else {
			//Case 0. No children or Case 1. One child that is the left one
			if(aNode.rightChild == null) {
				return aNode.leftChild;
			}
			else if(aNode.leftChild == null) { //Case 1. Right child
				return aNode.rightChild;
			}
			//Case 2. Two children
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);		
		}
		return aNode;
	}
	
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null) {
			return null;
		}
		else if(aNode.leftChild == null) {
			return aNode;
		}
		else {
			return findMinInTree(aNode.leftChild);
		}
	}
}
