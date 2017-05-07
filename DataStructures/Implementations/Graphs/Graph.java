package Outco_DS4_Graph;
// constructing "undirected graph"
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Graph class should contain vertices, totalNumOfVertices, totalNumOfEdges properties
// we used HashMap to store vertices, but can use any other DS to store vertices.

// in vertices hash map key and value are stored in following way
/*{
	vertex value 5(key) is stored as key : vertex object is stored as value
}*/

public class Graph {
	HashMap<Integer, Vertex> vertices;
	int numOfTotalVertices;
	int numOfTotalEdges;

	public Graph() {
		vertices = new HashMap<Integer, Vertex>();
	}

	// check if vertex already exist in graph, using hash map get method, if not
	// exist in map add new vertex
	// to the map.
	public void addVertex(int vertexValue) {
		if (vertices.get(vertexValue) == null) {
			Vertex newVertex = new Vertex(vertexValue);
			vertices.put(vertexValue, newVertex);
			numOfTotalVertices++;
		} else {
			System.out.println("vertex already present in graph");
		}
	}

	public Vertex getVertex(int vertexValue) {
		if (vertices.get(vertexValue) != null) {
			return vertices.get(vertexValue);
		} else {
			System.out.println("no vertex found with given value");
			return null;
		}
	}

	// step 1: check whether vertex1, vertex2 exist in graph
	// step 2: if exist, check vertex1 has already edge vertex2 if not add edge
	// to vertex2 from vertex1
	// same with vertex2 to vertex1

	public void addEdge(int vertexValue1, int vertexValue2) {
		if (vertices.get(vertexValue1) != null && vertices.get(vertexValue2) != null) {
			if (vertices.get(vertexValue1).getEdges().get(vertexValue2) == null
					&& vertices.get(vertexValue2).getEdges().get(vertexValue1) == null) {
				vertices.get(vertexValue1).getEdges().put(vertexValue2, vertexValue2);
				vertices.get(vertexValue2).getEdges().put(vertexValue1, vertexValue1);
				numOfTotalEdges++;
			} else {
				System.out.println("edge already exist");
			}
		} else {
			System.out.println("either one   or both of the vertices dosent exist in graph ");
		}
	}

	public void removeEdge(int vertexValue1, int vertexValue2) {
		if (vertices.get(vertexValue1) != null && vertices.get(vertexValue2) != null) {
			if (vertices.get(vertexValue1).getEdges().get(vertexValue2) != null
					&& vertices.get(vertexValue2).getEdges().get(vertexValue1) != null) {
				vertices.get(vertexValue1).getEdges().remove(vertexValue2);
				vertices.get(vertexValue2).getEdges().remove(vertexValue1);
				numOfTotalEdges--;
			} else {
				System.out.println("edge dosent exist");
			}
		} else {
			System.out.println("either one or both of the vertices dosent exist in graph");
		}
	}

	public void removeVertex(int vertexValue) {
		if (vertices.get(vertexValue) != null) {
			Vertex doDelete = vertices.get(vertexValue);
			HashMap<Integer, Integer> doDeleteEdges = doDelete.getEdges();
			// iterating through the all edges of vertex to be delete and remove
			// those those edges
			Set<Integer> keyset = doDeleteEdges.keySet();
			Iterator<Integer> it = keyset.iterator();
			while (it.hasNext()) {
				int key = it.next();
				removeEdge(key, vertexValue);
			}
			// after deleting all edges remove vertex
			vertices.remove(vertexValue);
			numOfTotalVertices--;
		} else {
			System.out.println("vertex dosent exist");
		}
	}
    
	// return edges of given vertex value
	public int[] findNeighbours(int vertexValue) {
		if (vertices.get(vertexValue) != null) {
			Vertex vertex = vertices.get(vertexValue);
			HashMap<Integer, Integer> edges = vertex.getEdges();

			Set<Integer> keyset = edges.keySet();
			int[] neighbours = new int[keyset.size()];
			Iterator<Integer> it = keyset.iterator();
			int index = 0;
			while (it.hasNext()) {
				int key = it.next();
				neighbours[index] = key;
				index++;
			}
			return neighbours;
		} else {
			System.out.println("given vertex not exist in graph");
			return null;
		}
	}

	public HashMap<Integer, Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(HashMap<Integer, Vertex> vertices) {
		this.vertices = vertices;
	}

	public int getNumOfTotalVertices() {
		return numOfTotalVertices;
	}

	public void setNumOfTotalVertices(int numOfTotalVertices) {
		this.numOfTotalVertices = numOfTotalVertices;
	}

	public int getNumOfTotalEdges() {
		return numOfTotalEdges;
	}

	public void setNumOfTotalEdges(int numOfTotalEdges) {
		this.numOfTotalEdges = numOfTotalEdges;
	}

}
