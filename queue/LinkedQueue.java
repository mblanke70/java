package queue;

public class LinkedQueue<E> implements Queue<E> 
{ 	
	private class Element
	{
		public E data;
		public Element next;  
	}

	private Element head;
	private Element tail;

	public LinkedQueue() 
	{ 
		head = tail = null;
	}
	
	public boolean empty() 
	{ 
		return head == null; 
	}

	public void offer(E x) 
	{
		Element newElement = new Element(); 
		newElement.data = x;
		
		if(empty())
			head = newElement;
		else
			tail.next = newElement;
		
		tail = newElement;
	}

	public E peek()
	{
		if(empty())
			throw new RuntimeException("Schlange.front: Schlange leer");
		
		return head.data;
	}

	public E poll() 
	{
		if(empty())
			throw new RuntimeException("Schlange.front: Schlange leer");
		
		Element p = head;
		head = head.next;
		return p.data;
	}
	
	public String toString()
	{
		String  s = "";
		Element p = head;
		
		while(p != null)
		{
			s += p.data + " ";
			p = p.next;
		}
		
		return s;
	}
}