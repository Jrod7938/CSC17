import java.util.*;

public class Ego {
	// empty list of egonets
	List<egonet> egonets = new ArrayList<>();

	// the nested class used to define an egonet
	public static class egonet {
		
		int center; // center of the egonet
		Graph G; // subgraph that represents the egonet

		egonet(int c, Graph g) {
			center = c;
			G = g;
		}

		int getCenter() {
			return center;
		}

		Graph getG() {
			return G;
		}
	}

	public Ego(Graph g) {
		// for each vertex in the graph
		for (int v : g.getVertices()) {
			// create a new graph to store the egonet
			Graph egonetGraph = new Graph();

			// add the current vertex to the egonet graph
			egonetGraph.addVertex(v);

			// get the neighbors of the current vertex
			Set<Integer> neighbors = g.adj(v);

			for (int neighbor : neighbors) {
				// for each neighbor of the current vertex, add the neighbor to the egonet graph
				egonetGraph.addVertex(neighbor);

				// add the edge between the current vertex and its neighbor to the egonet graph
				egonetGraph.addEdge(v, neighbor);

				// get the neighbors of the current neighbor
				Set<Integer> neighborNeighbors = g.adj(neighbor);

				// for each neighbor of the current neighbor
				for (int neighborNeighbor : neighborNeighbors) {
					// if the neighbor's neighbor is also a neighbor of the current vertex
					if (neighbors.contains(neighborNeighbor)) {
						// add the neighbor's neighbor to the egonet graph
						egonetGraph.addVertex(neighborNeighbor);

						// add the edge between the current neighbor and its neighbor to the egonet graph
						egonetGraph.addEdge(neighbor, neighborNeighbor);
					}
				}
			}

			// create a new egonet using the current vertex as the center and the egonet graph
			egonet egonet = new egonet(v, egonetGraph);

			// add the egonet to the list of egonets
			egonets.add(egonet);
		}
        // sort the list of egonets by power (number of edges) in descending order
        egonets.sort((ego1, ego2) -> ego2.getG().getE() - ego1.getG().getE());
    }

    public List<egonet> top(int k) {
        // this is the method to return the top k ego networks with the largest number of edges.
        return egonets.subList(0, Math.min(k, egonets.size()));
    }
}
