import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DLinkedList <T extends Comparable<T>>
{
	//Create head of the list
	Node head;
	Node tail;
			
	//O(1)
	class Node
	{
		//Declare variables
		T data;
		Node next;
		Node prev;
					
		//Constructor to create new node
		Node(T data)
		{
			this.data = data;
			next = prev = this;
		}
	}
	
	//O(1)
	//Create head
	public DLinkedList()
	{
		head = new Node(null);
	}
	//O(1)
	//Add data to the list
	public Node add(T item)
	{
		Node newNode = new Node(item);
		newNode.prev = head;
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
		return newNode;
	}
	//O(n)
	//Display data in list
	public String toString()
	{
		String str = "[";
		Node curr = head.next;
		while(curr != head)
		{
			str += curr.data + " ";
			curr = curr.next;
		}
		str = str.substring(0, str.length() - 1);
		return str + "]";
	}
	//O(n^2)
	//Insert data in order
	public void insertOrder(T item)
	{
		add(item);
		Node current = null;
		Node index = null;
		T tempItem;
		
		if(head.next == null)
		{
			return;
		}
		else
		{
			for(current = head.next; current.next != null && current.data != null; current = current.next)
			{
				for(index = current.next; index != null && index.data != null; index = index.next)
				{
					if(current.data.compareTo(index.data) > 0)
					{
						tempItem = current.data;
						current.data = index.data;
						index.data = tempItem;
					}
				}
			}
		}
	}
	//O(n)
	//Print list
	public void printlist(Node node)
	{
		Node last = null;
		while(node != null)
		{
			System.out.println(node.data + " ");
			last = node;
			node = node.next;
		}
	}
	//O(1)
	//Remove leading or trailing non letters and lower case list
	public static String cleanUp(String str)
	{
		String newStr = str.toLowerCase();
		newStr = newStr.replaceAll("[^a-z']", "");
		
		return newStr;
	}
	//O(n)
	//Remove any node passed in
	public boolean remove(T val)
	{
		if (head.next == null)
		{
			return false;
		}
		else
		{
			Node temp = head.next;
			
			while(temp != head)
			{
				//Loop through all nodes
				if(temp.data.compareTo(val) == 0)
				{
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}
	//O(n)
	//Insert only if node is unique
	public boolean insertOrderUnique(T item)
	{	
		//If list is empty, call insert
		if(head.next.data == null)
		{
			this.insertOrder(item);
			return true;
		}
		//Insert value unless value is a duplicate
		Node curr = head.next;
		while(curr != head)
		{
			if(curr.data.compareTo(item) == 0)
			{
				return false;
			}
			curr = curr.next;
		}
		this.insertOrder(item);
		return true;
	}
	//O(n+m)
	//Merge two lists together
	public DLinkedList<T> merge(DLinkedList<T> rhs)
	{
		DLinkedList<T> result = new DLinkedList<T>();
		
		//Add both lists together by calling insert and remove to delete lists
		Node curr = head.next;
		while(curr != head)
		{
			result.insertOrder(curr.data);
			remove(curr.data);
			curr = curr.next;
		}
		curr = rhs.head.next;
		while(curr != rhs.head)
		{
			result.insertOrder(curr.data);
			rhs.remove(curr.data);
			curr = curr.next;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//Create two lists
		DLinkedList<String> list1 = new DLinkedList<>();
		DLinkedList<String> list2 = new DLinkedList<>();
		
		//Read from file
		Scanner fin = new Scanner(new File("text1.in"));
		String str;
		
		//Add text to list
		while(fin.hasNext())
		{
			str = fin.next();
			str = cleanUp(str);
			list1.insertOrderUnique(str);
		}
		fin.close();
		
		//Read from file
		fin = new Scanner(new File("text2.in"));
		while(fin.hasNext())
		{
			str = fin.next();
			str = cleanUp(str);
			list2.insertOrderUnique(str);
		}
		
		System.out.println("List 1: " + list1);
		System.out.println("List 2: " + list2);
		
		DLinkedList combined = list1.merge(list2);
		
		System.out.println("\nAFTER MERGE");
		System.out.println("List 1: [" + list1);
		System.out.println("List 2: [" + list2);
		System.out.println("\n" + combined);
		
	}
}