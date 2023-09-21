import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BST 
{
	Node root;
	int numSteps;
	
	//O(1)
	class Node
	{
		//Create head of the list
		String key;
		Node right, left;
		
		public Node(String data) 
		{
			key = data;
			left = right = null;
		}
	}
	//O(1)
	public BST()
	{
		root = null;
	}
	//O(1)
	void newInsert(String key)
	{
		root = insert(root, key);
	}
	//O(log n)
	public Node insert(Node root, String data)
	{
		if(root == null)
		{
			root = new Node(data);
			return root;
		}
		if(data.compareTo(root.key) < 0)
		{
			root.left = insert(root.left, data);
		}
		else if (data.compareTo(root.key) > 0)
		{
			root.right = insert(root.right, data);
		}
		return root;
	}
	//O(n)
	public boolean search(String key)
	{
		numSteps = 0;
		Node temp = searchRecursive(root, key);
		if(temp != null)
		{
			return true;
		}
		return false;
	}
	//O(n)
	public Node searchRecursive(Node root, String key)
	{
		numSteps ++;
		if(root == null || root.key.compareTo(key) == 0)
		{
			return root;
		}
		if(root.key.compareTo(key) > 0)
		{
			return searchRecursive(root.left, key);
		}
		return searchRecursive(root.right, key);
	}
	//O(1)
	public void inOrder()
	{
		inOrderTraveral(root);
	}
	public void inOrderTraveral(Node root)
	{
		if(root != null)
		{
			inOrderTraveral(root.left);
			System.out.print(root.key + " ");
			inOrderTraveral(root.right);
		}
	}
	//O(n)
	public String minValue(Node root)
	{
		String minVal = root.key;
		
		while(root.left != null)
		{
			minVal = root.left.key;
			root = root.left;
		}
		return minVal;
	}
	//O(n)
	public void deleteKey(String key) 
	{
		root = deleteRecursive(root, key);
		
	}
	//O(n)
	public Node deleteRecursive(Node temp, String key)
	{
		if (temp == null)
			return root;
		if(key.compareTo(temp.key) < 0)
			temp.left = deleteRecursive(temp.left, key);
		else if (key.compareTo(temp.key) > 0)
			temp.right = deleteRecursive(temp.right, key);
		else
		{
			if(temp.left == null)
				return temp.right;
			else if(temp.right == null)
				return temp.left;
			else
			{
				temp.key = minValue(temp.right);
				temp.right = deleteRecursive(temp.right, temp.key);
			}
		}
		return temp;
	}
	public static void main(String[] args) throws FileNotFoundException  
	{
		Scanner in = new Scanner(new File("Text.in"));
		BST bst = new BST();

		String curr;
		while(in.hasNext())
		{
			curr = in.next();
			curr = curr.toLowerCase();
			if(!bst.search(curr))
				bst.newInsert(curr);
		}
		in.close();
		
		bst.inOrder();
		System.out.println();
		bst.deleteKey("earthwax");
		bst.inOrder();
		System.out.println();
		System.out.println("Searching for \"shelf\"; " + bst.search("shelf") + ", determined in " + bst.numSteps + " steps.");
		System.out.println("Searching for \"water\"; " + bst.search("water") + ", determined in " + bst.numSteps + " steps.");
	}
}
