package structures;

import java.util.Set;
import structures.impl.Pair;

public interface WeightedGraph<V> extends Graph<V> {

	public Set<Pair<V,Double>> outgoingEdges(V v);

	public boolean addWeightedEdge(V o, V d, double w);

	public boolean setEdgeWeight(V o, V d, double w);

}
