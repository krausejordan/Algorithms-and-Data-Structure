//Jordan Krause
//This is my own work

package app;

public class MyList <T extends Comparable<T>>
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
			
			//Constructor to create new node
			Node(T data)
			{
				this.data = data;
			}
		}
	
		//O(n)
		//Insert a node
		public void insert(T val)
		{
			Node newNode = new Node(val);

			//if first value is empty
			if(head == null)
			{
				//create new node and make it head
				head = newNode;
				tail = head;
			}
			else if(head.data.compareTo(val) > 0)
			{
				//if new value is less than head, make new value point to head
				newNode.next = head;
				head = newNode;
			}
			else
			{
				//Create variables
				Node prev = head;
				Node temp = head.next;
					
				//Test new value to see where to insert it
				while (temp != null)
				{
					if(temp.data.compareTo(val) > 0)
					{
						prev.next = newNode;
						newNode.next = temp;
						return;
					}
					prev = temp;
					temp = temp.next;
				}
				tail.next = newNode;
				tail = newNode;
			}
		}
		//O(n)
		//Display nodes
		public void printlist()
		{
			//Create temp head to ensure data isn't lost
			Node temp = head;
			
			//Print all data
			while(temp != null)
			{
				//print each node
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
		//O(1)
		//Get info from first node (head)
		public void front()
		{
			if (head == null)
			{
				System.out.println("Head is null");
			}
			else
			{
				//Print the head data
				System.out.println(head.data);
			}
		}
		//O(1)
		//Get info from last node (tail)
		public void back()
		{
			if (head == null)
			{
				System.out.println("Head is null");
			}
			else
			{
				//Display tail data
				System.out.println(tail.data);
			}
		}
		//O(1)
		//Delete first node
		public void popFront()
		{
			if (head == null)
			{
				System.out.println("Head is null");
			}
			else
			{
				//set head to the next node
				Node temp = head;
				head = temp.next;
			}
		}
		//O(n)
		//Delete the last Node
		public void popBack()
		{
			if (head == null)
			{
				System.out.println("Head is null");
			}
			else
			{
				
				Node temp = head;
				Node prev = null;
				
				//Loop through all nodes
				while(temp.next != null)
				{
					prev = temp;
					temp = temp.next;
				}
				//set tail to previous and delete tail
				tail = prev;
				tail.next = null;
			}
		}
		//O(1)
		//return if empty
		public boolean empty()
		{
			if (head == null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		//O(n)
		//Return size of list
		public int size() 
		{
			Node temp = head;
			int count = 0;
			
			//increment count until temp points to null
			while(temp != null)
			{
				temp = temp.next;
				count++;
			}
			return count;
		}
		//O(n)
		//Reverse the order of the List
		public void reverse()
		{
			//Set variables
			Node next = head.next;
			Node prev = null;
			Node curr = head;
			
			tail = head;
			
			//Until curr is null, switch the positions of the list
			while(curr != null)
			{
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			head = prev;
		}
		//O(n)
		//Get each index
		public T get(int pos)
		{
			Node temp = head;
			
			//Loop through list to get index
			for(int i = 0; i < pos; i++)
			{
				temp = temp.next;
			}
			return temp.data;
		}
		//O(n)
		//Merge two lists together
		public void merge(MyList<T> list2)
		{
			//Use insert to put each index in list
			for (int i = 0; i < list2.size(); i++)
			{
				this.insert(list2.get(i));
			}
		}
		public static void main(String[] args) 
		{
			//Test insert() and printList()
			MyList<Integer> myList1 = new MyList<Integer>();
			myList1.insert(10);
			myList1.insert(20);
			myList1.insert(30);
			myList1.insert(15);
			System.out.print("List one: ");
			myList1.printlist();
			
			//Test insert() and printList()
			MyList<Integer> myList2 = new MyList<Integer>();
			myList2.insert(75);
			myList2.insert(83);
			myList2.insert(62);
			myList2.insert(97);
			System.out.println();
			System.out.print("List two: ");
			myList2.printlist();
			
			//Test merge()
			myList1.merge(myList2);
			System.out.println();
			System.out.print("Merged List one and two: ");
			myList1.printlist();
			
			//Test reverse()
			myList2.reverse();
			System.out.println();
			System.out.print("Reversed list two: ");
			myList2.printlist();
					
			//Test reverse()
			myList1.reverse();
			System.out.println();
			System.out.print("Reversed Merged List: ");
			myList1.printlist();
			
			//Test size()
			System.out.println();
			System.out.print("Size of list one: " + myList1.size());
			
			//Test empty()
			System.out.println();
			System.out.print("List 1 is empty: " + myList1.empty());
			
			//Test front()
			System.out.println();
			System.out.print("Head data of merged list: ");
			myList1.front();
			
			//Test back()
			System.out.print("Tail data of merged list: ");
			myList1.back();
		}
}
