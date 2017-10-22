package stack;

public class LinkedStack<E> implements Stack<E>
{
	private class Element
	{
		E data;
		Element next;
	} 

	private Element top; 

	public LinkedStack()
	{
		top = null; 
	}

	public boolean isEmpty()
	{ 
		return top == null; 
	}

	public void push(E x)
	{ 
		Element hilf = new Element(); 
		hilf.data = x; 
		hilf.next = top; 
		top = hilf; 
	}

	public E top()
	{
		if( isEmpty() )
			throw new RuntimeException("in LinkedStack.top");
		
		return top.data; 
	}
	
	public E pop()
	{ 
		if( isEmpty() )
			throw new RuntimeException("in LinkedStack.pop");
		
		E data = top.data;
		top = top.next;
		return data;
	}
	
	public String toString()
	{
		String  s = "";
		Element p = top;
		
		while( p != null )
		{
			s += p.data + " ";
			p  = p.next;
		}
		
		return s;
	}
}