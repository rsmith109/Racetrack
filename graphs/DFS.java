package graphs;
import java.util.HashMap;

import racetrack.Vertex;



/**
 * DFS.java
 * 
 * Implements Depth-First Search on a Graph
 * To use this class, first build a graph and call the dfs or explore method.
 * Then, use the accessor methods to retrieve copies of the output data structures.
 * 
 * You should not change this file for the assignment.
 */

public class DFS {
	private HashMap<Vertex, Boolean> visited;
	private HashMap<Vertex, Integer> pre;
	private HashMap<Vertex, Integer> post;
	private int clock = 1;
	
	public void explore(Graph<Vertex> g, Vertex source){
		visited.put(source, true);
		pre.put(source, clock);
		clock++;
		for(Vertex u: g.getAdjacentVertices(source)){
			if(!visited.get(u)){
				explore(g, u);
			}
		}
		post.put(source, clock);
		clock++;
	}
	
	public void dfs(Graph<Vertex> g){
		// reset instance variables.
		clock = 1;
		visited = new HashMap<Vertex, Boolean>();
		pre = new HashMap<Vertex, Integer>();
		post = new HashMap<Vertex, Integer>();
		for(Vertex v:g.getVertices()){
			visited.put(v, false);
		}
		for(Vertex v:g.getVertices()){
			if(!visited.get(v)){
				explore(g,v);
			}
		}
	}
	
	private HashMap<Vertex, Integer> clone(HashMap<Vertex, Integer> toClone){
		HashMap<Vertex, Integer> clone = new HashMap<Vertex, Integer>();
		for(Vertex v: toClone.keySet()) {
			clone.put(v, toClone.get(v));
		}
		return clone;
	}
	
	public HashMap<Vertex, Integer> getPreTimes(){
		return clone(pre);
	}
	
	public HashMap<Vertex, Integer> getPostTimes(){
		return clone(post);
	}
}
