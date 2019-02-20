/*
 * Written by Noah Shaw
 */
public class PlayerCircularLinkedList {
	
	//Private class
	private class ListNode
	{
		//Instance variables for ListNode
		private Player data;
		private ListNode link;
		//Constructor for ListNode
		public ListNode(Player aData, ListNode aLink)
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
	public PlayerCircularLinkedList()
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
	public void insert(Player aData) //Inserts data at the end of the list
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //List is empty
		{
			head = newNode;
			current = newNode;
			tail = newNode;
			return;
		}
		tail.link = newNode; //List is not empty
		tail = newNode;
		tail.link = head;
	}
	public Player getDataAtCurrent() //Returns the data at the current node
	{
		if(current != null)
		{
			return current.data;
		}
		return null;
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
		else //Current is in the middle of the list
		{
			previous.link = current.link;
			current = current.link;
		}
	}
}
