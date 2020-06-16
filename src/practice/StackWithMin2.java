package practice;

public class StackWithMin2 extends MyStack<Integer>{
	
	MyStack<Integer> s2;
	
	public void push(int value) {
		if(value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}
	
	
	public Integer pop() {
		int val = super.pop();
		if(val == min()) {
			s2.pop();
		}
		
		return val;
	}
	public int min() {
		if(s2.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else {
			return s2.peek();
		}
	}

}
