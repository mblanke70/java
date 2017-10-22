package huffman;

public class HuffNode implements Comparable<HuffNode> 
{
	public HuffNode left;
	public HuffNode right;
	public HuffNode parent;
	
	public int value;
	public Character data;
	
	// Erzeugt einen inneren Knoten
	public HuffNode(HuffNode l, HuffNode r)
	{
		left  = l;
		right = r;
		value = l.value + r.value; 
		l.parent = r.parent = this;
	}
	
	// Erzeugt einen Blatt-Knoten
	public HuffNode(int v, char c)
	{
		value = v;
		data  = c;
	}
	
	// Vergleicht zwei Knoten anhand ihres Wertes
	public int compareTo(HuffNode n)
	{
		if(value<n.value)
			return -1;
		else if(value>n.value)
			return 1;
		else
			return 0;
	}
	
	// Liefert eine String-Repräsentation des Knoten-Objekts
	public String toString()
	{
		String s = "";
	
		s += "[ value=" + value + " ";
		if(data!=null)
			s += "| data=" + data + " ";
		if(left!=null) 
			s+= ": left =" + left;
		if(right!=null) 
			s+= ": right=" + right;
		s += "]";
	
		return s;
	}
}