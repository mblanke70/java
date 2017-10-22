package stack;

public class ArrayStack<Item> implements Stack<Item>
{
	public static final int N = 10;

	Item[] a;		// speichert die Elemente
	int topindex;	// Anzahl der gespeicherten Elemente

	@SuppressWarnings("unchecked")		
	public ArrayStack()
	{
		a = (Item[]) new Object[N];
		topindex = 0;
	}

	@SuppressWarnings("unchecked")		
	public ArrayStack(int capacity)
	{
		a = (Item[]) new Object[capacity];
		topindex = 0;
	}

	public boolean isEmpty()
	{
		return topindex == 0;
	}

	public Item top()
	{
		if( isEmpty() )
			throw new RuntimeException("Keller.top: Keller leer");
				return a[topindex-1];
	}
	 
	public Item pop()
	{
		if( isEmpty() )
			throw new RuntimeException("Keller.pop: Keller leer");

		topindex--;
		Item elem = a[topindex];
		a[topindex] = null;
		return elem;
	}

	public void push(Item x)
	{
		if( topindex == a.length )
			throw new RuntimeException("Keller.push: Keller voll");

		a[topindex] = x;
		topindex++;
	}
	
	public String toString()
	{
		String s = "";
		
		for(int i=0; i<topindex; i++)
			s += a[i] + " ";
		
		return s;
	}
}