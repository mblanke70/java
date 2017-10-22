package huffman;

import bintree.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Huffman 
{	
	LinkedBinTree<HuffVal> root;
	Map<Character, String> encodeMap;
	String plain;
	
	public Huffman(String s)
	{
		plain = s;
		
		// Huffman-Baum aufbauen
		int[] counter = new int[128];
		
		for(char c : s.toCharArray())
			counter[c]++;
		
		MinHeap<LinkedBinTree<HuffVal>> q = new MinHeap<LinkedBinTree<HuffVal>>(); 
		for(int i=0; i<128; i++)
			if(counter[i]>0)
				q.insert(new LinkedBinTree<HuffVal>(new HuffVal(counter[i], (char) i)));
		
		while(q.size()>1)
		{
			LinkedBinTree<HuffVal> a = q.extractMin();
			LinkedBinTree<HuffVal> b = q.extractMin();
			
			q.insert(new LinkedBinTree<HuffVal>(a, new HuffVal(a.getValue().count + b.getValue().count), b));
		}
		
		root = q.extractMin();

		encodeMap = new HashMap<Character, String>();
		
		Iterator<BinTree<HuffVal>> it = TreeTraversals2.iteratorPreorder(root);
		String code;
		
		while( it.hasNext() )
		{
			BinTree<HuffVal> t = it.next();
			if( t.isLeaf()  )
			{
				char c = t.getValue().data;
				code = "";
				while( !t.getParent().isEmpty() )
				{
					code = (t.getParent().getLeft().getValue() == t.getValue() ? "0" : "1") + code;
					t = t.getParent();
				}
				
				encodeMap.put(c, code);
			}
		}		
	}
	
	public String encode()
	{
		String code = "";
		for(char c : plain.toCharArray())
			code += encodeMap.get(c);

		return code;
	}
	
	public String decode()
	{
		String code = encode();
		BinTree<HuffVal> p = root;
		String plain = "";
		
		for(int i=0; i<code.length(); i++)
		{
			if( p.isLeaf() )
			{
				plain += p.getValue().data;
				p = root;
			}
			
			if( code.charAt(i) == '0' )
				p = p.getLeft();
			else
				p = p.getRight();
		}
		
		plain += p.getValue().data;
		
		return plain;
	}
	
	public static void main(String[] args) 
	{
		Huffman huf = new Huffman("ACHTALTEAMEISENASSENAMABENDANANAS");
		
		System.out.println(huf.plain);
		System.out.println(huf.encodeMap);
		
		System.out.println(huf.encode());
		System.out.println(huf.encode().length());
		System.out.println(huf.decode());
	}
}