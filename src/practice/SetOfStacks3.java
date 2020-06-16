package practice;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks3 {
	private ArrayList<MyStack2> stacks = new ArrayList<MyStack2>();
	private int capacity;
	
	public SetOfStacks3(int c) {
		this.capacity = c;
	}
	
	public void push(int v) {
		MyStack2 last = this.getLastStack();
		if(last != null && !(last.isFull())) {
			last.push(v);
		}
		else {
			MyStack2 st = new MyStack2(this.capacity);
			st.push(v);
			stacks.add(st);
		}
		
	}
	public int pop() {
		
		MyStack2 last = this.getLastStack();
		if(last == null) {
			throw new EmptyStackException();
		}
		int v =  last.pop();
		if(last.isEmpty()) {
			stacks.remove(stacks.size() -1);
		}
				
		return v;
	}
	
	
	public MyStack2 getLastStack(){
		if(stacks.size() == 0) return null;
		return stacks.get(stacks.size() -1);
	}
	
	public boolean isEmpty() {
		MyStack2 last = this.getLastStack();
		
		return last == null || last.isEmpty();
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		MyStack2 st = stacks.get(index);
		int removed_item;
		if(removeTop) removed_item = st.pop();
		else removed_item = st.removeBottom();
		
		if(st.isEmpty()) {
			stacks.remove(index);
		}
		else if(stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			st.push(v);
		}
		
		return removed_item;
	}

}

