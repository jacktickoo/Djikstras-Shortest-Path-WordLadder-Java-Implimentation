import java.util.*;

/**
 class to represent an undirected graph using adjacency lists
 */
public class Graph {

	private Vertex[] vertices; // the (array of) vertices
	private int numVertices = 0; // number of vertices

	// possibly other fields representing properties of the graph

	/**
	 * creates a new instance of Graph with n vertices
	 */
	public Graph(int n) {
		numVertices = n;
		vertices = new Vertex[n];
		for (int i = 0; i < n; i++)
			vertices[i] = new Vertex(i);
	}

	public Vertex getVertex(int i) {
		return vertices[i];
	}

	public Vertex getClosest(Set<Vertex> unvisited){
		Vertex closest = unvisited.iterator().next();
		int lowestDistance = Integer.MAX_VALUE;
		for (Vertex v : unvisited){
			if (v.getSourceDistance() < lowestDistance){
				closest = v;
				lowestDistance = v.getSourceDistance();
			}
		}
		return closest;
	};

	/**
	 * carry out a dijkstras shortest path algorithm
	 */
	public void bfs(int s, int e, List<String> wordList) {

		Set<Vertex> visited = new HashSet<>();
		Set<Vertex> unvisited = new HashSet<>();

		vertices[s].setPredecessor(-1); // v was initial/starting vertex
		vertices[s].setSourceDistance(0);
		visited.add(vertices[s]);
		Vertex v = vertices[s];

		for (AdjListNode node : v.getAdjList()) { //initialize starting adjacent nodes with their distance
			unvisited.add(vertices[node.getVertexIndex()]);
			vertices[node.getVertexIndex()].setPredecessor(v.getIndex()); //set first round predecessor
			vertices[node.getVertexIndex()].setSourceDistance(node.getDistance()); //set first source distance
		}

		while (!unvisited.isEmpty()) {
			v = getClosest(unvisited);

			for (AdjListNode node : v.getAdjList()) { //if adjacent nodes not in visited add to unvisited
				if (!visited.contains(vertices[node.getVertexIndex()])){
					unvisited.add(vertices[node.getVertexIndex()]);
				}
				if (vertices[node.getVertexIndex()].getSourceDistance() > ( v.sourceDistance + node.getDistance())) {   //if node distance from source > pred + weight
					vertices[node.getVertexIndex()].setPredecessor(v.getIndex()); //set v as pred
					vertices[node.getVertexIndex()].setSourceDistance(v.sourceDistance + node.getDistance()); //update new weight
				}
			}
			visited.add(vertices[v.getIndex()]);
			unvisited.remove(vertices[v.getIndex()]); //mark node as visited
		}

		if (vertices[e].getSourceDistance() == Integer.MAX_VALUE){
			System.out.print("Word ladder from " + wordList.get(s) + " to " + wordList.get(e) + " is not possible.");
			return;
		}
		else {
			List<String> wordLadder = new ArrayList<String>();   //print path
			Vertex w = vertices[e];
			wordLadder.add(wordList.get(w.getIndex()));
			int i = w.getPredecessor();
			while (i!=-1) {
				w = vertices[i];
				wordLadder.add(wordList.get(w.getIndex()));
				i = w.getPredecessor();
			}
			Collections.reverse(wordLadder);
			for (String word : wordLadder) {
				System.out.println(word);
			}
			System.out.println("Dijkstra's shortest path length: " +vertices[e].sourceDistance);
			return;

		}
	}
}
