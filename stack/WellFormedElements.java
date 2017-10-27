package stack;

import java.util.Scanner;

public class WellFormedElements 
{
	public static boolean isWellFormed(String t)
	{
		CharStack s = new CharArrayStack();
		
		for(int i=0; i<t.length(); i++)
		{
			char c = t.charAt(i);
			
			if( c=='(' ) 
			{
				s.push('(');
			}
			else 
			{
				if( s.isEmpty() ) 
				{
					return false;
				}
				s.pop();
			}
		}
		
		if( s.isEmpty() )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		String t = s.nextLine();
		s.close();
		
		if( isWellFormed(t) )
			System.out.println("well-formed");
		else
			System.out.println("NOT well-formed");
	}
}