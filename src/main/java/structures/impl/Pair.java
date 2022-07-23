package structures.impl;

public class Pair<A,B> {

	private A first;
	private B second;

	public Pair(A a, B b) {
		first = a;
		second = b;
	}

	public A first()
	{ return first; }

	public B second()
	{ return second; }

	public void setFirst(A a)
	{ first = a; }

	public void setSecond(B b)
	{ second = b; }

	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Pair)) return false;

		Pair<?,?> otherAsPair = (Pair<?,?>) other;
		return otherAsPair.first().equals(first) && otherAsPair.second().equals(second);
	}

}
