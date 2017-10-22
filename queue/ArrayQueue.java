package queue;

public class ArrayQueue<E> implements Queue<E> 
{
	public static final int N = 10;

	private E[] elementData;
	private int head;
	private int count;

	@SuppressWarnings("unchecked")	
	public ArrayQueue() 
	{
		elementData = (E[]) new Object[N];
		head = count = 0;
	}

	@SuppressWarnings("unchecked")	
	public ArrayQueue(int n) 
	{	
		elementData = (E[]) new Object[n];	
		head = count = 0;
	}

	public boolean empty() 
	{
		return count == 0;
	}

	public E peek() 
	{
		if( empty() )
			throw new RuntimeException("Schlange.front: Schlange leer");	
		
		return elementData[head];
	}
	
	public E poll() 
	{
		if( empty() )
			throw new RuntimeException("Schlange.deq: Schlange leer");
		
		elementData[head] = null;
		count--;
		
		int i = head;
		head = (head + 1) % elementData.length;
		return elementData[i];
	}

	public void offer(E x) 
	{	
		if( count == elementData.length )
			throw new RuntimeException("Schlange.enq: Schlange voll");
		
		  
		elementData[(head + count) % elementData.length] = x;
		count++;
	}

  	public String toString()
  	{
  		String s = "";
  		ArrayQueue<E> temp = new ArrayQueue<E>();
  		
  		while(!empty()){
  			s += peek() + " ";
  			temp.offer(peek());
  			poll();
  		}
  		
  		while(!temp.empty()){
  			offer(temp.peek());
  			temp.poll();
  		}
  		
  		return s;
  	}
}