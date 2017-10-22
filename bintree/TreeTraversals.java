package bintree;

import java.util.*;

public class TreeTraversals 
{
	public static <E> void preorder(BinTree<E> t) 
	{
		if( !t.isEmpty() )
		{
			System.out.print(t.getValue() +  " ");
			preorder(t.getLeft());
			preorder(t.getRight());
		}
	}
	
	public static <E> void postorder(BinTree<E> t) 
	{
		if( !t.isEmpty() )
		{
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getValue() +  " ");
		}
	}
	
	public static <E> void inorder(BinTree<E> t) 
	{	
		if( !t.isEmpty() )
		{
			inorder(t.getLeft());	
			System.out.print(t.getValue()+ " ");
			inorder(t.getRight());
		}
	}
	
	public static <E> void levelorder(BinTree<E> t)
	{
		Queue<BinTree<E>> q = new LinkedList<BinTree<E>>();
		q.add(t);
		
		while( !q.isEmpty() )
		{
			t = q.poll();
			System.out.print(t.getValue() + " ");
			
			if( !t.getLeft().isEmpty() )
				q.add(t.getLeft());
			
			if( !t.getRight().isEmpty() )
				q.add(t.getRight());
		}
	}
}