package practice;

public class StackWithMin extends MyStack<StackNodeWithMin>{
	
	public void push(int value) {
		int newMin = Math.min(value, min());
		
		super.push(new StackNodeWithMin(value, newMin));
	}
	
	public int min() {
		if(this.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else {
			return this.peek().min;
		}
	}

}
