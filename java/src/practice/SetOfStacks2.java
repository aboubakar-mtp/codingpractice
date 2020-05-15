package practice;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks2 {
	private ArrayList<MyStack> stacks = new ArrayList<MyStack>();
	private int capacity;
	
	public SetOfStacks2(int c) {
		this.capacity = c;
	}
	
	public void push(int v) {
		MyStack<Integer> last = this.getLastStack();
		if(last != null && (last.size() != this.capacity)) {
			last.push(v);
		}
		else {
			MyStack<Integer> st = new MyStack<>();
			st.push(v);
			stacks.add(st);
		}
		
	}
	public int pop() {
		
		MyStack<Integer> last = this.getLastStack();
		if(last == null) {
			throw new EmptyStackException();
		}
		int v =  last.pop();
		if(last.size() == 0) {
			stacks.remove(stacks.size() -1);
		}
				
		return v;
	}
	
	public MyStack getLastStack(){
		if(stacks.size() == 0) return null;
		return stacks.get(stacks.size() -1);
	}

}
