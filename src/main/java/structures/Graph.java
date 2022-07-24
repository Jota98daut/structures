package structures;

import java.util.Iterator;
import java.util.Set;

public interface Graph<V> extends Iterable<V> {
	
	public Set<V> vertices();

	public Set<V> adjacents(V v);

	public int vertexCount();

	public int edgeCount(V v);

	public boolean addVertex(V v);

	public boolean addEdge(V o, V d);

	public boolean removeVertex(V v);

	public boolean removeEdge(V o, V d);

	public Iterator<V> dfsIterator();

	public Iterator<V> bfsIterator();

	private static void warshall(double[][] g, int[][] path, double[][] cost) {
		int n = g.length;
		initialize(g, path, cost);
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(cost[i][k] + cost[k][j] < cost[i][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
						path[i][j] = k;
					}
				}
			}
		}
	}

	private static void initialize(double[][] graph, int[][] path, double[][] cost) {
		int n = graph.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				cost[i][j] = graph[i][j];
				if(graph[i][j] < Double.MAX_VALUE)
					path[i][j] = i;
			}
		}
	}

}
