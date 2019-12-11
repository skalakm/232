package graph;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class MatrixGraph extends Graph {

	Edge[][] matrix;
	public MatrixGraph(int numberOfVertexs) {
		super(numberOfVertexs);
		matrix = new Edge[numberOfVertexs][numberOfVertexs];
	}

	@Override
	public void addEdge(int startVertex, int endVertex, int weight) {
		matrix[startVertex][endVertex] = new Edge(startVertex, endVertex, weight);

	}

	@Override
	public ArrayList<Edge> getNeighbors(int vertex) {
		// make an arraylist
		
		//go through that row and add all the edges
		
		ArrayList<Edge> neighbors = new ArrayList<Edge>();
		
		for(int i = 0; i < size(); ++i) {
			if(matrix[vertex][i] !=null) {
				neighbors.add(matrix[vertex][i]);
			}
		}
		
		return neighbors;
	}

	@Override
	public boolean hasEdge(int start, int end) {
		
		return matrix[start][end]!=null;
	}

	@Override
	public void removeEdge(int start, int end) {
		matrix[start][end] = null;
		
	}
	
	
	
	

}
