package practice;

public class MyQueueFromStacks {
	private MyStack<Integer> stack1 = new MyStack<>();
	private MyStack<Integer> stack2 = new MyStack<>();
	
	public MyQueueFromStacks() {
		
	}
	
	public void add(Integer v) {
		stack1.push(v);
	}
	
	public Integer remove() {
		Integer first;
		if(stack1.isEmpty()) return -1;
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		first = stack2.pop();
		
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		
		return first;
	}
	
	
	public static void main(String[] args) {
		MyQueueFromStacks q = new MyQueueFromStacks();
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		q.add(8);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
	}

}
