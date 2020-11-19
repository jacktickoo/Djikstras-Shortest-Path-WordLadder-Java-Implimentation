import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

	public int size() {
		return numVertices;
	}

	public Vertex getVertex(int i) {
		return vertices[i];
	}


	/**
	 * carry out a breadth first search/traversal of the graph from startword
	 * until endword or until all nodes visited
	 */
	public void bfs(int s, int e, List<String> wordList) {

		for (Vertex v : vertices) v.setVisited(false); // initialise (all vertices unvisted)
		LinkedList<Vertex> queue = new LinkedList<Vertex>(); // queue to process

		Vertex v = vertices[s];
		v.setVisited(true);
		v.setPredecessor(v.getIndex()); // v was initial/starting vertex
		queue.add(v); // add to queue for processing

		while (!queue.isEmpty()) {
			Vertex u = queue.remove(); // get next vertex to process
			LinkedList<AdjListNode> list = u.getAdjList(); // get adjacency list of the vertex

			for (AdjListNode node : list) {
				Vertex w = vertices[node.getVertexIndex()];

				if (!w.getVisited()) { // if vertex has not been visited
					w.setVisited(true);
					w.setPredecessor(u.getIndex()); // w was found using u so this is the predecessor
					queue.add(w); // add to queue for processing

					List<String> wordLadder = new ArrayList<String>(); //used to store path from start to end

					if (w.getIndex() == e) { // reached the target word
						wordLadder.add(wordList.get(w.getIndex()));
						int i = w.getPredecessor();

						while (i != s) {
							wordLadder.add(wordList.get(i));
							i = vertices[i].getPredecessor();
						}

						wordLadder.add(wordList.get(s));
						Collections.reverse(wordLadder); //all words are added to arraylist in reverse order
						for (String word : wordLadder) {
							System.out.println(word);
						}
						System.out.println("Shortest Word Ladder length: " + wordLadder.size());
						return;
					}
				}
			}
		}
		System.out.print("Word ladder from " + wordList.get(s) + " to " + wordList.get(e) + " is not possible.");
		return;
	}
}
