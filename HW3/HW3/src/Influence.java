import java.util.*;

public class Influence {
	public List<influencer> listofInfluencers;

	// the nested class used to define a influencer
	public static class influencer implements Comparable<influencer>{
		int source; // the influencer
		double power; // the impact of this influencer

		influencer(int i, double p) {
			source = i;
			power = p;
		}

		int getSource() {
			return source;
		}

		double getPower() {
			return power;
		}

		@Override // override influencer to compare for sorting
		public int compareTo(influencer in) {
			return (int) ((int) -1*(this.getPower() - in.getPower()));
		}
	}

	public Influence(Graph g) {
		// this is the constructor to build the data structure that stores all influencers
		listofInfluencers = new ArrayList<>();
		Set<Integer> vertices = g.getVertices();

		// get power for each vertice
		for(Integer i: vertices){
			int placeHolderSource = i;
			double power = getPower(g, placeHolderSource);

			// add to list
			influencer data = new influencer(placeHolderSource, power);
			listofInfluencers.add(data);
		}

		// sort by power
		Collections.sort(listofInfluencers);
	}

	public List<influencer> top(int k) {
		// this method returns the top k influencers
		List<influencer> topK = new ArrayList<>();

		// get top k influencers
		for(int i = 0; i < k; i++){
			topK.add(listofInfluencers.get(i));
		}
		return topK;
	}

	// get power 
	public double getPower(Graph g, int source){
		double power = 0;

		// distance to source
		HashMap<Integer, Integer> distTo = new HashMap<Integer, Integer>();
		LinkedList<Integer> queue = new LinkedList<>();

		// visited vertices
		HashSet<Integer> visited = new HashSet<Integer>();

		queue.addLast(source);
		distTo.put(source, 0);

		// BFS
		while(!queue.isEmpty()){

			// get the first element in the queue
			int vertice = queue.remove();
			// add to visited
			visited.add(vertice);

			// update power
			if(vertice != source){
				power += 1 / Math.pow(2, (distTo.get(vertice) - 1)); // update power 
			}

			// go through the list 
			Iterator<Integer> iterator = g.adj(vertice).iterator();

			while(iterator.hasNext()){
				// get the neighbor
				int neighbor = iterator.next();
				
				// if not visited
				if(!visited.contains(neighbor)){
					// add to visited
					visited.add(neighbor);
					// add to queue
					queue.addLast(neighbor);
					// update distance
					distTo.put(neighbor, distTo.get(vertice) + 1);
				}
			}
		}
		return power;
	}
}