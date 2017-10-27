package stack;

public class Test 
{
	public static void main(String[] args) 
	{
		IntStack s = new IntArrayStack();
		
		//System.out.println(s.pop());
		//System.out.println(s.top());
		
		s.push(4);
		s.push(7);
		s.push(8);
		s.push(9);

		System.out.println(s.top());
		System.out.println(s.pop());
		System.out.println(s.top());
		
		System.out.println(s);
	}
}
