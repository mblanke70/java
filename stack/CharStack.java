package stack;

public interface CharStack 
{
	/**
	 * Prüft, ob der Keller leer ist.
	 * 
	 * @return true, wenn der Keller leer ist
	 */
	boolean isEmpty();
	
	/**
	 * Prüft, ob der Keller voll ist.
	 * 
	 * @return true, wenn der Keller voll ist
	 */
	boolean isFull();
	
	/**
	 * Liefert das oberste Keller-Element (ohne es zu löschen).
	 * 
	 * @return das oberste Keller-Element
	 */
	char top();
	
	/**
	 * Legt das übergebene Element oben auf den Keller.
	 * 
	 * @param x das zu speichernde Element
	 */
	void push(char x);
	
	/**
	 * Löscht und liefert das oberste Keller-Element.
	 * 
	 * @return das oberste Keller-Element
	 */
	char pop();
	
	/**
	 * Liefert die Anzahl der im Keller gespeicherten Elemente
	 *
	 * @return Anzahl der Keller-Elemente
	 */
	int size();
}
