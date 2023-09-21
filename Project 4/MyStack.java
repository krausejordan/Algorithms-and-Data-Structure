public class MyStack <T>
{
	//Declare variables
	Node topList;
	int count;
	
	//O(1)
	//Default constructor
	public MyStack()
	{
		topList = null;
		count = 0;
	}
	
	//O(1)
	class Node
	{
		//Declare variables
		T data;
		Node next;
		
		//Constructor to create new node
		Node(T data)
		{
			this.data = data;
			this.next = null;
		}
	}
	//O(1)
	//Non default constructor
	public MyStack<T> push(T val)
	{
		//Set variables
		Node newNode = new Node(val);
		newNode.data = val;
		newNode.next = topList;
		
		topList = newNode;
		count++;
		return this;
				
	}
	//O(1)
	//returns size
	public int size()
	{
		return count;
	}
	//O(1)
	//empty stack
	public Boolean empty()
	{
		return topList == null;
	}
	//O(1)
	//Return top data in stack
	public T top()
	{
		return topList.data;
	}
	//O(1)
	//Deletes top data in stack
	public void pop()
	{
		if(topList == null)
		{
			System.out.println("Error");
			return;
		}
		Node temp = topList;
		topList = topList.next;
		count--;
	}
}