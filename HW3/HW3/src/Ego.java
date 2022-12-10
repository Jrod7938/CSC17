
import java.util.*;
public class Ego {
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

	List<egonet> egoNetworks; // the list to store ego networks in a sorted order

	public Ego(Graph g) {
		egoNetworks = new ArrayList<>();
		// build data structure to store ego networks
		for (int v : g.getVertices()) {
			// create an egonet for each vertex
			Graph egoNet = new Graph();
			for (int w : g.adj(v)) {
				// add the center and its neighbors to the egonet
				egoNet.addVertex(v);
				egoNet.addVertex(w);
				egoNet.addEdge(v, w);
			}
			egoNetworks.add(new egonet(v, egoNet));
		}
		// sort ego networks based on their powers (number of edges)
		Collections.sort(egoNetworks, new Comparator<egonet>() {
			public int compare(egonet e1, egonet e2) {
				return e2.getG().getE() - e1.getG().getE();
			}
		});
	}

	public List<egonet> top(int k) {
		// return the top k ego networks
		return egoNetworks.subList(0, k);
	}
}
