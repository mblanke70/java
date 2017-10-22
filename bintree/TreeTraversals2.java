package bintree;

import java.util.*;

public class TreeTraversals2 
{
	public static <E> Iterator<BinTree<E>> iteratorPreorder(BinTree<E> t)
	{
		ArrayList<BinTree<E>> templist = new ArrayList<BinTree<E>>();
	    preorder(t, templist);
	    return templist.iterator();
	}
	
	public static <E> void preorder(BinTree<E> t, ArrayList<BinTree<E>> templist) 
	{
		if( !t.isEmpty() )
		{
			templist.add(t);
			preorder(t.getLeft(), templist);
			preorder(t.getRight(), templist);
		}
	}
	
	public static <E> Iterator<BinTree<E>> iteratorPostorder(BinTree<E> t)
	{
		ArrayList<BinTree<E>> templist = new ArrayList<BinTree<E>>();
	    postorder(t, templist);
	    return templist.iterator();
	}
	
	public static <E> void postorder(BinTree<E> t, ArrayList<BinTree<E>> templist) 
	{
		if( !t.isEmpty() )
		{
			postorder(t.getLeft(), templist);
			postorder(t.getRight(), templist);
			templist.add(t);
		}
	}
	
	public static <E> Iterator<BinTree<E>> iteratorInorder(BinTree<E> t)
	{
		ArrayList<BinTree<E>> templist = new ArrayList<BinTree<E>>();
	    inorder(t, templist);
	    return templist.iterator();
	}
	
	public static <E> void inorder(BinTree<E> t, ArrayList<BinTree<E>> templist) 
	{	
		if( !t.isEmpty() )
		{
			inorder(t.getLeft(), templist);	
			templist.add(t);
			inorder(t.getRight(), templist);
		}
	}
	
	public static <E> Iterator<BinTree<E>> levelorder(BinTree<E> t)
	{
		ArrayList<BinTree<E>> templist = new ArrayList<BinTree<E>>();
		Queue<BinTree<E>> q = new LinkedList<BinTree<E>>();
		q.add(t);
		
		while( !q.isEmpty() )
		{
			t = q.poll();
			templist.add(t);
			
			if( !t.getLeft().isEmpty() )
				q.add(t.getLeft());
			
			if( !t.getRight().isEmpty() )
				q.add(t.getRight());
		}
		
		return templist.iterator();
	}
}