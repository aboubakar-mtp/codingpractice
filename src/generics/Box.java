package generics;

public class Box<T, U> {
	
	T obj1;
	U obj2;
	
	public Box(T o1, U o2) {
		this.obj1 = o1;
		this.obj2 = o2;
	}
	
	public void printContent() {
		System.out.println("This box contains");
		System.out.println(this.obj1.getClass().getName() + " = " + this.obj1);
		System.out.println(this.obj2.getClass().getName() + " = " + this.obj2);
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Box<String, Integer> b1 = new Box<String, Integer>("Hello", 28);
		Box<String, Character> b2 = new Box<>("Good", 'M');
		
		Box<Character, Double> b3 = new Box<>('A', 18.5);
		
		b1.printContent();
		b2.printContent();
		b3.printContent();

	}

}
