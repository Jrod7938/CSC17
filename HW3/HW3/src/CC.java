import java.util.*;
public class CC {
	// the nested class used to define a connected component
	public static class cc {
		int id; // the id of the component
		int size; // the size of the component

		cc(int i, int s) {
			id = i;
			size = s;
		}

		int getId() {
			return id;
		}

		int getSize() {
			return size;
		}
	}

	private List<cc> components;
	
	public CC(Graph g) {
		// this is the constructor to build the data structure that stores all connected components
		
		components = new ArrayList<>();
		Map<Integer, Integer> visited = new HashMap<>(); // map of visited vertices
		int id = 1; // id of the current connected component
		
		for (int v : g.getVertices()) {
			if (!visited.containsKey(v)) {
				// v is not visited yet, so it must be part of a new connected component
				int size = dfs(g, v, visited, id);
				components.add(new cc(id, size));
				id++;
			}
		}
		
		// sort the components in descending order of size
		Collections.sort(components, new Comparator<cc>() {
			@Override
			public int compare(cc c1, cc c2) {
				return c2.size - c1.size;
			}
		});
	}
	
	// Depth-first search
	private int dfs(Graph g, int v, Map<Integer, Integer> visited, int id) {
		int size = 1;
		visited.put(v, id);
		
		// visit all unvisited neighbors of v
		for (int w : g.adj(v)) {
			// w is not visited yet, so it must be part of the same connected component
			if (!visited.containsKey(w)) {
				// recursively visit w
				size += dfs(g, w, visited, id);
			}
		}
		
		return size;
	}

	public int count() {
		// this is the method to return the number of connected components
		return components.size();
	}

	public List<cc> top(int k) {
		// this is the method to return the top k connected components
		return components.subList(0, Math.min(k, components.size()));
	}
}