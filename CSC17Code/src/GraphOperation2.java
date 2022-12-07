import java.util.*;

public class GraphOperation2 {

	public static int time = 0;

	private static class Graph {
		private int V;
		private Map<Integer, ArrayList<Integer>> adjListsMap;

		public Graph(int v) {
			V = 0;

			adjListsMap = new HashMap<Integer, ArrayList<Integer>>();
			for (int i = 0; i < v; i++) {
				addVertex();
			}
		}

		public int getNumVertices() {
			return V;
		}

		public List<Integer> getNeighbors(int v) {
			return new ArrayList<Integer>(adjListsMap.get(v));
		}

		public void addVertex() {
			int v = getNumVertices();
			ArrayList<Integer> neighbors = new ArrayList<Integer>();
			adjListsMap.put(v, neighbors);
			V++;
		}

		public void addEdge(int v, int w) {
			(adjListsMap.get(v)).add(w);
		}
	}


    public static List<List<Integer>> allBridges(Graph g) {
        // Create a list to store the bridges
        List<List<Integer>> bridges = new ArrayList<>();
    
        // Create an array to store the lowest reachable vertex for each vertex
        int[] reachable = new int[g.getNumVertices()];
        Arrays.fill(reachable, -1);
    
        // For each vertex in the graph, if it hasn't been visited yet,
        // perform a depth-first search starting from this vertex
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (reachable[i] == -1) {
                dfs(g, i, -1, reachable, bridges);
            }
        }
    
        // Return the list of bridges
        return bridges;
    }
    
    private static void dfs(Graph g, int u, int parent, int[] reachable, List<List<Integer>> bridges) {
        // Mark the current vertex as visited
        reachable[u] = u;
    
        // Visit each neighbor of the current vertex
        for (int v : g.getNeighbors(u)) {
            if (v == parent) {
                // Skip the current vertex's parent
                continue;
            }
    
            if (reachable[v] == -1) {
                // If the neighbor hasn't been visited yet,
                // perform a depth-first search starting from this neighbor
                dfs(g, v, u, reachable, bridges);
    
                // Update the lowest reachable vertex for the current vertex
                reachable[u] = Math.min(reachable[u], reachable[v]);
    
                // If the neighbor's lowest reachable vertex is higher than the current vertex,
                // the edge between the current vertex and the neighbor is a bridge
                if (reachable[v] > u) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                // If the neighbor has already been visited,
                // update the lowest reachable vertex for the current vertex
                reachable[u] = Math.min(reachable[u], reachable[v]);
            }
        }
    }
    

	public static void main(String args[]) {
		Graph graph1 = new Graph(5);
		graph1.addEdge(0, 1);
		graph1.addEdge(0, 2);
		graph1.addEdge(0, 3);
		graph1.addEdge(1, 0);
		graph1.addEdge(1, 2);
		graph1.addEdge(2, 0);
		graph1.addEdge(2, 1);
		graph1.addEdge(3, 0);
		graph1.addEdge(3, 4);
		graph1.addEdge(4, 3);

		System.out.println(allBridges(graph1));
	}
}