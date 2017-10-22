package stack;

public interface Stack<E> 
{
	public boolean isEmpty();   // liefert true, falls Keller leer, false sonst
	public void    push(E x); 	// legt Objekt x auf den Keller    
	public E       top();       // liefert oberstes Kellerelement
	public E       pop();       // entfernt und liefert oberstes Kellerelement
}