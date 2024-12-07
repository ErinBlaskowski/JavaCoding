/*
 * Erin Blaskowski
 */

public class GenLL <T>{
	
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) 
		{
			data = aData;
			link = aLink;
		}
	}
	
	protected ListNode head;
	protected ListNode current;
	protected ListNode previous;
	
	public GenLL() {
		head = current = previous = null;
	}
	
	public void add(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head==null) {
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
	}
	
	public void print() {
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	public void goToNext() {
		if(current != null) {
			previous = current;
			current = current.link;
		}
	}
	
	public void reset() {
		current = head;
		previous = null;
	}
	
	public T getCurrent() {
		if(current == null) {
			return null;
		}
		else {
			return current.data;
		}
	}
	
	public void setCurrent(T aData) {
		if(current == null) {
			return;
		}
		current.data = aData;
	}
	
	public void removeCurrent()
	{
		if(current != null && previous == null) //current == head;
		{
			head = head.link;
			current = head;
		}
		else if(current != null && previous != null) {
			previous.link = current.link;
			current = current.link;
		}
	}
	
	public void addAfterCurrent(T aData) 
	{
		if(current == null) {
			return;
		}
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
}
