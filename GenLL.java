import java.util.Iterator;
public class GenLL <T> implements Iterable<T> //Generic type T
{
	private class ListNode //Internal class
	{
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private class ListIterator implements Iterator <T>
	{
		private ListNode iCurr;
		public ListIterator(ListNode head)
		{
			iCurr = head;
		}
		public boolean hasNext()
		{
			return iCurr != null;
		}
		public T next()
		{
			T ret = iCurr.data;
			iCurr = iCurr.link;
			return ret;
		}
	}
	public Iterator<T> iterator()
	{
		return new ListIterator(head);
	}
	private ListNode head; //Point to the first item in the list
	private ListNode curr; //Current node of interest
	private ListNode prev; //One node behind current
	public GenLL()
	{
		head = curr = prev = null;
	}
	public void insert(T aData) //Inserts at the end of the list
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //List is empty
		{
			head = newNode;
			curr = head; //curr = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = newNode;
	}
	public void print()
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
		{
			System.out.println(temp.data);
		}
		System.out.println();
	}
	public T getCurrent()
	{
		if(curr != null)
		{
			return curr.data;
		}
		return null;
	}
	public void setCurrent(T aData)
	{
		if(curr != null)
		{
			curr.data = aData;
		}
	}
	public void goToNext()
	{
		if(curr == null)
		{
			return;
		}
		prev = curr;
		curr = curr.link;
	}
	public void reset()
	{
		prev = null;
		curr = head;
	}
	public void insertAfterCurren(T aData)
	{
		if(curr == null)
		{
			return;
		}
		ListNode newNode = new ListNode(aData, curr.link);
		curr.link = newNode;
	}
	public void deleteCurrent()
	{
		if(curr != null && prev != null) //Current is not the head (in the middle)
		{
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null) //Current is at the head
		{
			head = head.link; //curr = curr.link
		}
	}
	public boolean isContained(T aData)
	{
		return search(aData) != null;
	}
	private ListNode search(T aData)
	{
		ListNode temp = head;
		while(temp != null)
		{
			if(temp.data.equals(aData))
			{
				return temp;
			}
		}
		return null;
	}
}
