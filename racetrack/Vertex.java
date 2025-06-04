/**
 * This object represents a Vertex within a graph.
 * Each edge to other vertices is kept in the Vertex object as
 * an adjacency list.  
 * 
 * You should CHANGE or SUBCLASS this class for your assignment.
 * 
 * Authors: Russell, Divesh
 */
package racetrack;

import java.util.*;

public class Vertex {
	private ArrayList<Vertex> myEdges;
	private int xVel;
	private int yVel;
	private int xPos;
	private int yPos;

	public Vertex(int x, int y, int dx, int dy){
		myEdges = new ArrayList<Vertex>();
		xPos = x;
		yPos = y;
		xVel = dx;
		yVel = dy;
	}

	
	public int getXVel() {
		return xVel;
	}
	
	public int getYVel() {
		return yVel;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	// If a vertex is added with no weight, assume its weight is 1.
	public void addEdge(Vertex j){
		myEdges.add(j);
	}
	
	public void removeEdge(Vertex j){
		myEdges.remove(j);
	}
	
	public boolean hasEdge(Vertex j){
		return myEdges.contains(j);
	}
	
	public Collection<Vertex> getAdjacentVertices(){
		return myEdges;
	}
	
	public String toString(){
		return this.xPos + "," + this.yPos + "," + this.xVel + "," + this.yVel;
	}
}
