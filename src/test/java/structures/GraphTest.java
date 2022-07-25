package structures;

import org.junit.Test;
import structures.impl.DirectedWeightedGraph;
import structures.impl.LinkedList;

import static org.junit.Assert.assertEquals;

public class GraphTest {

	@Test
	public void bfList() {
		DirectedWeightedGraph<Character> chg = new DirectedWeightedGraph<>();
		chg.addVertex('a');
		chg.addVertex('b');
		chg.addVertex('c');
		chg.addVertex('d');
		chg.addVertex('e');
		chg.addVertex('f');

		chg.addEdge('a','b');
		chg.addEdge('a','c');
		chg.addEdge('a','d');
		chg.addEdge('c','e');
		chg.addEdge('d','a');
		chg.addEdge('d','d');
		chg.addEdge('d','f');
		chg.addEdge('e','b');
		chg.addEdge('f','c');

		List<Character> expected = new LinkedList<>();
		expected.add('a');
		expected.add('b');
		expected.add('c');
		expected.add('d');
		expected.add('e');
		expected.add('f');

		assertEquals(expected, chg.toListBF());
	}

	@Test
	public void dijkstraTest() {
		DirectedWeightedGraph<Character> graph = new DirectedWeightedGraph<>();

		graph.addVertex('a');
		graph.addVertex('b');
		graph.addVertex('c');
		graph.addVertex('d');
		graph.addVertex('e');
		graph.addVertex('f');

		graph.addWeightedEdge('a','b',3);
		graph.addWeightedEdge('a','c',20);
		graph.addWeightedEdge('a','d',5);
		graph.addWeightedEdge('c','e',10);
		graph.addWeightedEdge('d','a',8);
		graph.addWeightedEdge('d','d',3);
		graph.addWeightedEdge('d','f',2);
		graph.addWeightedEdge('e','b',1);
		graph.addWeightedEdge('f','c',4);

		List<Character> expected = new LinkedList<>();
		expected.add('a');
		expected.add('d');
		expected.add('f');
		expected.add('c');

		assertEquals(expected, graph.getShortestPath('a','c'));

		expected.clear();
		expected.add('a');
		expected.add('d');
		expected.add('f');
		expected.add('c');
		expected.add('e');

		assertEquals(expected, graph.getShortestPath('a','e'));

		expected.clear();
		expected.add('a');

		assertEquals(expected, graph.getShortestPath('a','a'));
	}

}
