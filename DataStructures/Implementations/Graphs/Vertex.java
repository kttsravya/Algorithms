package Outco_DS4_Graph;

import java.util.HashMap;

// vertex class should have vertex value and edges associated with that particular vertex

// we use hash map to store edges associated with particular vertex in the following code,but
// can use any other data structure like arrays, lists etc..

// in hash map the data is stored in following way
/*
 * {
	5:5
   }
   first 5(vertexValue) is key and second 5(vertexValue) is value
*/

public class Vertex {
	int vertexValue;
	HashMap<Integer, Integer> edges;

	public Vertex(int vertexValue) {
		this.vertexValue = vertexValue;
		this.edges = new HashMap<Integer, Integer>();
	}

	public int getVertexValue() {
		return vertexValue;
	}

	public void setVertexValue(int vertexValue) {
		this.vertexValue = vertexValue;
	}

	public HashMap<Integer, Integer> getEdges() {
		return edges;
	}

	public void setEdges(HashMap<Integer, Integer> edges) {
		this.edges = edges;
	}

}
