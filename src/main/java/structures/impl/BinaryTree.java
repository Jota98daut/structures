package structures.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.function.Predicate;
import structures.IBinaryTree;
import structures.ITreeNode;
import structures.IBinaryTreeNode;
import structures.Order;
import structures.List;
import structures.Queue;

public class BinaryTree<T> implements IBinaryTree<T> {

	private BinaryTreeNode<T> root;
	private int size;

	public BinaryTree(BinaryTreeNode<T> root) {
		this.root = root;
		size = (root != null) ? root.size() : 0;
	}

	public BinaryTree()
	{ this(null); }

	public ITreeNode<T> getRoot()
	{ return root; }

	public List<ITreeNode<T>> getChildren(ITreeNode<T> node) {
		List<ITreeNode<T>> children = new ArrayList<>();
		ITreeNode<T> left = root.getLeftChild();
		ITreeNode<T> right = root.getRightChild();
		if(left != null) children.add(left);
		if(right != null) children.add(right);
		return children;
	}

	public int size()
	{ return size; }

	public int height() 
	{ return root.height(); }

	public boolean isEmpty()
	{ return root == null; }

	public void clear() {
		root = null;
		size = 0;
	}

	public List<T> toList()
	{ return toList(Order.INORDER); }

	public List<T> toList(Order order) {
		List<T> list = new ArrayList<>(size);
		switch(order) {
			case PREORDER:
				root.toListPreorder(list);
				break;
			case INORDER:
				root.toListInorder(list);
				break;
			case POSTORDER:
				root.toListPostorder(list);
				break;
			default:
				break;
		}

		return list;
	}

	public void addLeft(BinaryTreeNode<T> target, T o) {
		if(target == null)
			throw new NullPointerException("null node");
		
		IBinaryTreeNode<T> left = target.getLeftChild();

		if(left != null)
			throw new IllegalStateException("target has a left child already");
		BinaryTreeNode<T> newNode = new BinaryTreeNode<>(o);
		target.setLeftChild(newNode);
	}

	public void addRight(BinaryTreeNode<T> target, T o) {
		if(target == null)
			throw new NullPointerException("null node");
		
		IBinaryTreeNode<T> right = target.getRightChild();

		if(right != null)
			throw new IllegalStateException("target has a right child already");
		BinaryTreeNode<T> newNode = new BinaryTreeNode<>(o);
		target.setRightChild(newNode);
	}

	public void add(ITreeNode<T> node, T o) {
		if(!(node instanceof BinaryTreeNode))
			throw new IllegalArgumentException("node is not BinaryTreeNode");

		BinaryTreeNode<T> concreteNode = (BinaryTreeNode<T>) node;

		if(concreteNode.getLeftChild() == null)
			addLeft(concreteNode, o);
		else if(concreteNode.getRightChild() == null)
			addRight(concreteNode, o);
		else
			throw new IllegalStateException("target node has both children already");
	}

	public IBinaryTree<T> leftChild(ITreeNode<T> node) {
		if(!(node instanceof BinaryTreeNode))
			throw new IllegalArgumentException("node is not BinaryTreeNode");

		BinaryTreeNode<T> concreteNode = (BinaryTreeNode<T>) node;
		BinaryTreeNode<T> left = (BinaryTreeNode<T>) concreteNode.getLeftChild();
		return new BinaryTree<>(left);
	}

	public IBinaryTree<T> rightChild(ITreeNode<T> node) {
		if(!(node instanceof BinaryTreeNode))
			throw new IllegalArgumentException("node is not BinaryTreeNode");

		BinaryTreeNode<T> concreteNode = (BinaryTreeNode<T>) node;
		BinaryTreeNode<T> right = (BinaryTreeNode<T>) concreteNode.getRightChild();
		return new BinaryTree<>(right);
	}

	@Override
	public boolean remove(Object o) 
	{ return root.remove(o); }

	public BinaryTreeNode<T> findNode(Object o) 
	{ return root.findNode(o); }

	@Override
	public boolean add(T elem) 
	{ return root.add(elem); }

	@Override
	public Object[] toArray()
	{ return toList().toArray(); }

	@Override
	public Iterator<T> iterator()
	{ return iterator(Order.INORDER); }

	public Iterator<T> iterator(Order order) 
	{ return toList(order).iterator(); }

	@Override
	public boolean contains(Object o)
	{ return root.contains(o); }

	@Override
	public boolean retainAll(Collection<?> col) { throw new UnsupportedOperationException(); }

	@Override
	public boolean removeAll(Collection<?> col) { throw new UnsupportedOperationException(); }

	@Override
	public boolean addAll(Collection<? extends T> col) { throw new UnsupportedOperationException(); }

	@Override
	public boolean containsAll(Collection<?> col) { throw new UnsupportedOperationException(); }

	@Override
	public <E> E[] toArray(E[] a) { throw new UnsupportedOperationException(); }

	@Override
	public Spliterator<T> spliterator() { throw new UnsupportedOperationException(); }

	@Override
	public int hashCode() { throw new UnsupportedOperationException(); }

	@Override
	public Stream<T> parallelStream() { throw new UnsupportedOperationException( "unsupported operation" ); }

	@Override
	public Stream<T> stream() { throw new UnsupportedOperationException( "unsupported operation" ); }

	@Override
	public boolean removeIf(Predicate<? super T> filter) { throw new UnsupportedOperationException( "unsupported operation" ); }

	@Override
	public boolean equals(Object o) { throw new UnsupportedOperationException(); }

}
