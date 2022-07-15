package structures;

public interface IBinaryTreeNode<T> extends ITreeNode<T> {

	public IBinaryTreeNode<T> getLeftChild();

	public IBinaryTreeNode<T> getRightChild();

	public void setLeftChild(IBinaryTreeNode<T> node);

	public void setRightChild(IBinaryTreeNode<T> node);

}
