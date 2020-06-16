package practice;

public class ResizableArray<V> {
	
	static final int INIT_CAP = 2;
	
	int currentSize;
	
	V[] storage;

	public ResizableArray() {
		this.currentSize = this.INIT_CAP;
		
		//storage = new V[this.INIT_CAP];
	}
	
	

}
