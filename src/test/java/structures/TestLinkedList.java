package structures;

import java.util.Iterator;
import org.junit.Test;
import structures.List;
import structures.impl.LinkedList;

public class TestLinkedList {

	@Test
	public void testLinkedList() {

		System.out.println( "Test creation, insertion, deletion and printing..." );
		List<Integer> l1 = new LinkedList<>();
		for( int i = 0; i < 10; i++ )
			l1.add( 2*i );
		l1.add( 3, 5 );
		l1.remove( 4 );
		l1.remove( (Integer) 12 );


		System.out.println( l1 );

		System.out.println( "\nTest iterator..." );
		Iterator<Integer> itr = l1.iterator();
		while( itr.hasNext() )
			System.out.print( itr.next() + " " );
		System.out.println();

		System.out.println( "\nTest for each..." );
		for( Integer n : l1 )
			System.out.print(n + " ");
		System.out.println();

	}

}
