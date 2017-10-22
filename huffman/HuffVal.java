package huffman;

public class HuffVal implements Comparable<HuffVal>
{
	public int count;
	public Character data;
	public String code;
	
	public HuffVal(int v, char c)
	{
		count = v;
		data  = c;
		code = "";
	}
	
	public HuffVal(int v)
	{
		count = v;
	}
	
	public int compareTo(HuffVal other)
	{
		if(this.count>other.count)
			return 1;
		else if(this.count<other.count)
			return -1;
		else
			return 0;
	}

	public String toString()
	{
		return count + " " + data;
	}
}
