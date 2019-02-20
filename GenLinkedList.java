/*
 * Written by Noah Shaw
 */
public class GenLinkedList <T> {
	
	//Internal class
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//Instance variables
	private ListNode head; //Point to the first item in the list
	private ListNode curr; //Current node of interest
	private ListNode prev; //One node behind current
	
	//Constructor
	public GenLinkedList()
	{
		head = curr = prev = null;
	}
	
	//Methods
	public void insert(T aData) //Inserts at the end of the list
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //List is empty
		{
			head = newNode;
			curr = head;
			return;
		}
		ListNode temp = head; //List is not empty
		while(temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = newNode;
	}
	public void deleteCurrent() //Deletes a node
	{
		if(curr != null && prev != null) //Current is in the middle of the list
		{
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null) //Current is the head
		{
			head = head.link;
		}
	}
	public T getCurrent() //Returns the data at current
	{
		if(curr != null) //Current is not empty
		{
			return curr.data;
		}
		return null;
	}
	public void goToNext() //Goes to the next node
	{
		if(curr == null)
		{
			return;
		}
		prev = curr;
		curr = curr.link;
	}
	public void goToPrev() //Goes to the previous node
	{
		if(curr == null || prev == null)
		{
			return;
		}
		curr = prev;
	}
	public void resetCurrent() //Resets the current to head
	{
		prev = null;
		curr = head;
	}
	public boolean hasMore() //Determines if the list has more nodes after current
	{
		return curr != null;
	}
	public void print() //Prints the list
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
		{
			System.out.println(temp.data);
		}
	}

}
