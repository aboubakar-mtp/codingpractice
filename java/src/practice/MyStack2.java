package practice;

public class MyStack2 {
	
	private static class SNode{
		private int value;
		private SNode above;
		private SNode below;
		
		public SNode(int v) {
			this.value = v;
		}
	}
	
	private int capacity;
	public SNode top, bottom;
	public int size = 0;
	
	public MyStack2(int cap) {
		this.capacity = cap;
	}
	public boolean isFull() {
		return this.capacity == size;
	}
	
	public void join(SNode above, SNode below) {
		if(below != null) below.above =above;
		if(above != null) above.below = below;
	}
	
	public boolean push(int v) {
		if(size >= capacity) {
			return false;
		}
		size++;
		SNode node = new SNode(v);
		if(size == 1) {
			bottom = node;
		}
		join(node, top);
		top = node;
		return true;
	}
	
	public int pop() {
		SNode t = top;
		top = top.below;
		size--;
		return t.value;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int removeBottom() {
		SNode b = bottom;
		bottom = bottom.above;
		
		if(bottom != null) bottom.below = null;
		
		size--;
		
		return b.value;
	}
	

	

}
