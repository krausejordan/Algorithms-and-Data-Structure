//Jordan Krause

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyString 
{

	public static void main(String[] args) 
	{
		//Declare and initialize variables
		int increment = 0;
		String[] words = new String[10];
		Scanner fileInput = null;
		try
		{
			//Read file
			fileInput = new Scanner(new File("test.txt"));
		}
		catch(FileNotFoundException e)
		{
			//Print stack trace if file not found
			e.printStackTrace();
		}
		while(fileInput.hasNext())
		{
			//Add all words to the array
			words[increment] = fileInput.next();
			increment++;
		}
		System.out.println("Unsorted List: ");
		for (int i = 0; i < 10; i ++)
		{
			//Display all words in the array
			System.out.print(words[i] + " ");
		}
		//Close file
		fileInput.close();
		
		//Invoke bubbleSort and set equal to variable
		words = bubbleSort(words);
		System.out.println("\nSorted List: ");
		for (int i = 0; i < 10; i++)
		{
			//Display sorted list
			System.out.print(words[i]+ " ");
		}
		
		//Ask user to input a key word
		Scanner myObj = new Scanner(System.in);
		System.out.println("\nEnter a word to search (enter 0 to quit): ");
		String key = "";
		while(!key.equals("0"))
		{
			//Set variable to inputed key
			key = myObj.nextLine();
			
			//Invoke binarySearch and set equal to variable
			int results = binarySearch(words, key);
			if (key.equals("0"))
			{
				//If user wants to quit, print goodbye
				System.out.println("Goodbye");
			} 
			else if (results == -1)
			{
				//Display if input is not in the list
				System.out.println(key + " is not in the list.");
			}
			else
			{
				//Display key and index if key is in the list
				System.out.println(key + " is in the list at index " + results);
			}
		}
		//Closer Scanner
		myObj.close();
	}
	public static String[] bubbleSort(String[] words)
	{
		//Controls index
		for (int i = 0; i < 10; i++)
		{
			for(int j = 1; j < (10 - i); j++)
			{
				//compare index to the one next to it
				if (words[j-1].compareTo(words[j]) > 0)
				{
					//lower index bigger, move it over one spot
					String temp = words[j-1];
					words[j - 1] = words[j];
					words[j] = temp;
				}
			}
		}
		return words;
	}
	public static int binarySearch(String[] words, String key)
	{
		//Initialize variables
		int bottomHalf = 0;
		int topHalf = words.length - 1;
		
		while (bottomHalf <= topHalf)
		{
			//Set middle of the array
			int middle = bottomHalf + (topHalf - bottomHalf) / 2;
			if(key.compareTo(words[middle]) == 0)
			{
				//If key and middle are equal, return middle index
				return middle;
			}
			else if(key.compareTo(words[middle]) > 0)
			{
				//if key > middle, set bottom half to 1+ middle to cut the array in half
				bottomHalf = middle + 1;
			}
			else
			{
				//if key < middle, set bottom half to middle - 1 to cut the array in half
				topHalf = middle - 1;
			}
		}	
		return -1;
		
	}
}