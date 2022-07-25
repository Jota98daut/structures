package structures.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import structures.List;
import structures.WeightedGraph;
import structures.Queue;
import structures.Stack;

public class DirectedWeightedGraph<V> implements WeightedGraph<V> {

	private final Map<V,List<Pair<V,Double>>> adjacencyMap;

	public DirectedWeightedGraph() {
		adjacencyMap = new HashMap<>();
		indices = new HashMap<>();
		vertexCount = 0;
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
	{ return vertexCount; }

	public int edgeCount(V v) {
		if(v == null) throw new NullPointerException();
		if(!adjacencyMap.containsKey(v)) throw new IllegalArgumentException("key does not exist");

		return adjacencyMap.get(v).size();
	}

	public boolean addVertex(V v) {
		if(v == null) throw new NullPointerException();
		if(adjacencyMap.containsKey(v)) return false;

		adjacencyMap.put(v, new LinkedList<>());
		indices.put(v, vertexCount);
		vertexCount++;

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
		indices.remove(v);
		for(List<Pair<V,Double>> adjList : adjacencyMap.values()) {
			for(Pair <V,Double> edge : adjList) {
				if(edge.first().equals(v))
					adjList.remove(edge);
			}
		}
		vertexCount--;
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
				if(edge.second() != w) {
					edge.setSecond(w);
					return true;
				}
			}
		}
		return false;
	}

	public double getEdgeWeight(V o, V d) {
		if(o == null || d == null) throw new NullPointerException();
		if(!vertices().contains(o) || !vertices().contains(d)) throw new IllegalArgumentException("key does not exist");
		if(!adjacents(o).contains(d)) return Double.MAX_VALUE;

		for(Pair<V,Double> edge : adjacencyMap.get(o)) {
			if(edge.first().equals(d))
				return edge.second();
		}
		return Double.MAX_VALUE;
	}

	public List<V> toListBF() {
		int n = vertexCount;
		visited = new boolean[n];
		for(int i = 0; i < n; i++)
			visited[i] = false;
		List<V> resultList = new LinkedList<>();
		for(V v : indices.keySet())
			toListBF(v, resultList);
		return resultList;
	}

	public List<V> toListDF() {
		int n = vertexCount;
		visited = new boolean[n];
		for(int i = 0; i < n; i++) 
			visited[i] = false;
		List<V> resultList = new LinkedList<>();
		for(V v : indices.keySet())
			toListDF(v, resultList);
		return resultList;
	}

	private void toListBF(V v, List<V> list) {
		if(v == null) throw new NullPointerException();
		if(!adjacencyMap.containsKey(v)) throw new IllegalArgumentException("key does not exist");

		Queue<V> queue = new LinkedQueue<>();
		if(!visited[indices.get(v)]) // If v is not visited
			queue.enqueue(v);
		while(!queue.isEmpty()) {
			V u = queue.dequeue();
			visited[indices.get(u)] = true;
			list.add(u);
			for(V w : adjacents(u)) {
				if(!visited[indices.get(w)]) // if w is not visited
					queue.enqueue(w);
			}
		}
		
	}

	private void toListDF(V v, List<V> list) {
		if(v == null) throw new NullPointerException();
		if(!indices.containsKey(v)) throw new IllegalArgumentException("key does not exist");

		Stack<V> stack = new LinkedStack<>();
		if(!visited[indices.get(v)])
			stack.push(v);
		while(!stack.isEmpty()) {
			V u = stack.pop();
			visited[indices.get(u)] = true;
			list.add(u);
			for(V w : adjacents(u)) {
				if(!visited[indices.get(w)])
					stack.push(w);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void dijkstra(V s) {

		// Initialization

		previous = (V[]) new Object[vertexCount];
		distance = new double[vertexCount];
		visited = new boolean[vertexCount]; // Used to store the vertices with final distance
		for(int i = 0; i < vertexCount; i++) {
			previous[i] = null;
			distance[i] = Double.MAX_VALUE;
			visited[i] = false;
		}
		distance[indices.get(s)] = 0;


		PriorityQueue<V> queue = new PriorityQueue<>(vertexCount,
				(v1, v2) -> Double.compare(distance[indices.get(v1)], distance[indices.get(v2)]));
		queue.addAll(vertices());
		while(!queue.isEmpty()) {
			V u = queue.remove();
			visited[indices.get(u)] = true;
			for(V v : adjacents(u)) {
				int iV = indices.get(v);
				if(!visited[iV]) {
					double dU = distance[indices.get(u)];
					double wUV = getEdgeWeight(u,v);
					// Relax
					if(distance[iV] > dU + wUV) {
						distance[iV] = dU + wUV;
						previous[iV] = u;
						queue.remove(v);
						queue.add(v);
					}
				}
			}

		}
	}

	public List<V> getShortestPath(V s, V d) {
		if(s == null || d == null) throw new NullPointerException();
		if(!vertices().contains(s) || !vertices().contains(d)) throw new IllegalArgumentException("key does not exist");

		dijkstra(s);
		List<V> path = new LinkedList<>();
		path.add(d);
		if(s == d) return path;	// Case s == d
		if(previous[indices.get(d)] == null) return null; // Case no path between s and d
		V current = previous[indices.get(d)];
		while(current != null) {
			path.add(0,current);
			current = previous[indices.get(current)];
		}
		return path;
	}

	public Iterator<V> dfsIterator()
	{ return toListDF().iterator(); }

	public Iterator<V> bfsIterator()
	{ return toListBF().iterator(); }

	public Iterator<V> iterator()
	{ return bfsIterator(); }

	private final Map<V,Integer> indices;
	private int[][] allPairsPaths;
	private double[][] allPairsCosts;
	private boolean[] visited;
	private V[] previous;
	private double[] distance;

	private int vertexCount;

}
