
public class Node {
	Node next = null;
	int data;
	
	public Node (int d) {
		this.data = d;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public Node insertBefore(int data) {
		Node n = new Node(data);
		if(this != null) {
			n.next = this;
		}
		return n;
	}
	
	public Node deleteNode(Node head, int d) {
		Node n = head;
		
		if(n.data == d) {
			return head.next;
		}
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				
				return head;
			}
			n = n.next;
		}
		
		return head;
	}
	
	public int length() {
		Node h = this;
		int count = 0;
		while(h != null) {
			count++;
			h = h.next;
		}
		
		return count;
	}
	
	
}
