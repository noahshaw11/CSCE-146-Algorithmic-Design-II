/*
 * Written by Noah Shaw
 */
public class LinkedListQueue <T> {
	
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
	
	//Attributes
	private ListNode head; //Points to the first item in the list
	private ListNode tail; //Points to the last item in the list
	
	//Other methods
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null)
		{
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = newNode;
	}
	public T dequeue()
	{
		if(head == null)
		{
			return null;
		}
		T ret = head.data;
		head = head.link;
		return ret;
	}
	public T peek()
	{
		if(head == null)
		{
			return null;
		}
		return head.data;
	}
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

}
