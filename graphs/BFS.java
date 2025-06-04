package graphs;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import racetrack.Vertex;

/**
 * BFS.java
 * 
 * Implements Breadth-First Search on a Graph
 * To use this class, first build a graph and call the breadthFirstSearch method.
 * Then, use the accessor methods to retrieve copies of the output data structures.
 * 
 * You should not change this file for the assignment.
 */

public class BFS {
	private HashMap<Vertex, Integer> distance = new HashMap<Vertex, Integer>();
	private HashMap<Vertex, Vertex> parent = new HashMap<Vertex, Vertex>();
	
	public void breadthFirstSearch(Graph<Vertex> g, Vertex s){
		distance = new HashMap<Vertex, Integer>();
		parent = new HashMap<Vertex, Vertex>();
		for (Vertex v:g.getVertices()){
			distance.put(v, Integer.MAX_VALUE);
		}
		distance.put(s, 0);
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(s);
		while(!queue.isEmpty()){
			Vertex u = queue.poll();
			for(Vertex v: u.getAdjacentVertices()){
				if(distance.get(v)==Integer.MAX_VALUE){
					queue.add(v);
					distance.put(v, distance.get(u)+1);
					parent.put(v, u);
				}
			}
		}
	}
	
	public HashMap<Vertex, Integer> getDistances(){
		HashMap<Vertex, Integer> clone = new HashMap<Vertex, Integer>();
		for(Vertex v: distance.keySet()) {
			clone.put(v,distance.get(v));
		}
		return clone;
	}
	
	public HashMap<Vertex, Vertex> getParents(){
		HashMap<Vertex, Vertex> clone = new HashMap<Vertex, Vertex>();
		for(Vertex v: parent.keySet()) {
			clone.put(v,parent.get(v));
		}
		return clone;
	}
}

