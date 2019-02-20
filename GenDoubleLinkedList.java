/*
 * Written by Noah Shaw
 */
public class GenDoubleLinkedList <T> {
	
		//Internal class
		private class ListNode
		{
			private T data;
			private ListNode nextLink;
			private ListNode prevLink;
			public ListNode()
			{
				data = null;
				nextLink = null;
				prevLink = null;
			}
			public ListNode(T aData, ListNode aNextLink, ListNode aPrevLink)
			{
				data = aData;
				nextLink = aNextLink;
				prevLink = aPrevLink;
			}
		}
		
		//Instance variables
		private ListNode head; //Point to the first item in the list
		private ListNode curr; //Current node of interest
		
		//Constructor
		public GenDoubleLinkedList()
		{
			head = curr = null;
		}
		
		//Methods
		public void goToNext() //Goes to the next node in the list
		{
			if(curr == null || curr.nextLink == null)
			{
				return;
			}
			curr = curr.nextLink;
		}
		public void goToPrev() //Goes to the previous node
		{
			if(curr == null || curr.prevLink == null)
			{
				return;
			}
			curr = curr.prevLink;
		}
		public T getDataAtCurrent() //Returns the data at the current node
		{
			if(curr != null)
			{
				return curr.data;
			}
			return null;
		}
		public void setDataAtCurrent(T aData) //Sets the data at the current node
		{
			if(curr != null)
			{
				curr.data = aData;
			}
		}
		public void insert(T aData) //Inserts a new node at the end of the list
		{
			ListNode newNode = new ListNode(aData, null, null);
			if(head == null) //List is empty
			{
				head = newNode;
				curr = head;
				return;
			}
			ListNode temp = head; //List is not empty
			while(temp.nextLink != null)
			{
				temp = temp.nextLink;
			}
			temp.nextLink = newNode;
		}
		public void insertNodeAfterCurrent(T aData) //Inserts a new node after the current node
		{
			if(curr == null)
			{
				return;
			}
			ListNode newNode = new ListNode(aData, curr.nextLink, curr);
			curr.nextLink = newNode;
		}
		public void deleteCurrentNode() //Deletes the current node
		{
			if(curr != null && curr.prevLink != null) //Current is in the middle of the list
			{
				curr.prevLink.nextLink = curr.nextLink;
				curr.nextLink.prevLink = curr.prevLink;
				curr = curr.nextLink;
			}
			else if(curr != null) //Current is at the head
			{
				head = head.nextLink;
			}
		}
		public void showList() //Prints the list
		{
			for(ListNode temp = head; temp != null; temp = temp.nextLink)
			{
				System.out.println(temp.data);
			}
		}
		public boolean inList(T aData) //Determines if a data is in the list
		{
			return this.findNodeWith(aData) != null;
		}
		private ListNode findNodeWith(T aData) //Finds the node with a data
		{
			ListNode temp = head;
			while(temp != null)
			{
				if(temp.data.equals(aData))
				{
					return temp;
				}
				temp = temp.nextLink;
			}
			return null;
		}

}
