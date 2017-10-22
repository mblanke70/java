package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

// https://algs4.cs.princeton.edu/13stacks/FixedCapacityStack.java.html

public class FixedCapacityStack<Item> implements Iterable<Item> 
{
    private Item[] a;    // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStack(int capacity) 
    {
        a = (Item[]) new Object[capacity];   // no generic array creation
        N = 0;
    }

    public boolean isEmpty()          {  return N == 0;                     }
    public void push(Item item)       {  a[N++] = item;                     }
    public Item pop()                 {  return a[--N];                     }
    public Iterator<Item> iterator()  {  return new ReverseArrayIterator(); }


    public class ReverseArrayIterator implements Iterator<Item> 
    {
        private int i = N-1;

        public boolean hasNext() 
        {
            return i >= 0;
        }

        public Item next() 
        {
            if (!hasNext()) throw new NoSuchElementException();
            	return a[i--];
        }

        public void remove() 
        {
            throw new UnsupportedOperationException();
        }
    }
} 