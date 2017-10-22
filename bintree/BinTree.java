package bintree;

public interface BinTree<E>
{ 
	public boolean    isEmpty();
	public boolean    isLeaf();
	public BinTree<E> getLeft();
	public BinTree<E> getRight();
	public BinTree<E> getParent();	
	public E          getValue();
	
	//public void       setRight(BinTree<E> b);
	//public void       setLeft (BinTree<E> b);
	//public void       setValue(E x);
}
