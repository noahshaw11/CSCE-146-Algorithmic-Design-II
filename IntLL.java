
public class IntLL {
	private class ListNode //Internal class
	{
		private int data;
		private ListNode link;
		public ListNode(int aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head; //First element of the list
	private ListNode curr; //Current element of the list of interest
	private ListNode prev; //One node behind current
	public IntLL()
	{
		head = curr = prev = null;
	}
	public void insert(int aData)
	{
		//Create the link
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //List is empty
		{
			head = newNode;
			curr = head;
			return;
		}
		//List was not empty
		ListNode temp = head;
		while(temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = newNode;
	}
	public void insertAfterCurrent(int aData)
	{
		if(curr == null)
		{
			return;
		}
		ListNode newNode = new ListNode(aData, curr.link);
		curr.link = newNode;
	}
	public int getCurrent()
	{
		if(curr != null)
			return curr.data;
		else
			return 0;
	}
	public void setCurrent(int aData)
	{
		if(curr != null)
			curr.data = aData;
	}
	public void moveCurrentForward()
	{
		if(curr != null)
		{
			prev = curr;
			curr = curr.link;
		}
	}
	public void resetCurrent()
	{
		curr = head;
	}
	public void print()
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
		/*
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp);
			temp = temp.link;
		}
		*/
	}
	public void deleteCurrent()
	{
		if(curr != null && prev != null) //In the middle of the list
		{
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null) //Curr is at the head
		{
			head = head.link;
		}
		else //List is empty
		{
			System.out.println("Nope");
		}
	}

}
