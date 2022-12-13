/*
 * Given a directed, acyclic graph of N nodes. 
 * Find all possible paths from node 0 to node N-1, 
 * and return them in any order. The graph is 
 * represented by the adjacency list. There are no 
 * self-edges or parallel edges. For example, <1, [2, 3]> 
 * means there are edges from 1 to 2 and from 1 to 3.
 */

import java.util.*;

public class finalPractice {
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

    public static List<List<Integer>> allPathsSourceTarget(Graph graph) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        // add node 0 to the path
        path.add(0);
        // start DFS traversal from node 0
        dfs(graph, 0, paths, path);

        // return all paths
        return paths;
    }

    // DFS traversal
    private static void dfs(Graph graph, int v, List<List<Integer>> paths, List<Integer> path) {
        // if we reached the last node
        if (v == graph.getNumVertices() - 1) {
            // add the path to the list of paths
            paths.add(new ArrayList<Integer>(path));
            return;
        }
        
        // traverse all neighbors of the current node
        for (int w : graph.getNeighbors(v)) {
            // add the neighbor to the path
            path.add(w);
            // recursively traverse the neighbor
            dfs(graph, w, paths, path);
            // backtrack by removing the neighbor from the path
            path.remove(path.size() - 1);
        }
    }

    public static void main(String args[]) {
        Graph graph1 = new Graph(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(0, 3);
        graph1.addEdge(1, 3);
        graph1.addEdge(2, 3);
        System.out.println(allPathsSourceTarget(graph1));
    }
}