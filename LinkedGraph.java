/*
 * Erin Blaskowski
 */

import java.util.*;

public class LinkedGraph {
	
	private class Vertex 
	{
		String name;
		ArrayList<Edge> neighbors;
		
		public Vertex(String aName) 
		{
			this.name = aName;
			neighbors = new ArrayList<Edge>();
		}
	}
	
	private class Edge 
	{
		Vertex toVert;
		double weight;
		
		public Edge(Vertex aV, double aW)
		{
			toVert = aV;
			weight = aW;
		}
	}
	
	private Vertex origin; //movable starting point
	private ArrayList<Vertex> vertices; //contains all vertices in graph
	private ArrayList<Vertex> markedVerts; //used by DFS & BFS
	private Queue<Vertex> vertQueue; //used by BFS
	
	public LinkedGraph() {
		origin = null;
		vertices = new ArrayList<Vertex>();
		markedVerts = new ArrayList<Vertex>();
		vertQueue = new LinkedList<Vertex>();
	}
	
	public void addVertex(String aN)
	{
		if(vertexIsContained(aN))
		{
			return;
		}
		Vertex v = new Vertex(aN);
		vertices.add(v);
		if(origin == null) {
			origin = v;
		}
	}
	
	private boolean vertexIsContained(String aName)
	{
		for(Vertex vert : vertices)
		{
			if(vert.name.equals(aName))
			{
				return true;
			}
		}
		return false;
	}
	
	public void addEdge(String fromVert, String toVert, double weight)
	{
		Vertex v1 = getVert(fromVert);
		Vertex v2 = getVert(toVert);
		if(v1 == null || v2 == null) 
		{
			return;
		}
		
		v1.neighbors.add(new Edge(v2, weight));
	}
	
	private Vertex getVert(String aN)
	{
		for(Vertex vert : vertices)
		{
			if(vert.name.equals(aN))
			{
				return vert;
			}
		}
		return null;
	}
	
	public void printDFS()
	{
		markedVerts.clear();
		printDFS(origin);
	}
	
	private void printDFS(Vertex vert)
	{
		if(markedVerts.contains(vert)) {
			return;
		}
		
		System.out.println(vert.name);
		markedVerts.add(vert);
		
		for(Edge edge : vert.neighbors)
		{
			printDFS(edge.toVert);
		}
	}
	
	public void printBFS()
	{
		markedVerts.clear();
		System.out.println(origin.name);
		vertQueue.add(origin);
		printBFS(origin);
	}
	
	private void printBFS(Vertex vert)
	{
		while(!vertQueue.isEmpty())
		{
			Vertex currVert = vertQueue.remove();
			markedVerts.add(currVert);
			for(Edge edge : currVert.neighbors)
			{
				if(!vertQueue.contains(edge.toVert) && !markedVerts.contains(edge.toVert))
				{
					System.out.println(edge.toVert.name);
					vertQueue.add(edge.toVert);
				}
			}
		}
	}
	
}

