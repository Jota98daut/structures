package structures;

import java.util.Collection;

public interface Tree<T> extends Collection<T> {

	public ITreeNode<T> getRoot();

	public List<ITreeNode<T>> getChildren(ITreeNode<T> node);

	public int size();

	public int height();

	public boolean isEmpty();

	public void clear();

	public List<T> toList();

	public List<T> toList(Order order);

	public void add(ITreeNode<T> node, T o);

}
