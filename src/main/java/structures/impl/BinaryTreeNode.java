package structures.impl;

import structures.List;
import structures.IBinaryTreeNode;
import structures.ITreeNode;
import structures.Queue;

public class BinaryTreeNode<T> implements IBinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private BinaryTreeNode<T> parent;

	public BinaryTreeNode()
	{ this(null); }

	public BinaryTreeNode(T o) {
		data = o;
		left = null;
		right = null;
		parent = null;
	}

	public T getData()
	{ return data; }

	public void setData(T o)
	{ data = o; }

	public List<ITreeNode<T>> getChildren() {
		List<ITreeNode<T>> children = new LinkedList<>();
		if(left != null) children.add(left);
		if(right != null) children.add(right);

		return children;
	}

	public ITreeNode<T> getParent()
	{ return parent; }

	public void setParent(BinaryTreeNode<T> p)
	{ parent = p; }

	public IBinaryTreeNode<T> getLeftChild()
	{ return left; }

	public IBinaryTreeNode<T> getRightChild()
	{ return right; }

	public void setLeftChild(IBinaryTreeNode<T> node) {
		if(!(node instanceof BinaryTreeNode))
			throw new IllegalArgumentException("node type mismatch");
		BinaryTreeNode<T> concreteNode = (BinaryTreeNode<T>) node;

		if(concreteNode.parent != null)
			throw new IllegalStateException("node belongs to another tree");

		concreteNode.setParent(this);
		left = concreteNode;
	}

	public void setRightChild(IBinaryTreeNode<T> node) {
		if(!(node instanceof BinaryTreeNode))
			throw new IllegalArgumentException("node type mismatch");
		BinaryTreeNode<T> concreteNode = (BinaryTreeNode<T>) node;

		if(concreteNode.parent != null)
			throw new IllegalStateException("node belongs to another tree");

		concreteNode.setParent(this);
		right = concreteNode;
	}

	public int size() {
		int size = 1;
		if(left != null) size += left.size();
		if(right != null) size += right.size();
		return size;
	}

	public int height() {
		int leftHeight = (left != null) ? left.height() : 0;
		int rightHeight = (right != null) ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public void toListPreorder(List<T> list) {
		list.add(data);
		if(left != null) left.toListPreorder(list);
		if(right != null) right.toListPreorder(list);
	}

	public void toListInorder(List<T> list) {
		if(left != null) left.toListPreorder(list);
		list.add(data);
		if(right != null) right.toListPreorder(list);
	}

	public void toListPostorder(List<T> list) {
		if(left != null) left.toListPreorder(list);
		if(right != null) right.toListPreorder(list);
		list.add(data);
	}

	public BinaryTreeNode<T> findNode(Object o) {
		if(o == null) throw new NullPointerException();

		Queue<BinaryTreeNode<T>> queue = new LinkedQueue<>();
		queue.enqueue(this);
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> current = queue.dequeue();
			if(current.data.equals(o))
				return current;
			if(current.left != null) queue.enqueue(current.left);
			if(current.right != null) queue.enqueue(current.right);
		}
		return null;
	}

	public boolean remove(Object o) {
		if(o == null) return false;

		BinaryTreeNode<T> node = findNode(o);
		if(node == null) return false;

		if(node.left != null || node.right != null)
			throw new IllegalArgumentException("node to remove has children");
		
		if(node.parent != null) {
			if(node.parent.left == node)
				node.parent.left = null;
			else
				node.parent.right = null;
			return true;
		}

		return false;

	}

	public boolean add(T elem) {
		if(elem == null) return false;

		BinaryTreeNode<T> newNode = new BinaryTreeNode<>(elem);

		// Get first available position
		Queue<BinaryTreeNode<T>> queue = new LinkedQueue<>();
		queue.enqueue(this);
		BinaryTreeNode<T> parent = null;
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> current = queue.dequeue();
			if(current.left == null || current.right == null) {
				parent = current;
				break;
			}
			queue.enqueue(current.left);
			queue.enqueue(current.right);
		}

		if(parent.left == null)
			parent.setLeftChild(newNode);
		else
			parent.setRightChild(newNode);

		return true;
	}

	public boolean contains(Object o) {
		if(o == null) return false;

		Queue<BinaryTreeNode<T>> queue = new LinkedQueue<>();
		queue.enqueue(this);
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> current = queue.dequeue();
			if(current.data.equals(o))
				return true;
			if(current.left != null) queue.enqueue(current.left);
			if(current.right != null) queue.enqueue(current.right);
		}
		return false;
	}

}
