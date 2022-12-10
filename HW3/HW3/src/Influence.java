import java.util.*;

public class Influence {
	// the nested class used to define a influencer
	public static class influencer {
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
	}

	private List<influencer> influencers;
	
	public Influence(Graph g) {
		// this is the constructor to build the data structure that stores all influencers from graph g in a sorted order based on their influences.
		
		influencers = new ArrayList<>();
		
		for (int v : g.getVertices()) {
			influencers.add(new influencer(v, influence(g, v)));
		}
		
		// sort the influencers in descending order of power
		Collections.sort(influencers, new Comparator<influencer>() {
			@Override
			public int compare(influencer i1, influencer i2) {
				return Double.compare(i2.power, i1.power);
			}
		});
	}
	
	// Compute the influence of a given vertex
	private double influence(Graph g, int v) {
		// Placeholder implementation that simply returns the degree of the vertex
		return g.adj(v).size();
	}

	public List<influencer> top(int k) {
		// this is the method to return the top k influencers. The nested class influencer is provided to define an influencer.
		return influencers.subList(0, Math.min(k, influencers.size()));
	}
}
