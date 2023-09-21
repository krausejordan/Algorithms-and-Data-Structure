public class Recursion 
{

	public static void main(String[] args)
	{
		String a = "DFEFFFFFG";
		String b = "ABAEFGCC";
		String c = b + a;
		System.out.println("Slip: " + a + " is " + isSlip(a));
		System.out.println("Slap: " + b + " is " + isSlap(b));
		System.out.println("Slop: " + c + " is " + isSlop(c));
	}
	//O(n)
	public static boolean isSlop(String a)
	{
		//Find the last 'c' in the string
		int lastIndex = a.lastIndexOf("C");
		
		//If there is no 'C'...
		if(lastIndex == -1)
		{
			//Find last H
			lastIndex = a.lastIndexOf("H");
			
			//If there is no 'H'... not a slop
			if(lastIndex != 1)
			{
				return false;
			}
		}
		//If there is a slap followed by a slip... then its a slop
		if(isSlap(a.substring(0, lastIndex + 1)) && isSlip(a.substring(lastIndex + 1)))
		{
			return true;
		}
		return false;
	}
	//O(n)
	public static boolean isSlap(String a)
	{
		//check to see if it starts with 'A'
		if(a.charAt(0) != 'A')
		{
			return false;
		}
		//if its only 2 elements, is the second one 'H'
		if(a.length() == 2) 
		{
			if(a.charAt(1) == 'H')
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		//is it long enough and ends in 'C'
		if(a.length() < 5 || a.charAt(a.length()-1) != 'C')
		{
			return false;
		}
		//if there is a b, then followed by a slap or is 'A' followed by a slip
		if((a.charAt(1) == 'B' && isSlap(a.substring(2,a.length()-1))) || isSlip(a.substring(1,a.length()-1)))
		{
			return true;
		} 
		
		return false;
	}
	
	//O(n)
	public static boolean isSlip(String a)
	{
		//Does it start with 'D' or 'E'
		if(a.charAt(0) != 'D' && a.charAt(0) != 'E')
		{
			return false;
		}
		
		//Followed by an 'F'?
		if(a.charAt(1) == 'F')
		{			
			//check for more 'F's
			for(int i = 2; i < a.length() - 1; i++)
			{
				if(a.charAt(i) != 'F')
				{
					//if not a slip return false
					if(!isSlip(a.substring(i)))
					{
						return false;
					}
				}
			}
		}
		else
		{
			return false;
		}
		//Check the end is 'G'
		if(a.charAt(a.length() - 1) != 'G') 
		{
			return false;
		}
		return true;
	}
}
