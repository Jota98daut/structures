package structures;

public interface IBinaryTree<T> extends Tree<T> {

	public IBinaryTree<T> leftChild(ITreeNode<T> node);

	public IBinaryTree<T> rightChild(ITreeNode<T> node);

}
