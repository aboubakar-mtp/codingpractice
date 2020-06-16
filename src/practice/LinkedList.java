package practice;
import java.util.HashSet;
import java.util.Stack;

public class LinkedList {
	
	public void deleteDups(Node node){
		HashSet<Integer> set = new HashSet<Integer>();
		
		Node previous = null;
		
		while(node != null) {
			if(set.contains(node.data)) {
				previous.next = node.next;
			}else {
				set.add(node.data);
				previous = node;
			}
			node = node.next;
		}
	}
	
	public void deleteDups2(Node node) {
		Node current = node;
		
		while(current != null) {
			Node runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				}
				else {
					runner = runner.next;
				}
			}
			
			current = current.next;
		}
	}

	
	public Node returnKthTotheLast(Node list, int k) {
		Node start = list;
		int size = 0;
		while(start != null) {
			size++;
			start = start.next;
		}
		start = list;
		int c = size - k;
		while(c > 0) {
			start = start.next;
			c--;
		}
		
		return start;
	}
	
	
	public Node returnKthTotheLast2(Node list, int k) {
		Node ret = null;
		Node start = null;
		for(int i=1; i<=k; i++) {
			start = list;
			while(start.next.next != null) {
				start = start.next;
			}
			if(i == k) {
				return start.next;
			}
			else {
				start.next = null;
			}
			
			
		}
		return ret;
	}
	
	public Node returnKthTotheLast3(Node head, int k) {
		Index idx = new Index();
		return returnKthTotheLast3(head, k, idx);
	}
	public Node returnKthTotheLast3(Node head, int k, Index idx) {
		if(head == null) {
			return new Node(13);
		}
		
		Node node = returnKthTotheLast3(head.next, k, idx);
		idx.value = idx.value + 1;
		if(idx.value == k) {
			return head;
		}
		
		return node;
		
	}
	
	public Node returnKthTotheLast4(Node head, int k) {
		Node p1 = head;
		Node p2 = head;
		
		for(int i = 0; i < k; i++) {
			if(p1 == null) return null;
			p1 = p1.next;
		}
		
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
	public int printKthToLast(Node list, int k) {
		if(list == null) {
			return 0;
		}
		int index = printKthToLast(list.next, k) + 1;
		
		if(index == k) {
			System.out.println(k + "th to last is " + list.data);
		}
		
		return index;
	}
	
	
	
	//not efficient
	public void deleteMiddleNode(Node c) {
		while(c.next.next != null) {
			c.data = c.next.data;
			c = c.next;
		}
		c.data = c.next.data;
		c.next = null;
	}
	
	public boolean deleteMiddleNode2(Node c) {
		if(c == null || c.next == null) {
			return false;
		}
		
		c.data = c.next.data;
		c.next = c.next.next;
		
		return true;
	}
	
	
	
	public Node partitionList(Node list, Node part) {
		Node left = null, right = null, rightStart = null, leftStart = null;
		while(list != null) {
			if(list.data < part.data) {
				if(left == null) {
					left = list;
					leftStart = list;
					
				}
				else {
					left.next = list;
					left = list;
				}
				System.out.println("less " + list.data);
			}
			else{
				if(right == null) {
					right = list;
					rightStart = list;
				}
				else {
					right.next = list;
					right = list;
				}
				System.out.println("more " + list.data);
			}
			
			list = list.next;
		}
		right.next = null;
		left.next = rightStart;
		return leftStart;
	}
	
	public Node partitionList2(Node node, int x) {
		Node head = node;
		Node tail = node;
		
		while(node != null) {
			Node next = node.next;
			if(node.data < x) {
				node.next = head;
				head = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		
		tail.next = null;
		
		return head;
	}
	
	
	public Node sumLists(Node l1, Node l2) {
		Index carry = new Index();
		Node res = null;
		while(l1 != null || l2 != null) {
			if(l1 == null || l2 == null) {
				break;
			}
			int sum = l1.data + l2.data;
			res = constructDigit(res, sum, carry);
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if(l1 != null) {
			while( l1 != null) {
				int sum = l1.data;
				res = constructDigit(res, sum, carry);
				l1 = l1.next;
			}
		}
		else if(l2 != null) {
			while( l2 != null) {
				int sum = l1.data;
				res = constructDigit(res, sum, carry);
				
			}
		}
		
		if(carry.value != 0) {
			res.appendToTail(carry.value);
		}
		
		return res;
	}
	
	
	public Node constructDigit(Node start, int sum, Index carry) {
		int val;
		//int carry= 0;
		int total = sum + carry.value;
		val = total % 10;
		
		carry.value = (total > 9) ? 1 : 0;
		
		if(start == null) {
			start = new Node(val);
		}
		else {
			start.appendToTail(val);
		}
		
		return start;
	}
	
	
	public Node sumLists2(Node l1, Node l2, int carry) {
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		Node res = new Node(0);
		int value = carry;
		
		if(l1 != null) {
			value += l1.data;
		}
		if(l2 != null) {
			value += l2.data;
		}
		
		res.data = value % 10;
		
		//if(l1 != null || l2 != null) {
			Node more = sumLists2(l1 == null ? null : l1.next,
					l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			res.next = more;
		//}
		
		return res;
	}
	
	
	public Node sumLists3(Node l1, Node l2) {
		int len1 = l1.length();
		int len2 = l2.length();
		
		if(len1 < len2) {
			l1 = this.padList(l1, len2 - len1);
		}
		else {
			l2 = this.padList(l2, len1 - len2);
		}
		
		PartialSum sum = addListHelper(l1, l2);
		
		if(sum.carry == 0) {
			return sum.sum;
		}
		else {
			Node res = null;
			if(sum.sum != null) {
				res = sum.sum.insertBefore(sum.carry);
			}
			return res;
		}
	}
	
	public PartialSum addListHelper(Node l1, Node l2) {
		if(l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		System.out.println("gooda");
		
		PartialSum sum = addListHelper(l1.next, l2.next);
		
		int val = sum.carry + l1.data + l2.data;
		Node fullResult = null;
		//if(sum.sum != null) {
			fullResult = sum.sum.insertBefore(val % 10);
			System.out.println("good");
		//}
		
		sum.sum = fullResult;
		sum.carry = val/10;
		
		return sum;
	}
	
	public Node padList(Node list, int padding) {
		Node head = list;
		for(int i = 0; i < padding; i++) {
			head = head.insertBefore(0);
		}
		
		return head;
	}
	
	
	
	public boolean isPalindrome(Node list) {
		int len = list.length();
		int mid = len / 2;
		Node head = list;
		Node firstHalf = null;
		int i = 0;
		while(i < mid) {
			if(firstHalf == null) {
				firstHalf = new Node(head.data);
			}
			else {
				firstHalf.appendToTail(head.data);
			}
			head = head.next;
			i++;
		}
		if(len % 2 != 0) {
			head = head.next;
		}
		Node secondHalfrev = null;
		while(head != null) {
			secondHalfrev = this.insertBeforeHelper(secondHalfrev, head.data);
			head = head.next;
		}
		
		return this.areEqual(firstHalf, secondHalfrev);
	}
	
	public boolean isPalindrome2(Node list) {
		Stack<Integer> stack = new   Stack<>();
		
		Node head = list;
		while(head != null) {
			stack.push(head.data);
			head = head.next;
		}
		head = list;
		while(head != null) {
			int a = stack.pop();
			if(a != head.data) {
				return false;
			}
			head = head.next;
		}
		
		return true;
	}
	
	public boolean isPalindrome3(Node list) {
		Node fast = list;
		Node slow = list;
		Stack<Integer> stack = new Stack<>();
		
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) { // if list is odd, skip middle
			slow = slow.next;
		}
		
		while(slow != null) {
			Integer a = stack.pop();
			if(a != slow.data) {
				return false;
			}
			
			slow = slow.next;
		}
		return true;
	}
	
	public boolean areEqual(Node l1, Node l2) {
		if(l1.length() != l2.length()) {
			return false;
		}
		while( l1 != null) {
			if(l1.data != l2.data) {
				return false;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		
		return true;
	}
	
	
	public void printLinkedList (Node n) {
		while(n != null) {
			System.out.print(n.data + ", ");
			n = n.next;
		}
		System.out.println();
	}
	
	public Node add(Node n, int i) {
		while(n.next != null) {
			n = n.next;
		}
		Node nn = new Node(i);
		n.next = nn;
		
		return nn;
	}
	
	public Node insertBeforeHelper(Node list, int data) {
		Node n = new Node(data);
		if(list != null) {
			n.next = list;
		}
		return n;
	}
}
