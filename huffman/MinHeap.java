package huffman;

import java.util.List;

public class MinHeap<E extends Comparable<E>>
{
	// ========== Datenfelder =================================

	private Object[] data;
	private int N;
	
	// ========== Konstruktor =================================

	
	public MinHeap()
	{
		data = new Object[100];
	}
	
	/**
	 * Erzeugt einen Heap aus einer unsortierten Folge von "vergleichbaren"
	 * Objekten, die als Array übergeben wird
	 * 
	 * @param a Zahlenfolge
	 */
	public MinHeap(List<E> l)
	{
		data = new Object[100];
		N = l.size();
		
		for(int i=0; i<N; i++)
			data[i] = l.get(i);
		
		for(int i=N/2-1; i>=0; i--)
			heapify(i);
	}

	// ========== Private Methoden für internen Gebrauch ======
	
	/**
	 * Die Methode bekommt einen Knoten i und geht davon aus,
	 * dass an diesem Knoten (sofern es sich um einen inneren Knoten
	 * handelt) Teilbäume hängen, die selbst Heaps sind. Der Baum, 
	 * der den Knoten i als Wurzel hat, ist dagegen nicht unbedingt
	 * ein Heap. 
	 * 
	 * Die Methode tauscht den Wert der Wurzel solange durch den Baum 
	 * nach unten (mit dem kleineren Sohn) bis die Heap-Eigenscnaft 
	 * erfüllt ist.
	 * 
	 *  @param i Wurzel des (Teil-) Baumes (Array-Index)
	 */
	private void heapify(int i)
	{
		int l = left(i);
		int r = right(i);
		
		boolean isHeap = false;
		
		// solange wir nicht fertig sind und es (mindestens) einen linken Sohn vom aktuellen Knoten i gibt...
		while(!isHeap && l<N)
		{
			// i ist Knoten mit zwei Söhnen
			if(r<N)
			{
				// Muss überhaupt getauscht werden?
				if(((E)data[l]).compareTo((E)data[i])<0 || ((E)data[r]).compareTo((E)data[i])<0)
				{
					// Ja
					if(((E)data[l]).compareTo((E)data[r])<0)
					{
						// Tauschen mit linkem Sohn
						swap(i, l);
						i = l;
					}
					else
					{
						// Tauschen mit rechtem Sohn
						swap(i, r);
						i = r; 
					}
				}
				else
				{
					// Nein, Heap-Eigenschaft erfüllt, fertig!
					isHeap = true;
				}
			}
			
			// Sonderfall: i ist Knoten, der nur einen linken Sohn hat
			else
			{
				// Tauschen mit linkem Sohn nötig?
				if(((E)data[l]).compareTo((E)data[i])<0)
				{
					// Ja
					swap(i, l);
					i = l;
				}

				// Heap-Eigenschaft ist jetzt auf jeden Fall erfüllt, fertig!
				isHeap = true;
			}
			
			// Falls getauscht worden ist, hat Knoten i neue Kinder
			l = left(i);
			r = right(i);
		}
	}
	
	/**
	 * Vertauscht die Elemente an den Array-Positionen i und j
	 */
	private void swap(int i, int j)
	{
		E temp = (E) data[j];
		data[j] = data[i];
		data[i] = temp;
	}
	
	/**
	 * Liefert den Index des linken Sohns
	 * 
	 * @param i Knotenindex
	 * @return Index des linken Sohns von Knoten i
	 */
	private int left(int i)
	{
		return 2*i+1;
	}

	/**
	 * Liefert den Index des rechten Sohns
	 * 
	 * @param i Knotenindex
	 * @return Index des rechten Sohns von Knoten i
	 */
	private int right(int i)
	{
		return 2*i+2;
	}
	
	/**
	 * Liefert den Index des Vaterknotens
	 * 
	 * @param i Knotenindex
	 * @return Index des Vaters von Knoten i
	 */
	private int parent(int i)
	{
		return (i-1)/2;
	}
	
	// ========== Öffentliche Methoden ========================

	/**
	 * Liefert das Minimum (den Wert des Wurzelknotens).
	 * 
	 * @return Das Minimum.
	 */
	public E minimum()
	{
		return (E) data[0];
	}

	/**
	 * Liefert und entfernt das Minimum (= den Wurzelknoten des Heaps).
	 * 
	 * Dazu wird der Wert der Wurzel mit dem Wert des "letzten" Knotens
	 * (unterste Ebene, ganz rechts) überschrieben. Anschließend wird
	 * dieser Wert im Baum mit Hilfe der Methode heapify() nach unten 
	 * "versickert".
	 * 
	 * @return Das Minimum.
	 */
	public E extractMin()
	{
		E min = minimum();
		data[0] = data[N-1];
		N--;
		
		heapify(0);
		
		return min;
	}

	/**
	 * Fügt ein Element in den Heap ein.
	 * 
	 * Dazu wird das Element zunächst auf der niedrigsten Ebene so weit links
	 * wie möglich eingefügt. Damit bleibt der Binärbaum vollständig bis auf
	 * die letzte Ebene. Falls das neu eingeüfgte Element die Heap-Eigenschaft
	 * verletzt, tauscht es mit seinem Vater. Dieser Schritt wird solange wiederholt,
	 * bis die Heap-Eigenschaft erfüllt ist oder das Element ganz oben steht, also
	 * die neue Wurzel des Heaps ist.
	 * 
	 * @param val Der Wert, der in den MinHeap eingefügt werden soll.
	 */
	public void insert(E val)
	{
		int i = N;
		data[i] = val;
		N++;
		
		while(i>0 && ((E) data[i]).compareTo((E) data[parent(i)])<0)
		{
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	/**
	 * Liefert die Anzahl der gespeicherten Elemente
	 * 
	 *  @return Anzahl der im MinHeap gespeicherten Elemente
	 */
	public int size()
	{
		return N;
	}
	
	/**
	 * Liefert eine String-Repräsentation des MinHeaps
	 * 
	 * @return MinHeap in Form einer Zeichenkette.
	 */
	public String toString()
	{
		String s = "";
		for(int i=0; i<N; i++)
			s += " " + data[i];
		
		return s;
	}
}
