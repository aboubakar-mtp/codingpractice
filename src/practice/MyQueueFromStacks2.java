package practice;

public class MyQueueFromStacks2 {
	private MyStack<Integer> stack1 = new MyStack<>();
	private MyStack<Integer> stack2 = new MyStack<>();
	
	public MyQueueFromStacks2() {
		
	}
	
	public void add(Integer v) {
		stack1.push(v);
	}
	
	public void shiftStacks() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}
	
	public Integer remove() {
		this.shiftStacks();
		
		return stack2.pop();
	}
	
	public Integer peek() {
		this.shiftStacks();
		return stack2.peek();
	}
	
	
	
	
	public static void main(String[] args) {
		MyQueueFromStacks2 q = new MyQueueFromStacks2();
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		q.add(8);
		
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
	}

}
