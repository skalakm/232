package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public abstract class Graph {

	
	public static void main(String[] args) {
		Graph g = new ListGraph(6);
		g.addEdge(0, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 2);
		g.addEdge(4, 1);
		g.breadthFirstSearch(0);
		for(int i = 0; i < g.marks.length; ++i) {
			System.out.println(i + " " + g.marks[i]);
		}
	}
	int numVertexs;
	int[] marks;
	
	public Graph(int numberOfVertexs) {
		numVertexs = numberOfVertexs; 
		marks = new int[numberOfVertexs];
	}
	
	public void addUndirectedEdge(int u, int v, int weight) {
		addEdge(u,v,weight);
		addEdge(v,u,weight);
	}
	public abstract void addEdge(int startVertex, int endVertex, int weight);
	
	public void addEdge(int startVertex, int endVertex) {
		addEdge(startVertex, endVertex, 1);
	}
	
	
	public abstract ArrayList<Edge> getNeighbors(int vertex );
	
	public abstract boolean hasEdge(int start, int end);
	
	public abstract void removeEdge(int start, int end);
	
	public int size() {
		return numVertexs;
	}
	
	public void setMark(int v, int x) {
		marks[v] = x;
	}
	public int getMark(int v) {
		return marks[v];
	}
	
	public void setAllMarks(int markVal) {
		for(int i =0; i < marks.length; ++i) {
			marks[i] = markVal;
		}
	}
	
	
	public void breadthFirstSearch(int startVertex) {
		
		setAllMarks(-1);
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		setMark(startVertex, 0);
		q.add(startVertex);
		
		while(!q.isEmpty()) {
			int curVertex = q.poll();

			System.out.println(curVertex);
			for(Edge neighborEdge : getNeighbors(curVertex)) {
				
				int neighbor = neighborEdge.end;

				if(marks[neighbor] == -1) {
					marks[neighbor] = marks[curVertex]+1;
					q.add(neighbor);
				}
			}
		}
		
	}
	
	
	
	
	class Edge{
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.start= start;
			this.end = end;
			this.weight = weight;
		}
	}
	

	
}
