package bintree;

import java.util.*;

public class TreeTest 
{
	/*
	 *          21
	 *        /    \
	 *       1      9
	 *      / \    / \
	 *     12  2  7  42
	 */
	public static void main(String[] args) 
	{
		LinkedBinTree<Integer> b1 = new LinkedBinTree<Integer>(12);
		LinkedBinTree<Integer> b2 = new LinkedBinTree<Integer>(2);
		LinkedBinTree<Integer> b3 = new LinkedBinTree<Integer>(7);
		LinkedBinTree<Integer> b4 = new LinkedBinTree<Integer>(42);
		LinkedBinTree<Integer> b5 = new LinkedBinTree<Integer>(b1, 1,  b2);
		LinkedBinTree<Integer> b6 = new LinkedBinTree<Integer>(b3, 9,  b4);
		LinkedBinTree<Integer> b7 = new LinkedBinTree<Integer>(b5, 21, b6);		
		
		TreeTraversals.preorder(b7);
		System.out.println();
		TreeTraversals.postorder(b7);
		System.out.println();
		TreeTraversals.inorder(b7);
		System.out.println();
		TreeTraversals.levelorder(b7);
		
		System.out.println("\n---------------------------------------------------");
		Iterator<BinTree<Integer>> it = TreeTraversals2.iteratorPreorder(b7);
		while( it.hasNext() )
			System.out.print(it.next().getValue() + " ");

		System.out.println();
		
		it = TreeTraversals2.iteratorPostorder(b7);
		while( it.hasNext() )
			System.out.print(it.next().getValue() + " ");
		
		System.out.println();

		it = TreeTraversals2.iteratorInorder(b7);
		while( it.hasNext() )
			System.out.print(it.next().getValue() + " ");
		
		System.out.println();

		it = TreeTraversals2.levelorder(b7);
		while( it.hasNext() )
			System.out.print(it.next().getValue() + " ");
	}
}
