package Outco_DS4_Graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

//idea: to go forward(in depth) while there is any such possibility, if not then,backtrack
public class DepthFirstSearch {
   public static void main(String[] args){
	  
	   // creating graph
	   
	   Graph graph = new Graph();
	   
	   graph.addVertex(1);
	   graph.addVertex(2);
	   graph.addVertex(3);
	   graph.addVertex(4);
	   graph.addVertex(5);
	   graph.addVertex(6);
	   
	   graph.addEdge(1, 2);
	   graph.addEdge(1, 3);
	   graph.addEdge(2, 4);
	   graph.addEdge(2, 5);
	   graph.addEdge(3, 5);
	   graph.addEdge(4, 5);
	   graph.addEdge(4, 6);
	   graph.addEdge(5, 6);
	  
	   // start vertex is one of the parameter for depth first search method to start 
	   // traversing from this vertex
	   
	  Vertex startVertex = null;
	  
	  HashMap<Integer, Vertex > vertices = graph.getVertices();
	  Set<Integer> keySet = vertices.keySet();
	  Iterator<Integer> it = keySet.iterator();
	  
	   // if unconnected graph is present , you should take out break statement
	  // that means breadth first search and depth first search is performed for every vertex..
	  
	  while(it.hasNext()){
		  int i = it.next();
		  startVertex = graph.getVertex(i);
		  break;
	  }
	  
	  // visited is the second parameter for depth first search to keep track of visited
	  // nodes
	  HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
	  
	  // send graph as third parameter
	  
	  // depthFirstSearch(startVertex, visited, graph);
	   
	   HashMap<Integer,Integer> visited1 = new HashMap<Integer,Integer>();
	   breadthFirstSearch(startVertex, visited1, graph);
	  
	
   }

private static void breadthFirstSearch(Vertex startVertex, HashMap<Integer, Integer> visited, Graph graph) {
	LinkedList<Vertex> queue = new LinkedList<Vertex>();
	if(visited.get(startVertex.vertexValue) == null){
		queue.add(startVertex);
		visited.put(startVertex.vertexValue, startVertex.vertexValue);
	}
	while( ! queue.isEmpty()){
		Vertex v = queue.removeFirst();
		System.out.println(v.vertexValue);
		
		
		HashMap<Integer, Integer> edges = v.getEdges();
		Set<Integer> set = edges.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			int next = it.next();
			if(visited.get(next) == null){
				queue.add(graph.getVertex(next));
				visited.put(next, next);
			}
		}
	}
	
}

private static void depthFirstSearch(Vertex startVertex, HashMap<Integer, Integer> visited, Graph graph) {
//	  System.out.println("startVertex is " + startVertex.vertexValue);
//	  System.out.println("elements is the visited hash map is ");
//	  Set<Integer> keyset1 = visited.keySet();
//	  Iterator<Integer> it1 = keyset1.iterator();
//	  while(it1.hasNext()){
//		  System.out.print(it1.next() + " ");
//	  }
//	  System.out.println();
	
	// checking whether startVertex is already visited or not
	if(visited.get(startVertex.vertexValue) == null){
		visited.put(startVertex.vertexValue,startVertex.vertexValue);
		System.out.println(startVertex.vertexValue);
		
		// now iterate through all the edges of start vertex until you find unvisited edge
		HashMap<Integer, Integer> edges = graph.getVertex(startVertex.vertexValue).getEdges();
		Set<Integer> keySet = edges.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()){
			int next = it.next();
			if(visited.get(next) == null){
				depthFirstSearch(graph.getVertex(next), visited, graph);
			}
		}
	}
	
}

}
