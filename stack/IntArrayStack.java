package stack;

/**
 * Diese Klasse modelliert einen Keller-Speicher auf Basis eines Arrays.
 * 
 * @author malte.blanke
 * @version 1.0
 */
public class IntArrayStack implements IntStack 
{
	private int[] a;
	private int topindex;
	
	/**
	 * Erzeugt einen leeren Keller mit 10 Speicherplätzen.
	 */
	public IntArrayStack()
	{
		a = new int[10];
		topindex = 0;
	}

	/**
	 * Liefert die Anzahl der im Keller gespeicherten Elemente
	 *
	 * @return Anzahl der Keller-Elemente
	 */
	public int size()
	{
		return topindex;
	}
	
	/**
	 * Prüft, ob der Keller leer ist.
	 * 
	 * @return true, wenn der Keller leer ist
	 */
	public boolean isEmpty() 
	{
		return topindex==0;
	}
	
	/**
	 * Prüft, ob der Keller voll ist.
	 * 
	 * @return true, wenn der Keller voll ist.
	 */
	public boolean isFull()
	{
		return topindex==a.length;
	}

	/**
	 * Liefert das oberste Keller-Element (ohne es zu löschen).
	 * 
	 * @return das oberste Keller-Element
	 */
	public int top() 
	{
		if( isEmpty() )
			throw new RuntimeException("in top: Keller leer!");
		
		return a[topindex-1];
	}

	/**
	 * Legt das übergebene Element oben auf den Keller.
	 * 
	 * @param x das zu speichernde Element
	 */
	public void push(int x) 
	{
		if( isFull() )
			throw new RuntimeException("in push: Keller voll!");
			
		a[topindex] = x;
		topindex++;
	}

	/**
	 * Liefert das oberste Keller-Element und löscht es aus dem Keller.
	 * 
	 * @return das oberste Keller-Element
	 */
	public int pop() 
	{
		if( isEmpty() )
			throw new RuntimeException("in pop: Keller leer!");
		
		topindex--;		
		return a[topindex];
	}
	
	/**
	 * Liefert eine String-Darstellung des Kellerinhalts
	 *
	 * @return String-Darstellung des Kellers 
	 */
	public String toString()
	{
		String s="";
		
		for(int i=0; i<topindex; i++)
			s += a[i] + " ";
		
		return s;
	}
}
