package graph;

import java.util.ArrayList;

public class ListGraph extends Graph{

	ArrayList<ArrayList<Edge> > list;
	public ListGraph(int numberOfVertexs) {
		super(numberOfVertexs);
		list= new ArrayList<ArrayList<Edge>>();
		for(int i = 0; i < numberOfVertexs; ++i) {
			list.add(new ArrayList<Edge>());
		}
	}

	@Override
	public void addEdge(int startVertex, int endVertex, int weight) {
		list.get(startVertex).add(new Edge(startVertex, endVertex, weight));
		
	}

	@Override
	public ArrayList<Edge> getNeighbors(int vertex) {
		return list.get(vertex);
	}

	@Override
	public boolean hasEdge(int start, int end) {
		// get out the adjacency list for the start vertex
		ArrayList<Edge> startVertexNeighbors = list.get(start);
		
		// look for the end vertex
		
		for(Edge e : startVertexNeighbors ) {
			if(e.end == end) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void removeEdge(int start, int end) {
		// get out the adjacency list for the start vertex
		ArrayList<Edge> startVertexNeighbors = list.get(start);
		
		// look for the end vertex
		int edgeToRemove = -1;
		for(int i =0; i < startVertexNeighbors.size(); ++i ) {
			if(startVertexNeighbors.get(i).end== end) {
				edgeToRemove = i;
				break;
			}
		}
		if(edgeToRemove!=-1) {
			startVertexNeighbors.remove(edgeToRemove);
		}
		
		
		
	}
	
	

}
