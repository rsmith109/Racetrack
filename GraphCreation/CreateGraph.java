package GraphCreation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import graphs.Graph;
import racetrack.Vertex;
import graphs.AdjListGraph;

/*
 * CreateGraph
 * Given the race track this class creates a graph of all the possible
 * vertices from each start vertex to its respective end vertices. Also
 * getters to access startVertices and endVertices
 * 
 * Authors: Russell, Divesh
 */

public class CreateGraph {
	
	private int vertexCount = 0;
	private ArrayList<Vertex> startVertices = new ArrayList<>();
	private ArrayList<Vertex> endVertices = new ArrayList<>();
	
	public ArrayList<Vertex> getStartVertex() {
		return startVertices;
	}
	
	public ArrayList<Vertex> getEndVertices() {
		return endVertices;
	}
	
	public int getVertexCount() {
		return vertexCount;
	}
	
	private boolean isInGraph(int[][] racetrack, int x, int y) {
		if (x < 0 || y < 0) {
			return false;
		}
		if (x > racetrack[0].length - 1 || y > racetrack.length - 1) {
			return false;
		}
		return true;
	}
	
	public Graph<Vertex> createGraph(int[][] racetrack) {
		
		// Start and End vertices
		HashMap<String, Vertex> verticesMap = new HashMap<>();
		
		// Queue to track next vertices
		Queue<Vertex> vertices = new LinkedList<>();
		
		Graph<Vertex> graph = new AdjListGraph(Graph.UNDIRECTED);
		
		// Get start vertices into HashMap and Queue
		for (int i = 0; i < racetrack.length; i++) {
			if (racetrack[i][0] == 0) {
				Vertex temp = new Vertex(0, i, 0, 0);
				String name = temp.toString();
				verticesMap.put(name, temp);
				vertices.add(temp);
				startVertices.add(temp);
			}
		}
		
		while (!vertices.isEmpty()) {
			Vertex top = vertices.poll();
			graph.addVertex(top);
			
			for (int i = -1; i < 2; i++) {
				
				int xVel = top.getXVel() + i;
				int xPos = xVel + top.getXPos();
				
				for (int j = -1; j < 2; j++) {
					
					int yVel = top.getYVel() + j;
					int yPos = yVel + top.getYPos();
					
					String id = xPos + "," + yPos + "," + xVel + "," + yVel;
					
					if (isInGraph(racetrack, xPos, yPos) && racetrack[yPos][xPos] == 0 && !verticesMap.containsKey(id)) {
						Vertex temp = new Vertex(xPos, yPos, xVel, yVel);
						
						vertexCount++;
						
						if (xPos != racetrack[0].length - 1) {
							vertices.add(temp);
						}
						else {
							endVertices.add(temp);
						}
						
						verticesMap.put(id, temp);
						graph.addVertex(temp);
						graph.addEdge(top, temp);
						
						//System.out.println(temp);
					}
				}
			}
		}
		
		//System.out.println(vertexCount);
		return graph;
		
	}
}
