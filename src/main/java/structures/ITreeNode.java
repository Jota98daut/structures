package structures;

public interface ITreeNode<T> {

	public T getData();

	public void setData(T o);

	public List<ITreeNode<T>> getChildren();

	public ITreeNode<T> getParent();

	public int size();

	public int height();

}
