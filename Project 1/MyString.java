package app;

public class MyString 
{
	//Declare variables
	private int curr_length;
	private char[] charArr;
	
	//O(1)
	//Non parameterized constructor
	public MyString()
	{
		//Initialize variables
		charArr = null;
		curr_length = 0;
	}
	//O(n)
	//Parameterized constructor
	public MyString(String input)
	{
		//Initialize variables
		curr_length = input.length();
		charArr = new char[curr_length];
		
		//Populate array
		for(int i = 0; i < curr_length; i++)
		{
			charArr[i] = input.charAt(i);
		}
	}
	//O(n)
	//Copy constructor
	public MyString(MyString copy)
	{
		//Initialize variables
		curr_length = copy.length();
		charArr = new char[curr_length];
		
		//Populate array
		for(int i = 0; i < curr_length; i++)
		{
			charArr[i] = copy.get(i);
		}
	}
	//O(1)
	//Return current length of array
	public int length()
	{
		return curr_length;
	}
	//O(1)
	//Return array
	public String toString()
	{
		return new String(charArr);
	}
	//O(n)
	//Concatenated two objects into one array
	public MyString concat(MyString input)
	{
		//Create new array with longer length
		char[] newCharArr = new char[curr_length + input.length()];
		
		//Populate array
		for(int i = 0; i < curr_length; i++)
		{
			newCharArr[i] = charArr[i]; 
		}
		//Add input to array
		for(int i = 0; i < input.length(); i++)
		{
			newCharArr[curr_length + i] = input.get(i);
		}
		return new MyString(new String(newCharArr));
	}
	//O(n)
	//Compare two strings
	public int compareTo(MyString input)
	{
		//Loop through the entire array
		for(int i = 0; i < curr_length; i++)
		{
			//if index of char > input index return 1
			if(charArr[i] > input.get(i))
			{
				return 1;
			}
			//if index of char < input index return -1
			else if(charArr[i] < input.get(i))
			{
				return -1;
			}
		}
		//Other wise return 0
		return 0;
	}
	//O(n)
	//Test if equal
	public boolean equals(MyString input)
	{
		//if lengths aren't equal
		if(curr_length != input.length())
		{
			return false;
		}
		else
		{
			//if equal lengths, check each index
			for(int i = 0; i < curr_length; i++)
			{
				if(charArr[i] != input.get(i))
				{
					return false;
				}
			}
		}
		return true;
	}
	//O(1)
	//Get index
	public char get(int i)
	{
		//Return element at specified index
		return charArr[i];
	}
	//O(n)
	//Change string to all upper case
	public MyString toUpper()
	{
		//Create new array
		char[] newCharArr = new char[curr_length];
		
		//Loop thru entire array
		for(int i = 0; i < curr_length; i++)
		{
			//if lower case, change to upper case
			if(charArr[i] >= 97 && charArr[i] <= 122)
			{
				newCharArr[i] = (char)(charArr[i] - 32);
				
			}
			else
			{
				//Leave as is
				newCharArr[i] = charArr[i];
			}
		}
		return new MyString(new String(newCharArr));
	}
	//O(n)
	//Change string to lower case
	public MyString toLower()
	{
		//Create new array
		char[] newCharArr = new char[curr_length];
		
		//Loop through entire array
		for(int i = 0; i < curr_length; i++)
		{
			//if upper case, change to lower
			if(charArr[i] >= 65 && charArr[i] <= 90)
			{
				newCharArr[i] = (char)(charArr[i] + 32);
			}
			else
			{
				//Leave array as is
				newCharArr[i] = charArr[i];
			}
		}
		return new MyString(new String(newCharArr));
	}
	//O(n)
	//return string from a certain index on
	public MyString substring(int i)
	{
		//Check length
		if(i > curr_length || i < 0)
		{
			return new MyString("Index out of bounds");
		}
		else
		{	
			//Create new array
			char[] newCharArr = new char[curr_length - i];
			for(int j = 0; j < (curr_length - i); j++)
			{
				//Populate array from index on
				newCharArr[j] = charArr[i + j]; 
			}
			return new MyString(new String(newCharArr));
		}
	}
	//O(n)
	//Return string from within the boundaries
	public MyString substring(int n, int m)
	{
		//If not within bounds, return error message
		if(n > curr_length || n < 0 || m > curr_length || m < 0 || m < n)
		{
			return new MyString("Index out of bounds");
		}
		else
		{
			//Create new array and populate between bounds
			char[] newCharArr = new char[m-n];
			for(int i = 0; i < (m-n); i++)
			{
				newCharArr[i] = charArr[n+1];
			}
			return new MyString(new String(newCharArr));
		}
	}
	//O(n^2)
	//Find first case of the input from the array
	public int indexOf(MyString input)
	{	
		for(int i = 0; i < curr_length; i++)
		{
			//Find first letter of input 
			if(charArr[i] == input.get(0))
			{
				//check the for the next letter
				int j = 0;
				for(j = 0; j < input.length(); j++)
				{
					if(charArr[i + j] != input.get(j))
					{
						break;
					}
				}
				//If the input is found, return the index
				if(j == input.length())
				{
					return i;
				}
			}
			
		}
		return -1;
	}
	//O(n^2)
	//Find the last case of the input from the array
	public int lastIndexOf(MyString input)
	{
		//Start from the end of the array
		for(int i = curr_length - 1; i < curr_length; i--)
		{
			//Find the first letter of the input
			if (charArr[i] == input.get(0))
			{
				int j = 0;
				//check the for the next letter
				for(j = 0; j < input.length(); j++)
				{
					if(charArr[i + j] != input.get(j))
					{
						break;
					}
				}
				//If the input is found, return the index
				if(j == input.length())
				{
					return i;
				}
			}
		}
		return -1;
	}
}
