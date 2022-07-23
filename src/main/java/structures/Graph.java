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

}
