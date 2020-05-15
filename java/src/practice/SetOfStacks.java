package practice;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks {
	
	List<MyStack> stackset = new ArrayList<MyStack>();
	int capacity = 3;
	int current;
	
	public SetOfStacks() {
		this.current = 0;
		stackset.add(new MyStack<Integer>());
		
	}
	
	public void push(Integer val) {
		stackset.get(this.current).push(val);
		if(stackset.get(this.current).size() == this.capacity) {
			this.current++;
			stackset.add(new MyStack<Integer>());
		}
	}
	
	public Integer pop() {
		
		if(stackset.get(this.current).size() == 0) {
			stackset.remove(this.current);
			this.current--;
			
		}
		if(this.current < 0) {
			this.current = 0;
			throw new EmptyStackException();
			
		}
		
		return (Integer)stackset.get(this.current).pop();
		
	}

}
