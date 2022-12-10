import java.util.*;

public class Ego {
	// place your code here
	private List<egonet> egoList;

	// the nested class used to define a egonet
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
		// TODO: strength is still not correct, need to fix
		egoList = new ArrayList<>();
		Set<Integer> vertices = g.getVertices();
		for (int v : vertices) {
			Graph egoGraph = new Graph();
			Set<Integer> neighbors = g.adj(v);
			egoGraph.addVertex(v);
			for (int n : neighbors) {
				egoGraph.addVertex(n);
				egoGraph.addEdge(v, n);
				Set<Integer> nNeighbors = g.adj(n);
				for (int nn : nNeighbors) {
					if (neighbors.contains(nn)) {
						egoGraph.addVertex(nn);
						egoGraph.addEdge(n, nn);
					}
				}
			}
			egoList.add(new egonet(v, egoGraph));
		}
		// sort egoList in descending order based on the number of edges in the ego graph
		Collections.sort(egoList, new Comparator<egonet>() {
			public int compare(egonet e1, egonet e2) {
				return e2.getG().getE() - e1.getG().getE();
			}
		});
	}

	public List<egonet> top(int k) {
		// this is the method to return the top k ego networks with the largest number of edges. The nested class egonet is provided to define an ego network.
		List<egonet> topK = new ArrayList<>();
		for (int i = 0; i < k && i < egoList.size(); i++) {
			topK.add(egoList.get(i));
		}
		return topK;
	}

}