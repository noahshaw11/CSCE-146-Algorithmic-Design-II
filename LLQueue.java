
public class LLQueue <T> implements QueueInterface <T> {
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
	private ListNode head;
	private ListNode tail;
	public LLQueue()
	{
		head = tail = null;
	}
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null)
		{
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = newNode; //tail = tail.link
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
	public void print() //BIG EXAM QUESTION
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

}
