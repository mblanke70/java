package bintree;

public class LinkedBinTree<E extends Comparable<E>> implements BinTree<E>, Comparable<LinkedBinTree<E>>
{	
	private class Node
	{
		E value;
		Node left, right, parent;
	    
		public Node(E x) 
		{       
			value = x;
		}  
	} 		
	
	public int compareTo(LinkedBinTree<E> other)
	{
		return root.value.compareTo(other.root.value);
	}
	
	private Node root;
  
	public LinkedBinTree() 
	{
		root = null;
	}

	public LinkedBinTree(E x) 
	{
		root = new Node(x);
	}
  
	public LinkedBinTree(LinkedBinTree<E> l, E x, LinkedBinTree<E> r) 
	{
		root = new Node(x);
		
		if (l != null) { setLeft(l);  l.setParent(this); }  // root.left  = l.root; l.root.parent = root; }
		if (r != null) { setRight(r); r.setParent(this); }  //root.right = r.root; r.root.parent = root; }
	}

	private LinkedBinTree(Node k) 
	{
		root = k;
	}

	public boolean isEmpty() 
	{
		return root == null;
	}

	public E getValue() 
	{
		if( isEmpty() )
			throw new RuntimeException("in BinTree.getValue");
		
		return root.value;
	}
	
	public void setLeft   (LinkedBinTree<E> l) { root.left   = l.root; }
	public void setRight  (LinkedBinTree<E> r) { root.right  = r.root; }
	public void setParent (LinkedBinTree<E> p) { root.parent = p.root; }
	public void setValue  (E x)                { root.value  = x;      }
	
	public LinkedBinTree<E> getLeft() 
	{
		if( isEmpty() )
			throw new RuntimeException("in BinTree.getLeft");
		
		return new LinkedBinTree<E>(root.left);
	}

	public LinkedBinTree<E> getRight() 
	{
		if( isEmpty() )
			throw new RuntimeException("in BinTree.getRight");
		
		return new LinkedBinTree<E>(root.right);
	}
	
	public LinkedBinTree<E> getParent() 
	{
		if( isEmpty() )
			throw new RuntimeException("in BinTree.getParent");
		
		return new LinkedBinTree<E>(root.parent);
	}
	
	public boolean isLeaf()
	{
		if( isEmpty() )
			throw new RuntimeException("in BinTree.isLeaf");
	
		return root.left == null && root.right == null;
	}
	
	public String toString()
	{
		return root.value.toString();
	}
}