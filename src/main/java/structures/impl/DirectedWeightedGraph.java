package structures.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import structures.List;
import structures.Graph;
import structures.WeightedGraph;

public class DirectedWeightedGraph<V> implements WeightedGraph<V> {

	Map<V,List<Pair<V,Double>>> adjacencyMap;

	public DirectedWeightedGraph() {
		adjacencyMap = new HashMap<>();
	}

	public Set<V> vertices()
	{ return adjacencyMap.keySet(); }

	public Set<V> adjacents(V v) {
		if(v == null) throw new NullPointerException();
		if(!adjacencyMap.containsKey(v)) return new HashSet<>();

		Set<V> adjacents = new HashSet<>();
		for(Pair<V,Double> edge : adjacencyMap.get(v))
			adjacents.add(edge.first());

		return adjacents;
	}

	public int vertexCount()
	{ return adjacencyMap.size(); }

	public int edgeCount(V v) {
		if(v == null) throw new NullPointerException();
		if(!adjacencyMap.containsKey(v)) throw new IllegalArgumentException("key does not exist");

		return adjacencyMap.get(v).size();
	}

	public boolean addVertex(V v) {
		if(v == null) throw new NullPointerException();
		if(adjacencyMap.containsKey(v)) return false;

		adjacencyMap.put(v, new LinkedList<Pair<V,Double>>());
		return true;
	}

	public boolean addWeightedEdge(V o, V d, double w) {
		if(o == null || d == null) throw new NullPointerException();
		Set<V> vertexSet = adjacencyMap.keySet();
		if(!vertexSet.contains(o) || !vertexSet.contains(d)) return false;
		if(adjacents(o).contains(d)) return false;

		adjacencyMap.get(o).add(new Pair<>(d,w));
		return true;
	}

	public boolean addEdge(V o, V d)
	{ return addWeightedEdge(o, d, 1); }

	public boolean removeVertex(V v) {
		if(v == null) throw new NullPointerException();
		if(!adjacencyMap.containsKey(v)) return false;

		adjacencyMap.remove(v);
		for(List<Pair<V,Double>> adjList : adjacencyMap.values()) {
			for(Pair <V,Double> edge : adjList) {
				if(edge.first().equals(v))
					adjList.remove(edge);
			}
		}
		return true;
	}

	public boolean removeEdge(V o, V d) {
		if(o == null || d == null) throw new NullPointerException();
		if(!adjacencyMap.containsKey(o) || !adjacencyMap.containsKey(d)) return false;
		if(!adjacents(o).contains(d)) return false;

		List<Pair<V,Double>> adjList = adjacencyMap.get(o);
		for(Pair<V,Double> edge : adjList) {
			if(edge.first().equals(d)) {
				adjList.remove(edge);
				return true;
			}
		}
		return false;
	}

	public Set<Pair<V,Double>> outgoingEdges(V v) {
		if(v == null) throw new NullPointerException();
		if(!vertices().contains(v)) return new HashSet<>();

		return new HashSet<>(adjacencyMap.get(v));
	}

	public boolean setEdgeWeight(V o, V d, double w) {
		if(o == null || d == null) throw new NullPointerException();
		if(!vertices().contains(o) || !vertices().contains(d)) return false;
		if(!adjacents(o).contains(d)) return false;

		for(Pair<V,Double> edge : adjacencyMap.get(o)) {
			if(edge.first().equals(d)) {
				if(edge.second().doubleValue() != w) {
					edge.setSecond(w);
					return true;
				}
			}
		}
		return false;
	}

	public Iterator<V> dfsIterator()
	{ throw new UnsupportedOperationException(); }

	public Iterator<V> bfsIterator()
	{ throw new UnsupportedOperationException(); }

	public Iterator<V> iterator()
	{ throw new UnsupportedOperationException(); }

	public static void main(String[] args) {
		Graph<Character> g = new DirectedWeightedGraph<>();
		g.addVertex('a');
		g.addVertex('b');
		g.addVertex('c');
		g.addVertex('d');
		g.addVertex('e');
		g.addVertex('f');

		g.addEdge('a', 'b');
		g.addEdge('a', 'c');
		g.addEdge('a', 'd');
		g.addEdge('c', 'e');
		g.addEdge('d', 'a');
		g.addEdge('d', 'd');
		g.addEdge('d', 'f');
		g.addEdge('e', 'b');
		g.addEdge('f', 'c');

		g.removeVertex('c');
		g.removeEdge('d', 'a');

		Set<Character> set = g.adjacents('a');
	}

}
