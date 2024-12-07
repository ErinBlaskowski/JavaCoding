/*
 * Erin Blaskowski
 */

import java.util.*;

public class AdjMatrixGraph 
{
	//Declare instance variables
	public static final int DEF_VERT = 10; //Default number of vertices
	private double[][] adjMatrix; //Creation of the grid/graph matrix
	private LinkedList<Integer> markedList; //Linked list of the graph
	private Queue<Integer> vQ;
	
	//Default constructor
	public AdjMatrixGraph()
	{
		init(DEF_VERT);
	}
	
	//Parameterized constructor
	public AdjMatrixGraph(int verts)
	{
		init(verts);
	}
	
	//Initialize the list and matrix
	private void init(int verts)
	{
		if(verts <= 0) {
			verts = DEF_VERT;
		}
		adjMatrix = new double[verts][verts];
		
		for(int i = 0; i < adjMatrix.length; i++) 
		{
			for(int j = 0; i < adjMatrix[i].length; j++)
			{
				adjMatrix[i][j] = 0.0;
			}
		}
		markedList = new LinkedList<Integer>();
		vQ = new LinkedList<Integer>();
		}
	
	//Add an edge between vertices
	public void addEdge(int fromVert, int toVert, double weight)
	{
		if(!isValid(fromVert) || !isValid(toVert))
		{
			return;
		}
		adjMatrix[fromVert][toVert] = weight;
	}
	
	//Check if the index is valid
	private boolean isValid(int index)
	{
		return index >= 0 && index < adjMatrix.length;
	}
	
	//Print out the graph
	public void printGraph() {
		for(int i = 0; i < adjMatrix.length; i++) 
		{
			for(int j = 0; i < adjMatrix[i].length; j++)
			{
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//Call the method to print out the depth first search of the graph
	public void printDFS()
	{
		markedList.clear();
		printDFS(0);
	}
	
	//Print out the very beginning of the depth first search of the graph (NOT NEEDED)
	public void printDFSstart(int startVert) 
	{
		markedList.clear();
		if(isValid(startVert)) {
			return;
		}
		printDFS(startVert);
	}
	
	//Recursive method to print out the depth first search of the graph
	private void printDFS(int index)
	{
		System.out.println(index);
		markedList.add(index);
		for(int i = 0; i < adjMatrix.length; i++)
		{
			if(adjMatrix[index][i] != 0.0 && !markedList.contains(i))
			{
				printDFS(i);
			}
		}
	}
	
	public void printBFS()
	{
		markedList.clear();
		vQ.clear();
		markedList.add(0); // 0 == v1
		System.out.println(0);
		while(!vQ.isEmpty())
		{
			int currI = vQ.remove();
			markedList.add(currI);
			for(int i = 0; i < adjMatrix.length; i++)
			{
				if(!markedList.contains(i) && !vQ.contains(i) && adjMatrix[currI][i] != 0.0)
				{
					System.out.println(i);
					vQ.add(i);
				}
			}
		}
	}
}
