package Outco_DS4_Graph;

public class CreatingGraph {
 public static void main(String[] args){
	 Graph g = new Graph();
	 
	 g.addVertex(0);
	 g.addVertex(1);
	 g.addVertex(2);
	 g.addVertex(3);
	 g.addVertex(4);
	 
	 g.addEdge(0, 2);
	 g.addEdge(1, 4);
	 g.addEdge(1, 3);
	 g.addEdge(2, 3);
	 g.addEdge(3, 4);
	
	
 }
}
