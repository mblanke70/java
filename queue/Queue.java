package queue;

public interface Queue<E> 
{ 
	public void offer(E x); 
	public E poll(); 
	public E peek(); 
	public boolean empty(); 
}

