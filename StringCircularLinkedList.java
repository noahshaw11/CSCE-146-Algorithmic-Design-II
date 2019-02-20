/*
 * Written by Noah Shaw
 */
public class StringCircularLinkedList {
	
	private class ListNode
	{
		
		//Instance variables for ListNode
		private String data;
		private ListNode link;
		//Constructor for ListNode
		public ListNode(String aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//Instance variables
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	private ListNode tail;
	
	//Constructor
	public StringCircularLinkedList()
	{
		head = current = previous = tail = null;
	}
	
	//Methods
	public void goToNext() //Goes to next node
	{
		if(current == null)
		{
			return;
		}
		if(current == tail)
		{
			previous = current;
			current = head;
			return;
		}
		previous = current;
		current = current.link;
	}
	public void goToPrev() //Goes to previous node
	{
		current = previous;
		ListNode orgCurr = new ListNode(previous.data, head.link);
		while(orgCurr != previous)
		{
			orgCurr = orgCurr.link;
		}
		previous = orgCurr;
	}
	public String getDataAtCurrent() //Returns the data at the current node
	{
		if(current != null)
		{
			return current.data;
		}
		return null;
	}
	public void setDataAtCurrent(String aData) //Sets the data at the current node
	{
		if(current != null)
		{
			current.data = aData;
		}
	}
	public void insert(String aData) //Inserts data at the end of the list
	{
		ListNode newNode = new ListNode(aData, null);
		//List is empty
		if(head == null)
		{
			head = newNode;
			current = newNode;
			tail = newNode;
			return;
		}
		//List is not empty
		tail.link = newNode;
		tail = newNode;
		tail.link = head;
	}
	public void insertAfterCurrent(String aData) //Inserts data after the current node
	{
		if(current == null)
		{
			return;
		}
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
		if(newNode == tail)
		{
			newNode.link = head;
		}
	}
	public void deleteCurrent() //Deletes the current node
	{
		if(current == tail) //Current is at the tail
		{
			previous.link = current.link;
			current = current.link;
			tail = previous;
			tail.link = head;
		}
		else if(current == head) //Current is at the head
		{
			previous.link = current.link;
			current = current.link;
			head = current;
			head.link = current.link;
		}
		else
		{
			previous.link = current.link;
			current = current.link;
		}
	}
	public void print() //Prints all of the data in the node
	{
		ListNode temp = head;
		System.out.println(temp.data);
		for(temp = head.link; temp != head; temp = temp.link)
		{
			System.out.println(temp.data);
		}
	}
	public boolean isInList(String aData) //Calls the search method
	{
		return search(aData) != null;
	}
	private ListNode search(String aData) //Searches for the data in the list
	{
		ListNode temp = head;
		if(temp.data.equalsIgnoreCase(aData))
		{
			return temp;
		}
		else
		{
			for(temp = head.link; temp != head; temp = temp.link)
			{
				if(temp.data.equalsIgnoreCase(aData))
				{
					return temp;
				}
			}
		}
		return null;
	}
	public void printprev()
	{
		System.out.println(previous.data);
	}
	public void printcurr()
	{
		System.out.println(current.data);
	}

}
