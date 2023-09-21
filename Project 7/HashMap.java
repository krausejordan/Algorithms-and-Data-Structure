import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashMap 
{
	public static int SIZE = 27;
	public static int HASH = 27;
	
	//Create arrayList of arrayLists
	public static ArrayList<ArrayList<String>> bucketArray = new ArrayList<ArrayList<String>>();
	
	//changes int to string
	//O(n)
	public static int hashy(String x)
	{
		int total = 0;
		for (int i = 0; i < x.length(); i++)
		{
			total += x.charAt(i);
		}
		return total;
	}
	//puts data in bucket Array
	//O(1)
	public static void insert(String newData)
	{
		//Get index of hashed data, add it to first index
		bucketArray.get(hashy(newData) % HASH).add(0, newData);
	}
	//O(n)
	public static boolean find(String lookup)
	{
		//hash loop up key, get bucket, if not empty enter for loop
		for (int i = 0; i < bucketArray.get(hashy(lookup) % HASH).size(); i++)
		{
			//if hashed lookup equals lookup, return true
			if(bucketArray.get(hashy(lookup) % HASH).get(i).equals(lookup))
			{
				return true;
			}
		}
		return false;
	}
	//O(n)
	public static void display()
	{
		//Loop through to display
		for(int i = 0; i < bucketArray.size(); i++)
		{
			System.out.print("Bucket " + i + ": ");
			for(int j =0; j < bucketArray.get(i).size(); j++)
			{
				System.out.print(bucketArray.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws FileNotFoundException 
	{
		for(int i = 0; i < SIZE; i++)
		{
			bucketArray.add(new ArrayList<String>());
		}
		
		String curr;
		Scanner myObj = new Scanner(new File("Input.in"));
		while(myObj.hasNext())
		{
			curr = myObj.next();
			insert(curr);
		}
		myObj.close();
		
		display();
		System.out.println("Searching for answer: " + find("answer"));
		System.out.println("Searching for view: " + find("view"));
		System.out.println("Searching for hey: " + find("hey"));
	}

}
